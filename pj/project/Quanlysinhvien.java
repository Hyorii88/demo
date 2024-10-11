package project;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Quanlysinhvien extends JFrame {
	private StudentManager studentmanager;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Namefield;
	private JTextField IDField;
	private JTextField Addfield;
	private JTextField GPAField;
	private JTextField timkiem;
	private JTable table;
	
	public Quanlysinhvien() {
		setTitle("QLSV");
		setFont(new Font("Arial", Font.PLAIN, 13));
		studentmanager =new StudentManager();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Name.setBounds(92, 47, 46, 14);
		contentPane.add(Name);
		
		Namefield = new JTextField();
		Namefield.setBounds(136, 46, 86, 20);
		contentPane.add(Namefield);
		Namefield.setColumns(10);
		
		JLabel IDsearch = new JLabel("ID:");
		IDsearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IDsearch.setBounds(326, 50, 19, 14);
		contentPane.add(IDsearch);
		
		IDField = new JTextField();
		IDField.setBounds(355, 46, 86, 20);
		contentPane.add(IDField);
		IDField.setColumns(10);
		
		JLabel Address = new JLabel("Address:");
		Address.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Address.setBounds(301, 104, 58, 14);
		contentPane.add(Address);
		
		Addfield = new JTextField();
		Addfield.setBounds(355, 101, 86, 20);
		contentPane.add(Addfield);
		Addfield.setColumns(10);
		
		
		
		
		JButton AddButton = new JButton("Add");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Namefield.getText().equals("") || IDField.getText().equals("")||Addfield.getText().equals("")||GPAField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(AddButton, "Xin hay nhap du thong tin");
				}
				else
				{
					addStudent();
					String data[]= {Namefield.getText() , IDField.getText() , Addfield.getText(),GPAField.getText() };
					DefaultTableModel s = (DefaultTableModel)table.getModel();
					s.addRow(data);
				}
			}
			
