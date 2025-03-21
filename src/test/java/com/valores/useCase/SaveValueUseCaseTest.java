package com.valores.useCase;

import com.valores.entity.Value;
import com.valores.ports.output.SaveValueOutputPort;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
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

    private final EasyRandom easyRandom = new EasyRandom();

    @Test
    void should_save_value_with_sucess() {

        var value = easyRandom.nextObject(Value.class);

        when(saveValue.saveValue(any())).thenReturn(true);

        var result = saveValueUseCase.saveValue(value);

        Assertions.assertThat(result).isEqualTo("Valor "+value.getNome()+" salvo com sucesso!");

    }

    @Test
    void should_not_save_value() {

        var value = easyRandom.nextObject(Value.class);

        when(saveValue.saveValue(any())).thenReturn(false);

        var result = saveValueUseCase.saveValue(value);

        Assertions.assertThat(result).isEqualTo("Valor "+value.getNome()+"não foi salvo!");


    }

}
