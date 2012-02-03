package org.vande.saska;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableInputPanel extends JPanel {

	private static final long serialVersionUID = -1090187246246045818L;
	private DefaultTableModel tableModel;
	
	public TableInputPanel(DataChart controller) {
		
		GridBagLayout gridbagLayout = new GridBagLayout();
		setLayout(gridbagLayout);		
		
		JTable inputTable = new JTable();
		tableModel = new DefaultTableModel();
		
		Double[] columnData1 = {1.0D, 2.0D, 3.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D};
		
		tableModel.addColumn("Col1", columnData1);
		
		Double[] columnData2 = {1.0D, 2.0D, 3.0D, 4.0D, 5.0D, 6.0D, 7.0D, 8.0D};
		
		tableModel.addColumn("Col2", columnData2);		
		
		tableModel.addTableModelListener(controller);
		
		
		inputTable.setModel(tableModel);
		
		GridBagConstraints tableConstraints = new GridBagConstraints();
		tableConstraints.gridx = 0;
		tableConstraints.gridy = 0;
		add(inputTable, tableConstraints);
		
		JButton updateButton = new JButton();
		updateButton.setText("Update chart");
		updateButton.addActionListener(controller);
		
		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.gridx = 0;
		buttonConstraints.gridy = 1;
		add(updateButton, buttonConstraints);
		
		
	}
	
	public TableModel getTableModel() {
		return tableModel;
	}

}
