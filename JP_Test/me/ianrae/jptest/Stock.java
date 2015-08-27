package me.ianrae.jptest;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

/**
 * @author Ian
 *
 */
public class Stock {

	private double fixedDividend;
	private boolean isCommon;
	private int lastDividend; // in pennies
	private String name;
	private int parValue; // in pennies
	private final double SMALL_DOUBLE = 0.01;
	private ArrayList<Trade> allTrades;
	
	/**
	 * Default Constructor
	 * @param name
	 */
	public Stock(String name) {
		super();
		this.name = name;
		allTrades = new ArrayList<Trade>();
	}

	double getFixedDividend() {
		return fixedDividend;
	}
	void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	boolean isCommon() {
		return isCommon;
	}
	void setCommon(boolean isCommon) {
		this.isCommon = isCommon;
	}
	int getLastDividend() {
		return lastDividend;
	}
	void setLastDividend(int lastDividend) {
		this.lastDividend = lastDividend;
	}
	String getName() {
		return name;
	}
	int getParValue() {
		return parValue;
	}
	void setParValue(int parValue) {
		this.parValue = parValue;
	}

	public boolean isCloseToZero(double value, double threshold){
	    return value >= -threshold && value <= threshold;
	}
	
	/**
	 * 
	 * calculateDividendYield
	 * 
	 * This method returns the calculated dividend yield checking first that the Market Price is not close to 0. 
	 * 
	 * @param marketPrice
	 * @return dividend yield
	 * 
	 */
	 double calculateDividendYield (int marketPrice) {
		double result = 0.0;
		if (marketPrice != 0) {
			// Can divide by marketPrice
			if (isCommon = true) {
				result = (double)lastDividend / (double)marketPrice;
			} else {
				result = (fixedDividend * parValue) / marketPrice; 
			}
		} else {
			System.out.println("Can't calculate Dividend Yield since Market Price is zero pence");
		}
		return result;
	}
	
	/**
	 * calculatePERatio
	 * 
	 * Returns the PE Ratio having checked that lastDividend is not 0
	 * 
	 * @param marketPrice
	 * @return
	 */
	double calculatePERatio (int marketPrice) {
		double result = 0.0;
		if (lastDividend != 0) {
			// Can divide by marketPrice
			result = marketPrice / lastDividend;
		} else {
			System.out.println("Can't calculate PE Ratio since Dividend is zero pence");
		}
		return result;
	}
	
	
	/**
	 * recordTrade
	 * 
	 * Adds a new trade to the list
	 * 
	 * @param price
	 * @param quantity
	 * @param isBuy
	 */
	void recordTrade(int price, int quantity, boolean isBuy) {
		Trade newTrade = new Trade (price, quantity, isBuy);
		allTrades.add(newTrade);
	}
	
	/**
	 * geometricMean
	 * Calculate the geometric mean
	 * 
	 * @return geometric mean of all trades
	 */
	double geometricMean () {
		double mean = 1.0;
		int numTrades = 0;
		
		// for all trades in the list, multiply the price and count the number of trades
		for (ListIterator<Trade> it = allTrades.listIterator(); it.hasNext(); ) {
			Trade trade = it.next();
			mean *= trade.getPrice();
			numTrades += 1;
		}
		
		if (numTrades > 0) { 
			mean = Math.pow(mean, 1.0 / (double) numTrades);
		} else {
			mean = 0.0;
			System.out.println("Can't calculate geomertic mean since no trades to process");
		}

		return mean;
	}

	/**
	 * @return weighted stock price for the last 15 minutes
	 */
	double volumeWeightedStockPrice () {
		double result = 0.0;
		double priceFactor = 0.0;
		double quantityFactor = 0.0;
		int numTrades = 0;
		final Date lastTime = new Date(System.currentTimeMillis()-15*60*1000);
		
		// start at end of list and calculate the weighted stock price. Stop when the trade is too early
		for (ListIterator<Trade> it = allTrades.listIterator(allTrades.size()); it.hasPrevious(); ) {
		    Trade trade = it.previous();
		    Date tradeTime = trade.getTimestamp();
		    if (tradeTime.after(lastTime)) {
		    	numTrades += 1;
		    	priceFactor += trade.getPrice() * trade.getQuantity();
		    	quantityFactor += trade.getQuantity();
		    } else {
		    	break;
		    }
	    
		}
		
		if (numTrades > 0) {
			result = priceFactor / quantityFactor;
		} else {
			result = 0.0;
			System.out.println("Can't calculate weighted stock price since no trades to process");
		}

		return result;
	}
	
}
