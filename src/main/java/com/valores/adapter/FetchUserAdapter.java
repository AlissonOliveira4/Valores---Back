package com.valores.adapter;

import com.valores.entity.User;
import com.valores.ports.output.FetchUserOutputPort;
import com.valores.repository.UserRepository;
import com.valores.repository.UserRepositoryCustom;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchUserAdapter implements FetchUserOutputPort {

    private final UserRepository userRepository;

    private final UserRepositoryCustom userRepositoryCustom;

    public FetchUserAdapter(UserRepository userRepository, UserRepositoryCustom userRepositoryCustom) {
        this.userRepository = userRepository;
        this.userRepositoryCustom = userRepositoryCustom;
    }

    public User fetchUser(String nome){
        return userRepository.findUserByNome(nome);
    }

    public List<User> top10Users(){
        return userRepositoryCustom.getTop10UsersByPontosAndTempo();
    }

}
