import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;

public class MainPage extends JFrame
{
	Connection con;
	Container c = getContentPane();
	JPanel PFlightTypes = new JPanel(null);
	JPanel PLogin = new JPanel(null);
	JPanel PFlightDetails = new JPanel(null);

	public boolean bCheck=true;

	JLabel LDomesticFlight = new JLabel("<html><B>Domestic Flights</B></html>");
	JLabel LInternationalFlight = new JLabel("<html><B>International Flights</B></html>");

	JLabel LDomesticFlight1 = new JLabel("<html><B>Domestic Flight Booking</B></html>");
	JLabel LInternationalFlight1 = new JLabel("<html><B>International Flight Booking</B></html>");

	JButton BLogin;

	final Object[] col1 ={ "From", "To", "Price", "Time" };
	final Object[] col2 = { "From", "To", "Price", "Time" };
	final Object[] col3 = { "From", "To", "Price", "Time" };
	
	final Object[][] row1 = { { "Nairobi", "Ukunda", "3125", "16:30" }, { "Nairobi", "Mombasa ", "3225", "19:00" }, { "Nairobi", "Malindi", "1425 ", "08:30" }, { "Nairobi", "Kisumu", "1025 ", "09:50" }, { "Nairobi", "Eldoret", "1525", "11:00" }, { "Nairobi", "Lamu", "3825 ", "05:30" }, { "Nairobi", "Isiolo", "3025 ", "05:30" } };
	final Object[][] row2 = { { "Nairobi", "London", "21485", "06:20" }};
	final Object[][] row3 = { { "Nairobi", "Ukunda", "9375", "16:30" }, { "Nairobi", "Mombasa ", "9675", "19:00" }, { "Nairobi", "Malindi", "4275", "08:30" }, { "Nairobi", "Kisumu", "3075", "09:50" }, { "Nairobi", "Eldoret", "4575", "11:00" }, { "Nairobi", "Lamu", "11475", "05:30" }, { "Nairobi", "Isiolo", "9075", "05:30" } };
	final Object[][] row4 = { { "Nairobi", "London", "64455", "06:20" }, { "Nairobi", "	Dubai", "27000", "20:45" }, { "Nairobi", "Cairo", "68925", "10:25" }, { "Nairobi", "CapeTown", "37500", "16:45" }, { "Nairobi", "Chicago", "105000", "06:30" }, { "Nairobi", "Dubai", "36000", "08:15" }, { "Nairobi", "Frankfurt", "55500", "06:50" } };
	

	public JTable TDomesticFlight = new JTable(row1, col1);
	public JTable TInternationalFlight = new JTable(row2, col2);
	public JTable TDomesticFlight1 = new JTable(row3, col3);
	public JTable TInternationalFlight1 = new JTable(row4, col2);

