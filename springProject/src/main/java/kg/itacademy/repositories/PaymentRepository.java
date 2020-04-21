package kg.itacademy.repositories;

import kg.itacademy.entities.Payment;
import kg.itacademy.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
  // @Query("select payment FROM Payment payment WHERE status=:p_status")
    //List<Payment> findAllByStatus(@Param("p_status") Status status);
    List<Payment> findAllByStatus( Status status);
    List<Payment> findAllByAccountFrom_Customer_Id(Long id);

}