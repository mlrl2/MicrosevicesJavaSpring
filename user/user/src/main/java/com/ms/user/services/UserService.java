package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //aqui que salva o usuario, e depois ele vai publicar no broker
    @Transactional
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

}
