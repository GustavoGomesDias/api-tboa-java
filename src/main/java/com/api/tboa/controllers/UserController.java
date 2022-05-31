package com.api.tboa.controllers;

import com.api.tboa.configs.AppConfig;
import com.api.tboa.DAO.user.*;
import com.api.tboa.DTO.UserDTO;
import com.api.tboa.adapeters.services.EncryptAdapter;
import com.api.tboa.models.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

// https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc => json
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("user")
public class UserController {
    private final EncryptAdapter encrypt;
    private final UserDAOImp daoImp = new UserDAOImp();

    public UserController() {
        var appConfig = new AppConfig();
        this.encrypt = appConfig.makeEncrypt();
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO dto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            var userModel = new UserModel();

            dto.setPassword(encrypt.encrypt(dto.getPassword()));
            BeanUtils.copyProperties(dto, userModel);

            daoImp.create(userModel);

            map.put("message", "Usuário criado com sucesso!");

            return ResponseEntity.status(HttpStatus.CREATED).body(map);
        } catch (Exception e) {
            map.put("error", "Erro no servidor, tente novamente mais tarde.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

}
