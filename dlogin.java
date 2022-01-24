package swing;

import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlogin extends JFrame {

	private JPanel contentPane;
	private JTextField driverid;
	private JTextField dcontno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dlogin frame = new dlogin();
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
	public dlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 560, 68);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(205, 92, 92), new Color(139, 0, 0), null, null));
		panel.setForeground(new Color(255, 0, 0));
		panel.setBackground(new Color(0, 128, 128));
		contentPane.add(panel);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("DRIVER LOGIN");
		lblNewJgoodiesLabel.setForeground(new Color(255, 69, 0));
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 35));
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(220, 20, 60));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(65, 105, 225), new Color(139, 0, 0), null, null));
		panel_1.setBounds(10, 90, 540, 344);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_1.setBounds(22, 26, 135, 37);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Driver_ID");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewJgoodiesLabel_2.setBounds(22, 26, 135, 34);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		driverid = new JTextField();
		driverid.setBounds(167, 27, 232, 36);
		panel_1.add(driverid);
		driverid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Enter Contact no");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNewJgoodiesLabel_3.setBounds(22, 101, 135, 42);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		dcontno = new JTextField();
		dcontno.setBounds(173, 106, 232, 37);
		panel_1.add(dcontno);
		dcontno.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String did = driverid.getText();
				String dno = dcontno.getText();
				Connection con; //= DriverManager.getConnection(url,usernameofdatabase,password);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con =  DriverManager.getConnection("jdbc:mysql://localhost/cabbooking","root","");
					Statement stm = con.createStatement();
					String sql= "Select * from driver where driver_id ="+did+" and contact_no "+dno+";";
					ResultSet rs = stm.executeQuery(sql);
					 if (rs.next())
					 {
						 dispose();
						 userpage u = new userpage();
						 u.setVisible(true);
					 }
					 else
					 { JOptionPane.showConfirmDialog(btnNewButton, "Driver_ID or Contact_No is wrong");
					 driverid.setText("");
					 dcontno.setText("");
					 }
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(89, 189, 114, 37);
		panel_1.add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("WANT TO REGISTER AS A DRIVER?");
		lblNewJgoodiesLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_4.setBounds(22, 276, 290, 37);
		panel_1.add(lblNewJgoodiesLabel_4);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(343, 281, 120, 33);
		panel_1.add(btnNewButton_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				driverid.setText("");
			    dcontno.setText("");
				
			}
		});
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnReset.setBounds(310, 189, 114, 37);
		panel_1.add(btnReset);
	}
}
