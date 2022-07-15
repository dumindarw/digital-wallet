package com.drw.digital.wallet.api;

import com.drw.digital.wallet.command.CreateTransactionCommand;
import com.drw.digital.wallet.action.GenericTransaction;
import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.model.Wallet;
import com.drw.digital.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController(value = "/wallets")
public class WalletController {

    @Autowired
    private WalletService service;

    @GetMapping
    private Flux<Wallet> getAllWallets(){
        return service.getAllWallets();
    }

    @PostMapping
    private Mono<Void> createWallet(@RequestBody Wallet){

    }

    @PutMapping(path = "/{walletId}/money")
    private Mono<Void> transactMoney(@PathVariable String fromWalletId, @RequestParam String action, @RequestBody Transaction transaction){

        CreateTransactionCommand createTransactionCommand = new CreateTransactionCommand();
        GenericTransaction trx = createTransactionCommand.createTransaction(action);

        trx.makeTransaction(fromWalletId, transaction.getToWalletId(), transaction.getAmount());

    }
}
