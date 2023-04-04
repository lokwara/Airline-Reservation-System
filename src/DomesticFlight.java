import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DomesticFlight extends JFrame
{
	JComboBox CBFrom, CBTo, CBClass, CBAdult, CBChildren, CBInfant;
	JLabel LFrom, LTo, LBookingDate, LClass, LAdult, LChildren, LInfant, LBookingDetails, LPassengerDetails, LDate, LImg1, LImg2;
	JTextField TFBookingDate;
	Icon img1, img2;
	JButton BFindFlight;
	JPanel PPanel1, PPanel2;

	MainPage type1;
	JTextField txtFname;
    JTextField txtLname;

	public DomesticFlight(MainPage type1)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\workspace\\airlineReservation\\src\\img\\pngwing.com.png"));
		Container c =getContentPane();
		c.setLayout(new BorderLayout());
		String[] sItem1={"Nairobi"};
		String[] sItem2 ={ "Mombasa", "Eldoret ", "Kisumu", "Malindi", "Wajir", "Ukunda", "Lamu", "Isiolo"};
		String[] sItem3={"Economic","Business"};

		this.type1 = type1;
		PPanel1 = new JPanel(null);
		PPanel1.setPreferredSize(new Dimension(500,200));

		LBookingDetails = new JLabel("Booking Details");
		LBookingDetails.setForeground(Color.GRAY);
		LFrom = new JLabel("From          :");
		LTo = new JLabel("To               :");
		LBookingDate = new JLabel("Booking Date:");
		LClass = new JLabel("Class         :");

		CBFrom = new JComboBox(sItem1);
		CBTo = new JComboBox(sItem2);
		CBClass = new JComboBox(sItem3);

		TFBookingDate = new JTextField(10);
		LDate = new JLabel("(DD/MM/YYYY)");
		LDate.setForeground(Color.red);

		img1=new ImageIcon("map1.jpg");
		LImg1 = new JLabel(img1);

		BFindFlight = new JButton("Find Flight");

		LBookingDetails.setBounds(20,3,100,20);

		LFrom.setBounds(257,74,100,20);
		CBFrom.setBounds(337,74,100,20);

		LTo.setBounds(257,105,100,20);
		CBTo.setBounds(337,105,100,20);

		LBookingDate.setBounds(103,171,100,20);
		TFBookingDate.setBounds(183,171,100,20);
		LDate.setBounds(293,171,100,20);

		LClass.setBounds(103,207,100,20);
		CBClass.setBounds(183,207,100,20);

		BFindFlight.setBounds(161,254,100,25);

		LImg1.setBounds(0,290,495,260);

		PPanel1.add(LBookingDetails);
		PPanel1.add(LFrom);
		PPanel1.add(CBFrom);
		PPanel1.add(LTo);
		PPanel1.add(CBTo);
		PPanel1.add(LBookingDate);
		PPanel1.add(TFBookingDate);
		PPanel1.add(LDate);
		PPanel1.add(LClass);
		PPanel1.add(CBClass);
		PPanel1.add(BFindFlight);
		PPanel1.add(LImg1);
		PPanel1.setBackground(Color.white);

		c.add(PPanel1,BorderLayout.WEST);
		
		JLabel lblFirstName = new JLabel("First Name     :");
		lblFirstName.setBounds(10, 77, 100, 14);
		PPanel1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name      :");
		lblLastName.setBounds(10, 117, 100, 14);
		PPanel1.add(lblLastName);
		
		txtFname = new JTextField();
		txtFname.setBounds(103, 74, 121, 20);
		PPanel1.add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setColumns(10);
		txtLname.setBounds(103, 114, 121, 20);
		PPanel1.add(txtLname);

		PPanel2 = new JPanel(null);
		PPanel2.setPreferredSize(new Dimension(320,160));

		LPassengerDetails=new JLabel("PassengerDetails");

		LAdult = new JLabel("Adults(12+)");

		LChildren = new JLabel("Children(2-11)");
		LInfant = new JLabel("Infants(under 2)");

		String[] item4={"1","2","3","4","5","6"};
		CBAdult = new JComboBox(item4);

		String[] item5={"0","1","2","3","4"};
		CBChildren = new JComboBox(item5);

		String[] item6={"0","1","2","3"};
		CBInfant = new JComboBox(item6);

		img2 = new ImageIcon("note_bg.gif");
		LImg2 = new JLabel(img2);

		LPassengerDetails.setBounds(40,3,100,20);

		LAdult.setBounds(40,40,100,20);
		CBAdult.setBounds(140,40,100,20);

		LChildren.setBounds(40,105,100,20);
		CBChildren.setBounds(140,105,100,20);

		LInfant.setBounds(40,170,100,20);
		CBInfant.setBounds(140,170,100,20);

		LImg2.setBounds(16,220,320,200);

		PPanel2.add(LPassengerDetails);
		PPanel2.add(LAdult);
		PPanel2.add(LChildren);
		PPanel2.add(LInfant);
		PPanel2.add(CBAdult);
		PPanel2.add(CBChildren);
		PPanel2.add(CBInfant);
		PPanel2.add(LImg2);

		PPanel2.setBackground(Color.white);

		c.add(PPanel2,BorderLayout.EAST);

		setSize(795,413);
		setVisible(true);

		BFindFlight.addActionListener(new button3(this, type1));
	}
	public static void main(String args[])
	{
		MainPage type1=null;
		new DomesticFlight(type1);
	}
}

