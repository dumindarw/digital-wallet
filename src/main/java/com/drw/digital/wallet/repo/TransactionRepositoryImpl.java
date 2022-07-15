package com.drw.digital.wallet.repo;

import com.drw.digital.wallet.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @Override
    public Mono<Transaction> makeTransaction(Transaction trx) {

        return mongoTemplate.insert(trx);
    }
}
