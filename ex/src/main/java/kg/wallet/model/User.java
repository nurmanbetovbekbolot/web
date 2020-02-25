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
public class User {
    private int id;
    private String name;
    private String gender;
    private Integer yearOfBirth;

    public int getAge(){
         return 2020-this.yearOfBirth;
    }
}

