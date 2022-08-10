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
import javax.swing.ListSelectionModel;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 

public class Billing extends JFrame {

	private JPanel contentPane;
	private JTextField qty;
	private JTextField price;
	private JTable table;
	DefaultTableModel model;
	private JTextField cid;
	private int ro;
	private int key;
	private int bid;
	private String bcat;
	private int proc;
	private int[] a= new int[100];
	private int[] b= new int[100];
	private int[] c= new int[100];
	private int myindex;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billing frame = new Billing(null);
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
	public Billing(String result) {
		setTitle("Billing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1119, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new MatteBorder(9, 10, 9, 9, (Color) new Color(0, 0, 128)));
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBounds(0, 0, 1105, 639);
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
		
		JLabel bname = new JLabel(result);
		bname.setFont(new Font("Tahoma", Font.BOLD, 15));
		bname.setBounds(723, 12, 256, 24);
		panel_1.add(bname);
		
		JLabel lblNewLabel_2 = new JLabel("  Rmega Company");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(2, 5, 272, 37);
		panel_1.add(lblNewLabel_2);
		
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
				
				Supplier sup= new Supplier(result);
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
				
				Customer cus= new Customer(result);
				cus.setVisible(true);
				
			}
		});
		l3.setForeground(new Color(0, 0, 128));
		l3.setFont(new Font("Dialog", Font.BOLD, 20));
		l3.setBounds(45, 143, 113, 37);
		panel.add(l3);
		
		JLabel l4 = new JLabel("Products");
		l4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Products prod= new Products(result);
				prod.setVisible(true);
				
			}
		});
		l4.setForeground(new Color(0, 0, 128));
		l4.setFont(new Font("Dialog", Font.BOLD, 20));
		l4.setBounds(45, 190, 113, 37);
		panel.add(l4);
		
		JLabel l5 = new JLabel("Billing");
		l5.setEnabled(false);
		l5.setForeground(new Color(0, 0, 128));
		l5.setFont(new Font("Dialog", Font.BOLD, 20));
		l5.setBounds(45, 237, 113, 37);
		panel.add(l5);
		
		JLabel lblNewLabel_2_1_6 = new JLabel("Billing");
		lblNewLabel_2_1_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_6.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_6.setBounds(233, 66, 113, 37);
		contentPane_1.add(lblNewLabel_2_1_6);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCustomerName.setBounds(233, 113, 100, 16);
		contentPane_1.add(lblCustomerName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Dialog", Font.BOLD, 12));
		lblQuantity.setBounds(233, 149, 88, 16);
		contentPane_1.add(lblQuantity);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCustomerId.setBounds(578, 113, 88, 16);
		contentPane_1.add(lblCustomerId);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPrice.setBounds(825, 113, 88, 16);
		contentPane_1.add(lblPrice);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblProductName.setBounds(456, 149, 88, 16);
		contentPane_1.add(lblProductName);
		
		qty = new JTextField();
		qty.setColumns(10);
		qty.setBounds(300, 149, 55, 19);
		contentPane_1.add(qty);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(875, 113, 87, 19);
		contentPane_1.add(price);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(982, 595, 85, 21);
		contentPane_1.add(btnNewButton_1);
		
		JComboBox<String> proname = new JComboBox<String>();
		proname.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection econ = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
					PreparedStatement ps= econ.prepareStatement("select * from product where pname='"+proname.getSelectedItem().toString()+"'"); 
					ResultSet rs= ps.executeQuery();
					if(rs.next())
					{
						price.setText(rs.getString(4));
						bid=Integer.parseInt(rs.getString(1));
						bcat=rs.getString(3);
					}
				
					econ.close();
					ps.close();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				
				try
				{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
					PreparedStatement ps= con.prepareStatement("select pqty from product where pid="+bid); 						
					ResultSet rs=ps.executeQuery();
					rs.next();
					a[bid]=rs.getInt(1);
											
				con.close();
				ps.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
				
			}
		});
		
		JComboBox<String> cname = new JComboBox<String>();
		cname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection econ = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
					PreparedStatement ps= econ.prepareStatement("select cusid from customer where cusname='"+cname.getSelectedItem().toString()+"'"); 
					ResultSet rs= ps.executeQuery();
					if(rs.next())
					{
						cid.setText(rs.getString(1));
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
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
					PreparedStatement ps= con.prepareStatement("insert into bill values(?,?,?,?,?,?)"); 						
					ps.setInt(1,ro);	
					ps.setString(2, dtf.format(now));
					ps.setString(3, cid.getText());
					ps.setString(4, cname.getSelectedItem().toString());
					ps.setString(5, "");
					ps.setString(6, "0");
					
					ps.executeUpdate();
					
				con.close();
				ps.close();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
					Print pr = new Print(result);
					pr.setVisible(true);
			}
		});
		
		JButton btnNewButton_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cname.getSelectedIndex()==-1 || cid.getText().isEmpty() || price.getText().isEmpty() || qty.getText().isEmpty() || proname.getSelectedIndex()==-1 )
				{
					JOptionPane.showMessageDialog(btnNewButton_1_1_1, "Missing Information!");
				}
				else
				{
					if(a[bid]==0)
					{
						JOptionPane.showMessageDialog(btnNewButton_1_1_1, "Out of Stock!");
						qty.setText("");
					}
					else
					{
						b[bid]=Integer.parseInt(qty.getText());
						if(a[bid]<b[bid])
						{
							JOptionPane.showMessageDialog(btnNewButton_1_1_1, "Out of Limit!");
							qty.setText("");
						}
						else {
						try
						{
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
							PreparedStatement ps= con.prepareStatement("insert into pbill values(?,?,?,?,?,?)"); 
							ps.setInt(1,bid);	
							ps.setString(2, proname.getSelectedItem().toString());
							ps.setString(3, bcat);
							ps.setString(4, price.getText());
							ps.setString(5, qty.getText());
							ps.setDouble(6, Double.parseDouble(price.getText())*Double.parseDouble(qty.getText()));
							
							ps.executeUpdate();
													
						con.close();
						ps.close();
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
					
						try
						{
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
							PreparedStatement ps= con.prepareStatement("update product set pqty=? where pid="+ bid); 						
							ps.setInt(1, a[bid]-b[bid]);
							ps.executeUpdate();
														
						con.close();
						ps.close();
						proname.setSelectedIndex(0);
						bcat="";
						price.setText("");
						qty.setText("");
						bid=0;
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
						
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
							PreparedStatement ps= con.prepareStatement("select * from pbill"); 
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
					
				}
				
			}
		});
		
		JButton btnNewButton_1_1_1_1 = new JButton("Edit");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(key==0)
				{
					JOptionPane.showMessageDialog(btnNewButton_1_1_1_1, "Select a Product!");
				}
				else if(cname.getSelectedIndex()==-1 || cid.getText().isEmpty() || price.getText().isEmpty() || qty.getText().isEmpty() || proname.getSelectedIndex()==-1)
				{
					JOptionPane.showMessageDialog(btnNewButton_1_1_1_1, "Missing Information!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("select pbqty from pbill where pbid="+key); 	
						ResultSet rs=ps.executeQuery();
						rs.next();
						c[key]=rs.getInt(1);
						System.out.println(c[key]);
							
					con.close();
					ps.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
					b[key]=Integer.parseInt(qty.getText());
					if(a[bid]<b[bid])
					{
						JOptionPane.showMessageDialog(btnNewButton_1_1_1, "Out of Limit!");
						qty.setText("");
					}
					else {
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("update pbill set pbqty=?, Amount=? where pbid=?"); 	
						ps.setInt(3,key);
						ps.setString(1, qty.getText());
						ps.setDouble(2, Double.parseDouble(price.getText())*Double.parseDouble(qty.getText()));
						
						ps.executeUpdate();
							
					con.close();
					ps.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
					
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("update product set pqty=? where pid="+ key); 						
						ps.setInt(1, a[key]+c[key]-b[key]);
						ps.executeUpdate();
												
					key=0;	
					proname.setSelectedIndex(0);
					bcat="";
					price.setText("");
					qty.setText("");
					con.close();
					ps.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
					
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("select * from pbill"); 
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
				
			}
		});
		
		btnNewButton_1_1_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1_1.setBounds(722, 181, 85, 21);
		contentPane_1.add(btnNewButton_1_1_1);
		
		
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
							PreparedStatement ps= con.prepareStatement("select pbqty from pbill where pbid="+key); 	
							ResultSet rs=ps.executeQuery();
							rs.next();
							c[key]=rs.getInt(1);
							
							ps.executeUpdate();
								
						con.close();
						ps.close();
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
						try
						{
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
							PreparedStatement ps= con.prepareStatement("delete from pbill where pbid="+key); 	
							ps.executeUpdate();
							
						con.close();
						ps.close();
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
						
						try
						{
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
							PreparedStatement ps= con.prepareStatement("update product set pqty=? where pid="+ key); 						
							ps.setInt(1, a[key]+c[key]);
							ps.executeUpdate();
													
						key=0;	
						proname.setSelectedIndex(0);
						bcat="";
						price.setText("");
						qty.setText("");
						con.close();
						ps.close();
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
						
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
							PreparedStatement ps= con.prepareStatement("select * from pbill"); 
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
		btnNewButton_1_2.setBounds(981, 181, 85, 21);
		contentPane_1.add(btnNewButton_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 236, 816, 347);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				model=(DefaultTableModel)table.getModel();
				myindex=table.getSelectedRow();
				key=Integer.valueOf(model.getValueAt(myindex,0).toString());
				proname.setSelectedItem(model.getValueAt(myindex,1).toString());
				price.setText(model.getValueAt(myindex,3).toString());
				qty.setText(model.getValueAt(myindex,4).toString());
			}
		});
		table.setBackground(new Color(240, 255, 255));
		scrollPane.setViewportView(table);
		
		proname.setBounds(551, 148, 216, 21);
		contentPane_1.add(proname);
		
		try {
			Connection econ = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps= econ.prepareStatement("select * from pbill"); 
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
			PreparedStatement ps= econ.prepareStatement("select * from product"); 
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				String o=rs.getString("pname");
				proname.addItem(o);
			}
		
			econ.close();
			ps.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}	
		
		try {
			Connection econ = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps= econ.prepareStatement("select count(*) from product"); 
			ResultSet rs= ps.executeQuery();
			rs.next();
			proc=rs.getInt(1);
			int[] a= new int[proc];
			int[] b= new int[proc];
			int[] c= new int[proc];
		
			econ.close();
			ps.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}	
		
		price.setEditable(false);
		
		cname.setBounds(343, 113, 162, 21);
		contentPane_1.add(cname);
		
		cid = new JTextField();
		cid.setBounds(667, 113, 96, 19);
		contentPane_1.add(cid);
		cid.setColumns(10);
		
		try {
			Connection econ = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps= econ.prepareStatement("select * from customer"); 
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				String o=rs.getString("cusname");
				cname.addItem(o);
			}
		
			econ.close();
			ps.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}		
		
		cid.setEditable(false);
		
		btnNewButton_1_1_1_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1_1_1.setBounds(851, 181, 85, 21);
		contentPane_1.add(btnNewButton_1_1_1_1);
		
		Connection con;
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps1= con.prepareStatement("select count(*) from bill"); 
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
}
}
