package project;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import java.awt.Color;

public class Dangkymon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public static void main(String[] args )
	{
		try {
			Dangkymon test =new Dangkymon();
			test.setVisible(true);		
			}catch(Exception e){
			
		}
	}
	public Dangkymon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 448);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 76, 586, 163);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox Monhoc1 = new JCheckBox("Mon1");
		Monhoc1.setBounds(19, 7, 141, 23);
		panel.add(Monhoc1);
		
		JCheckBox Monhoc2 = new JCheckBox("mon2");
		Monhoc2.setBounds(334, 7, 97, 23);
		panel.add(Monhoc2);
		
		table = new JTable();
		String filepath = "C:\\Users\\bangd\\Desktop\\data.txt";
		File file = new File(filepath);
		
		 try {
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String firstLine = br.readLine().trim();
	            String[] columnsName = firstLine.split(",");
	            DefaultTableModel model = (DefaultTableModel)table.getModel();
	            model.setColumnIdentifiers(columnsName);
	            
	            Object[] tableLines = br.lines().toArray();
	            
	        
	            for(int i = 0; i < tableLines.length; i++)
	            {
	                String line = tableLines[i].toString().trim();
	                String[] dataRow = line.split("/");
	                model.addRow(dataRow);
	            }
	            
	            
	        } catch (Exception ex) {
	 
	        }
	}
}
