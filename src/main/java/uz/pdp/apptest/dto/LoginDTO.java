package uz.pdp.apptest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LoginDTO {


    private String username;
    private String password;

}