package com.drw.digital.wallet.service;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.model.Wallet;
import com.drw.digital.wallet.repo.TransactionRepository;
import com.drw.digital.wallet.repo.TransactionRepositoryImpl;
import com.drw.digital.wallet.repo.WalletRepository;
import com.drw.digital.wallet.repo.WalletRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository trxRepository;

    @Autowired
    WalletRepository walletRepository;

    public Mono<Transaction> makeTransaction(Transaction trx){
        return trxRepository.makeTransaction(trx).doOnNext(transaction -> {
            walletRepository.updateWalletBalance(new Wallet(transaction.getAmount()));
        });

        //TODO: Update wallet balance
        //repository.updateWallte(txt);
    }
}
