package com.drw.digital.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "wallets")
public class Wallet {

    @Id
    String walletId;
    String walletName;
    double walletBalance;

    public Wallet( double walletBalance){
        this.walletBalance = walletBalance;
    }
}
