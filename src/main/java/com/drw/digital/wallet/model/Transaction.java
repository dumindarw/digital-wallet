package com.drw.digital.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Transaction {

    int id;
    String fromWalletId;
    String toWalletId;
    double amount;

    public Transaction(String fromWalletId,String toWalletId, double amount){
        this.toWalletId = toWalletId;
        this.fromWalletId = fromWalletId;
        this.amount = amount;
    }
}
