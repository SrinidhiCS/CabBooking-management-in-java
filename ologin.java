package swing;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 598);
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
		panel_1.setBounds(10, 104, 496, 444);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Owner_Name");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_1.setBounds(23, 30, 179, 39);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		ownid = new JTextField();
		ownid.setBounds(277, 32, 172, 39);
		panel_1.add(ownid);
		ownid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Taxi_ID");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewJgoodiesLabel_2.setBounds(23, 108, 260, 31);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		taxiid = new JTextField();
		taxiid.setBounds(293, 106, 156, 39);
		panel_1.add(taxiid);
		taxiid.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		Image d=new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(d));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oname = ownid.getText();
				String tid = taxiid.getText();
				Connection con; //= DriverManager.getConnection(url,usernameofdatabase,password);
				PreparedStatement insert;
				try {
					 ologin frame = new ologin();
					if(oname.length()==0)
					{ JOptionPane.showMessageDialog(frame, "Please Enter Owner_Name");			
					}
					if(tid.length()==0)
					{ JOptionPane.showMessageDialog(frame, "Please Enter Taxi_ID");
					}
					else{
						Class.forName("com.mysql.jdbc.Driver");
						con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","");
						Statement stm = con.createStatement();
						String sql = "select * from taxi where own_name = '"+oname+"' and Taxi_id = '"+tid+"'";
						ResultSet rs = stm.executeQuery(sql);
						if (rs.next())
						{
							dispose();
							ownerhome u = new ownerhome();
							u.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Owner_Name or Taxi_ID is wrong","ERROR", JOptionPane.ERROR_MESSAGE);
							ownid.setText("");
							taxiid.setText("");
						}
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
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton.setBounds(84, 188, 141, 39);
		panel_1.add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("DO YOU WANT TO REGISTER YOUR CAR AS A TAXI?");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewJgoodiesLabel_3.setBounds(10, 270, 381, 39);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		JButton btnNewButton_1 = new JButton("Register");
		Image r=new ImageIcon(this.getClass().getResource("/Transport-Driver-icon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(r));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				oregister or = new oregister();
				or.show();
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_1.setBounds(201, 308, 172, 49);
		panel_1.add(btnNewButton_1);
		
		JButton btnReset = new JButton("Reset");
		Image re=new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnReset.setIcon(new ImageIcon(re));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ownid.setText("");
			taxiid.setText("");
			}
		});
		btnReset.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnReset.setBounds(277, 188, 141, 39);
		panel_1.add(btnReset);
		
		JButton btnNewButton_2 = new JButton("Back");
		Image b=new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(b));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
				}
		});
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton_2.setBounds(211, 378, 122, 40);
		panel_1.add(btnNewButton_2);
	}
}
