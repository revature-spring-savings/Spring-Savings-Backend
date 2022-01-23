package com.projectthree.springbanking.accounts;

import com.projectthree.springbanking.transactions.TransactionsEntity;
import com.projectthree.springbanking.users.UsersEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountsServiceTest {

    @Mock
    private AccountsRepository accountsRepository;

    @InjectMocks
    private AccountsService accountsService;

    @Test
    void allAccounts() {
        List<AccountsEntity> accounts = new ArrayList();

        accounts.add(new AccountsEntity(1, 1, "checking", 500, new UsersEntity(), new HashSet<TransactionsEntity>()));
        accounts.add(new AccountsEntity(2, 2, "checking", 500, new UsersEntity(), new HashSet<TransactionsEntity>()));
        accounts.add(new AccountsEntity(3, 3, "checking", 500, new UsersEntity(), new HashSet<TransactionsEntity>()));

        given(accountsRepository.findAll()).willReturn(accounts);

        List<AccountsEntity> expected = accountsService.allAccounts();

        assertEquals(expected, accounts);
    }

    @Test
    void allAccountsByID() {
        List<AccountsEntity> accounts = new ArrayList();

        accounts.add(new AccountsEntity(1, 1, "checking", 500, new UsersEntity(), new HashSet<TransactionsEntity>()));
        accounts.add(new AccountsEntity(2, 1, "checking", 500, new UsersEntity(), new HashSet<TransactionsEntity>()));
        accounts.add(new AccountsEntity(3, 1, "checking", 500, new UsersEntity(), new HashSet<TransactionsEntity>()));
        Integer userID = 1;
        given(accountsRepository.findByuserID(1)).willReturn(accounts);

        List<AccountsEntity> expected = accountsService.allAccountsByID(1);

        assertEquals(expected, accounts);

    }



    @Test
    void deposit() {
    }

    @Test
    void withdraw() {
    }

    @Test
    void createAccount() {
    }
}