package uz.pdp.apptest.service;

import uz.pdp.apptest.dto.LoginDTO;
import uz.pdp.apptest.dto.RegisterDTO;
import uz.pdp.apptest.dto.UserDTO;

public interface AuthService {

    UserDTO login(LoginDTO loginDTO);

    UserDTO register(RegisterDTO registerDTO);


}
