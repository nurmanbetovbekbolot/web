package kg.itacademy.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    public static Long generate(){
        return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }
}
