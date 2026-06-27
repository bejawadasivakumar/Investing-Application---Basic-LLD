package InvestingApplication;

import InvestingApplication.models.Stock;
import InvestingApplication.models.User;
import InvestingApplication.services.PortfolioService;
import InvestingApplication.servicesImpl.PortfolioServiceImpl;
import InvestingApplication.servicesImpl.StockServiceImpl;
import InvestingApplication.servicesImpl.UserServiceImpl;

public class InvestingApplicationMain {
	
	public static void main(String[] args) {
		System.out.println("---Investing Application---");
		
		//User
		UserServiceImpl userService = new UserServiceImpl();
		userService.addUser(new User(1,"siva",20000));
//		String name = "siva";
//		if(userService.getUser(name) != null) {
//		System.out.println(userService.getUser(name));
//		}
//		else {
//			System.out.println("Not found with the given name");
//		}
		
		//stock
		StockServiceImpl stockService = new StockServiceImpl();
		stockService.addStock(new Stock("INFY","infosys private limited", 10000));
//		String stockSymbol = "INFY";
//		if(stockService.getStock(stockSymbol) != null) {
//			System.out.println(stockService.getStock(stockSymbol));
//		}
//		else {
//			System.out.println("Not found with the given stockSymbol");
//		}
//		if(stockService.getStock(stockSymbol) != null) {
//			stockService.updatePrice(stockSymbol, 20000);
//		}
//		else {
//			System.out.println("Not found with the given stockSymbol");
//		}
		
		// portfolio
		PortfolioService portfolioService = new PortfolioServiceImpl(userService,stockService);
		portfolioService.buyStock("siva", "INFY", 2);
		portfolioService.sellStock("siva", "INFY", 1);
		System.out.println(portfolioService.history());
		System.out.println(portfolioService.profile("siva"));
		
	}

}
