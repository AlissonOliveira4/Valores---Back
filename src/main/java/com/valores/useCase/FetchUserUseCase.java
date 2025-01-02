package com.valores.useCase;

import com.valores.entity.User;
import com.valores.ports.input.FetchUserInputPort;
import com.valores.ports.output.FetchUserOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchUserUseCase implements FetchUserInputPort {

    private final FetchUserOutputPort fetchUserOutputPort;

    public FetchUserUseCase(FetchUserOutputPort fetchUserOutputPort) {
        this.fetchUserOutputPort = fetchUserOutputPort;
    }

    public List<User> top10Users(){
        return fetchUserOutputPort.top10Users();
    }
}
