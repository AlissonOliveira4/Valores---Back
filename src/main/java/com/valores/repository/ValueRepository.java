package com.valores.repository;

import com.valores.entity.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends MongoRepository<Value, String> {

    Value save(Value value);

    Value findByNome(String nome);
}
