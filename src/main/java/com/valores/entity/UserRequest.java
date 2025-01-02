package com.valores.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRequest {

    private String nome;

    private int pontos;

    private LocalTime tempo;

    public UserRequest(String nome, int pontos, LocalTime tempo) {
        this.nome = nome;
        this.pontos = pontos;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public LocalTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalTime tempo) {
        this.tempo = tempo;
    }
}
