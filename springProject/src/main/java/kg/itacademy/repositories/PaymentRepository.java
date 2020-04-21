package kg.itacademy.repositories;

import kg.itacademy.entities.Payment;
import kg.itacademy.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // @Query("select payment FROM Payment payment WHERE status=:p_status")
    //List<Payment> findAllByStatus(@Param("p_status") Status status);
    List<Payment> findAllByStatus(Status status);

    List<Payment> findAllByAccountFrom_Customer_Id(Long id);

  @Query(value = "select p.* from payment p" +
            " left join account pa on p.account_from_id = pa.id" +
            " where pa.customer_id= :client_id and p.created_date between :dateFrom and :dateTo", nativeQuery = true)
    List<Payment> findAllByDateOfClientId(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo, @Param("client_id") Long clientId);

}