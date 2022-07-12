package com.drw.digital.wallet.action;

public interface GenericTransaction {

    void makeTransaction(String fromAccount, String toAccount, double amount);

}
