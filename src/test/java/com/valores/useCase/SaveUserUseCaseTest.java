package com.valores.useCase;

import com.valores.entity.User;
import com.valores.exception.AlreadyExistsException;
import com.valores.exception.NullPointerException;
import com.valores.ports.output.FetchUserOutputPort;
import com.valores.ports.output.SaveUserOutputPort;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SaveUserUseCaseTest {

    @InjectMocks
    private SaveUserUseCase saveUserUseCase;

    @Mock
    private SaveUserOutputPort saveUser;

    @Mock
    private FetchUserOutputPort fetchUser;

    private EasyRandom easyRandom;
    private User user;

    @BeforeEach
    void setUp() {
        easyRandom = new EasyRandom();
        user = easyRandom.nextObject(User.class);
    }

    @Test
    void should_save_user_with_success() {

        when(fetchUser.fetchUser(any())).thenReturn(null);

        when(saveUser.save(any())).thenReturn(true);

        var result = saveUserUseCase.saveUser(user);

        Assertions.assertThat(result).isEqualTo("User salvo com sucesso!");

        verify(fetchUser, times(1)).fetchUser(any());
        verify(saveUser, times(1)).save(any());
    }

    @Test
    void should_save_user_with_name_null() {
        user.setNome(null);

        var exception = assertThrows(NullPointerException.class, () -> {
            saveUserUseCase.saveUser(user);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("Nome é vazio!");

    }

    @Test
    void should_save_user_existent() {

        when(fetchUser.fetchUser(any())).thenReturn(user);

        var exception = assertThrows(AlreadyExistsException.class, () -> {
            saveUserUseCase.saveUser(user);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("User já existente!");

        verify(fetchUser, times(1)).fetchUser(any());
    }

    @Test
    void should_not_save_user() {

        when(fetchUser.fetchUser(any())).thenReturn(null);

        when(saveUser.save(any())).thenReturn(false);

        var result = saveUserUseCase.saveUser(user);

        Assertions.assertThat(result).isEqualTo("User não foi salvo!");

        verify(fetchUser, times(1)).fetchUser(any());
        verify(saveUser, times(1)).save(any());
    }

}
