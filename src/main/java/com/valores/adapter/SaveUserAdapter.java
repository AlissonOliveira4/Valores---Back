package com.valores.adapter;

import com.valores.entity.User;
import com.valores.ports.output.SaveOutputPort;
import com.valores.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserAdapter implements SaveOutputPort {

    private final UserRepository userRepository;

    @Autowired
    public SaveUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean save(User user){
        User user1 = userRepository.save(user);
        return user1 != null;
    }

}
