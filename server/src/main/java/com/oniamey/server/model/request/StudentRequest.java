package com.oniamey.server.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequest {

    @NotNull(message = "name dose not empty")
    private String name;

    @NotNull(message = "code dose not empty")
    private String code;

}
