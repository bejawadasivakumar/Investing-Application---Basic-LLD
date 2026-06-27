package InvestingApplication.models;

public class Transaction {
	
	private String userName;
	private String symbol;
	private int qty;
	private TradingBuyOrSell type;
	public Transaction(String userName, String symbol, int qty, TradingBuyOrSell type) {
		super();
		this.userName = userName;
		this.symbol = symbol;
		this.qty = qty;
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public TradingBuyOrSell getType() {
		return type;
	}
	public void setType(TradingBuyOrSell type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Transaction [userName=" + userName + ", symbol=" + symbol + ", qty=" + qty + ", type=" + type + "]";
	}

}
