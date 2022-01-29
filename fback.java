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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class fback extends JFrame {

	private JPanel contentPane;
	private JTextField trid;
	private JTextField usid;
	private JTextField fback;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fback frame = new fback();
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
	
	public fback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.ORANGE, null, null));
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 11, 631, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("USER FEEDBACK PAGE");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 31));
		lblNewJgoodiesLabel.setBounds(133, 23, 371, 43);
		panel.add(lblNewJgoodiesLabel);
		
		JPanel bg = new JPanel();
		bg.setBounds(10, 110, 631, 421);
		contentPane.add(bg);
		bg.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Trip_ID");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_1.setBounds(62, 8, 131, 37);
		bg.add(lblNewJgoodiesLabel_1);
		
		trid = new JTextField();
		trid.setBounds(39, 56, 183, 37);
		bg.add(trid);
		trid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter User_ID");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_2.setBounds(428, 11, 120, 31);
		bg.add(lblNewJgoodiesLabel_2);
		
		usid = new JTextField();
		usid.setBounds(408, 56, 173, 36);
		bg.add(usid);
		usid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Enter Rating");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_3.setBounds(27, 118, 120, 37);
		bg.add(lblNewJgoodiesLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "4", "3", "2", "1", "0"}));
		comboBox.setBounds(145, 120, 71, 37);
		bg.add(comboBox);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Enter Your Feedback");
		lblNewJgoodiesLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_4.setBounds(27, 216, 183, 37);
		bg.add(lblNewJgoodiesLabel_4);
		
		fback = new JTextField();
		fback.setBounds(220, 168, 389, 165);
		bg.add(fback);
		fback.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		Image img = new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnReset.setIcon(new ImageIcon(img));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usid.setText("");
				trid.setText("");
				fback.setText("");
				
			}
		});
		btnReset.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnReset.setBounds(27, 347, 156, 47);
		bg.add(btnReset);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fback frame = new fback();
				String uid=usid.getText();
				String tid=trid.getText();
				String fb=fback.getText();
				String ra= comboBox.getSelectedItem().toString();
				int rating = Integer.parseInt(ra);
				if(uid.length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter User_ID");			
				}
				if(tid.length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Trip_ID");
				}
				else{
				try{
					PreparedStatement pst;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","");
					Statement stm = con.createStatement();
					String sql1= "Select user_id from trip_details where trip_id ='"+tid+"'";
					ResultSet rs1 = stm.executeQuery(sql1);
					if(rs1.next())
					{	pst=con.prepareStatement("Insert into feedback(trip_id,rating,message)values(?,?,?)");
						pst.setString(1, tid);
						pst.setInt(2, rating);
						pst.setString(3,fb);
						pst.executeUpdate();
						String sql= "Select * from feedback where trip_id ='"+tid+"'and message ='"+fb+"'";
						ResultSet rs = stm.executeQuery(sql);
						rs.next();
						JOptionPane.showMessageDialog(frame,"Thank you for your Feedback!!");
						JOptionPane.showMessageDialog(frame,"Feedback_ID is "+rs.getInt(1));
						usid.setText("");
						trid.setText("");
						fback.setText("");
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
		Image img1 = new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton_1.setBounds(244, 344, 156, 47);
		bg.add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		Image img2 = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				userpage dp = new userpage();
				dp.show();
			}
		});
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnBack.setBounds(453, 347, 156, 47);
		bg.add(btnBack);
		
		JLabel bground = DefaultComponentFactory.getInstance().createLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/feedback-icon.jpg")).getImage();
		bground.setIcon(new ImageIcon(img3));
		bground.setBounds(-37, 0, 668, 421);
		bg.add(bground);
		
		
	}
}
