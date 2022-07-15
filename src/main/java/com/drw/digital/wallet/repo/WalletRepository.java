package com.drw.digital.wallet.repo;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.model.Wallet;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.UpdateRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface WalletRepository {

    Flux<Wallet> getAllWallets();
    Mono<Wallet> createWallet(Wallet wallet);
    Flux<Wallet> updateWalletBalance(Wallet balance);
}
