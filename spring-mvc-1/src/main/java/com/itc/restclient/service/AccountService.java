package com.itc.restclient.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.Account;
import com.itc.restclient.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public Optional<Account> getAccountInformation(Long id) {
		return accountRepository.findById(id);
	}

	public Account depositAmount(Account account) throws Exception {

		Optional<Account> dbaccount1 = accountRepository.findById(account.getId());
		if (dbaccount1.isEmpty()) {
			throw new Exception("We do not have an account with this id or account number");
		}
		Account dbacount = dbaccount1.get();
		BigDecimal currentbalance = dbacount.getBalance();
		BigDecimal depositamount = account.getBalance();

		BigDecimal Totalamount = currentbalance.add(depositamount);
		System.out.println(Totalamount);
		dbacount.setBalance(Totalamount);

		Account amountafterdeposit = accountRepository.save(dbacount);

		return amountafterdeposit;

	}

	public Account withdrawAmount(Account account) throws Exception {
		Optional<Account> dbaccount1 = accountRepository.findById(account.getId());
		if (dbaccount1.isEmpty()) {
			throw new Exception("We do not have an account with this id or account number");
		}
		Account dbaccountinfo = dbaccount1.get();
		BigDecimal currentBalance = dbaccountinfo.getBalance();
		BigDecimal withdrwarAmount = account.getBalance();

		if (currentBalance.intValueExact() < withdrwarAmount.intValueExact()) {
			throw new Exception("You do not have sufficient amount");
		}

		BigDecimal withdraramount1 = currentBalance.subtract(withdrwarAmount);
		dbaccountinfo.setBalance(withdraramount1);

		System.out.println(withdraramount1);
		Account dbdetail = accountRepository.save(dbaccountinfo);

		return dbdetail;

	}
	

	

}
