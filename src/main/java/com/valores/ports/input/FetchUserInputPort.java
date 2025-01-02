package com.valores.ports.input;

import com.valores.entity.User;

import java.util.List;

public interface FetchUserInputPort {

    List<User> top10Users();

}
