package com.drw.digital.wallet.command;

import com.drw.digital.wallet.action.GenericTransaction;

public interface TransactionCommand {

    GenericTransaction create();
}
