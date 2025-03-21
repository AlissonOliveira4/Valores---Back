package com.valores.adapter;

import com.valores.entity.User;
import com.valores.entity.Value;
import com.valores.repository.ValueRepository;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FetchValueAdapterTest {

    @InjectMocks
    private FetchValueAdapter fetchValueAdapter;

    @Mock
    private ValueRepository valueRepository;

    private EasyRandom easyRandom;
    private Value value;

    @BeforeEach
    void setUp() {
        easyRandom = new EasyRandom();
        value = easyRandom.nextObject(Value.class);
    }

    @Test
    void should_fetch_value_with_sucess() {

        when(valueRepository.findByNome("a")).thenReturn(value);

        var result = fetchValueAdapter.getValue("a");

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(value);

        verify(valueRepository, times(1)).findByNome("a");

    }

    @Test
    void should_fetch_value_failed() {

        when(valueRepository.findByNome(any())).thenReturn(null);

        var result = fetchValueAdapter.getValue(any());

        Assertions.assertThat(result).isNull();

        verify(valueRepository, times(1)).findByNome(any());

    }

}
