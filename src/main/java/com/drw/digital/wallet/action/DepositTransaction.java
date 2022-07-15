package com.drw.digital.wallet.action;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.service.TransactionService;
import com.drw.digital.wallet.service.WalletService;
import com.drw.digital.wallet.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import reactor.core.publisher.Mono;

@Component
public class DepositTransaction implements GenericTransaction {

    //@Autowired
    private TransactionService service;


    @Override
    public Mono<Transaction> makeTransaction(String fromWalletID, String toAccount, double amount) {
        service = SpringUtils.ctx.getBean(TransactionService.class);
        return service.makeTransaction(new Transaction(fromWalletID, fromWalletID,  amount));
    }
}
