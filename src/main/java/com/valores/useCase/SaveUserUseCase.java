package com.valores.useCase;

import com.valores.entity.User;
import com.valores.exception.AlreadyExistsException;
import com.valores.exception.NullPointerException;
import com.valores.ports.input.SaveUserInputPort;
import com.valores.ports.output.FetchUserOutputPort;
import com.valores.ports.output.SaveUserOutputPort;
import org.springframework.stereotype.Service;

@Service
public class SaveUserUseCase implements SaveUserInputPort {

    private final SaveUserOutputPort saveUserOutputPort;

    private final FetchUserOutputPort fetchUserOutputPort;

    public SaveUserUseCase(SaveUserOutputPort saveUserOutputPort, FetchUserOutputPort fetchUserOutputPort) {
        this.saveUserOutputPort = saveUserOutputPort;
        this.fetchUserOutputPort = fetchUserOutputPort;
    }

    public String saveUser(User user){

        if (user.getNome() == null){
            throw new NullPointerException("Nome é vazio!");
        }

        if (fetchUserOutputPort.fetchUser(user.getNome()) != null){
            throw new AlreadyExistsException("User já existente!");
        }

        if (saveUserOutputPort.save(user)) {
            return "User salvo com sucesso!";
        }
        return "User não foi salvo!";
    }
}
