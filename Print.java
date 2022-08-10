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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;

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
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JSplitPane;

public class Print extends JFrame {

	private JPanel contentPane;
	private double total_price=0;
	private JTextField paym;
	private int billno;
	private int pno;
	private JTable table;
	private int bilno;
	private String bildt, bilcn,bilpy;
	private double bilamt;
	JPanel panel_2 = new JPanel();
	private void printRecord(JPanel panell)
	{
		PrinterJob printerJob =PrinterJob.getPrinterJob();
		printerJob.setJobName("Print Invoice");
		printerJob.setPrintable(new Printable(){
		@Override
		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException{
			if(pageIndex>0)
			{
				return Printable.NO_SUCH_PAGE;
			}
			Graphics2D graphics2D =(Graphics2D)graphics;
			graphics2D.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
			graphics2D.scale(0.5, 0.5);
			panel_2.paint(graphics2D);
			return Printable.PAGE_EXISTS;
		}
	     });
		boolean returningResult= printerJob.printDialog();
		if(returningResult) 
		{
			try
			{
				printerJob.print();
			}
			catch(PrinterException printerException)
			{
				JOptionPane.showMessageDialog(panell, "Print Error: "+ printerException.getMessage());
			}
		}
		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Print frame = new Print(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param  
	 */
	public Print(String result) {
				
		setTitle("Print");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1119, 676);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel page = new JPanel();
		page.setBorder(new MatteBorder(9, 10, 9, 9, (Color) new Color(0, 0, 128)));
		page.setBackground(Color.WHITE);
		page.setBounds(0, 0, 1105, 639);
		contentPane.add(page);
		page.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 9, 1095, 55);
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 9, 9, (Color) new Color(0, 0, 128)));
		panel_1.setBackground(new Color(0, 191, 255));
		page.add(panel_1);
		
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
		
		JLabel prname = new JLabel(result);
		prname.setFont(new Font("Tahoma", Font.BOLD, 15));
		prname.setBounds(723, 12, 256, 24);
		panel_1.add(prname);
		
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
		page.add(panel);
		
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
		lblNewLabel_2_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Customer cus =new Customer(result);
				cus.setVisible(true);
				
			}
		});
		lblNewLabel_2_1_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_3.setBounds(45, 143, 113, 37);
		panel.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Products");
		lblNewLabel_2_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Products prod= new Products(result);
				prod.setVisible(true);
				
			}
		});
		lblNewLabel_2_1_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_4.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_4.setBounds(45, 190, 113, 37);
		panel.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_1_5 = new JLabel("Billing");
		lblNewLabel_2_1_5.setEnabled(false);
		lblNewLabel_2_1_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_5.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1_5.setBounds(45, 237, 113, 37);
		panel.add(lblNewLabel_2_1_5);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(918, 552, 40, 16);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		page.add(lblTotal);
		
		JLabel total = new JLabel();
		total.setBounds(992, 551, 75, 19);
		total.setForeground(Color.RED);
		total.setFont(new Font("Tahoma", Font.BOLD, 15));
		page.add(total);
		
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(249, 113, 817, 416);
		page.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Rmega Company");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(303, 10, 225, 16);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Bill no. :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(62, 90, 56, 13);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date & Time :");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(483, 90, 86, 13);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Customer Name :");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(62, 113, 108, 13);
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("INVOICE");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1.setBounds(381, 45, 65, 13);
		panel_2.add(lblNewLabel_3_2_1);
		
		JLabel bn = new JLabel("");
		bn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bn.setBounds(181, 90, 86, 13);
		panel_2.add(bn);
		
		JLabel cn = new JLabel("");
		cn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cn.setBounds(181, 114, 219, 13);
		panel_2.add(cn);
		
		JLabel dt = new JLabel("");
		dt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dt.setBounds(580, 91, 187, 13);
		panel_2.add(dt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 148, 718, 178);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBackground(new Color(240, 255, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblPaymentMethod_2 = new JLabel("Payment Method :");
		lblPaymentMethod_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaymentMethod_2.setBounds(62, 341, 116, 16);
		panel_2.add(lblPaymentMethod_2);
		
		JLabel pm = new JLabel("");
		pm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pm.setBounds(189, 344, 219, 13);
		panel_2.add(pm);
		
		JLabel lblTotal_2 = new JLabel("Total :");
		lblTotal_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal_2.setBounds(586, 341, 50, 16);
		panel_2.add(lblTotal_2);
		
		JLabel t = new JLabel("");
		t.setFont(new Font("Tahoma", Font.PLAIN, 12));
		t.setBounds(640, 344, 100, 13);
		panel_2.add(t);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("                                                \u00A9 Copyright 2022  @ Sales & Inventory Management Software, RAKSHA MODI, SKIT Jaipur");
		lblNewLabel_4_1_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_1_1_2.setBackground(new Color(220, 220, 220));
		lblNewLabel_4_1_1_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_4_1_1_2.setBounds(0, 390, 817, 16);
		panel_2.add(lblNewLabel_4_1_1_2);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setBounds(982, 593, 85, 21);
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		page.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.setBounds(877, 593, 85, 21);
		btnNewButton_1_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		page.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2_1_6_1 = new JLabel("Bill");
		lblNewLabel_2_1_6_1.setBounds(641, 66, 37, 37);
		lblNewLabel_2_1_6_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1_6_1.setFont(new Font("Dialog", Font.BOLD, 20));
		page.add(lblNewLabel_2_1_6_1);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method");
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPaymentMethod.setBounds(319, 552, 126, 16);
		page.add(lblPaymentMethod);
		
		paym = new JTextField();
		paym.setBounds(455, 552, 208, 19);
		page.add(paym);
		paym.setColumns(10);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(paym.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(btnNewButton_1, "Add Payment Method!");
				}
				else
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps= con.prepareStatement("update bill set paymth=?, amt=? where bnum="+ billno); 		
						bilpy=paym.getText().toString();
						bilamt=Double.parseDouble(total.getText());
						ps.setString(1,paym.getText().toString());	
						ps.setDouble(2, Double.parseDouble(total.getText()));
						
						ps.executeUpdate();
						
					con.close();
					ps.close();
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
					bn.setText(String.valueOf(bilno));
					dt.setText(bildt);
					cn.setText(bilcn);
					pm.setText(bilpy);
					t.setText(String.valueOf(bilamt));
					
					printRecord(panel_2);
					
					try
					{
						Connection ccon = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						PreparedStatement ps3= ccon.prepareStatement("truncate table pbill");
						ps3.executeUpdate();
						
						ps3.close();
						ccon.close();	
					}
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}				
				
			}			
		});
		
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
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps= con.prepareStatement("select count(*) from bill"); 						
			
			ResultSet rs= ps.executeQuery();
			rs.next();
			billno=rs.getInt(1);
			
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
			PreparedStatement ps= con.prepareStatement("select * from bill where bnum="+ billno); 						
			ResultSet rs= ps.executeQuery();
			rs.next();
			bilno=rs.getInt(1);
			bildt=rs.getString(2);
			bilcn=rs.getNString(4);
			
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
			PreparedStatement ps= con.prepareStatement("select count(*) from pbill"); 						
			
			ResultSet rs= ps.executeQuery();
			rs.next();
			pno=rs.getInt(1);
			
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
		PreparedStatement ps= con.prepareStatement("select * from pbill");
		ResultSet rs=ps.executeQuery();
		rs.next();
		for(int l=0;l<pno;l++)
		{
			total_price+=rs.getDouble(6);	
			rs.next();
		}
		ps.close();	
		con.close();
	}
	catch (SQLException e1)
	{
		e1.printStackTrace();
	}
	
	total.setText(Double.toString(total_price));
	
	btnNewButton_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			dispose();
			
		}
	});
	}
}

