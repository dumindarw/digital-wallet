package com.drw.digital.wallet.action;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.repo.WalletRepository;
import com.drw.digital.wallet.service.TransactionService;
import com.drw.digital.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import reactor.core.publisher.Mono;
@Component
public class WithdrawTransaction implements GenericTransaction {

    @Autowired
    TransactionService service;



    @Override
    public Mono<Transaction> makeTransaction(String fromAccount, String toAccount, double amount) {
       return service.makeTransaction(new Transaction(fromAccount, fromAccount,  -amount));
    }
}
