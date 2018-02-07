package project.bank.gui;
/*
		A basic implementation of the JDialog class.
*/

import java.awt.*;

public class ReportDialog extends javax.swing.JDialog
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ReportDialog(Frame parent, String report)
	{
		super(parent);
		setTitle("Generated Report");
		getContentPane().setLayout(null);
		this.setPreferredSize(new Dimension(800,767));
//		this.setResizable(false);
//		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,508,240);
		JScrollPane1.getViewport().add(JTextArea);
		JTextArea.setBounds(0,0,505,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(256,276,96,24);

		// generate the string for the report

		
		
		JTextArea.setText(report);
		
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		//}}
	}
	
	//{{DECLARE_CONTROLS
	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JTextArea JTextArea = new javax.swing.JTextArea();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
			 
	}
}
