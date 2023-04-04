import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;


public class administration extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administration frame = new administration();
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
	public administration() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\kisspng-businessperson-encapsulated-postscript-computer-ic-5adbe83421d369.9659607215243612681386.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 709, 366);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton addBtn = new JButton("Add Flight");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addflight af = new addflight();
				af.setVisible(true);
				dispose();
			}
		});
		addBtn.setBounds(116, 72, 172, 23);
		panel.add(addBtn);
		
		JButton removeBtn = new JButton("Remove Flight");
		removeBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		removeBtn.setBounds(235, 203, 184, 23);
		panel.add(removeBtn);
		
		JButton btnFuelAndCrew = new JButton("Fuel and Crew Management");
		btnFuelAndCrew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFuelAndCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewAndFuelmanagement cf = new crewAndFuelmanagement();
				cf.setVisible(true);
				administration admin = new administration();
				dispose();
			}
		});
		btnFuelAndCrew.setBounds(309, 72, 251, 23);
		panel.add(btnFuelAndCrew);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\technician-icon1.png"));
		lblNewLabel.setBounds(547, 32, 152, 139);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\pngwing.com (5).png"));
		lblNewLabel_1.setBounds(29, 39, 100, 90);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\pngwing.com (6).png"));
		lblNewLabel_2.setBounds(116, 167, 100, 90);
		panel.add(lblNewLabel_2);
	}
}
