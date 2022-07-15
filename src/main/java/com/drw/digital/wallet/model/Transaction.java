package com.drw.digital.wallet.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "transactions")
public class Transaction {

    @Id
    String id;
    String fromWalletId;
    String toWalletId;
    double amount;

    public Transaction(String fromWalletId,String toWalletId, double amount){
        this.toWalletId = toWalletId;
        this.fromWalletId = fromWalletId;
        this.amount = amount;
    }
}
