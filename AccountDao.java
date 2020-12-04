package com.bookapp.model.dao;



public interface AccountDao {
	public List<Account> getAllAccounts();
	public Account updateAccount(Account account);
	public Account updateAccount(int id,Account account);
	public Account delAccount(int accountId);
	public Account getAccountById(int accountId);
	public Account addAccount(Account account);
	

}
