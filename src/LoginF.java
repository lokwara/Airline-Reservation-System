
import java.sql.*;
import java.io.File;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Font;

public class LoginF extends JFrame {
Connection con = null;
ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	JFrame frame;
	private JTextField txtUname;
	private JPasswordField txtPassw;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginF window = new LoginF();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginF() {
		initialize();
		con= Database.mycon(); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\aeroplane.jpg"));
		frame.setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 784, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\aeroplane.jpg"));
		lblNewLabel.setBounds(0, 0, 373, 425);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(374, 0, 474, 425);
		frame.getContentPane().add(panel_1);
		panel_1.setBackground(UIManager.getColor("Button.disabledForeground"));
		panel_1.setForeground(UIManager.getColor("Button.focus"));
		panel_1.setLayout(null);
		
		txtUname = new JTextField();
		txtUname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUname.setBounds(194, 140, 171, 20);
		panel_1.add(txtUname);
		txtUname.setColumns(10);
		
		txtPassw = new JPasswordField();
		txtPassw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassw.setBounds(194, 185, 171, 20);
		panel_1.add(txtPassw);
		
		final JLabel user = new JLabel("Username");
		user.setFont(new Font("Tahoma", Font.PLAIN, 20));
		user.setForeground(Color.BLACK);
		user.setBounds(60, 143, 106, 20);
		panel_1.add(user);
		
		final JLabel pass = new JLabel("Password");
		pass.setForeground(Color.BLACK);
		pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass.setBounds(60, 188, 106, 23);
		panel_1.add(pass);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get text from user
				// get text from password
				  String Uname= txtUname.getText();
				  String Passw = txtPassw.getText();
				  
	try{
		String sql="SELECT * FROM clients WHERE username = ? AND password = ?";
		pst=con.prepareCall(sql);
		pst.setString(1,Uname);
		pst.setString(2,Passw);
		
		rs =pst.executeQuery();
		if (rs.next())
		{
			JOptionPane.showMessageDialog(rootPane, "Successful");
			dispose();
			MainPage window = new MainPage();
			window.setVisible(true);
			LoginF frame = new LoginF();
			frame.setVisible(false);
			 
		}
		else
		{
			JOptionPane.showMessageDialog(rootPane, "ERROR \n Fill in Details");
		}
	}
	catch( Exception e1 )
	{
		
	}
			
			}
		});
		btnLogin.setBounds(194, 297, 89, 23);
		panel_1.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\icons8-login-64.png"));
		lblNewLabel_1.setBounds(177, 11, 106, 85);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblCantLogIn = new JLabel("Cant Log in?");
		lblCantLogIn.setForeground(Color.BLACK);
		lblCantLogIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantLogIn.setBounds(82, 335, 84, 19);
		panel_1.add(lblCantLogIn);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginF window = new LoginF();
				window.setVisible(false);
				window.dispose();
				register frame = new register();
				frame.setVisible(true);
				
			}
		});
		btnRegister.setBounds(194, 331, 89, 23);
		panel_1.add(btnRegister);
		
		JButton btnAdmin = new JButton("Administrator");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrator admin =new administrator();
				admin.setVisible(true);
				dispose();
			}
		});
		btnAdmin.setBounds(194, 244, 106, 23);
		panel_1.add(btnAdmin);
	}
}
