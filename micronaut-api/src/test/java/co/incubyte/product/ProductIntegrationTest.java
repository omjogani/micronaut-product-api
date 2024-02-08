package co.incubyte.product;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ProductIntegrationTest {

  private static final Logger log = LoggerFactory.getLogger(ProductIntegrationTest.class);
  private String base;
  @Inject EmbeddedServer embeddedServer;

  @BeforeEach
  void setUp() {
    base = embeddedServer.getURI().toString();
  }

  @AfterEach
  void tearDown() {}

  @Test
  void addProduct(RequestSpecification specs) {
    String id = createApiCall(specs);
    log.info(id);
    assertEquals(id, getAPICall(base, id));
  }

  private static String getAPICall(String base, String id) {
    return RestAssured.given()
        .log()
        .all()
        .when()
        .get(base + "/product/" + id)
        .then()
        .extract()
        .body()
        .path("id");
  }

  private static String createApiCall(RequestSpecification specification) {
    String name = UUID.randomUUID().toString();
    String body = """
    {
        "name":"$name",
        "price":100.0
    }
""".replace("$name", name);
    // @formatter:off
    return specification
        .given()
        .log()
        .all()
        .when()
        .contentType(ContentType.JSON)
        .body(body)
        .post("/product")
        .then()
        .log()
        .all()
        .body("id", is(not(blankOrNullString())))
        .body("name", is(not(blankOrNullString())))
        .body("createdAt", is(not(blankOrNullString())))
        .body("updatedAt", is(not(blankOrNullString())))
        .extract()
        .body()
        .path("id");
    // @formatter:on
  }
}
