package com.valores.repository;

import com.valores.entity.User;
import com.valores.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import java.time.LocalTime;
import java.util.List;

@Repository
public class UserRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User updateUserByNome(String nome, User user) {

        Query query = new Query();
        query.addCriteria(Criteria.where("nome").is(nome));

        User existingUser = mongoTemplate.findOne(query, User.class);

        if (existingUser == null) {
            System.out.println("Nenhum usuário encontrado com o nome: " + nome);
            throw new NotFoundException("User não encontrado!");
        }

        boolean isTempoMaior = LocalTime.parse(user.getTempo()).isAfter(LocalTime.parse(existingUser.getTempo()));

        Update update = new Update();

        if (user.getPontos() > existingUser.getPontos()) {
            update.set("pontos", user.getPontos());
            update.set("tempo", user.getTempo());
        } else if (user.getPontos() == existingUser.getPontos() && isTempoMaior){
            update.set("tempo", user.getTempo());
        } else {
            return null;
        }

        return mongoTemplate.findAndModify(query, update, User.class);
    }

    public List<User> getTop10UsersByPontosAndTempo() {

        Query query = new Query();

        query.with(Sort.by(Sort.Order.desc("pontos"), Sort.Order.desc("tempo")));

        query.limit(10);

        return mongoTemplate.find(query, User.class);
    }
}
