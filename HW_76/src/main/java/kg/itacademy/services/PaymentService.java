package kg.itacademy.services;

import kg.itacademy.entities.Payment;
import kg.itacademy.enums.Status;
import kg.itacademy.models.ConfirmationModel;

import java.util.Date;
import java.util.List;


public interface PaymentService {
    List<Payment> getAll();

    Payment getById(Long id);

    Payment update(Payment payment);

    Payment create(Payment payment);

    void deleteById(Long id);

    Payment save(Payment payment);

//    void doTransaction(Payment payment);

    List<Payment> findAllByStatus(Status status);

    List<Payment> getPaymentsByPeriod(Date start, Date end);

    List<Payment> getPaymentsByCustomer(Long id);

    Payment confirmPayment(ConfirmationModel confirmationModel, String clientKeyWord) throws Exception;
}
