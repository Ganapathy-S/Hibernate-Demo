package com.demo.oneToManyBidirectional;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private long id;

	private String name;
	
	private Set<Account> accounts = new HashSet<Account>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccounts(Account account){
		accounts.add(account);
		account.setUser(this);
	}
}
