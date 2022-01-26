package swing;

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
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class uregister extends JFrame {

	private JPanel contentPane;
	private JTextField uname;
	private JTextField ucontno;
	private JTextField uaddr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uregister frame = new uregister();
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
	public uregister() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(173, 255, 47), new Color(255, 0, 0), null, null));
		panel.setBackground(new Color(205, 133, 63));
		panel.setBounds(10, 11, 644, 81);
		contentPane.add(panel);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("NEW USER REGISTRATION");
		lblNewJgoodiesTitle.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 35));
		panel.add(lblNewJgoodiesTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(65, 105, 225), new Color(255, 99, 71), new Color(138, 43, 226), new Color(255, 105, 180)));
		panel_1.setBounds(10, 103, 644, 454);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Enter User Name");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel.setBounds(10, 33, 158, 42);
		panel_1.add(lblNewJgoodiesLabel);
		
		uname = new JTextField();
		uname.setBounds(210, 36, 263, 42);
		panel_1.add(uname);
		uname.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Contact Number");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_1.setBounds(10, 117, 181, 47);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		ucontno = new JTextField();
		ucontno.setBounds(234, 117, 263, 36);
		panel_1.add(ucontno);
		ucontno.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Address");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_2.setBounds(10, 236, 141, 42);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		uaddr = new JTextField();
		uaddr.setBounds(161, 214, 298, 93);
		panel_1.add(uaddr);
		uaddr.setColumns(10);
		
		JButton btnNewButton = new JButton("Reset");
		Image c=new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(c));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uname.setText("");
				ucontno.setText("");
				uaddr.setText("");
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnNewButton.setBounds(54, 347, 150, 42);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		Image s=new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(s));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uregister frame =new uregister();
				if(uname.getText().length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter User name");			
				}
				if(ucontno.getText().length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Contact number");
				}
				if(uaddr.getText().length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Address");	
				}
				else {
					try {
						String name = uname.getText();
						String cont = ucontno.getText();
						String addr = uaddr.getText();
						
						Class.forName("com.mysql.jdbc.Driver");
						con= DriverManager.getConnection("jdbc:mysql://localhost/cabbooking","root","");
						pst = con.prepareStatement("Inser into user (Name,Contact_no,Address)values(?,?,?)");
						pst.setString(1, name);
						pst.setString(2, cont);
						pst.setString(3, addr);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(frame,"User Created Successfully");
						uname.setText("");
						ucontno.setText("");
						uaddr.setText("");
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
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnNewButton_1.setBounds(259, 347, 158, 42);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		Image b=new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButton_1_1.setIcon(new ImageIcon(b));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ulogin u = new ulogin();
				u.show();
			}
		});
		btnNewButton_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnNewButton_1_1.setBounds(465, 347, 141, 42);
		panel_1.add(btnNewButton_1_1);
	}
}
