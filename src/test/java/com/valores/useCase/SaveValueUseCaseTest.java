package com.valores.useCase;

import com.valores.entity.User;
import com.valores.entity.Value;
import com.valores.ports.output.SaveValueOutputPort;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SaveValueUseCaseTest {

    @InjectMocks
    private SaveValueUseCase saveValueUseCase;

    @Mock
    private SaveValueOutputPort saveValue;

    private EasyRandom easyRandom;
    private Value value;

    @BeforeEach
    void setUp() {
        easyRandom = new EasyRandom();
        value = easyRandom.nextObject(Value.class);
    }



    @Test
    void should_save_value_with_sucess() {

        when(saveValue.saveValue(any())).thenReturn(true);

        var result = saveValueUseCase.saveValue(value);

        Assertions.assertThat(result).isEqualTo("Valor "+value.getNome()+" salvo com sucesso!");

    }

    @Test
    void should_not_save_value() {

        when(saveValue.saveValue(any())).thenReturn(false);

        var result = saveValueUseCase.saveValue(value);

        Assertions.assertThat(result).isEqualTo("Valor "+value.getNome()+"não foi salvo!");


    }

}
