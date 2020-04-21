package kg.itacademy.entities;

import kg.itacademy.enums.Currency;
import kg.itacademy.enums.Tarif;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "number")
    String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "tarif")
    Tarif tarif;

    @Column(name = "balance")
    BigDecimal balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    Currency currency;

    @Column(name = "confirmation_code")
    Long code;
}
