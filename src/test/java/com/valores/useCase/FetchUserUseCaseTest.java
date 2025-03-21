package com.valores.useCase;

import com.valores.entity.User;
import com.valores.ports.output.FetchUserOutputPort;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class FetchUserUseCaseTest {

    @InjectMocks
    private FetchUserUseCase fetchUserUseCase;

    @Mock
    private FetchUserOutputPort fetchUserOutputPort;

    private EasyRandom easyRandom;
    private List<User> users;

    @BeforeEach
    void setUp() {
        easyRandom = new EasyRandom();
        users = easyRandom.objects(User.class, 10).toList();
    }

    @Test
    void should_return_top10_users() {

        when(fetchUserOutputPort.top10Users()).thenReturn(users);

        var result = fetchUserUseCase.top10Users();

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).hasSize(10);
        Assertions.assertThat(result).isEqualTo(users);

        verify(fetchUserOutputPort, times(1)).top10Users();

    }

}
