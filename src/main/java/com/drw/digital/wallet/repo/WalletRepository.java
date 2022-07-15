package com.drw.digital.wallet.repo;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.model.Wallet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface WalletRepository {

    Mono<Transaction> makeTransaction(Transaction trx);
    Flux<Wallet> getAllWallets();
}
