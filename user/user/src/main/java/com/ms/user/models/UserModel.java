package com.ms.user.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;


// É minha entidade o objeto que estou trabalhando, onde defino que o usuario tem ID unico, e seto essa propriedade nelee
//aqui também starto minha tabela e defino as colunas
@Entity
//@getter @setter
@Table (name= "TB_USERS")
public class UserModel implements Serializable {

    private static final long seralVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String name;
    private String email;

    //lombok

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
