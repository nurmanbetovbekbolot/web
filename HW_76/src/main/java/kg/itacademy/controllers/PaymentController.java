package kg.itacademy.controllers;

import kg.itacademy.entities.Payment;
import kg.itacademy.enums.Status;
import kg.itacademy.models.ConfirmationModel;
import kg.itacademy.models.ResponseMessage;
import kg.itacademy.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Payment getById(@PathVariable("id") Long id) {
        return paymentService.getById(id);
    }

    @GetMapping(value = "/getByStatus/{status}")
    public List<Payment> getByStatus(@PathVariable("status") Status s) {
        return paymentService.findAllByStatus(s);
    }

    @GetMapping(value = "/getByCustomer/{customer}")
    public List<Payment> getPaymentsByCustomer(@PathVariable("customer") Long id) {
        return paymentService.getPaymentsByCustomer(id);
    }

    @PutMapping
    public Payment update(@RequestBody Payment a) {
        return paymentService.update(a);
    }
//    @PutMapping(value = "/confirmCode/{code_to}")
//    public Payment confirmCode(@PathVariable("code_to") Long id) {
//        return paymentService.update();
//    }

    @PostMapping("/confirm")
    public ResponseMessage confirm(@RequestBody ConfirmationModel confirmationModel, @RequestHeader String codeWord) {
        try {
            return ResponseMessage.builder()
                    .success(true)
                    .json(paymentService.confirmPayment(confirmationModel, codeWord))
                    .build();
        } catch (Exception e) {
            return ResponseMessage.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping
    public ResponseMessage save(@RequestBody Payment payment) {
        try {
            return ResponseMessage.builder()
                    .success(true)
                    .json(paymentService.create(payment))
                    .build();
        } catch (Exception e) {
            return ResponseMessage.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
    }

    @DeleteMapping
    public void deleteById(Long id) {
        paymentService.deleteById(id);
    }
}


