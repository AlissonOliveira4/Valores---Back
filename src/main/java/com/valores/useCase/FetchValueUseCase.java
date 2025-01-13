package com.valores.useCase;

import com.valores.entity.Value;
import com.valores.ports.input.FetchValueInputPort;
import com.valores.ports.output.FetchValueOutputPort;
import org.springframework.stereotype.Service;

@Service
public class FetchValueUseCase implements FetchValueInputPort {

    private FetchValueOutputPort fetchValueOutputPort;

    public FetchValueUseCase(FetchValueOutputPort fetchValueOutputPort) {
        this.fetchValueOutputPort = fetchValueOutputPort;
    }

    public Value getValue(String nome){
        return fetchValueOutputPort.getValue(nome);
    }

}
