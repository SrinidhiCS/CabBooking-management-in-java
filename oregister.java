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
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class oregister extends JFrame {

	private JPanel contentPane;
	private JTextField oname;
	private JTextField regno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					oregister frame = new oregister();
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
	public oregister() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 538, 75);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(75, 0, 130), new Color(255, 0, 0), null, null));
		panel.setBackground(new Color(102, 205, 170));
		contentPane.add(panel);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("NEW OWNER REGISTRATION");
		lblNewJgoodiesLabel.setBackground(new Color(102, 205, 170));
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 32));
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 0, 0), new Color(138, 43, 226), null, null));
		panel_1.setBounds(10, 97, 538, 351);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Owner Name");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_1.setBounds(10, 11, 169, 38);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		oname = new JTextField();
		oname.setBounds(204, 17, 233, 32);
		panel_1.add(oname);
		oname.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Car registration Number");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_2.setBounds(10, 82, 265, 38);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		regno = new JTextField();
		regno.setBounds(296, 82, 162, 38);
		panel_1.add(regno);
		regno.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Enter Taxi Type");
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_3.setBounds(10, 155, 169, 38);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		JComboBox Type = new JComboBox();
		Type.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		Type.setModel(new DefaultComboBoxModel(new String[] {"Micro", "Mini", "Premium", "Sedan"}));
		Type.setToolTipText("");
		Type.setBounds(231, 151, 102, 38);
		panel_1.add(Type);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oname.setText("");
				regno.setText("");
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnNewButton.setBounds(24, 237, 114, 42);
		panel_1.add(btnNewButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dregister frame =new dregister();
				if(oname.getText().length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Owner name");			
				}
				if(regno.getText().length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Registration number");
				}
				else {
					try {
						String name = oname.getText();
						String rno = regno.getText();
						String model = Type.getSelectedItem().toString();
						
						Class.forName("com.mysql.jdbc.Driver");
						con= DriverManager.getConnection("jdbc:mysql://localhost/cabbooking","root","");
						pst = con.prepareStatement("Inser into taxi (own_name,Type,Reg_no)values(?,?,?)");
						pst.setString(1, name);
						pst.setString(2, model);
						pst.setString(3, rno);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(frame,"Taxi Registered Successfully");
						oname.setText("");
						regno.setText("");
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
		btnSubmit.setBounds(205, 237, 114, 42);
		panel_1.add(btnSubmit);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			ologin o = new ologin();
			o.show();
			}
		});
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		btnNewButton_2.setBounds(385, 237, 114, 42);
		panel_1.add(btnNewButton_2);
	}
}
