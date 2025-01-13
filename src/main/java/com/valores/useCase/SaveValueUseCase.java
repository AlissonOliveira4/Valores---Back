package com.valores.useCase;

import com.valores.entity.Value;
import com.valores.ports.input.SaveValueInputPort;
import com.valores.ports.output.SaveValueOutputPort;
import org.springframework.stereotype.Service;

@Service
public class SaveValueUseCase implements SaveValueInputPort {

    private SaveValueOutputPort saveValueOutputPort;

    public SaveValueUseCase(SaveValueOutputPort saveValueOutputPort) {
        this.saveValueOutputPort = saveValueOutputPort;
    }

    public String saveValue(Value value) {
        return saveValueOutputPort.saveValue(value) ? "Valor "+value.getNome()+" salvo com sucesso!" : "Valor "+value.getNome()+"não foi salvo!";
    }

}
