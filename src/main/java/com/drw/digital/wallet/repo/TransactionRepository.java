package com.drw.digital.wallet.repo;

import com.drw.digital.wallet.model.Transaction;
import reactor.core.publisher.Mono;

public interface TransactionRepository {

    Mono<Transaction> makeTransaction(Transaction trx);
}
