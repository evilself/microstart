package io.falcon.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RedisHash("Message")
public class TheMessage implements Serializable {
    private String id;

    @NotNull
    private String message;

    public TheMessage(String message) {
        this.message = message;
    }
}