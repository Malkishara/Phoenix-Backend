package com.oxcentra.phoenix.dto;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDto {
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String logo;
    private String password;
    private String confirmPassword;

}
