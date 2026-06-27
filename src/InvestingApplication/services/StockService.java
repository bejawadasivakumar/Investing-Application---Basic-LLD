package InvestingApplication.services;

import InvestingApplication.models.Stock;

public interface StockService {

	void addStock(Stock stock);
	Stock getStock(String symbol);
	void updatePrice(String symbol, double price);
}
