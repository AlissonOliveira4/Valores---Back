package com.valores.adapter;

import com.valores.entity.Value;
import com.valores.repository.ValueRepository;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SaveValueAdapterTest {

    @InjectMocks
    private SaveValueAdapter saveValue;

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
    void should_save_value_with_sucess() {

        when(valueRepository.save(any())).thenReturn(value);

        var result = saveValue.saveValue(value);

        Assertions.assertThat(result).isEqualTo(true);

        verify(valueRepository, times(1)).save(value);

    }

    @Test
    void should_save_value_failed() {

        when(valueRepository.save(any())).thenReturn(null);

        var result = saveValue.saveValue(value);

        Assertions.assertThat(result).isEqualTo(false);

        verify(valueRepository, times(1)).save(value);

    }

}
