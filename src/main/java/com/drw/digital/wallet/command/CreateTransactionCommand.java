package com.drw.digital.wallet.command;

import com.drw.digital.wallet.action.DebitTransaction;
import com.drw.digital.wallet.action.GenericTransaction;
import com.drw.digital.wallet.action.TransferTransaction;
import com.drw.digital.wallet.action.WithdrawTransaction;

import java.util.Map;

public class CreateTransactionCommand {

    private static final Map<String, TransactionCommand> TRANSACTIONS;

    static {
        TRANSACTIONS = Map.of(
                "withdraw", WithdrawTransaction::new,
                "debit", DebitTransaction::new,
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
