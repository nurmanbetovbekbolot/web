package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Application {
    Integer id;
    String fullName;
    String email;
    Boolean isOnline;
    String course;
}
