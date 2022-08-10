package saim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

public class Products extends JFrame {

	private JPanel contentPane;
	private JTextField proname;
	private JTextField qty;
	private JTextField price;
	private JTextField sname;
	private JTable table;
	DefaultTableModel model;
	private int control;
	private boolean tf;
	private int ro;
	private int key;
	private int myindex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products frame = new Products(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Products(String result) {
		setTitle("Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1119, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(0, 0, 1105, 639);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new MatteBorder(9, 10, 9, 9, (Color) new Color(0, 0, 128)));
		contentPane_1.setBackground(Color.WHITE);
		contentPane.add(contentPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 9, 9, (Color) new Color(0, 0, 128)));
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(10, 9, 1095, 55);
		contentPane_1.add(panel_1);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login lg= new Login();
				lg.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(980, 4, 101, 38);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(657, 6, 68, 36);
		panel_1.add(lblNewLabel);
		
		JLabel pname = new JLabel(result);
		pname.setFont(new Font("Tahoma", Font.BOLD, 15));
		pname.setBounds(723, 12, 256, 24);
		panel_1.add(pname);
		
		JLabel lblNewLabel_2 = new JLabel("  Rmega Company");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(2, 5, 272, 37);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Products");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(234, 66, 113, 37);
		contentPane_1.add(lblNewLabel_2_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(9, 10, 9, 9, (Color) new Color(0, 0, 128)));
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 55, 221, 584);
		contentPane_1.add(panel);
		
		JLabel l1 = new JLabel("Dashboard");
		l1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Dashboard dash=new Dashboard(result);
				dash.setVisible(true);
				
			}
		});
		l1.setForeground(new Color(0, 0, 128));
		l1.setFont(new Font("Dialog", Font.BOLD, 20));
		l1.setBounds(45, 49, 113, 37);
		panel.add(l1);
		
		JLabel l2 = new JLabel("Supplier");
		l2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Supplier sup =new Supplier(result);
				sup.setVisible(true);
				
			}		
		});
		l2.setForeground(new Color(0, 0, 128));
		l2.setFont(new Font("Dialog", Font.BOLD, 20));
		l2.setBounds(45, 96, 113, 37);
		panel.add(l2);
		
		JLabel l3 = new JLabel("Customer");
		l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Customer cus=new Customer(result);
				cus.setVisible(true);
				
			}
		});
		l3.setForeground(new Color(0, 0, 128));
		l3.setFont(new Font("Dialog", Font.BOLD, 20));
		l3.setBounds(45, 143, 113, 37);
		panel.add(l3);
		
		JLabel l4 = new JLabel("Products");
		l4.setEnabled(false);
		l4.setForeground(new Color(0, 0, 128));
		l4.setFont(new Font("Dialog", Font.BOLD, 20));
		l4.setBounds(45, 190, 113, 37);
		panel.add(l4);
		
		JLabel l5 = new JLabel("Billing");
		l5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Billing bill=new Billing(result);
				bill.setVisible(true);
				
			}
		});
		l5.setForeground(new Color(0, 0, 128));
		l5.setFont(new Font("Dialog", Font.BOLD, 20));
		l5.setBounds(45, 237, 113, 37);
		panel.add(l5);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblProductName.setBounds(234, 113, 88, 16);
		contentPane_1.add(lblProductName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Dialog", Font.BOLD, 12));
		lblQuantity.setBounds(234, 149, 88, 16);
		contentPane_1.add(lblQuantity);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCategory.setBounds(542, 113, 88, 16);
		contentPane_1.add(lblCategory);
		
		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSupplierId.setBounds(410, 149, 88, 16);
		contentPane_1.add(lblSupplierId);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPrice.setBounds(811, 113, 88, 16);
		contentPane_1.add(lblPrice);
		
		JLabel lblSupplierName = new JLabel("Supplier Name");
		lblSupplierName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSupplierName.setBounds(696, 149, 88, 16);
		contentPane_1.add(lblSupplierName);
		
		proname = new JTextField();
		proname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		proname.setBounds(336, 113, 162, 19);
		contentPane_1.add(proname);
		proname.setColumns(10);
		
		qty = new JTextField();
		qty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		qty.setColumns(10);
		qty.setBounds(301, 149, 55, 19);
		contentPane_1.add(qty);
		
		price = new JTextField();
		price.setFont(new Font("Tahoma", Font.PLAIN, 12));
		price.setColumns(10);
		price.setBounds(864, 112, 87, 19);
		contentPane_1.add(price);
		
		sname = new JTextField();
		sname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sname.setColumns(10);
		sname.setBounds(811, 149, 256, 19);
		contentPane_1.add(sname);
		
		JComboBox <String>cat = new JComboBox();
		cat.setModel(new DefaultComboBoxModel(new String[] {"Food & Medicines", "Watches & Stationery", "Household Requisites", "General Use Items", "Toiletries", "Liquor"}));
		cat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cat.setBounds(612, 112, 152, 21);
		contentPane_1.add(cat);
		
		JComboBox<String> sid = new JComboBox();
		sid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection econ = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
					PreparedStatement ps= econ.prepareStatement("select supname from supplier where supid="+sid.getSelectedItem().toString()); 
					ResultSet rs= ps.executeQuery();
					if(rs.next())
					{
						sname.setText(rs.getString(1));
					}
				
					econ.close();
					ps.close();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				
			}
		});
		sid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sid.setBounds(489, 148, 152, 21);
		contentPane_1.add(sid);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection rcon;
				try
				{
					rcon = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
					PreparedStatement psr= rcon.prepareStatement("select max(pid) from product");
					ResultSet s= psr.executeQuery();
					s.next();
					control=s.getInt(1);
					
					rcon.close();
					psr.close();
				} 
				catch (SQLException e2) 
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 
				
				if(proname.getText().isEmpty() || cat.getSelectedIndex()==-1 || price.getText().isEmpty() || qty.getText().isEmpty() || sid.getSelectedIndex()==-1  || sname.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(btnNewButton_1, "Missing Information!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("insert into product values(?,?,?,?,?,?,?)"); 						
						if(tf==true)
						{
							ps.setInt(1,++control);
						}
						else
						{
							ps.setInt(1,ro);	
						}
						ps.setString(2, proname.getText());
						ps.setString(3, cat.getSelectedItem().toString());
						ps.setString(4, price.getText());
						ps.setString(5, qty.getText());
						ps.setString(6, sid.getSelectedItem().toString());
						ps.setString(7, sname.getText());
						
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(btnNewButton_1, "Success!");
						
						proname.setText("");
						cat.setSelectedIndex(0);
						price.setText("");
						qty.setText("");
						sid.setSelectedIndex(0);
						sname.setText("");
						key=0;
					con.close();
					ps.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
					
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("select * from product"); 
						ResultSet rs= ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
						con.close();
						ps.close();
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(438, 212, 85, 21);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(key==0)
				{
					JOptionPane.showMessageDialog(btnNewButton_1_1, "Select a Product!");
				}

				else if(proname.getText().isEmpty() || cat.getSelectedIndex()==-1 || price.getText().isEmpty() || qty.getText().isEmpty() || sid.getSelectedIndex()==-1  || sname.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(btnNewButton_1_1, "Missing Information!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("update product set pname=?, pcat=?, pprice=?, pqty=?, supid=?, supname=? where pid=?"); 						
						ps.setInt(7,key);
						ps.setString(1, proname.getText());
						ps.setString(2, cat.getSelectedItem().toString());
						ps.setString(3, price.getText());
						ps.setString(4, qty.getText());
						ps.setString(5, sid.getSelectedItem().toString());
						ps.setString(6, sname.getText());
						
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(btnNewButton_1_1, "Success!");
						
						proname.setText("");
						cat.setSelectedIndex(0);
						price.setText("");
						qty.setText("");
						sid.setSelectedIndex(0);
						sname.setText("");
						key=0;
					con.close();
					ps.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
					
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("select * from product"); 
						ResultSet rs= ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
						con.close();
						ps.close();
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(583, 212, 85, 21);
		contentPane_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(key==0)
				{
					JOptionPane.showMessageDialog(btnNewButton_1_2, "Select a Product!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("delete from product where pid="+key); 						
						
						ps.executeUpdate();
						JOptionPane.showMessageDialog(btnNewButton_1, "Success!");
						
						proname.setText("");
						cat.setSelectedIndex(0);
						price.setText("");
						qty.setText("");
						sid.setSelectedIndex(0);
						sname.setText("");
						key=0;
						
					con.close();
					ps.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
					
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("select * from product"); 
						ResultSet rs= ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
						con.close();
						ps.close();
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1_2.setForeground(new Color(0, 0, 128));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_2.setBounds(729, 212, 85, 21);
		contentPane_1.add(btnNewButton_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 257, 816, 347);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				model=(DefaultTableModel)table.getModel();
				myindex=table.getSelectedRow();
				key=Integer.valueOf(model.getValueAt(myindex,0).toString());
				proname.setText(model.getValueAt(myindex,1).toString());
				cat.setSelectedItem(model.getValueAt(myindex,2).toString());
				price.setText(model.getValueAt(myindex,3).toString());
				qty.setText(model.getValueAt(myindex,4).toString());
				sid.setSelectedItem(model.getValueAt(myindex,5).toString());
				sname.setText(model.getValueAt(myindex,6).toString());
				
			}
		});
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBackground(new Color(240, 255, 255));
		scrollPane.setViewportView(table);
		
		Connection con;
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps1= con.prepareStatement("select count(*) from product"); 
			ResultSet rs1= ps1.executeQuery();
			rs1.next();
			ro=rs1.getInt(1);
			ro++;
			con.close();
			ps1.close();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		Connection vcon;
		try 
		{
			vcon = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps1= vcon.prepareStatement("select * from product where pid="+ro); 
			ResultSet rs1= ps1.executeQuery();
			if(rs1.next())
			{
				tf=true;
			}
			else
			{
				tf=false;
			}
			vcon.close();
			ps1.close();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		try {
			Connection econ = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps= econ.prepareStatement("select * from product"); 
			ResultSet rs= ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		
			econ.close();
			ps.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		try {
			Connection econ = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps= econ.prepareStatement("select * from supplier"); 
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				String o=rs.getString("supid");
				sid.addItem(o);
			}
		
			econ.close();
			ps.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}		
		
		sname.setEditable(false);
	}
}
