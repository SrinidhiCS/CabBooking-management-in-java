package swing;

import java.sql.*;
import java.util.Date;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class utrip extends JFrame {

	private JPanel contentPane;
	private JTextField userid;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					utrip frame = new utrip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public utrip() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 191, 255), new Color(0, 206, 209), null, null));
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(10, 11, 744, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("BOOK A TRIP ");
		lblNewJgoodiesTitle.setForeground(new Color(210, 105, 30));
		lblNewJgoodiesTitle.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 36));
		lblNewJgoodiesTitle.setBounds(275, 11, 227, 46);
		panel.add(lblNewJgoodiesTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(70, 130, 180), new Color(255, 0, 0), null, null));
		panel_1.setBounds(10, 90, 744, 588);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel bground = DefaultComponentFactory.getInstance().createLabel("");
		bground.setBounds(311, 11, 159, 168);
		panel_1.add(bground);
		Image img = new ImageIcon(this.getClass().getResource("/maps-icon.png")).getImage();
		bground.setIcon(new ImageIcon(img));
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Enter User_id");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel.setBounds(27, 175, 117, 28);
		panel_1.add(lblNewJgoodiesLabel);
		
		userid = new JTextField();
		userid.setBounds(159, 177, 142, 28);
		panel_1.add(userid);
		userid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Select Taxi Type");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_1.setBounds(27, 236, 142, 28);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		JComboBox ttype = new JComboBox();
		ttype.setModel(new DefaultComboBoxModel(new String[] {"Micro    Rs.10/Km", "Mini     Rs.11/Km", "Premium  Rs.13/Km", "Sedan    Rs.15/Km"}));
		ttype.setBounds(179, 239, 142, 27);
		panel_1.add(ttype);
		
	
		JComboBox pickloc = new JComboBox();
		pickloc.setModel(new DefaultComboBoxModel(new String[] {"Bangalore", "Mysore", "Tumkur"}));
		pickloc.setBounds(235, 328, 122, 33);
		panel_1.add(pickloc);
		
		JComboBox droploc = new JComboBox();
		droploc.setModel(new DefaultComboBoxModel(new String[] {"Bangalore", "Mysore", "Tumkur"}));
		droploc.setBounds(253, 409, 122, 33);
		panel_1.add(droploc);

		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Choose start Date");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_2.setBounds(490, 173, 142, 33);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Enter Pick-Up Location");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_3.setBounds(27, 328, 198, 33);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Enter Destination Location");
		lblNewJgoodiesLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_4.setBounds(28, 409, 215, 33);
		panel_1.add(lblNewJgoodiesLabel_4);
		
		JButton btnNewButton = new JButton("Reset");
		Image img1 = new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid.setText("");
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton.setBounds(27, 489, 142, 41);
		panel_1.add(btnNewButton);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(490, 205, 133, 28);
		panel_1.add(dateChooser);
		Date dat = new Date();
		dateChooser.setMinSelectableDate(dat);
		
		JButton btnSubmit = new JButton("Submit");
		Image img2 = new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img2));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dregister frame =new dregister();
			String uid = userid.getText();
			String pl = pickloc.getSelectedItem().toString();
			String dl = droploc.getSelectedItem().toString();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			
			if(uid.length()==0)
			{ JOptionPane.showMessageDialog(frame, "Please Enter User_ID");			
			}
			if(dateChooser.getDate()==null)
			{ JOptionPane.showMessageDialog(frame, "Please Enter Date");
			}
			if(pl==dl)
			{ JOptionPane.showMessageDialog(frame, "Please Enter Different Pick-Up and Drop Locations");
			}
			else {
				try {
					String sd = date.format(dateChooser.getDate());
				    String type = ttype.getSelectedItem().toString();
					Boolean r1;
					String tid;
					String dname;
					String treg;
					String trid;
					PreparedStatement pst,pst1;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","");
					pst=con.prepareStatement("Insert into trip_details(user_id,start_date,taxi_type,startloc,destloc,taxi_id,driver_id)values(?,?,?,?,?,?,?)");
					pst.setString(1, uid);
					pst.setString(2, sd);
					pst.setString(3,type);
					pst.setString(4,pl);
					pst.setString(5,dl);
					Statement stm1 = con.createStatement();
					String sql1= "Select * from taxi where type ='"+type+"'"+"and taxi_id not in(Select taxi_id from trip_details where start_date='"+sd+"')";
					ResultSet rs1 = stm1.executeQuery(sql1);
					r1=rs1.next();
					if (r1==false)
					{ JOptionPane.showMessageDialog(null, "Taxi Type not available","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else {
					tid=rs1.getString(1);
					pst.setString(6, rs1.getString(1));
					String sql2= "Select * from driver where driver_id not in (Select driver_id from trip_details where start_date ='"+sd+"')"; 
					ResultSet rs2 = stm1.executeQuery(sql2);
					rs2.next();
					pst.setString(7, rs2.getString(1));
					pst.executeUpdate();
					Statement stm = con.createStatement();
					String sql= "Select * from trip_details where user_id='"+uid+"' and start_date ='"+sd+"'";
					ResultSet rs = stm.executeQuery(sql);
					JOptionPane.showMessageDialog(frame,"Trip Successfully registered");
					rs.next();
					trid=rs.getString(1);
					String sql3= "Select name from driver where driver_id='"+rs2.getString(1)+"'";
					ResultSet rs3 = stm.executeQuery(sql3);
					rs3.next();
					dname=rs3.getString(1);
					String sql5= "Select Contact_no from driver where driver_id='"+rs2.getString(1)+"'";
					ResultSet rs5 = stm.executeQuery(sql5);
					rs5.next();
					String dcno = rs5.getString(1);

					String sql4= "Select reg_no from taxi where Taxi_id='"+tid+"'";
					ResultSet rs4 = stm.executeQuery(sql4);
					rs4.next();
					treg=rs4.getString(1);
					JOptionPane.showMessageDialog(frame,"Trip_ID is "+trid+"\nDriver Name is :"+dname+"\nTaxi Registration number:"+treg+"\nDriver Contact Number :"+dcno);
					pst1=con.prepareStatement("Insert into bill_details(trip_id,distance,total_amt)values(?,?,?)");
					String sq= "Select * from Distance where (city1='"+pl+"' and city2 ='"+dl+"') OR (city1='"+dl+"'and city2='"+pl+"')";
					ResultSet rs6 = stm.executeQuery(sq);
					rs6.next();
					String dist=rs6.getString(3);
					int total = Integer.parseInt(dist)*Integer.parseInt(type.substring(12,14));
					pst1.setString(1, trid);
					pst1.setString(2, dist);
					pst1.setInt(3,total);
					pst1.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Bill Successfully generated");
					userid.setText("");
					ttype.setSelectedItem("");
					pickloc.setSelectedItem("");
					droploc.setSelectedItem("");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			}
		});
		btnSubmit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnSubmit.setBounds(289, 489, 142, 41);
		panel_1.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		Image img3 = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img3));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				userpage up = new userpage();
				up.show();
			}
		});
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnBack.setBounds(548, 489, 142, 41);
		panel_1.add(btnBack);
			
	}
}
