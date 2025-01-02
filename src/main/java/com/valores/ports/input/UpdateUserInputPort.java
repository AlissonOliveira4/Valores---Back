package com.valores.ports.input;

import com.valores.entity.User;

public interface UpdateUserInputPort {

    String update(User user, String nome);
}
