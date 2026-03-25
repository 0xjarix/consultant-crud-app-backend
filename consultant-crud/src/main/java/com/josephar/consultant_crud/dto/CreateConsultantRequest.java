package com.josephar.consultant_crud.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateConsultantRequest {

    @NotBlank(message = "First name is required")
    @Pattern(
            regexp = "^(?!\\s*$)[A-Za-zÀ-ÿ]+(?:[ -][A-Za-zÀ-ÿ]+)*$",
            message = "First name must contain only letters, spaces, or hyphens"
    )
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Pattern(
            regexp = "^(?!\\s*$)[A-Za-zÀ-ÿ]+(?:[ -][A-Za-zÀ-ÿ]+)*$",
            message = "Last name must contain only letters, spaces, or hyphens"
    )
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Expertise is required")
    @Pattern(
            regexp = "^(?!\\s*$)[A-Za-z0-9]+(?:\\s[A-Za-z0-9]+)*$",
            message = "Expertise must contain only letters, digits, and single spaces between words"
    )
    private String expertise;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;
}