class button3 implements ActionListener
{
	DomesticFlight type;
	MainPage type1;
	button3(DomesticFlight type, MainPage type1)
	{
		this.type = type;
		this.type1 = type1;
	}
	public void actionPerformed(ActionEvent e)
	{   String fName = type.txtFname.getText();
	    String lName = type.txtLname.getText();
		String sFrom = (String)type.CBFrom.getSelectedItem();
		String sTo = (String)type.CBTo.getSelectedItem();
		String sClass = (String)type.CBClass.getSelectedItem();
		String sBookingDate = type.TFBookingDate.getText();
		Integer iPrice=0;
		String sTime="";


		Integer iAdult = Integer.parseInt((String)type.CBAdult.getSelectedItem());
		Integer iChildren = Integer.parseInt((String)type.CBChildren.getSelectedItem());
		Integer iInfant = Integer.parseInt((String)type.CBInfant.getSelectedItem());

		int i = 0;

		if(sClass.equals("Economic"))
		{
			try{
				while(i<20)
				{
					if(type1.row1[i][1].equals(sTo))
					{
						iPrice = Integer.parseInt((String)type1.row1[i][2]);
						sTime = (String)type1.row1[i][3];
						break;
					}
					i++;
				}
			}catch(Exception e1)
			{
				
			}
		}
		else
		{
			try
			{
				while(i<20)
				{
					if(type1.row1[i][1].equals(sTo))
					{
						iPrice = Integer.parseInt((String)type1.row3[i][2]);
						sTime = (String)type1.row3[i][3];
						break;
					}
					i++;
				}
			}catch(Exception e1)
			{
				
			}
		}
		type.setTitle(iPrice + " " + sTime);

		iPrice = (iPrice*iAdult)+(iPrice*(iChildren/2));

		int iCount=0;
		int iSeatCount=0;
		String[] sfName = new String[1250];
        String[] slName = new String[1250];
		String[] sTempFrom=new String[1250];
		String[] sTempTo=new String[1250];
		String[] sTempClass=new String[1250];
		String[] sTempBookingDate=new String[1250];
		String[] sTempTime=new String[1250];
		Integer[] iTempAdult=new Integer[1250];
		Integer[] iTempChildren=new Integer[1250];
		Integer[] iTempInfant=new Integer[1250];
		Integer[] iTempPrice=new Integer[1250];

		try
		{
//read from data
			Save2 save1;
			ObjectInputStream OIS1 = new ObjectInputStream(new FileInputStream("save2"));
			do
			{
				save1 = (Save2)OIS1.readObject();
				sfName[iCount] = save1.fName;
				slName[iCount] = save1.lName;
				sTempFrom[iCount] = save1.sFrom;
				sTempTo[iCount] = save1.sTo;
				sTempClass[iCount] = save1.sClass;
				sTempBookingDate[iCount] = save1.sBookingDate;
				sTempTime[iCount] = save1.sTime;
				iTempAdult[iCount] = save1.iAdult;
				iTempChildren[iCount] = save1.iChildren;
				iTempInfant[iCount] = save1.iInfant;
				iTempPrice[iCount] = save1.iPrice;

				iCount++;
				if(save1.sBookingDate.equals(sBookingDate))
					if(save1.sTo.equals(sTo))
						iSeatCount=iSeatCount + save1.iAdult + save1.iChildren + save1.iInfant;
			}while(save1!=null);
			OIS1.close();

		}
		catch(Exception e1)
		{
		}

		iSeatCount = iSeatCount + iAdult + iChildren + iInfant;

		if(iSeatCount > 60)
		{
			JOptionPane.showMessageDialog(null,"Seats are full. Sorry!");
		}
		else
		{
			int iChoice = JOptionPane.showConfirmDialog(null,"Seats available. Do you want to Book now?");
			if(iChoice == JOptionPane.YES_OPTION)
			{
				new PrintTicket1(fName, lName, sFrom, sTo, sClass, iAdult, iChildren, iInfant, sBookingDate, iPrice, sTime);
			try
			{
//write into data
				Save2 save2=new Save2(lName,fName, sFrom, sTo, sClass, iAdult, iChildren, iInfant, sBookingDate, iPrice, sTime);
				ObjectOutputStream OOS1 = new ObjectOutputStream(new FileOutputStream("save2"));
				for(i=0;i<iCount;i++)
				{
					Save2 temp1=new Save2( sfName[i], slName[i], sTempFrom[i], sTempTo[i], sTempClass[i], iTempAdult[i], iTempChildren[i], iTempInfant[i], sTempBookingDate[i], iTempPrice[i], sTempTime[i]);
					OOS1.writeObject(temp1);
System.out.println(temp1);
				}
				OOS1.writeObject(save2);
				OOS1.close();
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
			}
			else
			{
			}
		}
	}
}


class Save2 implements Serializable
{
	String fName, lName, sFrom, sTo, sClass, sBookingDate, sTime;
	Integer iPrice, iAdult, iChildren, iInfant;
//	int iCount;
	public Save2(String fName,String lName, String sFrom, String sTo, String sClass, Integer iAdult, Integer iChildren, Integer iInfant, String sBookingDate, Integer iPrice, String sTime)
	{   
		this.lName=lName;
		this.fName=fName;
		this.sFrom=sFrom;
		this.sTo=sTo;
		this.sClass=sClass;
		this.iAdult=iAdult;
		this.iChildren=iChildren;
		this.iInfant=iInfant;
		this.sBookingDate=sBookingDate;
		this.iPrice=iPrice;
		this.sTime=sTime;
//		this.iCount = iCount;
	}
	public String toString()
	{
		return fName +" "+lName +""+sFrom+" "+sTo+" "+sClass+" "+iAdult+" "+iChildren+" "+iInfant+" "+sBookingDate+" "+iPrice+" "+sTime;
	}
}