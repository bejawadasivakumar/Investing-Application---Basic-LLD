package InvestingApplication.servicesImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import InvestingApplication.exceptions.InsufficientBalanceException;
import InvestingApplication.models.PortfolioProfilePerUser;
import InvestingApplication.models.Stock;
import InvestingApplication.models.TradingBuyOrSell;
import InvestingApplication.models.Transaction;
import InvestingApplication.models.User;
import InvestingApplication.services.PortfolioService;
import InvestingApplication.services.StockService;
import InvestingApplication.services.UserService;

public class PortfolioServiceImpl implements PortfolioService{
	
	 private UserService userService;
	 private StockService stockService;

	    public PortfolioServiceImpl(UserService userService,
	                                StockService stockService) {
	        this.userService = userService;
	        this.stockService = stockService;
	    }
	
	List<Transaction> history = new ArrayList<>();
	Map<String,List<PortfolioProfilePerUser>> profiles = new HashMap<>();

	@Override
	public void buyStock(String userName, String symbol, int qty) {
		User user = userService.getUser(userName);
		Stock stock = stockService.getStock(symbol);
		double price = stock.getPrice() * qty;
		if(user.getBalance() < price) {
			throw new InsufficientBalanceException("balance insufficent to buy the stock");
		}
		else {
		user.setBalance(user.getBalance() - price);
		if(!profiles.containsKey(userName)) {
			profiles.put(userName, new ArrayList<>());
		}
		profiles.get(userName).add(new PortfolioProfilePerUser(user,stock,TradingBuyOrSell.BUY,qty));
		history.add(new Transaction(user.getName(),stock.getSymbol(),qty,TradingBuyOrSell.BUY));
		System.out.println("stock purchased..");
		}	
	}

	@Override
	public void sellStock(String userName, String symbol, int qty) {
		User user = userService.getUser(userName);
		Stock stock = stockService.getStock(symbol);
		if(user == null || stock == null) {
			System.out.println("user or stock is not there..");
			return;
		}
		int ownShares = 0;

		for(Transaction t : history){

		    if(t.getUserName().equals(userName)
		       && t.getSymbol().equals(symbol)){

		        if(t.getType()==TradingBuyOrSell.BUY){

		            ownShares += t.getQty();

		        }else{

		            ownShares -= t.getQty();

		        }

		    }

		}
		if(ownShares < qty) {
			System.out.println("Not possible to sell the stock bcz quantity is less..");
		}
		else {
		double proceeds = stock.getPrice() * qty;
		user.setBalance(user.getBalance() + proceeds);
		if(!profiles.containsKey(userName)) {
			profiles.put(userName, new ArrayList<>());
		}
		profiles.get(userName).add(new PortfolioProfilePerUser(user,stock,TradingBuyOrSell.SELL,qty));
		history.add(new Transaction(user.getName(),stock.getSymbol(),qty,TradingBuyOrSell.SELL));
		System.out.println("Sold stock...");
		}
		
	}

	@Override
	public List<Transaction> history() {
		return history;
	}

	@Override
	public List<PortfolioProfilePerUser> profile(String userName) {
		
		return profiles.get(userName);
	}	
}
