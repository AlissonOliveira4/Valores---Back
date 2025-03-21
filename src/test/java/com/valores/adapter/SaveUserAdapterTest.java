package com.valores.adapter;

import com.valores.entity.User;
import com.valores.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SaveUserAdapterTest {

    @InjectMocks
    private SaveUserAdapter saveUser;

    @Mock
    private UserRepository userRepository;

    private EasyRandom easyRandom = new EasyRandom();

    @Test
    void should_save_user_with_sucess() {

        var user = easyRandom.nextObject(User.class);

        when(userRepository.save(any())).thenReturn(user);

        var result = saveUser.save(user);

        Assertions.assertThat(result).isEqualTo(true);

        verify(userRepository, times(1)).save(user);

    }

    @Test
    void should_save_user_failed() {

        var user = easyRandom.nextObject(User.class);

        when(userRepository.save(user)).thenReturn(null);

        var result = saveUser.save(user);

        Assertions.assertThat(result).isEqualTo(false);

        verify(userRepository, times(1)).save(user);

    }

}
