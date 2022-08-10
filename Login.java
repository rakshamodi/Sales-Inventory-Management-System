package saim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField password;
	private String result;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
		public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1100, 638);
		contentPane.add(scrollPane);
		
		JPanel contentPane_1 = new JPanel();
		scrollPane.setViewportView(contentPane_1);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.WHITE);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(393, 151, 320, 430);
		contentPane_1.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(0, 0, 128)));
		panel.setBackground(new Color(0, 191, 255));
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Wide Latin", Font.BOLD, 18));
		lblNewLabel_1.setBounds(110, 33, 95, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(23, 116, 65, 19);
		panel.add(lblNewLabel_2);
		
		userid = new JTextField();
		userid.setForeground(Color.BLACK);
		userid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userid.setColumns(10);
		userid.setBackground(new Color(211, 211, 211));
		userid.setBounds(103, 117, 189, 19);
		panel.add(userid);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(23, 164, 80, 19);
		panel.add(lblNewLabel_2_1);
		
		JButton b1 = new JButton("Login");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rmega", "root", "");
				
				String uid= userid.getText();
				String pass=password.getText();
				PreparedStatement ps= con.prepareStatement("select * from Login where uid='"+uid+"' and upass='"+pass+"'"); 
				ResultSet rs= ps.executeQuery();
				
				boolean flag=rs.next();
				if(flag)
				{
					result=rs.getString("uname");
									
					Dashboard dashbrd= new Dashboard(result);
					dashbrd.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(b1, "Incorrect Username or Password!");
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
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.setBounds(103, 253, 116, 35);
		panel.add(b1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Or");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(155, 319, 27, 19);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Create a new Account");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(62, 359, 189, 19);
		panel.add(lblNewLabel_2_2_1);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		password.setBackground(new Color(211, 211, 211));
		password.setBounds(113, 165, 179, 19);
		panel.add(password);
		
		JCheckBox showpassword = new JCheckBox("Show Password");
		showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showpassword.isSelected())
				{
					password.setEchoChar((char) 0);
				}
				else
				{
					password.setEchoChar('•');
				}
				
			}
		});
		showpassword.setBackground(new Color(0, 191, 255));
		showpassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		showpassword.setBounds(181, 191, 111, 21);
		panel.add(showpassword);
		
		JButton b2 = new JButton("...");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register reg=new Register();
				reg.setVisible(true);
				
				
				
			}
		});
		b2.setForeground(new Color(211, 211, 211));
		b2.setBackground(new Color(0, 0, 128));
		b2.setBounds(235, 360, 27, 21);
		panel.add(b2);
		
		JLabel lblNewLabel = new JLabel("  Rmega Company\r\n");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(393, 53, 320, 60);
		contentPane_1.add(lblNewLabel);
	}
}
