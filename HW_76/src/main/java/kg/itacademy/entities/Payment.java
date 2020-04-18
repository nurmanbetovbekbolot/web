package kg.itacademy.entities;

import kg.itacademy.enums.Currency;
import kg.itacademy.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @CreatedDate
    @Column(name = "created_date")
    Date createdDate = new Date();

    @ManyToOne
    @JoinColumn(name = "account_from_id", referencedColumnName = "id")
    Account accountFrom;

    @ManyToOne
    @JoinColumn(name = "account_to_id", referencedColumnName = "id")
    Account accountTo;

    @Column(name = "confirmation_code", length = 4)
    String confirmationCode;

    @Column(name = "amount")
    BigDecimal amount;

    @Column(name = "currency")
    Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;

}