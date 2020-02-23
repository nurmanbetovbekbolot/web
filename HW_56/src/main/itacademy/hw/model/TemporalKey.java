package itacademy.hw.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@XmlRootElement(name = "tempkey")
public class TemporalKey {
    private String temporalKey;
}
