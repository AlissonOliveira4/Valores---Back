package com.valores.repository;

import com.valores.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

@Repository
public class UserRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User updateUserByNome(String nome, User user) {

        Query query = new Query();
        query.addCriteria(Criteria.where("nome").is(nome));

        Update update = new Update();
        update.set("pontos", user.getPontos());
        update.set("tempo", user.getTempo());

        return mongoTemplate.findAndModify(query, update, User.class);
    }

    public List<User> getTop10UsersByPontosAndTempo() {

        Query query = new Query();

        query.with(Sort.by(Sort.Order.desc("pontos"), Sort.Order.desc("tempo")));

        query.limit(10);

        return mongoTemplate.find(query, User.class);
    }
}
