package kg.itacademy.controllers;

import kg.itacademy.entities.Payment;
import kg.itacademy.enums.Status;
import kg.itacademy.exceptions.PaymentWasAlreadyProcessedException;
import kg.itacademy.models.ConfirmationModel;
import kg.itacademy.models.ResponseMessage;
import kg.itacademy.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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

    @GetMapping("/fetch/{one_date}/{two_date}")
    public List<Payment> getPaymentsByDateOfCustomerId(@PathVariable(value = "one_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate, @PathVariable(value = "two_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate,@RequestHeader Long id) {
        return paymentService.getPaymentsByDateOfCustomerId(fromDate, toDate,id);
    }
//    @GetMapping(value = "/getByDateAndCustomer/{one_date}/{two_date}")
//    public List<Payment> getPaymentsByDateOfCustomerId(@RequestParam("from") String from, @RequestParam("to") String to, @RequestHeader Long id) throws PaymentWasAlreadyProcessedException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            Date dFrom = dateFormat.parse(from);
//            Date dTo = dateFormat.parse(to);
//            return paymentService.getPaymentsByDateOfCustomerId(dFrom,dTo,id);
//        } catch (Exception e) {
//            throw new PaymentWasAlreadyProcessedException();
//        }
//    }

    @PutMapping
    public Payment update(@RequestBody Payment a) {
        return paymentService.update(a);
    }

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


