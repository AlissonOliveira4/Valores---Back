package com.valores.adapter;

import com.valores.entity.Value;
import com.valores.ports.output.FetchValueOutputPort;
import com.valores.repository.ValueRepository;
import org.springframework.stereotype.Component;

@Component
public class FetchValueAdapter implements FetchValueOutputPort {

    private ValueRepository valueRepository;

    public FetchValueAdapter(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }

    public Value getValue(String nome) {
        return valueRepository.findByNome(nome);
    }
}
