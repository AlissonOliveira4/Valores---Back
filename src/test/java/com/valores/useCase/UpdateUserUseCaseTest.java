package com.valores.useCase;

import com.valores.entity.User;
import com.valores.exception.NullPointerException;
import com.valores.ports.output.UpdateUserOutputPort;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateUserUseCaseTest {

    @InjectMocks
    private UpdateUserUseCase updateUserUseCase;

    @Mock
    private UpdateUserOutputPort updateUser;

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void should_update_user_with_sucess() {

        var user = easyRandom.nextObject(User.class);

        when(updateUser.updateUser(user, user.getNome())).thenReturn(true);

        var result = updateUserUseCase.update(user, user.getNome());

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(user.getNome() + " foi atualizado com sucesso!");

    }

    @Test
    void should_not_update_user() {

        var user = easyRandom.nextObject(User.class);

        when(updateUser.updateUser(user, user.getNome())).thenReturn(false);

        var result = updateUserUseCase.update(user, user.getNome());

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(user.getNome() + " não foi atualizado!");

    }

    @Test
    void should_not_update_user_because_variables_are_null() {

        var exception = assertThrows(NullPointerException.class, () -> {
            updateUserUseCase.update(null, null);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("Alguma variável é null!");


    }

}
