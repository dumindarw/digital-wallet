package com.drw.digital.wallet.service;

import com.drw.digital.wallet.model.Transaction;
import com.drw.digital.wallet.model.Wallet;
import com.drw.digital.wallet.repo.TransactionRepository;
import com.drw.digital.wallet.repo.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WalletService {



    @Autowired
    WalletRepository walletRepository;

    public Flux<Wallet> getAllWallets(){
        return walletRepository.getAllWallets();
    }

    public Mono<Wallet> createWallet(Wallet wallet){
        return walletRepository.createWallet(wallet);
    }


}
