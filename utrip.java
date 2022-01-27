package swing;

import java.sql.*;

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

public class utrip extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JTextField pickloc;
	private JTextField droploc;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */

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
		bground.setBounds(329, 11, 133, 128);
		panel_1.add(bground);
		Image img = new ImageIcon(this.getClass().getResource("/Maps-icon.png")).getImage();
		bground.setIcon(new ImageIcon(img));
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Enter User_id");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel.setBounds(10, 155, 117, 28);
		panel_1.add(lblNewJgoodiesLabel);
		
		userid = new JTextField();
		userid.setBounds(154, 153, 142, 28);
		panel_1.add(userid);
		userid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Select Taxi Type");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_1.setBounds(510, 155, 142, 28);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		JComboBox ttype = new JComboBox();
		ttype.setModel(new DefaultComboBoxModel(new String[] {"Micro         Rs.9/Km", "Mini         Rs.11/Km", "Premium   Rs.13/Km", "Sedan         Rs.15/Km"}));
		ttype.setBounds(510, 194, 142, 27);
		panel_1.add(ttype);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Choose start Date");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_2.setBounds(10, 201, 142, 27);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(25, 25, 112), null, null));
		calendar.setBounds(154, 201, 198, 153);
		panel_1.add(calendar);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Enter Pick-Up Location");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_3.setBounds(10, 378, 198, 33);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		pickloc = new JTextField();
		pickloc.setBounds(203, 382, 476, 28);
		panel_1.add(pickloc);
		pickloc.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Entr Destination Location");
		lblNewJgoodiesLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_4.setBounds(10, 439, 215, 33);
		panel_1.add(lblNewJgoodiesLabel_4);
		
		droploc = new JTextField();
		droploc.setBounds(235, 443, 476, 28);
		panel_1.add(droploc);
		droploc.setColumns(10);
		
		JButton btnNewButton = new JButton("Reset");
		Image img1 = new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid.setText("");
				pickloc.setText("");
				droploc.setText("");
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton.setBounds(22, 517, 142, 41);
		panel_1.add(btnNewButton);
		
		
		
		JButton btnSubmit = new JButton("Submit");
		Image img2 = new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(img2));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dregister frame =new dregister();
			String uid = userid.getText();
			String pl = pickloc.getText();
			String dl = droploc.getText();
			SimpleDateFormat sd = new SimpleDateFormat();
			String type = ttype.getSelectedItem().toString();
			
			if(uid.length()==0)
			{ JOptionPane.showMessageDialog(frame, "Please Enter User_ID");			
			}
			if(pl.length()==0)
			{ JOptionPane.showMessageDialog(frame, "Please Enter Pick-Up Location");
			}
			if(dl.length()==0)
			{ JOptionPane.showMessageDialog(frame, "Please Enter Destination Location");	
			}
			else {
				try {
					PreparedStatement pst;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","");
					/*pst=con.prepareStatement("Insert into trip_details(user_id,start_date,taxi_type,startloc,destloc)values(?,?,?,?,?)");
					pst.setString(1, uid);
					pst.setLong(2, sd);
					pst.setString(3,type);
					pst.executeUpdate();
					Statement stm = con.createStatement();
					String sql= "Select * from driver where Name ='"+name+"' and Contact_no ='"+cont+"'";
					ResultSet rs = stm.executeQuery(sql);
					JOptionPane.showMessageDialog(frame,"Trip Successfully registered");
					rs.next();
					JOptionPane.showMessageDialog(frame,"Trip_ID is "+rs.getString(1));*/
					userid.setText("");
					pickloc.setText("");
					droploc.setText("");
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
		btnSubmit.setBounds(294, 517, 142, 41);
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
		btnBack.setBounds(569, 517, 142, 41);
		panel_1.add(btnBack);

		

	}
}
