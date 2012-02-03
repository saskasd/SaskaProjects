package org.vande.saska;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class DataChart extends JFrame implements ActionListener,
		TableModelListener {

	private static final long serialVersionUID = -3951987224679730487L;
	private TableInputPanel tablePanel;
	private LineChartPanel chartDemoFrame;

	public DataChart() {
		super();

		setTitle("Data chart");

		GridBagLayout gridbagLayout = new GridBagLayout();
		getContentPane().setLayout(gridbagLayout);

		tablePanel = new TableInputPanel(this);

		GridBagConstraints tablePanelConstraints = new GridBagConstraints();
		tablePanelConstraints.gridx = 0;
		tablePanelConstraints.gridy = 0;
		getContentPane().add(tablePanel, tablePanelConstraints);

		chartDemoFrame = new LineChartPanel();

		GridBagConstraints chartPanelConstraints = new GridBagConstraints();
		chartPanelConstraints.gridx = 0;
		chartPanelConstraints.gridy = 1;
		getContentPane().add(chartDemoFrame, chartPanelConstraints);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button clicked");
		updateChartFromModel();
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("Table changed");
		updateChartFromModel();
	}

	private void updateChartFromModel() {
		TableModel tableModel = tablePanel.getTableModel();

		List<Entry<Double, Double>> xyData = new LinkedList<Entry<Double, Double>>();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			Double x = Double.parseDouble(tableModel.getValueAt(i, 0)
					.toString());
			Double y = Double.parseDouble(tableModel.getValueAt(i, 1)
					.toString());
			xyData.add(new SimpleEntry<Double, Double>(x, y));
		}

		chartDemoFrame.updateData(xyData);
	}

}
