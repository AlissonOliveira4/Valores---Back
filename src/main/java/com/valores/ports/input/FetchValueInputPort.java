package com.valores.ports.input;

import com.valores.entity.Value;

public interface FetchValueInputPort {

    Value getValue(String nome);

}
