package com.scm.forms;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String about;
}
