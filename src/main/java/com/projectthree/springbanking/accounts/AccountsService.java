package com.projectthree.springbanking.accounts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;
}
