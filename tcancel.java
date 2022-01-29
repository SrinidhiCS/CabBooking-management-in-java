package swing;

import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class tcancel extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JTextField tripid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tcancel frame = new tcancel();
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
	Connection con;
	
	public tcancel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.RED, Color.BLACK, null, null));
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 11, 501, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("TRIP CANCELLATION");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 33));
		lblNewJgoodiesLabel.setBounds(93, 22, 336, 37);
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.CYAN, null, null));
		panel_1.setBounds(10, 92, 501, 383);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter User_ID");
		lblNewJgoodiesLabel_1.setBounds(10, 25, 137, 39);
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		panel_1.add(lblNewJgoodiesLabel_1);
		
		JDateChooser dc = new JDateChooser();
		dc.setBounds(153, 175, 137, 33);
		panel_1.add(dc);
		
		userid = new JTextField();
		userid.setBounds(146, 25, 176, 39);
		panel_1.add(userid);
		userid.setColumns(10);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBounds(17, 275, 130, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid.setText("");
				tripid.setText("");
			}
		});
		Image d=new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(d));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		panel_1.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(192, 275, 130, 41);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tcancel frame= new tcancel();
				String uid=userid.getText();
				String tid =tripid.getText();
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

				if(uid.length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter User_ID");			
				}
				if(dc.getDate()==null)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Date");
				}
				if(tid.length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Trip_ID");
				}
				else {
					try {
						String sd = date.format(dc.getDate());
						PreparedStatement pst;
						Class.forName("com.mysql.jdbc.Driver");
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","");
						Statement stm = con.createStatement();
						String sql= "SELECT * from trip_details where user_id ='"+uid+"' and trip_id='"+tid+"' and start_date='"+sd+"'";
						ResultSet rs = stm.executeQuery(sql);
						if(rs.next())
						{
							pst=con.prepareStatement("Delete from trip_details where trip_id=? and user_id =? and start_date=?");
							pst.setString(1, tid);
							pst.setString(2, uid);
							pst.setString(3,sd);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(frame,"Trip Cancelled Successfully");
						}
						else {
							JOptionPane.showMessageDialog(null,"User_ID and Trip_Id are not matching","ERROR",JOptionPane.ERROR_MESSAGE);
							}
					}
						catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			}
		});
		Image s=new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(s));
		btnSubmit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		panel_1.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(368, 275, 123, 41);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				userpage u = new userpage();
				u.show();
			}
		});
		Image b=new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(b));
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		panel_1.add(btnBack);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Trip_ID");
		lblNewJgoodiesLabel_2.setBounds(10, 93, 137, 41);
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		panel_1.add(lblNewJgoodiesLabel_2);
		
		tripid = new JTextField();
		tripid.setBounds(130, 96, 176, 39);
		panel_1.add(tripid);
		tripid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Enter Start Date");
		lblNewJgoodiesLabel_3.setBounds(10, 175, 152, 33);
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		panel_1.add(lblNewJgoodiesLabel_3);
		
		JLabel bg = DefaultComponentFactory.getInstance().createLabel("");
		bg.setBounds(120, 11, 333, 340);
		panel_1.add(bg);
		Image img5 = new ImageIcon(this.getClass().getResource("/nocar-icon.jpg")).getImage();
		bg.setIcon(new ImageIcon(img5));
		
		
	}
}
