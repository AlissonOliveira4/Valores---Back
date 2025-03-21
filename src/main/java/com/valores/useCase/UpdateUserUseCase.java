package com.valores.useCase;

import com.valores.entity.User;
import com.valores.exception.NullPointerException;
import com.valores.ports.input.UpdateUserInputPort;
import com.valores.ports.output.UpdateUserOutputPort;
import org.bson.internal.BsonUtil;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class UpdateUserUseCase implements UpdateUserInputPort {

    private final UpdateUserOutputPort updateUserOutputPort;


    public UpdateUserUseCase(UpdateUserOutputPort updateUserOutputPort) {
        this.updateUserOutputPort = updateUserOutputPort;
    }

    public String update(User user, String nome) {
        if (user != null && nome != null){
            if (updateUserOutputPort.updateUser(user, nome)) {
                return nome + " foi atualizado com sucesso!";
            }
            return nome + " não foi atualizado!";
        }
        throw new NullPointerException("Alguma variável é null!");
    }
}
