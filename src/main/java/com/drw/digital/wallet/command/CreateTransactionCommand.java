package com.drw.digital.wallet.command;

import com.drw.digital.wallet.action.DepositTransaction;
import com.drw.digital.wallet.action.GenericTransaction;
import com.drw.digital.wallet.action.TransferTransaction;
import com.drw.digital.wallet.action.WithdrawTransaction;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.util.Map;

public class CreateTransactionCommand {

    private static final Map<String, TransactionCommand> TRANSACTIONS;

    static ReactiveMongoTemplate reactiveMongoTemplate;

    static {
        TRANSACTIONS = Map.of(
                "withdraw", WithdrawTransaction::new,
                "deposit", DepositTransaction::new,
                "transfer", TransferTransaction::new
        );
    }

    public GenericTransaction createTransaction(String actionType){
        TransactionCommand command = TRANSACTIONS.get(actionType);

        if(command == null) {
            throw new IllegalArgumentException("Invalid transaction type: " + actionType);
        }

        return command.create();
    }
}
