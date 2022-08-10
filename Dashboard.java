package saim;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.Button;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.JList;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Dashboard extends JFrame {

	private JPanel contentPane;
	private String usname;
	private String s,c,p,b;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param result 
	 */
	public Dashboard(String result) {
		Connection scon;
		try 
		{
			scon = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps1= scon.prepareStatement("select count(*) from supplier"); 
			ResultSet rs1= ps1.executeQuery();
			rs1.next();
			s=rs1.getString(1);
			scon.close();
			ps1.close();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		Connection ccon;
		try 
		{
			ccon = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps1= ccon.prepareStatement("select count(*) from customer"); 
			ResultSet rs1= ps1.executeQuery();
			rs1.next();
			c=rs1.getString(1);
			ccon.close();
			ps1.close();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		Connection pcon;
		try 
		{
			pcon = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps1= pcon.prepareStatement("select count(*) from product"); 
			ResultSet rs1= ps1.executeQuery();
			rs1.next();
			p=rs1.getString(1);
			pcon.close();
			ps1.close();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		Connection bcon;
		try 
		{
			bcon = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
			PreparedStatement ps1= bcon.prepareStatement("select count(*) from bill"); 
			ResultSet rs1= ps1.executeQuery();
			rs1.next();
			b=rs1.getString(1);
			bcon.close();
			ps1.close();
		} 
		catch (SQLException e2) {
			e2.printStackTrace();
		}
		usname=result;
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1119, 676);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(9, 10, 9, 9, (Color) new Color(0, 0, 128)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 9, 1, (Color) new Color(0, 0, 128)));
		panel_1.setBounds(10, 9, 1087, 55);
		panel_1.setBackground(new Color(0, 191, 255));
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton.setBounds(980, 4, 101, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login lg= new Login();
				lg.setVisible(true);
				
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(657, 6, 68, 36);
		panel_1.add(lblNewLabel);
		
		JLabel name = new JLabel(usname);
		name.setBounds(723, 12, 256, 24);
		panel_1.add(name);
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("  Rmega Company");
		lblNewLabel_2.setBounds(2, 5, 272, 37);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(9, 10, 9, 9, (Color) new Color(0, 0, 128)));
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 55, 221, 584);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel l1 = new JLabel("Dashboard");
		l1.setEnabled(false);
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
		l5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Billing bill= new Billing(result);
				bill.setVisible(true);
				
			}
		});
		l5.setForeground(new Color(0, 0, 128));
		l5.setFont(new Font("Dialog", Font.BOLD, 20));
		l5.setBounds(45, 237, 113, 37);
		panel.add(l5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Dashboard");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(234, 66, 113, 37);
		contentPane.add(lblNewLabel_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(0, 0, 128)));
		panel_2.setBounds(242, 125, 247, 95);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Suppliers");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(77, 21, 97, 27);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel(s);
		lblNewLabel_3_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(115, 55, 45, 21);
		panel_2.add(lblNewLabel_3_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(0, 0, 128)));
		panel_2_1.setBackground(new Color(0, 191, 255));
		panel_2_1.setBounds(823, 125, 247, 95);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Products");
		lblNewLabel_3_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(78, 21, 97, 27);
		panel_2_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(p);
		lblNewLabel_3_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1.setBounds(115, 55, 45, 21);
		panel_2_1.add(lblNewLabel_3_1_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(0, 0, 128)));
		panel_2_1_1.setBackground(new Color(0, 191, 255));
		panel_2_1_1.setBounds(533, 125, 247, 95);
		contentPane.add(panel_2_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Customers");
		lblNewLabel_3_2_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2_1.setBounds(73, 21, 107, 27);
		panel_2_1_1.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel(c);
		lblNewLabel_3_1_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1_1.setBounds(116, 55, 45, 21);
		panel_2_1_1.add(lblNewLabel_3_1_1_1);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(0, 0, 128)));
		panel_2_1_1_1.setBackground(new Color(0, 191, 255));
		panel_2_1_1_1.setBounds(242, 265, 247, 95);
		contentPane.add(panel_2_1_1_1);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Bills");
		lblNewLabel_3_2_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2_1_1.setBounds(98, 21, 50, 27);
		panel_2_1_1_1.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel(b);
		lblNewLabel_3_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1_1_1_1.setBounds(114, 55, 45, 21);
		panel_2_1_1_1.add(lblNewLabel_3_1_1_1_1);
	}
}
