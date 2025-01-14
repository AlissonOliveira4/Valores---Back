package com.valores.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Document(collection = "User")
@TypeAlias("User")
public class User {

    @Id
    private String id;

    @Field("nome")
    @Indexed(unique = true)
    private String nome;

    private int pontos;

    private String tempo;

    public User(){}

    public User(String nome, int pontos, LocalTime tempo) {
        this.nome = nome;
        this.pontos = pontos;
        this.tempo = tempo.toString();
    }

    public User(String nome, int pontos, String tempo) {
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

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }


}
