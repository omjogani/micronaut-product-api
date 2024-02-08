package co.incubyte.order;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class OrderIntegrationTest {
  private static final Logger log = LoggerFactory.getLogger(OrderIntegrationTest.class);
  private String base;

  @Inject EmbeddedServer embeddedServer;

  @BeforeEach
  void setUp() {
    base = embeddedServer.getURI().toString();
  }

  // create test to add order
  @Test
  void addOrder(RequestSpecification specs) {
    String productId = addProductApiCall(base);
    String id = createOrderApiCall(specs, productId);
    log.info("Demo" + id);
    assertEquals(id, getAPICall(base, id));
  }

  private static String addProductApiCall(String base) {
    String body = """
        {
            "name": "FAKE_NAME",
            "price": 100.0
        }
        """;
    return RestAssured
        .given()
        .log()
        .all()
        .when()
        .contentType(ContentType.JSON)
        .body(body)
        .post(base + "/product")
        .then()
        .log()
        .all()
        .body("id", is(not(blankOrNullString())))
        .body("name", is(not(blankOrNullString())))
        .body("price", is(greaterThanOrEqualTo(1.0)))
        .extract()
        .body()
        .path("id");
  }

  private static String getAPICall(String base, String id) {
    return RestAssured.given()
        .log()
        .all()
        .when()
        .get(base + "/order/" + id)
        .then()
        .extract()
        .body()
        .path("id");
  }

  private static String createOrderApiCall(RequestSpecification specification, String productId) {
    String body =
        """
                {
                    "quantity": 10,
                    "amount": 100.0,
                    "productId": "$PRODUCT_ID"
                }
                """.replace("$PRODUCT_ID", productId);
    return specification
        .given()
        .log()
        .all()
        .when()
        .contentType(ContentType.JSON)
        .body(body)
        .post("/order")
        .then()
        .log()
        .all()
        .body("id", is(not(blankOrNullString())))
        .body("quantity", is(not(blankOrNullString())))
        .body("amount", is(not(blankOrNullString())))
        .extract()
        .body()
        .path("id");
  }
}
