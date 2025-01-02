package com.valores.useCase;

import com.valores.entity.User;
import com.valores.ports.input.SaveUserInputPort;
import com.valores.ports.output.FetchUserOutputPort;
import com.valores.ports.output.SaveOutputPort;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SaveUserUseCase implements SaveUserInputPort {

    private final SaveOutputPort saveUserOutputPort;

    private final FetchUserOutputPort fetchUserOutputPort;

    public SaveUserUseCase(SaveOutputPort saveOutputPort, FetchUserOutputPort fetchUserOutputPort) {
        this.saveUserOutputPort = saveOutputPort;
        this.fetchUserOutputPort = fetchUserOutputPort;
    }

    public String saveUser(User user){

        if (user.getNome() == null){
            return "Nome é vazio!";
        }

        User user1 = fetchUserOutputPort.fetchUser(user.getNome());

        if (user1 != null){
            if (user.getPontos() < user1.getPontos()){
                return "User já existente!!!";
            }
        }

        if (saveUserOutputPort.save(user)) {
            return "User salvo com sucesso!";
        }
        return "User não foi salvo!";
    }
}
