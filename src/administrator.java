import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class administrator extends JFrame {

	Connection con = null;
	ResultSet rs = null;
		PreparedStatement pst = null;
	JFrame frame;
	private JPanel contentPane;
	private JTextField txtUname;
	private JPasswordField txtPassw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administrator frame = new administrator();
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
	public administrator() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\kisspng-businessperson-encapsulated-postscript-computer-ic-5adbe83421d369.9659607215243612681386.png"));
		
		
		con= Database.mycon();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(388, 0, 474, 425);
		panel.setForeground(Color.BLACK);
		panel.setBackground(SystemColor.textInactiveText);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUname = new JTextField();
		txtUname.setBounds(194, 140, 171, 20);
		txtUname.setColumns(10);
		panel.add(txtUname);
		
		txtPassw = new JPasswordField();
		txtPassw.setBounds(194, 185, 171, 20);
		panel.add(txtPassw);
		
		JLabel label = new JLabel("Username");
		label.setBounds(60, 143, 106, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(60, 188, 106, 14);
		panel.add(label_1);
		
		JButton button = new JButton("login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get text from user
				// get text from password
				  String Uname= txtUname.getText();
				  String Passw = txtPassw.getText();
				  
	try{
		String sql="SELECT * FROM administrators WHERE username = ? AND password = ?";
		pst=con.prepareCall(sql);
		pst.setString(1,Uname);
		pst.setString(2,Passw);
		
		rs =pst.executeQuery();
		if (rs.next())
		{
			JOptionPane.showMessageDialog(rootPane, "Successful");
			dispose();
			administration window = new administration();
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
		button.setBounds(221, 232, 89, 23);
		panel.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\icons8-login-64.png"));
		lblNewLabel_1.setBounds(214, 11, 96, 118);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\pngairplane.png"));
		lblNewLabel.setBounds(0, 0, 378, 425);
		contentPane.add(lblNewLabel);
	}
}
