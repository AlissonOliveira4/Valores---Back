package com.valores.ports.output;

import com.valores.entity.User;

public interface UpdateUserOutputPort {

    boolean updateUser(User user, String nome);

}
