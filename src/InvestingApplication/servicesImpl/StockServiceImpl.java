package InvestingApplication.servicesImpl;

import java.util.HashMap;
import java.util.Map;

import InvestingApplication.exceptions.DuplicateStockException;
import InvestingApplication.exceptions.StockNotFoundException;
import InvestingApplication.models.Stock;
import InvestingApplication.services.StockService;

public class StockServiceImpl implements StockService {
	
	Map<String,Stock> stockData = new HashMap<>();
	
	public void addStock(Stock stock) {
		if(stockData.containsKey(stock.getSymbol())) {
			throw new DuplicateStockException("stock already exists");
		}
		else {
			stockData.put(stock.getSymbol(), stock);
			System.out.println("stock is added");
		}
	}
	
	public Stock getStock(String symbol) {
		if(!stockData.containsKey(symbol)) {
			throw new StockNotFoundException("stock is not found");
		}
		return stockData.get(symbol);
	}
	
	public void updatePrice(String symbol, double price) {
		if(!stockData.containsKey(symbol)) {
			throw new StockNotFoundException("stock is not found");
		}
		Stock stock = stockData.get(symbol);
		stock.setPrice(price);
		System.out.println("price is updated in stock");
	}

}
