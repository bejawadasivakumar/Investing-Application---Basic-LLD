package InvestingApplication.servicesImpl;

import java.util.HashMap;
import java.util.Map;

import InvestingApplication.models.Stock;
import InvestingApplication.services.StockService;

public class StockServiceImpl implements StockService {
	
	Map<String,Stock> stockData = new HashMap<>();
	
	public void addStock(Stock stock) {
		if(stockData.containsKey(stock.getSymbol())) {
			System.out.println("stock already exists");
		}
		else {
			stockData.put(stock.getSymbol(), stock);
			System.out.println("stock is added");
		}
	}
	
	public Stock getStock(String symbol) {
		if(stockData.containsKey(symbol)) {
			return stockData.get(symbol);
		}
		return null;
	}
	
	public void updatePrice(String symbol, double price) {
		if(!stockData.containsKey(symbol)) {
			System.out.println("stock is not found");
		}
		Stock stock = stockData.get(symbol);
		stock.setPrice(price);
		System.out.println("price is updated in stock");
	}

}
