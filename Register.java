package saim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField userid;
	private JTextField cpassword;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(393, 151, 320, 430);
		panel.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(0, 0, 128)));
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Register");
		lblNewLabel_1.setBounds(92, 29, 137, 42);
		lblNewLabel_1.setFont(new Font("Wide Latin", Font.BOLD, 18));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(23, 113, 65, 19);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(103, 113, 189, 19);
		username.setBackground(new Color(211, 211, 211));
		username.setForeground(new Color(0, 0, 0));
		username.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setBounds(23, 170, 80, 19);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel_2_1);
		
		JButton b1 = new JButton("Register");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
						
						String uname= username.getText();
						String uid= userid.getText();
						String pass=password.getText();
						String cpass=cpassword.getText();
						PreparedStatement ps= con.prepareStatement("select * from Login where uid='"+uid+"'"); 
						ResultSet rs= ps.executeQuery();
						
						boolean flag=rs.next();
						
						if(flag)
						{
							JOptionPane.showMessageDialog(b1, "User Already Registered!");
						}
						else
						{
							if(pass.compareTo(cpass)==0) 
							{
								PreparedStatement ps1= con.prepareStatement("insert into Login values(?,?,?)"); 
								ps1.setString(1, uid);
								ps1.setString(2, pass);
								ps1.setString(3, uname);
								
								ps1.executeUpdate();
								
								JOptionPane.showMessageDialog(b1, "Registered!");
								
								Login lg= new Login();
								lg.setVisible(true);
								ps1.close();
							}
							else
							{
								JOptionPane.showMessageDialog(b1, "Incorrect Password!");
							}
						}
						con.close();
						ps.close();
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
				
			}
		});
		b1.setBounds(103, 260, 116, 35);
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(b1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Or");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(153, 317, 27, 19);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Already have an account");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(60, 359, 189, 19);
		panel.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("User ID");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(23, 141, 65, 19);
		panel.add(lblNewLabel_2_3);
		
		userid = new JTextField();
		userid.setForeground(Color.BLACK);
		userid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userid.setColumns(10);
		userid.setBackground(new Color(211, 211, 211));
		userid.setBounds(103, 141, 189, 19);
		panel.add(userid);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Confirm");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(23, 199, 80, 19);
		panel.add(lblNewLabel_2_1_1);
		
		cpassword = new JTextField();
		cpassword.setForeground(Color.BLACK);
		cpassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cpassword.setColumns(10);
		cpassword.setBackground(new Color(211, 211, 211));
		cpassword.setBounds(103, 200, 189, 19);
		panel.add(cpassword);
		
		JButton b2 = new JButton("...");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login log=new Login();
				log.setVisible(true);
				
			}
		});
		b2.setForeground(new Color(211, 211, 211));
		b2.setBackground(new Color(0, 0, 128));
		b2.setBounds(249, 360, 27, 21);
		panel.add(b2);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		password.setBackground(new Color(211, 211, 211));
		password.setBounds(113, 172, 179, 19);
		panel.add(password);
		
		JLabel lblNewLabel = new JLabel("  Rmega Company\r\n");
		lblNewLabel.setBounds(393, 53, 320, 60);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel);
	}
}
