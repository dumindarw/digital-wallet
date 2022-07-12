package com.drw.digital.wallet.model;

import lombok.Data;

@Data
public class Transaction {

    int id;
    String toWalletId;
    double amount;
}
