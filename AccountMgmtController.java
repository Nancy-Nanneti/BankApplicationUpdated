package com.bookapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookapp.model.entities.Account;
import com.bookapp.model.entities.AccountType;
import com.bookapp.model.entities.User;
import com.bookapp.model.service.AccountService;
import com.bookapp.model.service.TransactionLogService;
import com.bookapp.model.service.UserService;
import com.bookapp.web.formbeans.AccountBean;
import com.bookapp.web.formbeans.DepositBean;
import com.bookapp.web.formbeans.TransferBean;
import com.bookapp.web.formbeans.WithdrawBean;

import LoginDetailsVerification.ValidUser;

@Controller
public class AccountMgmtController {
	
	private AccountService accountService;
	private TransactionLogService transactionLogService;
	
	@Autowired
	public AccountMgmtController(AccountService accountService, TransactionLogService transactionLogService) {
		super();
		this.accountService = accountService;
		this.transactionLogService = transactionLogService;
	}

	@GetMapping("success")
	public String success() {
		return "success";
	}
	
	@GetMapping("welcome")
	public String welcome() {
		return "welcome";
	}
	
	
	@GetMapping("ShowAll")
		public ModelAndView showallaccounts(ModelAndView mv) {
			mv.setViewName("ShowAll");
			mv.addObject("accounts", accountService.getAllAccounts());
			return mv;
	}

	
	@GetMapping("showalltransactions")
	public ModelAndView showalltransactions(ModelAndView mv) {
		mv.setViewName("showalltransactions");
		mv.addObject("transactions", transactionLogService.getAllTransactionLogs());
		return mv;
	}

	
	@GetMapping("deleteaccount")
	public String delAccountBook(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		accountService.delAccount(id);
		return "redirect:/showallaccounts";
	}
	
	@GetMapping("updateaccount")
	public String addAccountGet(HttpServletRequest req, ModelMap map) {
		int id = Integer.parseInt(req.getParameter("id"));
		Account account = accountService.getAccountById(id);
		map.addAttribute("account", account);
		return "updateaccount";
	}
	
	
	@GetMapping("addaccount")
	public String addAccountGet(ModelMap map) {
		map.addAttribute("accountBean", new AccountBean());
		return "addaccount";
	}

	@PostMapping("addaccount")
	public String addAccountPost(@Valid @ModelAttribute("accountBean") Account accountBean, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/addaccount";
		} else {
			if (accountBean.getAid() == 0) {
				accountService.addAccount(accountBean);
			} else {
				accountService.updateAccount(accountBean.getAid(), accountBean);
			}
			return "redirect:/showallaccounts";
		}
	}

	
	@GetMapping("transfer")
	public String transferAmountGet(ModelMap model) {
		model.addAttribute("transferBean", new TransferBean());
		return "transfer";
	}
	
	@PostMapping("transfer")
	public String transferAmountPost(@Valid @ModelAttribute(name="transferBean")  TransferBean transferBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "transfer";
		}
		else {
		int fromAccount=transferBean.getFromAccountId();
		int toAccount=transferBean.getFromAccountId();
		double amount=transferBean.getToAccountId();

		accountService.transfer(fromAccount,toAccount,amount);
		return "redirect:/success";
		}
	}

	@GetMapping("withdraw")
	public String WithdrawAmountGet(ModelMap model) {
		model.addAttribute("withdrawBean", new WithdrawBean());
		return "withdraw";
	}
	
	@PostMapping("withdraw")
	public String WithdrawAmountPost(@Valid @ModelAttribute(name="withdrawBean")  WithdrawBean withdrawBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/success";
		}
		else {
		int fromAccount=withdrawBean.getFromAccountId();
		double amount=withdrawBean.getAmount();
	  accountService.withdraw(fromAccount, amount);
		return "redirect:/success";
		}
	}
	
	@GetMapping("deposit")
	public String DepositAmountGet(ModelMap model) {
		model.addAttribute("depositBean", new DepositBean());
		return "deposit";
	}
	
	@PostMapping("deposit")
	public String DepositAmountPost(@Valid @ModelAttribute(name="depositBean") DepositBean depositBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "deposit";
		}
		else {
		int fromAccount=depositBean.getFromAccountId();
		double amount=depositBean.getFromAccountId();
	  accountService.deposit(fromAccount, amount);
		return "redirect:/success";
		}
	}
}

//	
//	@GetMapping("login")
//	public String LoginControllerGet(ModelMap model) {
//		model.addAttribute("loginBean", new LoginBean());
//		return "login";
//	}
//	
//	@PostMapping("login")
//	public String LoginControllerPost(@Valid @ModelAttribute(name="loginBean")  LoginBean loginBean, BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return "redirect:/login";
//		}
//		String username=loginBean.getUsername();
//		String password=loginBean.getPassword();
//		if(username!=null && password!=null) {
//			return "success";
//		}
//		else {
//			return "login";
//		}
//	}
//	@GetMapping("logout")
//	public String LogoutControllerGet(ModelMap model) {
//		model.addAttribute("logoutBean", new LogoutBean());
//		return "welcome";
//	}	
//		// boolean isValidUser = ValidUser.isValidUser(loginBean.getUsername(), loginBean.getPassword());
//		User user=
//		
//         if(isValidUser)
//         {
//             System.out.println("User Login Successful");
//             return "transfer";
//         }
//         else {
//        	 return "redirect:/login";
//         }
//        
//		String username=loginBean.getUsername();
//		String password=loginBean.getPassword();
//		User.login(username,password);
//		
		//return "redirect:/success";
/*//ModelAndView mv=new ModelAndView();
//Account a1=new Account("nancy", "bvrm", 5000.0, "9949683316", "nancy@gmail.com", "868811983", "AP5432", AccountType.Saving);
//Account a2=new Account("swathi", "hyd", 5000.0, "994654326", "swathi@gmail.com", "86645983", "TS32456", AccountType.Saving);

//accountService.addAccount(a1);
//accountService.addAccount(a2);

//accountService.transfer(1, 2, 100);
 * mv.setViewName("show");
		mv.addObject("key", "bank app");
 */
