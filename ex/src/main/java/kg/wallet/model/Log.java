package kg.wallet.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@XmlRootElement(name = "users")
public class Log {
    private int id;
    private String name;
    private String gender;
    private Integer yearOfBirth;
    private Date date;
}

