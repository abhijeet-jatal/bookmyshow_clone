package com.clone.bookmyshow.controllerrs;

import com.clone.bookmyshow.dtos.SignUpRequestDTO;
import com.clone.bookmyshow.dtos.SignUpResponseDTO;
import com.clone.bookmyshow.enums.ResponseStatus;
import com.clone.bookmyshow.models.User;
import com.clone.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO){
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();

        try{
            User user = userService.signUp(signUpRequestDTO.getEmail(), signUpRequestDTO.getPassword());
            responseDTO.setUserId(user.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    @GetMapping("health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("All Okay");
    }
}