package uz.pdp.apptest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apptest.dto.LoginDTO;
import uz.pdp.apptest.dto.RegisterDTO;
import uz.pdp.apptest.dto.UserDTO;
import uz.pdp.apptest.entity.User;
import uz.pdp.apptest.exceptions.ApiException;
import uz.pdp.apptest.repository.UserRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    @Override
    public UserDTO login(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> ApiException.apiException("User not found"));

        if(!Objects.equals(user.getPassword(), loginDTO.getPassword()))
            throw ApiException.apiException("Username or password don't match");

        return mapToUserDTOFromUser(user);
    }


    @Override
    public UserDTO register(RegisterDTO registerDTO) {
        if(userRepository.existsByUsername(registerDTO.getUsername()))
            throw ApiException.apiException("This user already exists");

        if(!Objects.equals(registerDTO.getPassword(), registerDTO.getPrePassword()))
            throw ApiException.apiException("Password don't match");

        User save = userRepository.save(mapToUserFromUserDTO(registerDTO));

        return mapToUserDTOFromUser(save);
    }


    private UserDTO mapToUserDTOFromUser(User user) {
        return UserDTO.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    private User mapToUserFromUserDTO(RegisterDTO registerDTO){
        return User.builder()
                .name(registerDTO.getName())
                .username(registerDTO.getUsername())
                .password(registerDTO.getPassword())
                .build();
    }

}
