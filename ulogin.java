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

public class ulogin extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JTextField ucontno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ulogin frame = new ulogin();
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
	public ulogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 11, 515, 80);
		contentPane.add(panel);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("USER LOGIN");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewJgoodiesLabel.setForeground(new Color(255, 69, 0));
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(139, 69, 19), new Color(0, 0, 0), null, null));
		panel_1.setBounds(10, 108, 515, 339);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter User_ID");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNewJgoodiesLabel_1.setBounds(20, 39, 122, 29);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		userid = new JTextField();
		userid.setBounds(152, 36, 185, 38);
		panel_1.add(userid);
		userid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Contact No");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNewJgoodiesLabel_2.setBounds(20, 114, 132, 22);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		ucontno = new JTextField();
		ucontno.setBounds(162, 108, 186, 38);
		panel_1.add(ucontno);
		ucontno.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		Image s=new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(s));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid = userid.getText();
				String uno = ucontno.getText();
				Connection con; //= DriverManager.getConnection(url,usernameofdatabase,password)
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con =  DriverManager.getConnection("jdbc:mysql://localhost/cabbooking","root","");
					Statement stm = con.createStatement();
					String sql= "Select * from user where user_id ='"+uid+"' and contact_no '"+uno+"'";
					ResultSet rs = stm.executeQuery(sql);
					 if (rs.next())
					 {
						 dispose();
						 userpage u = new userpage();
						 u.setVisible(true);
					 }
					 else
					 {ulogin frame = new ulogin();
					 JOptionPane.showConfirmDialog(frame, "User_ID or Contact_No is wrong");
					 userid.setText("");
					 ucontno.setText("");
					 }
				con.close();
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
		btnNewButton.setBounds(108, 168, 132, 38);
		panel_1.add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("ARE YOU A NEW USER ?");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_3.setBounds(20, 239, 195, 38);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		JButton btnNewButton_1 = new JButton("Register");
		Image d=new ImageIcon(this.getClass().getResource("/user-icon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(d));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				uregister ur = new uregister();
				ur.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton_1.setBounds(225, 226, 163, 57);
		panel_1.add(btnNewButton_1);
		
		JButton btnReset = new JButton("Reset");
		Image r=new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnReset.setIcon(new ImageIcon(r));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid.setText("");
				ucontno.setText("");
				
			}
		});
		btnReset.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnReset.setBounds(288, 168, 122, 38);
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
		btnNewButton_2.setBounds(383, 288, 122, 40);
		panel_1.add(btnNewButton_2);
	}
}
