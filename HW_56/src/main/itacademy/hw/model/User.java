package itacademy.hw.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@XmlRootElement(name = "hw")
public class User {
    private String username;
    private Integer password;
}
