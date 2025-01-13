package com.valores.ports.output;

import com.valores.entity.Value;

public interface FetchValueOutputPort {

    Value getValue(String nome);

}
