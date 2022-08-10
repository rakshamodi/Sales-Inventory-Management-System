package saim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
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

public class Supplier extends JFrame {

	private JPanel contentPane;
	private JTextField supname;
	private JTextField phon;
	private JTable table;
	private JTextField remarks;
	private int ro;
	private int key;
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
					Supplier frame = new Supplier(null);
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
	public Supplier(String result) {
		
		setTitle("Supplier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1119, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBorder(new MatteBorder(9, 10, 9, 9, (Color) new Color(0, 0, 128)));
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBounds(0, 0, 1105, 639);
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
		
		JLabel sname = new JLabel(result);
		sname.setFont(new Font("Tahoma", Font.BOLD, 15));
		sname.setBounds(723, 12, 256, 24);
		panel_1.add(sname);
		
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
		l2.setEnabled(false);
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
		
		JLabel lblNewLabel_2_1_6 = new JLabel("Supplier");
		lblNewLabel_2_1_6.setBounds(234, 66, 113, 37);
		lblNewLabel_2_1_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_6.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane_1.add(lblNewLabel_2_1_6);
		
		JLabel lblProductName = new JLabel("Supplier Name");
		lblProductName.setBounds(234, 113, 88, 16);
		lblProductName.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane_1.add(lblProductName);
		
		JLabel lblQuantity = new JLabel("Address");
		lblQuantity.setBounds(251, 159, 88, 16);
		lblQuantity.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane_1.add(lblQuantity);
		
		JLabel lblCategory = new JLabel("Phone No.");
		lblCategory.setBounds(636, 113, 88, 16);
		lblCategory.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane_1.add(lblCategory);
		
		supname = new JTextField();
		supname.setBounds(336, 113, 251, 19);
		supname.setColumns(10);
		contentPane_1.add(supname);
		
		JButton btnNewButton_1 = new JButton("Save");
		
		btnNewButton_1.setBounds(438, 212, 85, 21);
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane_1.add(btnNewButton_1);
		
		JTextArea add = new JTextArea();
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection rcon;
				try
				{
					rcon = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
					PreparedStatement psr= rcon.prepareStatement("select max(supid) from supplier");
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
				
				if(supname.getText().isEmpty() || phon.getText().isEmpty() || add.getText().isEmpty() || remarks.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(btnNewButton_1, "Missing Information!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("insert into supplier values(?,?,?,?,?)"); 						
						if(tf==true)
						{
							ps.setInt(1,++control);
						}
						else
						{
							ps.setInt(1,ro);	
						}
						ps.setString(2, supname.getText());
						ps.setString(3, add.getText());
						ps.setString(4, phon.getText());
						ps.setString(5, remarks.getText());
						
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(btnNewButton_1, "Success!");
						
						supname.setText("");
						add.setText("");
						phon.setText("");
						remarks.setText("");
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
						PreparedStatement ps= con.prepareStatement("select * from supplier"); 
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
		
		
		JButton btnNewButton_1_1 = new JButton("Edit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(key==0)
				{
					JOptionPane.showMessageDialog(btnNewButton_1_1, "Select a Supplier!");
				}

				else if(supname.getText().isEmpty() || phon.getText().isEmpty() || add.getText().isEmpty() || remarks.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(btnNewButton_1_1, "Missing Information!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("update supplier set supname=?, supadd=?, supphone=?, supremarks=? where supid=?"); 						
						ps.setInt(5,key);
						ps.setString(1, supname.getText());
						ps.setString(2, add.getText());
						ps.setString(3, phon.getText());
						ps.setString(4, remarks.getText());
						
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(btnNewButton_1_1, "Success!");
						
						supname.setText("");
						add.setText("");
						phon.setText("");
						remarks.setText("");
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
						PreparedStatement ps= con.prepareStatement("select * from supplier"); 
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
		btnNewButton_1_1.setBounds(583, 212, 85, 21);
		
		btnNewButton_1_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(key==0)
				{
					JOptionPane.showMessageDialog(btnNewButton_1_2, "Select a Supplier!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("delete from supplier where supid="+key); 						
						
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(btnNewButton_1_2, "Success!");
						
						supname.setText("");
						add.setText("");
						phon.setText("");
						remarks.setText("");
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
						PreparedStatement ps= con.prepareStatement("select * from supplier"); 
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
		btnNewButton_1_2.setBounds(729, 212, 85, 21);
		btnNewButton_1_2.setForeground(new Color(0, 0, 128));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane_1.add(btnNewButton_1_2);
		
		phon = new JTextField();
		phon.setBounds(715, 113, 162, 19);
		phon.setColumns(10);
		contentPane_1.add(phon);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(332, 149, 351, 37);
		contentPane_1.add(scrollPane_1);
		
		scrollPane_1.setViewportView(add);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 257, 816, 347);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		key=0;
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				model=(DefaultTableModel)table.getModel();
				myindex=table.getSelectedRow();
				key=Integer.valueOf(model.getValueAt(myindex,0).toString());
				supname.setText(model.getValueAt(myindex,1).toString());
				add.setText(model.getValueAt(myindex,2).toString());
				phon.setText(model.getValueAt(myindex,3).toString());
				remarks.setText(model.getValueAt(myindex,4).toString());
				
			}
		});
		table.setBackground(new Color(240, 255, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblRemarks = new JLabel("Remarks");
		lblRemarks.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRemarks.setBounds(726, 162, 88, 16);
		contentPane_1.add(lblRemarks);
		
		remarks = new JTextField();
		remarks.setColumns(10);
		remarks.setBounds(803, 159, 172, 19);
		contentPane_1.add(remarks);
		
		
		Connection con;
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps1= con.prepareStatement("select count(*) from supplier"); 
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
			PreparedStatement ps1= vcon.prepareStatement("select * from supplier where supid="+ro); 
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
			PreparedStatement ps= econ.prepareStatement("select * from supplier"); 
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
