package io.falcon.persister.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TheMessage implements Serializable {
    private String id;

    @NotNull
    private String message;

    public TheMessage(String message) {
        this.message = message;
    }
}