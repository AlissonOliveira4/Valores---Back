package com.valores.ports.output;

import com.valores.entity.User;

import java.util.List;

public interface FetchUserOutputPort {

    User fetchUser(String nome);

    List<User> top10Users();

}
