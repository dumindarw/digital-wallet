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


@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {

    @Autowired
    private WalletService service;

    @GetMapping
    private Flux<Wallet> getAllWallets(){
        return service.getAllWallets();
    }

    @PostMapping
    private Mono<Wallet> createWallet(@RequestBody Wallet wallet){
        return service.createWallet(wallet);
    }

    @PutMapping(path = "/{walletId}/money")
    private Mono<Transaction> transactMoney(@PathVariable String walletId, @RequestParam String action, @RequestBody Transaction transaction){

        CreateTransactionCommand createTransactionCommand = new CreateTransactionCommand();
        GenericTransaction trx = createTransactionCommand.createTransaction(action);

        transaction.setFromWalletId(walletId);

        return trx.makeTransaction(walletId, transaction.getToWalletId(), transaction.getAmount());

    }
}
