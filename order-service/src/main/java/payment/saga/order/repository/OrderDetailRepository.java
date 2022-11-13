package payment.saga.order.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import payment.saga.order.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends ReactiveCrudRepository<OrderDetail, Integer> {
}
