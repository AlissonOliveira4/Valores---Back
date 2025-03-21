package com.valores.ports.output;

import com.valores.entity.User;

public interface SaveUserOutputPort {

    boolean save(User user);

}
