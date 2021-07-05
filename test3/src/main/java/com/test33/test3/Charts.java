package com.test33.test3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import smile.data.DataFrame;

public class Charts {
	
	public void companiesChart(DataFrame df) {
		
		//Get map of companies count (Key:Company Name, Value:Count)
		Map<String, Long> res = df.stream().collect(java.util.stream.Collectors.groupingBy(row -> row.getString("Company"), Collectors.counting()));
		/*
		long i1=0, i2=0, i3=0, i4=0, i5=0, i6=0, i7=0, i8=0, i9=0;
		//count companies with less than 9 jobs
		for (Map.Entry<String,Long> entry : res.entrySet()) {
			if(entry.getValue() == 1) {
				i1++;
			}
			if(entry.getValue() == 2) {
				i2++;
			}
			if(entry.getValue() == 3) {
				i3++;
			}
			if(entry.getValue() == 4) {
				i4++;
			}
			if(entry.getValue() == 5) {
				i5++;
			}
			if(entry.getValue() == 6) {
				i6++;
			}
			if(entry.getValue() == 7) {
				i7++;
			}
			if(entry.getValue() == 8) {
				i8++;
			}
			if(entry.getValue() == 9) {
				i9++;
			}
		}
		
		//Remove companies with less than 9 jobs
		Map<String, Long> filtered_data = res.entrySet().stream().filter(x -> x.getValue() > 9).collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		filtered_data.put("1 Jop Company", i1);
		filtered_data.put("2 Jop Company", i2);
		filtered_data.put("3 Jop Company", i3);
		filtered_data.put("4 Jop Company", i4);
		filtered_data.put("5 Jop Company", i5);
		filtered_data.put("6 Jop Company", i6);
		filtered_data.put("7 Jop Company", i7);
		filtered_data.put("8 Jop Company", i8);
		filtered_data.put("9 Jop Company", i9);
		
		System.out.println("Companies count after reduction: " + filtered_data.size());
		
		//Sort Map by values
		Map<String, Long> sorted = filtered_data .entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		//System.out.println(sorted);
		*/
		Map<String, Long> sorted = res .entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		PieChart chart = new PieChartBuilder().width (800).height (600).title ("Companies").build ();
		
		for (Map.Entry<String,Long> entry : sorted.entrySet()) {
			chart.addSeries(entry.getKey(), entry.getValue());
		}
		
		new SwingWrapper(chart).displayChart();
	}
	
	public void titlesChart(DataFrame df) {
		Map<String, Long> res = df.stream().collect(java.util.stream.Collectors.groupingBy(row -> row.getString("Title"), Collectors.counting()));
		
		//Sort Map by value
		Map<String, Long> jobs_Map = res .entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(10) .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
        List<Long> count = jobs_Map.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        List<String> title = jobs_Map.entrySet().stream().map(x -> x.getKey()).collect(Collectors.toList());
        
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (768).title ("Jobs").xAxisTitle("Tilte").yAxisTitle("Count").build ();
        //chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        
        chart.addSeries("Job Tiltle count", title, count);
        new SwingWrapper(chart).displayChart();
	}
	
	public void areasChart(DataFrame df){
    	//Map of Areas count
		Map<String, Long> res = df.stream().collect(java.util.stream.Collectors.groupingBy(row -> row.getString("Location"), Collectors.counting()));
		
		//Sort Map by value
		Map<String, Long> sorted = res .entrySet() .stream() .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) .limit(10) .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		List<Long> count = sorted.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        List<String> area = sorted.entrySet().stream().map(x -> x.getKey()).collect(Collectors.toList());
        
        CategoryChart chart = new CategoryChartBuilder().width (1024).height (768).title ("Most Popular Area").xAxisTitle("Area").yAxisTitle("Count").build ();
        //chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setStacked(true);
        
        chart.addSeries("Area count", area, count);
        new SwingWrapper(chart).displayChart();
    }
}
