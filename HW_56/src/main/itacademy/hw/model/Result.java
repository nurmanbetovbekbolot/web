package itacademy.hw.model;


import lombok.*;
import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@XmlRootElement(name = "result")
public class Result {
    private Integer result;

}
