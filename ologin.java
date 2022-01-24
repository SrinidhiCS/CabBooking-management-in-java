package swing;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ologin extends JFrame {

	private JPanel contentPane;
	private JTextField ownid;
	private JTextField taxiid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ologin frame = new ologin();
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
	public ologin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 496, 82);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(123, 104, 238), null, null));
		panel.setBackground(new Color(255, 105, 180));
		panel.setForeground(new Color(128, 128, 0));
		contentPane.add(panel);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("OWNER LOGIN ");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewJgoodiesLabel.setForeground(new Color(128, 128, 0));
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(119, 136, 153), new Color(244, 164, 96), null, null));
		panel_1.setBounds(10, 104, 496, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Owner_ID");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_1.setBounds(23, 30, 131, 39);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		ownid = new JTextField();
		ownid.setBounds(186, 30, 172, 39);
		panel_1.add(ownid);
		ownid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Taxi_ID");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewJgoodiesLabel_2.setBounds(34, 108, 131, 31);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		taxiid = new JTextField();
		taxiid.setBounds(162, 106, 156, 39);
		panel_1.add(taxiid);
		taxiid.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oid = ownid.getText();
				String tid = taxiid.getText();
				Connection con; //= DriverManager.getConnection(url,usernameofdatabase,password);
				PreparedStatement insert;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con =  DriverManager.getConnection("jdbc:mysql://localhost/cabbooking","root","");
					Statement stm = con.createStatement();
					String s = "select * from owners where ownerID = "+oid+" and taxiid = "+tid;
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton.setBounds(84, 188, 114, 39);
		panel_1.add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("DO YOU WANT TO REGISTER YOUR CAR AS A TAXI?");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewJgoodiesLabel_3.setBounds(10, 270, 381, 39);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_1.setBounds(186, 334, 117, 37);
		panel_1.add(btnNewButton_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ownid.setText("");
			taxiid.setText("");
			}
		});
		btnReset.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnReset.setBounds(277, 188, 114, 39);
		panel_1.add(btnReset);
	}
}
