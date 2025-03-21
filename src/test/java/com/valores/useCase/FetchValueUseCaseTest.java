package com.valores.useCase;

import com.valores.entity.Value;
import com.valores.ports.output.FetchValueOutputPort;
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
public class FetchValueUseCaseTest {

    @InjectMocks
    private FetchValueUseCase fetchValueUseCase;

    @Mock
    private FetchValueOutputPort fetchValue;

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void should_get_value() {

        var value = easyRandom.nextObject(Value.class);

        when(fetchValue.getValue(value.getNome())).thenReturn(value);

        var result = fetchValueUseCase.getValue(value.getNome());

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEqualTo(value);

        verify(fetchValue, times(1)).getValue(any());

    }

}
