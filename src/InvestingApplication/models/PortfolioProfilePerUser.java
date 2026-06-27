package InvestingApplication.models;

public class PortfolioProfilePerUser {
	
	private User user;
	private Stock stock;
	private TradingBuyOrSell type;
	private int quantity;
	
	public PortfolioProfilePerUser(User user, Stock stock, TradingBuyOrSell type, int quantity) {
		super();
		this.user = user;
		this.stock = stock;
		this.type = type;
		this.quantity = quantity;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public TradingBuyOrSell getType() {
		return type;
	}
	public void setType(TradingBuyOrSell type) {
		this.type = type;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "PortfolioProfilePerUser [user=" + user + ", stock=" + stock + ", type=" + type + ", quantity="
				+ quantity + "]";
	}
}
