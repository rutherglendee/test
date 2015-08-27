package me.ianrae.jptest;

import java.util.concurrent.TimeUnit;

public class SuperSimpleMain {

	static private void testTea () {
		Stock tea = new Stock("Tea");
		double res;
		tea.setCommon(true);
		tea.setLastDividend(0);
		tea.setParValue(100);
		
		System.out.println("=== Tea ===");
		// Test 1 simple dividend yield test
		res = tea.calculateDividendYield(125);
		System.out.print ("Tea dividend yield, market price 125: ");
		System.out.println (res);
		
		// Test 2 simple dividend yield test
		res = tea.calculatePERatio(140);
		System.out.print ("Tea PE ratio, market price 140: ");
		System.out.println (res);
				
		// Test 3 Geometric Mean
		tea.recordTrade(1,10, true); 
		tea.recordTrade(5, 20, true);
		tea.recordTrade(200, 500, true);
		res = tea.geometricMean();
		System.out.print ("Geometric Mean: ");
		System.out.println (res);
				
		// Test 4 Geometric Mean
		res = tea.volumeWeightedStockPrice();
		System.out.print ("Volume Weigted: ");
		System.out.println (res);
				
	}
	
	static private void testPop () {
		Stock pop = new Stock("Pop");
		double res;
		pop.setCommon(true);
		pop.setLastDividend(8);
		pop.setParValue(100);
		
		System.out.println("=== Pop ===");
		// Test 1 simple dividend yield test
		res = pop.calculateDividendYield(140);
		System.out.print ("pop dividend yield, market price 140: ");
		System.out.println (res);
		
		// Test 2 simple dividend yield test
		res = pop.calculatePERatio(140);
		System.out.print ("pop PE ratio, market price 210: ");
		System.out.println (res);
				
		// Test 3 Geometric Mean
		pop.recordTrade(1, 500, true); 
		pop.recordTrade(5, 20, true);
		pop.recordTrade(200, 1, true);
		res = pop.geometricMean();
		System.out.print ("Geometric Mean: ");
		System.out.println (res);
				
		// Test 4 Geometric Mean
		res = pop.volumeWeightedStockPrice();
		System.out.print ("Volume Weigted: ");
		System.out.println (res);
		
	}
	
	static private void testAle () {
		Stock ale = new Stock("Ale");
		double res;
		ale.setCommon(true);
		ale.setLastDividend(23);
		ale.setParValue(60);
		
		System.out.println("=== Ale ===");
		// Test 1 simple dividend yield test
		res = ale.calculateDividendYield(410);
		System.out.print ("pop dividend yield, market price 410: ");
		System.out.println (res);
		
		// Test 2 simple dividend yield test
		res = ale.calculatePERatio(730);
		System.out.print ("pop PE ratio, market price 730: ");
		System.out.println (res);
				
		// Test 3 Geometric Mean
		ale.recordTrade(1, 20, true); 
		ale.recordTrade(5, 100, true);
		ale.recordTrade(200, 30, true);
		res = ale.geometricMean();
		System.out.print ("Geometric Mean: ");
		System.out.println (res);
				
		// Test 4 Geometric Mean
		res = ale.volumeWeightedStockPrice();
		System.out.print ("Volume Weigted: ");
		System.out.println (res);
		
		
	}
	
	static private void testGin () {
		Stock gin = new Stock("Gin");
		double res;
		gin.setCommon(false);
		gin.setLastDividend(8);
		gin.setParValue(100);
		gin.setFixedDividend(2.0);
		
		System.out.println("=== Gin ===");
		// Test 1 simple dividend yield test
		res = gin.calculateDividendYield(521);
		System.out.print ("pop dividend yield, market price 521: ");
		System.out.println (res);
		
		// Test 2 simple dividend yield test
		res = gin.calculatePERatio(679);
		System.out.print ("pop PE ratio, market price 679: ");
		System.out.println (res);
				
		// Test 3 Geometric Mean
		gin.recordTrade(1, 293, true); 
		gin.recordTrade(5, 309, true);
		gin.recordTrade(200, 7895, true);
		res = gin.geometricMean();
		System.out.print ("Geometric Mean: ");
		System.out.println (res);
				
		// Test 4 Geometric Mean
		res = gin.volumeWeightedStockPrice();
		System.out.print ("Volume Weigted: ");
		System.out.println (res);
		
		
	}
	
	static private void testJoe () throws InterruptedException {
		Stock joe = new Stock("Joe");
		double res;
		joe.setCommon(true);
		joe.setLastDividend(13);
		joe.setParValue(250);
		
		System.out.println("=== Joe ===");
		// Test 1 simple dividend yield test
		res = joe.calculateDividendYield(960);
		System.out.print ("Joe dividend yield, market price 960: ");
		System.out.println (res);
		
		// Test 2 simple dividend yield test
		res = joe.calculatePERatio(885);
		System.out.print ("Joe PE ratio, market price 885: ");
		System.out.println (res);
				
		// Test 3 Geometric Mean
		joe.recordTrade(1, 500, true); 
		joe.recordTrade(5, 20, true);
		joe.recordTrade(200, 1, true);
		TimeUnit.MINUTES.sleep(15);
		TimeUnit.SECONDS.sleep(1);
		joe.recordTrade(1, 293, true); 
		joe.recordTrade(5, 309, true);
		joe.recordTrade(200, 7895, true);
		res = joe.geometricMean();
		System.out.print ("Geometric Mean: ");
		System.out.println (res);
				
		// Test 4 Geometric Mean
		res = joe.volumeWeightedStockPrice();
		System.out.print ("Volume Weigted: ");
		System.out.println (res);
		
		
	}
	
	public static void main(String[] args) {
		
		testTea();
		testPop();
		testAle();
		testGin();
		try {
			testJoe();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
