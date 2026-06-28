<b>1. Abstraction using Interfaces</b></br>

Instead of directly creating service classes, create interfaces.</br>
example : </br>
UserService.java</br>
public interface UserService {</br>
    void addUser(int id,String name);</br>
}</br>
This interface hide implementation details.</br>
This is Abstraction.</br>

<b>2. Polymorphism</b></br>

In Main.java</br>

Instead of UserServiceImpl userService = new UserServiceImpl();</br>

write:</br>
UserService userService = new UserServiceImpl();</br>
StockService stockService = new StockServiceImpl();</br>
PortfolioService portfolioService = new PortfolioServiceImpl();</br>

Notice that Left side is UserService</br>
Right side is UserServiceImpl()</br>

This is <b>Runtime Polymorphism</b></br>
because the interface reference points to different implementations.</br>

Tomorrow if you write:</br>
UserService userService = new PremiumUserServiceImpl(); nothing changes in Main.</br>

<b>3. Encapsulation</b>
Data is hidden using private.This is encapsulation.</br>

<b>4. Composition</b></br>

PortfolioProfilePerUser contains Stock and User.</br>

public class PortfolioProfilePerUser{</br>
  private User user;</br>
	private Stock stock;</br>
	private TradingBuyOrSell type;</br>
	private int quantity;</br>
}</br>
PortfolioProfilePerUser HAS-A Stock,User and TradingBuyOrSell.</br>
This is <b>composition.</b>
