package com.valores.adapter;

import com.valores.entity.User;
import com.valores.repository.UserRepository;
import com.valores.repository.UserRepositoryCustom;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FetchUserAdapterTest {

    @InjectMocks
    private FetchUserAdapter fetchUserAdapter;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRepositoryCustom userRepositoryCustom;

    private EasyRandom easyRandom = new EasyRandom();

    @Test
    void should_fetch_user_with_sucess() {

        var user = easyRandom.nextObject(User.class);

        when(userRepository.findUserByNome("a")).thenReturn(user);

        var result = fetchUserAdapter.fetchUser("a");

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(user);

        verify(userRepository, times(1)).findUserByNome("a");

    }

    @Test
    void should_fetch_user_failed() {

        when(userRepository.findUserByNome("a")).thenReturn(null);

        var result = fetchUserAdapter.fetchUser("a");

        Assertions.assertThat(result).isNull();

        verify(userRepository, times(1)).findUserByNome("a");

    }

    @Test
    void should_list_top10_with_sucess() {

        List<User> users = easyRandom.objects(User.class, 10).toList();

        when(userRepositoryCustom.getTop10UsersByPontosAndTempo()).thenReturn(users);

        var result = fetchUserAdapter.top10Users();

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(users);

        verify(userRepositoryCustom, times(1)).getTop10UsersByPontosAndTempo();

    }

    @Test
    void should_list_top10_failed() {

        when(userRepositoryCustom.getTop10UsersByPontosAndTempo()).thenReturn(null);

        var result = fetchUserAdapter.top10Users();

        Assertions.assertThat(result).isNull();

        verify(userRepositoryCustom, times(1)).getTop10UsersByPontosAndTempo();

    }

}
