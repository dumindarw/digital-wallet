package com.drw.digital.wallet.action;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.repo.WalletRepository;
import com.drw.digital.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class WithdrawTransaction implements GenericTransaction {

    @Autowired
    WalletService service;

    @Override
    public Mono<Transaction> makeTransaction(String fromAccount, String toAccount, double amount) {
       return service.makeTransaction(new Transaction(fromAccount, fromAccount,  -amount));
    }
}
