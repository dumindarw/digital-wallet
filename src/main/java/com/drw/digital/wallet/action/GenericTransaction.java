package com.drw.digital.wallet.action;

import com.drw.digital.wallet.model.Transaction;
import reactor.core.publisher.Mono;

public interface GenericTransaction {

    Mono<Transaction> makeTransaction(String fromWalletID, String toAccount, double amount);

}
