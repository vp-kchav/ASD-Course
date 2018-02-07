package project.framework.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 * A basic JFC based application.
 */
public class MainFrame extends javax.swing.JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/****
     * init variables in the object
     ****/
    String accountnr, clientName,street,city,zip,state,accountType,clientType;
	public String amount;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    MainFrame myframe;
    private Object rowdata[];
    
	public MainFrame(String appName)
	{
		myframe = this;

		setTitle(appName);
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(600,320);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
	

        this.model = new DefaultTableModel(); 
        JScrollPane1 = new JScrollPane();
        JTable1 = new JTable(model);
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
        
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
	}

	
	public void setPanel1Content(ArrayList<JButton> buttons) {
		
		for(JButton btn: buttons){
			JPanel1.add(btn);
		}
	}


	public void setTableModel(DefaultTableModel model) {
		
        JTable1.setModel(model);
	}



	public void initialize() {
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.addColumn("Column1");
		model2.addColumn("Column2");
		model2.addColumn("Column3");
		model2.addColumn("Column4");
		model2.addColumn("Column5");
		setTableModel(model2);
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();

        setPanel1Content(buttons);
	}


	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	public void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == MainFrame.this)
				exitApplication();
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				System.exit(0);
		}
	}

	protected JTable getJTable1() {
		return JTable1;
	}
    
}
