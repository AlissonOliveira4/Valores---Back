package com.valores.adapter;

import com.valores.entity.Value;
import com.valores.ports.output.SaveValueOutputPort;
import com.valores.repository.ValueRepository;
import org.springframework.stereotype.Component;

@Component
public class SaveValueAdapter implements SaveValueOutputPort{

    private ValueRepository valueRepository;

    public SaveValueAdapter(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }

    public boolean saveValue(Value value){
        return valueRepository.save(value) != null;
    }

}
