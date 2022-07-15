package com.drw.digital.wallet.repo;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WalletRepositoryImpl implements WalletRepository{

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @Override
    public Mono<Transaction> makeTransaction(Transaction trx) {

        return mongoTemplate.insert(trx);
    }

    @Override
    public Flux<Wallet> getAllWallets() {
        return mongoTemplate.findAll(Wallet.class);
    }
}
