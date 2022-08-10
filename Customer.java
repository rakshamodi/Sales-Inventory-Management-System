package saim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField cusname;
	private JTextField cusphon;
	private int key;
	private int ro;
	private JTable table;
	DefaultTableModel model;
	private int control;
	private boolean tf;
	private int myindex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer(null);
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
	public Customer(String result) {
		
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1119, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(0, 0, 1105, 639);
		contentPane_1.setBorder(new MatteBorder(9, 10, 9, 9, (Color) new Color(0, 0, 128)));
		contentPane_1.setBackground(Color.WHITE);
		contentPane.add(contentPane_1);
		contentPane_1.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 9, 1095, 55);
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 9, 9, (Color) new Color(0, 0, 128)));
		panel_1.setBackground(new Color(0, 191, 255));
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
		
		JLabel cname = new JLabel(result);
		cname.setFont(new Font("Tahoma", Font.BOLD, 15));
		cname.setBounds(723, 12, 256, 24);
		panel_1.add(cname);
		
		JLabel lblNewLabel_2 = new JLabel("  Rmega Company");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(2, 5, 272, 37);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 55, 221, 584);
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(9, 10, 9, 9, (Color) new Color(0, 0, 128)));
		panel.setBackground(new Color(0, 191, 255));
		contentPane_1.add(panel);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Dashboard");
		lblNewLabel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Dashboard dash= new Dashboard(result);
				dash.setVisible(true);
				
			}
		});
		lblNewLabel_2_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(45, 49, 113, 37);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Supplier");
		lblNewLabel_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Supplier sup= new Supplier(result);
				sup.setVisible(true);
				
			}
		});
		lblNewLabel_2_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_2.setBounds(45, 96, 113, 37);
		panel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Customer");
		lblNewLabel_2_1_3.setEnabled(false);
		lblNewLabel_2_1_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_3.setBounds(45, 143, 113, 37);
		panel.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Products");
		lblNewLabel_2_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Products prod =new Products(result);
				prod.setVisible(true);
				
			}
		});
		lblNewLabel_2_1_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_4.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_4.setBounds(45, 190, 113, 37);
		panel.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_1_5 = new JLabel("Billing");
		lblNewLabel_2_1_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Billing bill =new Billing(result);
				bill.setVisible(true);
				
			}
		});
		lblNewLabel_2_1_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_5.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_5.setBounds(45, 237, 113, 37);
		panel.add(lblNewLabel_2_1_5);
		
		JLabel lblNewLabel_2_1_6 = new JLabel("Customer");
		lblNewLabel_2_1_6.setBounds(234, 66, 113, 37);
		lblNewLabel_2_1_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_6.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane_1.add(lblNewLabel_2_1_6);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(234, 113, 113, 16);
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane_1.add(lblCustomerName);
		
		JLabel lblQuantity = new JLabel("Address");
		lblQuantity.setBounds(251, 159, 88, 16);
		lblQuantity.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane_1.add(lblQuantity);
		
		JLabel asv = new JLabel("Phone No.");
		asv.setBounds(636, 113, 88, 16);
		asv.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane_1.add(asv);
		
		cusname = new JTextField();
		cusname.setBounds(349, 113, 208, 19);
		cusname.setColumns(10);
		contentPane_1.add(cusname);
		
		JTextArea cusadd = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(438, 212, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection rcon;
				try
				{
					rcon = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
					PreparedStatement psr= rcon.prepareStatement("select max(cusid) from customer");
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
				
				if(cusname.getText().isEmpty() || cusphon.getText().isEmpty() || cusadd.getText().isEmpty())
				{
				  JOptionPane.showMessageDialog(btnNewButton_1, "Missing Information!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("insert into customer values(?,?,?,?)"); 	
						if(tf==true)
						{
							ps.setInt(1,++control);
						}
						else
						{
							ps.setInt(1,ro);	
						}
						ps.setString(2, cusname.getText());
						ps.setString(3, cusadd.getText());
						ps.setString(4, cusphon.getText());
						
						ps.executeUpdate();
						JOptionPane.showMessageDialog(btnNewButton_1, "Success!");
						
						cusname.setText("");
						cusphon.setText("");
						cusadd.setText("");
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
						PreparedStatement ps= con.prepareStatement("select * from customer"); 
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
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.setBounds(583, 212, 85, 21);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					
				if(key==0)
				{
					JOptionPane.showMessageDialog(btnNewButton_1_1, "Select a Customer!");
				}

				else if(cusname.getText().isEmpty() || cusphon.getText().isEmpty() || cusadd.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(btnNewButton_1_1, "Missing Information!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("update customer set cusname=?, cusadd=?, cusphone=? where cusid=?"); 						
						ps.setInt(4,key);
						ps.setString(1, cusname.getText());
						ps.setString(2, cusadd.getText());
						ps.setString(3, cusphon.getText());
						
						ps.executeUpdate();
						JOptionPane.showMessageDialog(btnNewButton_1_1, "Success!");
						
						cusname.setText("");
						cusphon.setText("");
						cusadd.setText("");
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
						PreparedStatement ps= con.prepareStatement("select * from customer"); 
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
		contentPane_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.setBounds(729, 212, 85, 21);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(key==0)
				{
					JOptionPane.showMessageDialog(btnNewButton_1_2, "Select a Customer!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("delete from customer where cusid="+key); 						
						
						ps.executeUpdate();
						JOptionPane.showMessageDialog(btnNewButton_1, "Success!");
						
						cusname.setText("");
						cusphon.setText("");
						cusadd.setText("");
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
						PreparedStatement ps= con.prepareStatement("select * from customer"); 
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
		contentPane_1.add(btnNewButton_1_2);
		
		cusphon = new JTextField();
		cusphon.setBounds(715, 113, 162, 19);
		cusphon.setColumns(10);
		contentPane_1.add(cusphon);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(332, 149, 662, 37);
		contentPane_1.add(scrollPane_1);
		
		scrollPane_1.setViewportView(cusadd);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 257, 816, 347);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		key=0;
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				model=(DefaultTableModel)table.getModel();
				myindex=table.getSelectedRow();
				key=Integer.valueOf(model.getValueAt(myindex,0).toString());
				cusname.setText(model.getValueAt(myindex,1).toString());
				cusadd.setText(model.getValueAt(myindex,2).toString());
				cusphon.setText(model.getValueAt(myindex,3).toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C_ID", "C_Name", "C_Address", "C_Phone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBackground(new Color(240, 255, 255));
		scrollPane.setViewportView(table);
		
		Connection con;
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps1= con.prepareStatement("select count(*) from customer"); 
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
			PreparedStatement ps1= vcon.prepareStatement("select * from customer where cusid="+ro); 
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
			PreparedStatement ps= econ.prepareStatement("select * from customer"); 
			ResultSet rs= ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		
			econ.close();
			ps.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}
}