private void addStudent()
{	
	String name = Namefield.getText();
	String id = IDField.getText();
	String add =Addfield.getText();
	String gpa =GPAField.getText();
	
	int a=Integer.parseInt(id);
	float b=Float.parseFloat(gpa);
	Student hocsinh = new Student(a,name , add , b);
	studentmanager.add(hocsinh);
	for(Student studentList:studentmanager.getstudent())
	{
		System.out.println(studentList.getName()+studentList.getId()+studentList.getAddress());
	}
}
});
		
		AddButton.setBounds(451, 46, 89, 23);
		contentPane.add(AddButton);
		
		JLabel lblNewLabel = new JLabel("GPA:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(92, 100, 46, 14);
		contentPane.add(lblNewLabel);
		
		GPAField = new JTextField();
		GPAField.setBounds(136, 99, 86, 20);
		contentPane.add(GPAField);
		GPAField.setColumns(10);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel s = (DefaultTableModel)table.getModel();
				if (table.getSelectedRowCount()==1)
				{
					String id = IDField.getText();
					int a=Integer.parseInt(id);
					studentmanager.delete(a);
					s.removeRow(table.getSelectedRow());
					for(Student studentList:studentmanager.getstudent())
					{
						System.out.println(studentList.getName()+studentList.getId()+studentList.getAddress());
					}
				}
				else
				{
					if (table.getSelectedRowCount()==0)
					{
						JOptionPane.showMessageDialog(DeleteButton, "Xin hay chon dong de xoa");
					}
					else
					{
						JOptionPane.showMessageDialog(DeleteButton, "Xin chi chon mot dong");
					}
				}
				
				}
		});
		DeleteButton.setBounds(451, 80, 89, 20);
		contentPane.add(DeleteButton);
		
		JButton UpdateButton = new JButton("Update");
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel s = (DefaultTableModel)table.getModel();
				if (table.getSelectedRowCount()==1)
				{
					String name = Namefield.getText();
					String id = IDField.getText();
					String add =Addfield.getText();
					String gpa =GPAField.getText();
					
					int a=Integer.parseInt(id);
					float b=Float.parseFloat(gpa);
					
					table.setValueAt(name,	table.getSelectedRow(), 0);
					table.setValueAt(id,	table.getSelectedRow(), 1);
					table.setValueAt(add,	table.getSelectedRow(), 2);
					table.setValueAt(gpa,	table.getSelectedRow(), 3);
					
					studentmanager.edit(a, name, add, a);
					for(Student studentList:studentmanager.getstudent())
					{
						System.out.println(studentList.getName()+studentList.getId()+studentList.getAddress());
					}
					
					
					JOptionPane.showMessageDialog(UpdateButton,"Da cap nhat thanh cong");
				}
				else
				{
					if (table.getSelectedRowCount()==0)
					{
						JOptionPane.showMessageDialog(DeleteButton, "Xin chon mot dong de cap nhat");
					}
					else
					{
						JOptionPane.showMessageDialog(DeleteButton, "Xin chi chon mot dong de cap nhat");
					}
				}
				
				}
			
		});
		UpdateButton.setBounds(451, 111, 89, 23);
		contentPane.add(UpdateButton);
		
		JButton SearchButton = new JButton("Search");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel se =(DefaultTableModel)table.getModel();
				TableRowSorter<DefaultTableModel> obj =new TableRowSorter<>(se);
				table.setRowSorter(obj);
				obj.setRowFilter(RowFilter.regexFilter(timkiem.getText()));
			}
		});
		SearchButton.setBounds(451, 15, 89, 23);
		contentPane.add(SearchButton);
		
		timkiem = new JTextField();
		timkiem.setBounds(136, 16, 305, 20);
		contentPane.add(timkiem);
		timkiem.setColumns(10);
		
		JButton ImportButton = new JButton("Import File");
		ImportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filepath = "C:\\Users\\bangd\\eclipse-workspace\\Finalpj\\pj\\project\\student.txt";
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
			                String name = (String) model.getValueAt(i, 0);
			            	String id = (String) model.getValueAt(i, 1);
			            	String add =(String) model.getValueAt(i, 2);
			            	String gpa =(String) model.getValueAt(i, 3);
			            	
			            	int a=Integer.parseInt(id);
			            	float b=Float.parseFloat(gpa);
			            	Student hocsinh = new Student(a,name , add , b);
			            	studentmanager.add(hocsinh);
			            	
			            }
			            
			            
			        } catch (Exception ex) {
			 
			        }
			    } 
				
			
				
		
			
		});
		ImportButton.setBounds(239, 141, 181, 23);
		contentPane.add(ImportButton);
		
		JButton btnNewButton = new JButton("Export");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\\\Users\\\\bangd\\\\eclipse-workspace\\\\Finalpj\\\\pj\\\\project\\\\student.txt");
					FileWriter fw =new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					for (int i=0; i<table.getRowCount();i++)
					{
						for (int j=0; j<table.getColumnCount();j++)
						{
							bw.write((String)table.getModel().getValueAt(i, j)+" ");
							if (j==table.getColumnCount()-1)
							{
								bw.write("\n");
								continue;
							}
							bw.write("/");
						}
					}
					bw.close();
					fw.close();
					
				}catch(Exception ex)
				{}
				
			}
		});
		btnNewButton.setBounds(246, 333, 144, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel s= (DefaultTableModel)table.getModel();
				String tblName =s.getValueAt(table.getSelectedRow(), 0).toString();
				String tblid =s.getValueAt(table.getSelectedRow(), 1).toString();
				String tbladd =s.getValueAt(table.getSelectedRow(), 2).toString();
				String tblgpa =s.getValueAt(table.getSelectedRow(), 3).toString();
				
				Namefield.setText(tblName);
				IDField.setText(tblid);
				Addfield.setText(tbladd);
				GPAField.setText(tblgpa);			
			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(60, 176, 583, 130);
		contentPane.add(table);
	}
}