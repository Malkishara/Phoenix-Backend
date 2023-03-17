package com.oxcentra.phoenix.dto;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String user_type;
    private int user_id;
    private Boolean result;
    private String message;
    private String access_token;
    private Date expires_at;
    private int expires_in;
}
