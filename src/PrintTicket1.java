import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrintTicket1 extends JFrame
{
	public PrintTicket1(String fName,String lName,String sFrom, String sTo, String sClass, Integer iAdult, Integer iChildren, Integer iInfant, String sBookingDate, Integer iPrice, String sTime)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\pngwing.com.png"));
		Container c=getContentPane();
		c.setLayout(new BorderLayout());


		JPanel Panel2 = new JPanel(null);

		Panel2.setPreferredSize(new Dimension(500,200));

		JLabel LTitle = new JLabel("Ticket");
		LTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
		JLabel LFrom = new JLabel("<html><font color=\"#000000\">From </font><font color=\"#778899\">"+sFrom+"</font></html>" );
		LFrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel LTo = new JLabel("<html><font color=\"#000000\">To </font><font color=\"#778899\">"+sTo+"</font></html>");
		LTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel LClass = new JLabel("<html><font color=\"#000000\">Class </font><font color=\"#778899\">"+sClass+"</font></html>" );
		LClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel LBookingDate = new JLabel("<html><font color=\"#000000\">Traveling Date </font><font color=\"#778899\">"+ sBookingDate+"</font></html>" );
		LBookingDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel LPrice = new JLabel("<html><font color=\"#000000\">Total Price </font><font color=\"#778899\">"+ iPrice+"</font></html>" );
		LPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel LTime = new JLabel("<html><font color=\"#000000\">DepatureTime </font><font color=\"#778899\">"+ sTime+"</font></html>" );
		LTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel LAdult = new JLabel("<html><font color=\"#000000\">Adult </font><font color=\"#778899\">"+iAdult+"</font></html>" );
		LAdult.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel LChildren = new JLabel("<html><font color=\"#000000\">Children </font><font color=\"#778899\">"+ iChildren+"</font></html>" );
		LChildren.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabel LInfant = new JLabel("<html><font color=\"#000000\">Infant </font><font color=\"#778899\">"+iInfant+"</font></html>" );
		LInfant.setFont(new Font("Tahoma", Font.PLAIN, 15));


		//JLabel LTicketNo=new JLabel("<html><font color=\"#000000\">TicketNumber &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;: &nbsp;</font></html>");
		//JLabel LBookedBy=new JLabel("<html><font color=\"#000000\">BookedBy &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;: &nbsp;</font></html>");

		JLabel LEmpty = new JLabel("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		


		LTitle.setBounds(229,46,203,45);
		LFrom.setBounds(20,228,300,20);

		LTo.setBounds(352,228,300,20);
		LClass.setBounds(20,200,300,20);
		LBookingDate.setBounds(352,275,300,20);
		LPrice.setBounds(20,275,300,20);
		LTime.setBounds(362,327,300,20);
		LAdult.setBounds(20,327,300,20);
		LChildren.setBounds(362,377,300,20);
		LInfant.setBounds(20,377,300,20);


		//LTicketNo.setBounds(320,80,300,20);
		//LBookedBy.setBounds(320,125,300,20);

		LEmpty.setBounds(0,541,1000,20);
		


		Panel2.add(LTitle);
		Panel2.add(LFrom);
		Panel2.add(LTo);
		Panel2.add(LClass);
		Panel2.add(LBookingDate);
		Panel2.add(LAdult);
		Panel2.add(LChildren);
		Panel2.add(LInfant);
		Panel2.add(LPrice);
		Panel2.add(LTime);

		
		Panel2.add(LEmpty);
	


		Panel2.setBackground(Color.white);

		c.add(Panel2, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Safe Journey");
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(229, 473, 193, 45);
		Panel2.add(lblNewLabel);
		
		JLabel lblfrom = new JLabel("<html><font color=\"#000000\">First Name </font><font color=\"#778899\">"+fName+"</font></html>");
		lblfrom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblfrom.setBounds(20, 152, 300, 20);
		Panel2.add(lblfrom);
		
		JLabel lbllastName = new JLabel("<html><font color=\"#000000\">Last Name </font><font color=\"#778899\">"+lName+"</font></html>");
		lbllastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbllastName.setBounds(341, 152, 300, 20);
		Panel2.add(lbllastName);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\pngwing.com (2).png"));
		label.setBounds(377, 0, 171, 149);
		Panel2.add(label);


		//pack();
		setSize(708,611);
		setVisible(true);
	}
}
