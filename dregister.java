package swing;

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
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class dregister extends JFrame {

	private JPanel contentPane;
	private JTextField dname;
	private JTextField dcontno;
	private JTextField daddr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dregister frame = new dregister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;

	/**
	 * Create the frame.
	 */
	public dregister() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(107, 142, 35), new Color(220, 20, 60), new Color(0, 191, 255), null));
		panel.setBounds(10, 11, 657, 81);
		panel.setBackground(new Color(218, 112, 214));
		contentPane.add(panel);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("NEW DRIVER REGISTRATION");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(173, 255, 47), new Color(65, 105, 225), null, null));
		panel_1.setBounds(10, 103, 657, 423);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Driver Name");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_1.setBounds(30, 29, 161, 41);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		dname = new JTextField();
		dname.setBounds(228, 36, 239, 33);
		panel_1.add(dname);
		dname.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Contact Number\r\n");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_2.setBounds(30, 105, 199, 41);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		dcontno = new JTextField();
		dcontno.setBounds(228, 108, 259, 41);
		panel_1.add(dcontno);
		dcontno.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Enter Address");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_3.setBounds(30, 200, 161, 41);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		daddr = new JTextField();
		daddr.setBounds(201, 189, 302, 69);
		panel_1.add(daddr);
		daddr.setColumns(10);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dname.setText("");
				dcontno.setText("");
				daddr.setText("");
			}
			
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnNewButton.setBounds(47, 322, 114, 42);
		panel_1.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dregister frame =new dregister();
				if(dname.getText().length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Driver name");			
				}
				if(dcontno.getText().length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Contact number");
				}
				if(daddr.getText().length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Address");	
				}
				else {
					try {
						String name = dname.getText();
						String cont = dcontno.getText();
						String addr = daddr.getText();
						
						Class.forName("com.mysql.jdbc.Driver");
						con= DriverManager.getConnection("jdbc:mysql://localhost/cabbooking","root","");
						pst = con.prepareStatement("Inser into driver (Name,Contact_no,Address)values(?,?,?)");
						pst.setString(1, name);
						pst.setString(2, cont);
						pst.setString(3, addr);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(frame,"User Created Successfully");
						dname.setText("");
						dcontno.setText("");
						daddr.setText("");
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
		btnSubmit.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnSubmit.setBounds(241, 322, 114, 42);
		panel_1.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				dlogin d = new dlogin();
				d.show();
			}
		});
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnBack.setBounds(458, 322, 114, 42);
		panel_1.add(btnBack);
		
	}
}
