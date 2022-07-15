package com.drw.digital.wallet.repo;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.model.Wallet;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class WalletRepositoryImpl implements WalletRepository{

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @Override
    public Flux<Wallet> getAllWallets() {
        return mongoTemplate.findAll(Wallet.class);
    }

    @Override public Mono<Wallet> createWallet(Wallet wallet) {
        return mongoTemplate.save(wallet);
    }

    @Override public Flux<Wallet> updateWalletBalance(Wallet wallet) {

        Query query = Query.query(Criteria.where("id").is(wallet.getWalletId()));

        return mongoTemplate.find(query, Wallet.class)
            .doOnNext(wallet1 -> {
                mongoTemplate.updateFirst(query, Update.update("balance", wallet.getWalletBalance() + wallet1.getWalletBalance()), Wallet.class);
            });
    }
}
