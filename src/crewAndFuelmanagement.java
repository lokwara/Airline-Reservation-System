import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class crewAndFuelmanagement extends JFrame {

	private JPanel contentPane;
	private JTextField txtPassengerno;
	private JTextField txtFuelAmount;
	private JTextField txtCrew;
	private JTextField txtDistance;
	private JLabel lblDistancekm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crewAndFuelmanagement frame = new crewAndFuelmanagement();
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
	public crewAndFuelmanagement() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\aeroplane.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPassengerno = new JTextField();
		txtPassengerno.setBounds(85, 130, 159, 20);
		contentPane.add(txtPassengerno);
		txtPassengerno.setColumns(10);
		
		JLabel lblPassengersNumber = new JLabel("Passengers number");
		lblPassengersNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassengersNumber.setBounds(85, 87, 140, 20);
		contentPane.add(lblPassengersNumber);
		
		txtFuelAmount = new JTextField();
		txtFuelAmount.setColumns(10);
		txtFuelAmount.setBounds(85, 236, 159, 20);
		contentPane.add(txtFuelAmount);
		
		txtCrew = new JTextField();
		txtCrew.setColumns(10);
		txtCrew.setBounds(345, 236, 292, 20);
		contentPane.add(txtCrew);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x,y,z;
				x = Double.valueOf(txtPassengerno.getText());
				y = Double.valueOf(txtDistance.getText());
				double total;
				total = 12*x;
				txtFuelAmount.setText("Fuel Amount"+total+"litres");
				if(x>60)
				{
				txtCrew.setText("5 more added crew including Air hostess");	
				}
				else{
					txtCrew.setText("");
				}
				
			}
		});
		btnCalculate.setBounds(580, 162, 89, 23);
		contentPane.add(btnCalculate);
		
		JLabel lblFuelAmount = new JLabel("Fuel Amount");
		lblFuelAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFuelAmount.setBounds(85, 192, 140, 20);
		contentPane.add(lblFuelAmount);
		
		JLabel lblAdditionalCrewMembers = new JLabel("Additional Crew Members");
		lblAdditionalCrewMembers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdditionalCrewMembers.setBounds(348, 192, 171, 20);
		contentPane.add(lblAdditionalCrewMembers);
		
		txtDistance = new JTextField();
		txtDistance.setColumns(10);
		txtDistance.setBounds(345, 130, 159, 20);
		contentPane.add(txtDistance);
		
		lblDistancekm = new JLabel("Distance(km)");
		lblDistancekm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistancekm.setBounds(345, 87, 140, 20);
		contentPane.add(lblDistancekm);
	}
}