	public JScrollPane JSP1 = new JScrollPane(TDomesticFlight, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	public JScrollPane JSP2 = new JScrollPane(TInternationalFlight, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	public JScrollPane JSP3 = new JScrollPane(TDomesticFlight1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	public JScrollPane JSP4 = new JScrollPane(TInternationalFlight1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	Icon img1 = new ImageIcon("img/economic.jpg");
	Icon img2 = new ImageIcon("img/business.jpg");
	Icon img3 = new ImageIcon("img/economic1.jpg");
	Icon img4 = new ImageIcon("img/business1.jpg");

	JLabel LEconomic = new JLabel("Economic", img1, SwingConstants.LEFT);
	JLabel LBusiness = new JLabel("Business", img2, SwingConstants.LEFT);
	JLabel LEconomic1 = new JLabel("Economic", img3, SwingConstants.LEFT);
	JLabel LBusiness1 = new JLabel("Business", img4, SwingConstants.LEFT);

	public MainPage()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\pngwing.com.png"));
		Connection con;
		String url = "jdbc:mysql://localhost/flights";
		String user="root";
		String pass="";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
		}
		catch(Exception el){
			
		}
		
		WindowUtilities.setNativeLookAndFeel();
		setPreferredSize(new Dimension(796,572));

		PFlightTypes.setBackground(Color.white);
		PFlightDetails.setBackground(Color.white);

		JSP1.setBounds(0, 340, 790, 200);
		JSP2.setBounds(0, 340, 790, 200);
		JSP3.setBounds(0, 340, 790, 200);
		JSP4.setBounds(0, 340, 790, 200);

		PFlightTypes.setBounds(0,0,500, 340);
		PFlightDetails.setBounds(0,340,790,200);

		LDomesticFlight1.setBounds(60, 60, 138, 20);
		LInternationalFlight1.setBounds(60, 100, 153, 20);

		PFlightDetails.add(JSP1);
		PFlightDetails.add(JSP2);
		PFlightDetails.add(JSP3);
		PFlightDetails.add(JSP4);

		JSP1.setVisible(true);
		JSP2.setVisible(false);
		JSP3.setVisible(false);
		JSP4.setVisible(false);

		LBusiness.setBounds(265, 170, 300, 125);
		LEconomic.setBounds(0, 170, 250, 125);
		LBusiness1.setBounds(280, 200, 135, 60);
		LEconomic1.setBounds(50, 200, 147, 60);

		PFlightTypes.add(LEconomic);
		PFlightTypes.add(LBusiness);
		PFlightTypes.add(LEconomic1);
		PFlightTypes.add(LBusiness1);

		LBusiness.setVisible(false);
		LEconomic1.setVisible(false);
		LBusiness1.setVisible(true);
		LEconomic.setVisible(true);


		LDomesticFlight.setBounds(60, 60, 100, 25);
		LInternationalFlight.setBounds(60, 100, 120, 25);

		c.add(PFlightTypes);
		c.add(PFlightDetails);
		PLogin.setBounds(496, 0, 350, 340);
		PFlightDetails.add(PLogin);
		PLogin.setBackground(Color.white);
				BLogin = new JButton("Book Flight");
				BLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
						BLogin.setBounds(77, 106, 129,42);
								PLogin.add(BLogin);
								
										BLogin.addActionListener(new button1(this));

		PFlightTypes.add(LDomesticFlight);
		PFlightTypes.add(LInternationalFlight);

		pack();
		setVisible(true);

		addWindowListener(new ExitListener());

		LDomesticFlight.addMouseListener(new mouse1(this, true));
		LInternationalFlight.addMouseListener(new mouse1(this, false));

		LDomesticFlight1.addMouseListener(new mouse3(this, true));
		LInternationalFlight1.addMouseListener(new mouse3(this, false));

		LBusiness1.addMouseListener(new mouse2(this, true));
		LEconomic1.addMouseListener(new mouse2(this, false));
	}

	public static void main(String args[])
	{
		new MainPage();
	}
}


class button1 implements ActionListener
{
	MainPage type;
	char[] cCheck, cPassword={};
	JFrame f;
	String sCheck,sCheck1="";

	public button1(MainPage type)
	{
		this.type = type;
	}
	public void actionPerformed(ActionEvent e)
	{
		
			type.PLogin.add(type.LDomesticFlight1);
			type.PLogin.add(type.LInternationalFlight1);

			
			type.PLogin.remove(type.BLogin);

			type.c.repaint();
		
		
	}
	
}

class mouse1 extends MouseAdapter
{
	MainPage type;
	boolean bCheck;

	public mouse1(MainPage type, boolean bCheck)
	{
		this.type = type;
		this.bCheck = bCheck;
	}
	public void mouseEntered(MouseEvent e)
	{
		type.LDomesticFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		type.LInternationalFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseClicked(MouseEvent e)
	{
		//view from database
				//database connection
				String sql = "SELECT * FROM internationalflights  ";
				try{
					PreparedStatement pst = type.con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					DefaultTableModel model = (DefaultTableModel)type.TInternationalFlight.getModel();
					model.setRowCount(0);
					while(rs.next()){
						model.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)});
					}
				}
				catch(Exception el)
				{
					
				}
		if(bCheck)
			type.bCheck = true;
		else
			type.bCheck = false;
		type.LEconomic.setVisible(true);
		type.LBusiness1.setVisible(true);
		type.LEconomic1.setVisible(false);
		type.LBusiness.setVisible(false);

		type.JSP1.setVisible(false);
		type.JSP2.setVisible(false);
		type.JSP3.setVisible(false);
		type.JSP4.setVisible(false);
		if(bCheck)
			type.JSP1.setVisible(true);
		else
			type.JSP2.setVisible(true);
		
		
		
	}
}



class mouse3 extends MouseAdapter
{
	MainPage type;
	boolean bCheck;

	public mouse3(MainPage type, boolean bCheck)
	{
		this.type = type;
		this.bCheck = bCheck;
	}
	public void mouseEntered(MouseEvent e)
	{
		type.LDomesticFlight1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		type.LInternationalFlight1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseClicked(MouseEvent e)
	{
		if (bCheck)
			new DomesticFlight(type);
		else
			new InternationalFlight(type);
	}
}


class mouse2 extends MouseAdapter
{
	MainPage type;
	boolean bCheck;

	public mouse2(MainPage type, boolean bCheck)
	{
		this.type = type;
		this.bCheck = bCheck;
	}
	public void mouseEntered(MouseEvent e)
	{
		type.LEconomic1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		type.LBusiness1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseClicked(MouseEvent e)
	{
		if(type.bCheck)
		{
			if (bCheck)
			{
				type.LBusiness1.setVisible(false);
				type.LBusiness.setVisible(true);
				type.LEconomic.setVisible(false);
				type.LEconomic1.setVisible(true);
				type.JSP1.setVisible(false);
				type.JSP2.setVisible(false);
				type.JSP3.setVisible(true);
				type.JSP4.setVisible(false);
			}
			else
			{
				type.LEconomic1.setVisible(false);
				type.LBusiness.setVisible(false);
				type.LBusiness1.setVisible(true);
				type.LEconomic.setVisible(true);
				type.JSP1.setVisible(true);
				type.JSP2.setVisible(false);
				type.JSP3.setVisible(true);
				type.JSP4.setVisible(false);
			}
		}
		else
		{
			if (bCheck)
			{
				type.LBusiness1.setVisible(false);
				type.LBusiness.setVisible(true);
				type.LEconomic.setVisible(false);
				type.LEconomic1.setVisible(true);
				type.JSP1.setVisible(false);
				type.JSP2.setVisible(false);
				type.JSP3.setVisible(false);
				type.JSP4.setVisible(true);
			}
			else
			{
				type.LEconomic1.setVisible(false);
				type.LBusiness.setVisible(false);
				type.LBusiness1.setVisible(true);
				type.LEconomic.setVisible(true);
				type.JSP1.setVisible(false);
				type.JSP2.setVisible(true);
				type.JSP3.setVisible(false);
				type.JSP4.setVisible(false);
			}
		}
	}
}

