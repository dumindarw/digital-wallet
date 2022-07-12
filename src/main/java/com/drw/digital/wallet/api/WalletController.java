package com.drw.digital.wallet.api;

import com.drw.digital.wallet.command.CreateTransactionCommand;
import com.drw.digital.wallet.action.GenericTransaction;
import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.model.Wallet;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController(value = "/wallets")
public class WalletController {

    @GetMapping
    private Mono<List<Wallet>> getAllWallets(){

    }

    @PostMapping
    private Mono<Void> createWallet(@RequestBody Wallet){

    }

    @PutMapping(path = "/{walletId}/money")
    private Mono<Void> transactMoney(@PathVariable String walletId, @RequestParam String action, @RequestBody Transaction transaction){

        CreateTransactionCommand createTransactionCommand = new CreateTransactionCommand();
        GenericTransaction trx = createTransactionCommand.createTransaction(action);

        trx.makeTransaction(walletId, transaction.getToWalletId(), transaction.getAmount());

    }
}
