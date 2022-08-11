package com.flatiron.spring.SpringBookProject.dto;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorDTO {
    @NotBlank
    private String name;
}
