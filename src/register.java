import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;


public class register extends JFrame {

	private JPanel contentPane;
	private JTextField Firsttxt;
	private JTextField Lasttxt;
	private JTextField txtId;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\pngwing.com (2).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblRegister.setBounds(209, 0, 228, 63);
		panel.add(lblRegister);
		
		JLabel Fname = new JLabel("First Name");
		Fname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Fname.setBounds(170, 74, 76, 14);
		panel.add(Fname);
		
		JLabel Lname = new JLabel("Last Name");
		Lname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lname.setBounds(152, 109, 83, 14);
		panel.add(Lname);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Username.setBounds(152, 157, 83, 14);
		panel.add(Username);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Password.setBounds(152, 200, 64, 14);
		panel.add(Password);
		
		Firsttxt = new JTextField();
		Firsttxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Firsttxt.setBounds(245, 71, 161, 20);
		panel.add(Firsttxt);
		Firsttxt.setColumns(10);
		
		Lasttxt = new JTextField();
		Lasttxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Lasttxt.setColumns(10);
		Lasttxt.setBounds(245, 106, 161, 20);
		panel.add(Lasttxt);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtId.setColumns(10);
		txtId.setBounds(245, 154, 161, 20);
		panel.add(txtId);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String nam =Firsttxt.getText();
			String nam2 = Lasttxt.getText();
			String id =txtId.getText();
			String password =txtPassword.getText();
			try{
				if(nam.isEmpty()&& nam2.isEmpty()&& id.isEmpty()&& password.isEmpty())
				{
					JOptionPane.showMessageDialog(rootPane, "Fill in Details");
				}
				else{
				Statement s = Database.mycon().createStatement();
				s.executeUpdate("INSERT INTO clients (First_Name, Last_Name, Username, Password) "
						+ "VALUES ('"+nam+"','"+nam2+"','"+id+"','"+password+"')");
				JOptionPane.showMessageDialog(rootPane, "Your Account has been Created!");
				
				LoginF window = new LoginF();
				window.frame.setVisible(true);
			register frame = new register();
			dispose();
				}
					
			}
			catch(Exception e1)
			{
				System.out.println("Fill in Details");
			}
			Firsttxt.setText("");
			Lasttxt.setText("");
			txtId.setText("");
			txtPassword.setText("");
			}
		});
		btnRegister.setBounds(194, 257, 89, 23);
		panel.add(btnRegister);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(359, 257, 89, 23);
		panel.add(btnReset);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(245, 199, 161, 20);
		panel.add(txtPassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 0, 80, 312);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(576, 0, 80, 312);
		panel.add(panel_2);
	}
}
