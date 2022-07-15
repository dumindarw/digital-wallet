package com.drw.digital.wallet.service;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.model.Wallet;
import com.drw.digital.wallet.repo.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WalletService {

    @Autowired
    WalletRepository repository;

    public Flux<Wallet> getAllWallets(){
        return repository.getAllWallets();
    }

    public Mono<Transaction> makeTransaction(Transaction trx){
        return repository.makeTransaction(trx);

        repository.updateWallte(txt);
    }
}
