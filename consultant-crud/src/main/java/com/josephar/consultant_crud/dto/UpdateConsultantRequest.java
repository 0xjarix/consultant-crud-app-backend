package com.josephar.consultant_crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateConsultantRequest {

        @Pattern(
                regexp = "^(?!\\s*$)[A-Za-zÀ-ÿ]+(?:[ -][A-Za-zÀ-ÿ]+)*$",
                message = "First name must contain only letters, spaces, or hyphens"
        )
        private String firstName;

        @Pattern(
                regexp = "^(?!\\s*$)[A-Za-zÀ-ÿ]+(?:[ -][A-Za-zÀ-ÿ]+)*$",
                message = "Last name must contain only letters, spaces, or hyphens"
        )
        private String lastName;

        @Pattern(regexp = ".\\S.", message = "Email cannot be blank")
        @Email(message = "Email should be valid")
        private String email;

        @Pattern(
                regexp = "^(?!\\s*$)[A-Za-z0-9]+(?:\\s[A-Za-z0-9]+)*$",
                message = "Expertise must contain only letters, digits, and single spaces between words"
        )
        private String expertise;

        @Min(value = 18, message = "Age must be at least 18")
        private Integer age;
}
