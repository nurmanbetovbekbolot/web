package kg.itacademy.services;

import kg.itacademy.entities.Account;
import kg.itacademy.entities.Payment;
import kg.itacademy.enums.Status;
import kg.itacademy.exceptions.WrongConfirmationCodeException;
import kg.itacademy.exceptions.WrongKeyWordException;
import kg.itacademy.models.ConfirmationModel;
import kg.itacademy.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentServiceImplementation implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    private AccountService accountService;

    private Random random = new Random();


    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Long id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.orElse(new Payment());
    }


    @Override
    public Payment update(Payment a) {
        return paymentRepository.save(a);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
        System.out.println("Payment with id " + id + " has been deleted");
    }

    @Override
    public Payment create(Payment payment) {
        payment.setStatus(Status.PROCESSING);
        int confirmationCode = random.nextInt(9999 - 1000 + 1) + 1000;
        payment.setConfirmationCode(confirmationCode + "");
        return save(payment);
    }

//    @Override
//    public void doTransaction(Payment payment) {
//        if (payment.getCodeFrom().equals(payment.getCodeTo()))
//        payment.setStatus(Status.SUCCESS);
//        else if (payment.getCodeFrom()==null||payment.getCodeTo()==null)
//            payment.setStatus(Status.PROCESSING);
//        else
//            payment.setStatus(Status.FAILED);
//    }

    @Override
    public List<Payment> findAllByStatus(Status status) {
        return paymentRepository.findAllByStatus(status);
    }

    @Override
    public List<Payment> getPaymentsByPeriod(Date start, Date end) {
        return null;
    }

    @Override
    public List<Payment> getPaymentsByCustomer(Long id) {
        return paymentRepository.findAllByAccountFrom_Customer_Id(id);
    }
    @Override
    public Payment confirmPayment(ConfirmationModel confirmationModel, String code) throws Exception {
        Payment payment = getById(confirmationModel.getPaymentId());
        if (!payment.getAccountFrom().getCustomer().getCodeWord().equals(code))
            throw new WrongKeyWordException();
        if (!payment.getConfirmationCode().equals(confirmationModel.getConfirmationCode()))
            throw new WrongConfirmationCodeException();
        processPayment(payment);
        return payment;
    }

    private void processPayment(Payment payment) {
        payment.setStatus(payment.getAmount().intValue() % 2 == 0 ? Status.SUCCESS : Status.FAILED);
        if (payment.getStatus().equals(Status.SUCCESS)) {
            Account from = accountService.getById(payment.getAccountFrom().getId());
            from.setBalance(from.getBalance().subtract(payment.getAmount()));
            Account to = accountService.getById(payment.getAccountTo().getId());
            to.setBalance(to.getBalance().add(payment.getAmount()));
            accountService.save(from);
            accountService.save(to);
            payment.setAccountFrom(from);
            payment.setAccountTo(to);
        }
        save(payment);
    }



}

