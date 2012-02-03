package org.vande.saska;

import java.awt.Dimension;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChartPanel extends JPanel {
	private static final long serialVersionUID = -4748009592786529098L;
	private static XYSeries localXYSeries1;

	public LineChartPanel() {
		JPanel localJPanel = createDemoPanel();
		localJPanel.setPreferredSize(new Dimension(500, 270));
		add(localJPanel);
	}

	private static XYDataset createDataset() {
		localXYSeries1 = new XYSeries("First");
		localXYSeries1.add(1.0D, 1.0D);
		localXYSeries1.add(2.0D, 4.0D);
		localXYSeries1.add(3.0D, 3.0D);
		localXYSeries1.add(4.0D, 5.0D);
		localXYSeries1.add(5.0D, 5.0D);
		localXYSeries1.add(6.0D, 7.0D);
		localXYSeries1.add(7.0D, 7.0D);
		localXYSeries1.add(8.0D, 8.0D);
		XYSeries localXYSeries2 = new XYSeries("Second");
		localXYSeries2.add(1.0D, 5.0D);
		localXYSeries2.add(2.0D, 7.0D);
		localXYSeries2.add(3.0D, 6.0D);
		localXYSeries2.add(4.0D, 8.0D);
		localXYSeries2.add(5.0D, 4.0D);
		localXYSeries2.add(6.0D, 4.0D);
		localXYSeries2.add(7.0D, 2.0D);
		localXYSeries2.add(8.0D, 1.0D);
		XYSeries localXYSeries3 = new XYSeries("Third");
		localXYSeries3.add(3.0D, 4.0D);
		localXYSeries3.add(4.0D, 3.0D);
		localXYSeries3.add(5.0D, 2.0D);
		localXYSeries3.add(6.0D, 3.0D);
		localXYSeries3.add(7.0D, 6.0D);
		localXYSeries3.add(8.0D, 3.0D);
		localXYSeries3.add(9.0D, 4.0D);
		localXYSeries3.add(10.0D, 3.0D);
		XYSeriesCollection localXYSeriesCollection = new XYSeriesCollection();
		localXYSeriesCollection.addSeries(localXYSeries1);
		localXYSeriesCollection.addSeries(localXYSeries2);
		localXYSeriesCollection.addSeries(localXYSeries3);
		
		return localXYSeriesCollection;
	}

	private static JFreeChart createChart(XYDataset paramXYDataset) {
		JFreeChart localJFreeChart = ChartFactory.createXYLineChart(
				"Line Chart Demo 6", "X", "Y", paramXYDataset,
				PlotOrientation.VERTICAL, true, true, false);
		XYPlot localXYPlot = (XYPlot) localJFreeChart.getPlot();
		XYLineAndShapeRenderer localXYLineAndShapeRenderer = new XYLineAndShapeRenderer();
		localXYLineAndShapeRenderer.setSeriesLinesVisible(0, false);
		localXYLineAndShapeRenderer.setSeriesShapesVisible(1, false);
		localXYLineAndShapeRenderer
				.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		localXYPlot.setRenderer(localXYLineAndShapeRenderer);
		NumberAxis localNumberAxis = (NumberAxis) localXYPlot.getRangeAxis();
		localNumberAxis.setStandardTickUnits(NumberAxis
				.createIntegerTickUnits());
		return localJFreeChart;
	}

	public static JPanel createDemoPanel() {
		JFreeChart localJFreeChart = createChart(createDataset());
		return new ChartPanel(localJFreeChart);
	}

	public void updateData(List<Entry<Double, Double>> xyData) {
		for (Entry<Double, Double> xyEntry : xyData) {
		
			double x = xyEntry.getKey();
			double y = xyEntry.getValue();
			
			localXYSeries1.remove(x);
			localXYSeries1.addOrUpdate(x, y);
		}
		
	}

//	public static void main(String[] paramArrayOfString) {
//		LineChartDemo6 localLineChartDemo6 = new LineChartDemo6(
//				"JFreeChart: LineChartDemo6.java");
//		localLineChartDemo6.pack();
//		RefineryUtilities.centerFrameOnScreen(localLineChartDemo6);
//		localLineChartDemo6.setVisible(true);
//	}
}
