package uz.pdp.apptest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RegisterDTO {

    private String name;
    private String username;
    private String password;
    private String prePassword;

}