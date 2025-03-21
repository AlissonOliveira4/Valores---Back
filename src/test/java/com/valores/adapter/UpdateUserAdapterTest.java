package com.valores.adapter;

import com.valores.entity.User;
import com.valores.repository.UserRepositoryCustom;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateUserAdapterTest {

    @InjectMocks
    private UpdateUserAdapter updateUser;

    @Mock
    private UserRepositoryCustom userRepository;

    private EasyRandom easyRandom;
    private User user;

    @BeforeEach
    void setUp() {
        easyRandom = new EasyRandom();
        user = easyRandom.nextObject(User.class);
    }

    @Test
    void should_update_user_with_sucess() {

        when(userRepository.updateUserByNome(user.getNome(), user)).thenReturn(user);

        var result = updateUser.updateUser(user, user.getNome());

        Assertions.assertThat(result).isEqualTo(true);

        verify(userRepository, times(1)).updateUserByNome(user.getNome(), user);

    }

    @Test
    void should_update_user_failed() {

        when(userRepository.updateUserByNome(user.getNome(), user)).thenReturn(null);

        var result = updateUser.updateUser(user, user.getNome());

        Assertions.assertThat(result).isEqualTo(false);

        verify(userRepository, times(1)).updateUserByNome(user.getNome(), user);

    }

}
