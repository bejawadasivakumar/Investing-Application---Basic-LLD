package InvestingApplication.models;

public class Stock {
	
	private String symbol; // INFY, TCS, HDFC
	private String company;
	private double price;
	
	public Stock() {
		
	}

	public Stock(String symbol, String company, double price) {
		super();
		this.symbol = symbol;
		this.company = company;
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", company=" + company + ", price=" + price + "]";
	}
	
}
