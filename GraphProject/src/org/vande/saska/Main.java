package org.vande.saska;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		DataChart frame = new DataChart();
		frame.setTitle("Chart demo");
		
		//frame.setPreferredSize(new Dimension(600, 400));
		frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setVisible(true);
	}

}
