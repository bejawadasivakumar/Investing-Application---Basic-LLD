package InvestingApplication;

import InvestingApplication.exceptions.UserNotFoundException;
import InvestingApplication.models.Stock;
import InvestingApplication.models.User;
import InvestingApplication.services.PortfolioService;
import InvestingApplication.services.StockService;
import InvestingApplication.services.UserService;
import InvestingApplication.servicesImpl.PortfolioServiceImpl;
import InvestingApplication.servicesImpl.StockServiceImpl;
import InvestingApplication.servicesImpl.UserServiceImpl;

public class InvestingApplicationMain {
	
	public static void main(String[] args) {
//		System.out.println("---Investing Application---");
//		
//		try {
//		//User
//		UserService userService = new UserServiceImpl();
//		userService.addUser(new User(1,"siva",20000));
//		String name = "sivla";
//		if(userService.getUser(name) != null) {
//		System.out.println(userService.getUser(name));
//		}
//		else {
//			System.out.println("Not found with the given name");
//		}
//		
//		//stock
//		StockService stockService = new StockServiceImpl();
//		stockService.addStock(new Stock("INFY","infosys private limited", 10000));
////		String stockSymbol = "INFY";
////		if(stockService.getStock(stockSymbol) != null) {
////			System.out.println(stockService.getStock(stockSymbol));
////		}
////		else {
////			System.out.println("Not found with the given stockSymbol");
////		}
////		if(stockService.getStock(stockSymbol) != null) {
////			stockService.updatePrice(stockSymbol, 20000);
////		}
////		else {
////			System.out.println("Not found with the given stockSymbol");
////		}
//		
//		// portfolio
//		PortfolioService portfolioService = new PortfolioServiceImpl(userService,stockService);
//		portfolioService.buyStock("siva", "INFY", 2);
//		portfolioService.sellStock("siva", "INFY", 1);
//		System.out.println(portfolioService.history());
//		System.out.println(portfolioService.profile("siva"));
//		}
//		catch(UserNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		
		 System.out.println("------ Investing Application ------");

	        UserService userService = new UserServiceImpl();
	        StockService stockService = new StockServiceImpl();
	        PortfolioService portfolioService =
	                new PortfolioServiceImpl(userService, stockService);

	        try {

	            // Add User
	            userService.addUser(new User(1, "siva", 20000));

	            // Find User
	            System.out.println(userService.getUser("siva"));

	            // Add Stock
	            stockService.addStock(new Stock("INFY", "Infosys Pvt Ltd", 10000));

	            // Buy Stock
	            portfolioService.buyStock("siva", "INFY", 2);

	            // Sell Stock
	            portfolioService.sellStock("siva", "INFY", 1);

	            // History
	            System.out.println("\nTransaction History");
	            System.out.println(portfolioService.history());

	            // Portfolio
	            System.out.println("\nPortfolio");
	            System.out.println(portfolioService.profile("siva"));

	        } catch (UserNotFoundException e) {

	            System.out.println("Error: " + e.getMessage());

	        } catch (Exception e) {

	            System.out.println("Unexpected Error: " + e.getMessage());
	        }
	}

}
