package com.valores.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Valores")
public class Value {

    private String nome;
    private String frase;
    private List<Question> perguntas;
    private String exemplo;

    public Value(String nome, String frase, List<Question> perguntas, String exemplo) {
        this.nome = nome;
        this.frase = frase;
        this.perguntas = perguntas;
        this.exemplo = exemplo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public List<Question> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Question> perguntas) {
        this.perguntas = perguntas;
    }

    public String getExemplo() {
        return this.exemplo;
    }

    public void setExemplo(String exemplo) {
        this.exemplo = exemplo;
    }

    public static class Question {

        private String pergunta;
        private boolean situacao;

        public Question(boolean situacao, String pergunta) {
            this.situacao = situacao;
            this.pergunta = pergunta;
        }

        public String getPergunta() {
            return pergunta;
        }

        public void setPergunta(String pergunta) {
            this.pergunta = pergunta;
        }

        public boolean isSituacao() {
            return situacao;
        }

        public void setSituacao(boolean situacao) {
            this.situacao = situacao;
        }
    }
}
