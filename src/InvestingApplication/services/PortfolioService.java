package InvestingApplication.services;

import java.util.List;

import InvestingApplication.models.PortfolioProfilePerUser;
import InvestingApplication.models.Transaction;

public interface PortfolioService {
	
	void buyStock(String userName,String symbol,int qty);
	
	void sellStock(String userName,String symbol, int qty);
	
	List<Transaction> history();
	
	List<PortfolioProfilePerUser> profile(String userName);

}
