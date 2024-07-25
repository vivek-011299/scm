package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {
    @NotBlank
    @Size(min = 3, message = "Minimum 3 characters required.")
    private String name;
    @Email(message = "Not a valid email.")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank
    @Size(min=6,message = "Password must be greater than 5 charcaters.")
    private String password;
    @Size(min = 10,max = 12,message = "Enter a valid phone number.")
    private String phoneNumber;
    @NotBlank
    private String about;
}
