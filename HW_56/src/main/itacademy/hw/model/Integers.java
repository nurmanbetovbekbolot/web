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
public class Integers {
    private Integer a;
    private Integer b;


    public Integer addInts(){
        return this.a+this.b;
    }

}
