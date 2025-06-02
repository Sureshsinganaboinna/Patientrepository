package com.itc.restclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itc.restclient.entities.Account;
import com.itc.restclient.repository.AccountRepository;
import com.itc.restclient.service.AccountService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("Transaction")
public class Accountcontroller {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountService accountService;

	@PostMapping("saveAccountDetails")
	public Account saveAccountDetailss(@RequestBody Account account) {

		return accountRepository.save(account);

	}

	@GetMapping("Account/{id}")
	public ResponseEntity<Object> getAccountDetails(@PathVariable("id") Long id) {
		System.out.println(id);
		Optional<Account> accountinfo = accountService.getAccountInformation(id);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "success");
		resMap.put("response", accountinfo);
		return ResponseEntity.status(HttpStatus.OK).body(resMap);
	}

	@PostMapping("amountdeposite")
	public ResponseEntity<Map<String, Object>> depositMoney(@RequestBody Account account) throws Exception {

		Account db = accountService.depositAmount(account);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "success");
		resMap.put("response afetr deposit amount", db);
		return ResponseEntity.status(HttpStatus.OK).body(resMap);

	}

	@PostMapping("amountwithdraw")
	public ResponseEntity<Map<String, Object>> withdrawMoney(@RequestBody Account account) throws Exception {

		Account dbaccountinfo = accountService.withdrawAmount(account);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "success");
		resMap.put("response afetr deposit amount", dbaccountinfo);
		return ResponseEntity.status(HttpStatus.OK).body(resMap);

	}

}
