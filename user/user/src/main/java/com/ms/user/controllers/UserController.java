package com.ms.user.controllers;

import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import com.ms.user.dtos.UserRecordDto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Como o nome da classe já diz ela é o controle, é onde criamos o endpoint para que o cliente envie um post passando um usuário e o MS vai receber esse usuário e salvar na Base de dados

//é um comando ao spring que diz pra ele que essa classe vai ser controlada pelo Framework
@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //É aqui que o spring sabe que vai receber um POST o /users é a URI da minha requisição do postman
    // e no UserRecodDto é onde o Spring passa o UserModel que ele recebe da requisição do usuário (POST) e faz o Registro
    @PostMapping()
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
        //após salvar o usupario eu preciso agora receber o objeto e transformar ele novamente na estrutura userModel
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        //agora já tenho um objeto do tipo userModel pra salvar na base de dados e então eu preciso de um service que faça o save
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

}
