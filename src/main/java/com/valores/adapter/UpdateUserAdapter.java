package com.valores.adapter;

import com.valores.entity.User;
import com.valores.ports.output.UpdateUserOutputPort;
import com.valores.repository.UserRepositoryCustom;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserRepositoryCustom userRepositoryCustom;

    public UpdateUserAdapter(UserRepositoryCustom userRepositoryCustom) {
        this.userRepositoryCustom = userRepositoryCustom;
    }

    public boolean updateUser(User user, String nome){
        return userRepositoryCustom.updateUserByNome(nome, user) != null;
    }

}
