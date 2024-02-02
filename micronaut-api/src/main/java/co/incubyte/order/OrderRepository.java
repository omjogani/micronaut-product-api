package co.incubyte.order;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {

}
