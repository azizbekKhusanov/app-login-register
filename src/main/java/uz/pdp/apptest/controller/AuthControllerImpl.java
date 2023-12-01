package uz.pdp.apptest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.apptest.dto.LoginDTO;
import uz.pdp.apptest.dto.RegisterDTO;
import uz.pdp.apptest.dto.UserDTO;
import uz.pdp.apptest.exceptions.ApiException;
import uz.pdp.apptest.payload.ApiResult;
import uz.pdp.apptest.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;


    @Override
    public ApiResult<UserDTO> login(@RequestBody LoginDTO loginDTO) {

        try {
            UserDTO userDTO = authService.login(loginDTO);
            return ApiResult.successResponse(userDTO);
        } catch (ApiException e) {
            throw ApiException.apiException(e.getMessage(), e.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<UserDTO> register(@RequestBody RegisterDTO registerDTO) {
        try {
            UserDTO userDTO = authService.register(registerDTO);
            return ApiResult.successResponse(userDTO);
        } catch (ApiException e) {
            throw ApiException.apiException(e.getMessage(), e.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
