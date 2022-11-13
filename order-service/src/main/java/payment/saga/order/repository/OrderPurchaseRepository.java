package payment.saga.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import payment.saga.order.model.OrderPurchase;

import java.util.Optional;

@Repository
public interface OrderPurchaseRepository extends ReactiveCrudRepository<OrderPurchase, Integer> {
}
