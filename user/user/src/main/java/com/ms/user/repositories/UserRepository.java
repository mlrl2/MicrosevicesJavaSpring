package com.ms.user.repositories;

import com.ms.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

}

//permite utilizar as principais funcionalidades do framework, é o repositorio do springboot so uma inicialização extendendo pra o meu modelo
//tbm responsavel por conexão do framework com a base