import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import javax.swing.JTextField;
import java.awt.Toolkit;


public class addflight extends JFrame {

	private JPanel contentPane;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtPrice;
	private JTextField txtTime;

	/**
	 * Launch the application.
	 */
	public static Connection mycon()
	{
		Connection con = null;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/flights","root","");
		} catch (ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					addflight frame = new addflight();
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
	public addflight() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\pngwing.com.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 704, 347);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Flights");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(295, 11, 126, 24);
		panel.add(lblNewLabel);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFrom.setBounds(26, 79, 71, 24);
		panel.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTo.setBounds(26, 153, 41, 24);
		panel.add(lblTo);
		
		JLabel lblPrice = new JLabel("Price($)");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(407, 79, 71, 24);
		panel.add(lblPrice);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTime.setBounds(407, 153, 60, 24);
		panel.add(lblTime);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String from = txtFrom.getText() ;
				String to = txtTo.getText() ;
				String price = txtPrice.getText() ;
				String time = txtTime.getText() ;
				
				try{
					Statement s = mycon().createStatement();
					s.executeUpdate("INSERT INTO internationalflights (depature, destination, price, time) "
							+ "VALUES ('"+from+"','"+to+"','"+price+"','"+time+"')");
					JOptionPane.showMessageDialog(rootPane, "Flight Added");
					
				
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				txtFrom.setText("");
				txtTo.setText("");
				txtPrice.setText("");
				txtTime.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(102, 237, 144, 31);
		panel.add(btnNewButton);
		
		txtFrom = new JTextField();
		txtFrom.setBounds(102, 82, 160, 20);
		panel.add(txtFrom);
		txtFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setColumns(10);
		txtTo.setBounds(102, 156, 160, 20);
		panel.add(txtTo);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(481, 82, 160, 20);
		panel.add(txtPrice);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(481, 156, 160, 20);
		panel.add(txtTime);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = txtFrom.getText() ;
				String to = txtTo.getText() ;
				String price = txtPrice.getText() ;
				String time = txtTime.getText() ;
				
				try{
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/flights", "root", "");
					Statement stmt = conn.createStatement();
					Statement s = mycon().createStatement();
					String sqlDelete = "DELETE FROM internationalflights  WHERE depature='', destination='', price='', time=''";
		            int rowsDeleted = stmt.executeUpdate(sqlDelete);
		            System.out.println(rowsDeleted + " row(s) deleted.");
					
					JOptionPane.showMessageDialog(rootPane, "Flight Deleted");
					
				//String sqlDelete = "DELETE FROM mytable WHERE name='John'";
		           // int rowsDeleted = stmt.executeUpdate(sqlDelete);
		           // System.out.println(rowsDeleted + " row(s) deleted.");
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				txtFrom.setText("");
				txtTo.setText("");
				txtPrice.setText("");
				txtTime.setText("");
				
			}
			
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(361, 237, 144, 31);
		panel.add(btnDelete);
	}
}
