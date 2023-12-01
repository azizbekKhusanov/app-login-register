package uz.pdp.apptest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.apptest.dto.LoginDTO;
import uz.pdp.apptest.dto.RegisterDTO;
import uz.pdp.apptest.dto.UserDTO;
import uz.pdp.apptest.payload.ApiResult;
import uz.pdp.apptest.utils.AppConstants;

@RequestMapping(AppConstants.AUTH_PATH)
@CrossOrigin(origins = AppConstants.CROSS_ORIGIN_PATH)
public interface AuthController {

    String LOGIN_PAGE = "/login";
    String REGISTER_PAGE = "/register";

    @PostMapping(LOGIN_PAGE)
    ApiResult<UserDTO> login(@RequestBody LoginDTO loginDTO);

    @PostMapping(REGISTER_PAGE)
    ApiResult<UserDTO> register(@RequestBody RegisterDTO registerDTO);

}
