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

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class unreg extends JFrame {

	private JPanel contentPane;
	private JTextField ownid;
	private JTextField taxid;
	private JTextField contno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					unreg frame = new unreg();
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
	public unreg() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(25, 25, 112), null, null));
		panel.setBackground(new Color(255, 127, 80));
		panel.setBounds(10, 11, 545, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("TAXI UNREGISTRATION PAGE");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 31));
		lblNewJgoodiesLabel.setBounds(64, 22, 433, 39);
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 235, 215));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(139, 0, 0), new Color(220, 20, 60), null, null));
		panel_1.setBounds(10, 97, 545, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Owner_Name\r\n");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_1.setBounds(23, 22, 192, 42);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Taxi_ID");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_2.setBounds(23, 105, 155, 42);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Enter Contact Number");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_3.setBounds(23, 192, 203, 42);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		ownid = new JTextField();
		ownid.setBounds(225, 25, 203, 42);
		panel_1.add(ownid);
		ownid.setColumns(10);
		
		taxid = new JTextField();
		taxid.setColumns(10);
		taxid.setBounds(188, 105, 203, 42);
		panel_1.add(taxid);
		
		contno = new JTextField();
		contno.setColumns(10);
		contno.setBounds(216, 195, 228, 42);
		panel_1.add(contno);
		
		JButton btnSubmit_1 = new JButton("Reset");
		Image img = new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnSubmit_1.setIcon(new ImageIcon(img));
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ownid.setText("");
				taxid.setText("");
				contno.setText("");
			}
		});
		btnSubmit_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnSubmit_1.setBounds(10, 275, 142, 41);
		panel_1.add(btnSubmit_1);
		
		JButton btnSubmit_1_1 = new JButton("Submit");
		btnSubmit_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unreg frame= new unreg();
				String oid=ownid.getText();
				String tid =taxid.getText();
				String cno =contno.getText();
				if(oid.length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter User_Name");			
				}
				if(tid.length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Taxi_ID");
				}
				if(cno.length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Contact Number");
				}
				
				else {
					try {
				PreparedStatement pst;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","");
				Statement stm = con.createStatement();
				String sql= "SELECT * from taxi where own_name ='"+oid+"' and Taxi_id='"+tid+"' and own_contno='"+cno+"'";
				ResultSet rs = stm.executeQuery(sql);
				if(rs.next())
				{	String sql1= "SELECT taxi_id from trip_details where taxi_id='"+tid+"'";
					ResultSet rs1 = stm.executeQuery(sql1);
					if(rs1.next())
					{JOptionPane.showMessageDialog(null,"Taxi has been Booked for a Trip","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					else {
					pst=con.prepareStatement("Delete from taxi where Taxi_id=? and own_name =? and own_contno=?");
					pst.setString(1, tid);
					pst.setString(2, oid);
					pst.setString(3,cno);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(frame,"You are unregistering the taxi","WARNING",JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(frame,"Taxi Unregistered Successfully");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Owner Name,Contact Number and Taxi_Id are not matching","ERROR",JOptionPane.ERROR_MESSAGE);
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
		btnSubmit_1_1.setIcon(new ImageIcon(img1));
		btnSubmit_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnSubmit_1_1.setBounds(209, 275, 142, 41);
		panel_1.add(btnSubmit_1_1);
		
		JButton btnSubmit_1_2 = new JButton("Back");
		btnSubmit_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ownerhome u = new ownerhome();
				u.show();
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnSubmit_1_2.setIcon(new ImageIcon(img2));
		btnSubmit_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnSubmit_1_2.setBounds(393, 275, 142, 41);
		panel_1.add(btnSubmit_1_2);
		
		JLabel bg = DefaultComponentFactory.getInstance().createLabel("");
		bg.setBounds(145, 36, 260, 280);
		panel_1.add(bg);
		Image img3 = new ImageIcon(this.getClass().getResource("/nocar-icon.jpg")).getImage();
		bg.setIcon(new ImageIcon(img3));
	}
}
