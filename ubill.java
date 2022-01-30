package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ubill extends JFrame {

	private JPanel contentPane;
	private JTextField usid;
	private JTextField trid;
	private JTextField amt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ubill frame = new ubill();
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
	PreparedStatement pst;
	Connection con;
	private JTextField price;
	private JTextField disttra;
	private JTextField billno;
	
	public ubill() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(139, 0, 0), new Color(255, 0, 0), null, null));
		panel.setBackground(new Color(128, 128, 0));
		panel.setBounds(10, 11, 624, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("USER BILL DETAILS");
		lblNewJgoodiesTitle.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 32));
		lblNewJgoodiesTitle.setBounds(176, 11, 301, 53);
		panel.add(lblNewJgoodiesTitle);
		
		JLabel bp = DefaultComponentFactory.getInstance().createLabel("");
		bp.setBounds(106, 11, 60, 53);
		panel.add(bp);
		Image img6 = new ImageIcon(this.getClass().getResource("/bill-icon.png")).getImage();
		bp.setIcon(new ImageIcon(img6));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(165, 42, 42), new Color(255, 69, 0), null, null));
		panel_1.setBounds(10, 97, 624, 493);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/bill-icon.jpg")).getImage();
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Enter User_ID");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel.setBounds(22, 11, 124, 38);
		panel_1.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Trip_ID");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_1.setBounds(30, 76, 116, 38);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Amount Payable");
		lblNewJgoodiesLabel_2.setForeground(Color.RED);
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_2.setBounds(30, 408, 148, 38);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		usid = new JTextField();
		usid.setBounds(164, 13, 148, 38);
		panel_1.add(usid);
		usid.setColumns(10);
		
		trid = new JTextField();
		trid.setBounds(163, 78, 162, 38);
		panel_1.add(trid);
		trid.setColumns(10);
		
		amt = new JTextField();
		amt.setEditable(false);
		amt.setBounds(188, 410, 137, 38);
		panel_1.add(amt);
		amt.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usid.setText("");
				trid.setText("");
				amt.setText("");
				billno.setText("");
				price.setText("");
				disttra.setText("");
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnReset.setIcon(new ImageIcon(img3));
		btnReset.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnReset.setBounds(27, 139, 142, 41);
		panel_1.add(btnReset);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ubill frame = new ubill();
				String uid=usid.getText();
				String tid=trid.getText();
				if(uid.length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter User_ID");			
				}
				if(tid.length()==0)
				{ JOptionPane.showMessageDialog(frame, "Please Enter Trip_ID");
				}
				else{
				try{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","");
					Statement stm = con.createStatement();
					String sql1= "Select * from trip_details where trip_id ='"+tid+"'";
					ResultSet rs1 = stm.executeQuery(sql1);
					
					if(rs1.next()&&uid.equals(rs1.getString(2)))
					{
						String sql = "Select * from bill_details where trip_id='"+tid+"'";
						PreparedStatement pst = con.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						rs.next();
						amt.setText("Rs."+rs.getString(4));
						price.setText(rs1.getString(4));
						disttra.setText(rs.getString(3)+"Kms");
						billno.setText(rs.getString(1));
					} 
					else {
						JOptionPane.showMessageDialog(null,"User_ID or Trip_ID is wrong","ERROR",JOptionPane.ERROR_MESSAGE);
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
		btnSubmit_1.setIcon(new ImageIcon(img1));
		btnSubmit_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnSubmit_1.setBounds(240, 139, 142, 41);
		panel_1.add(btnSubmit_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				userpage u = new userpage();
				u.show();
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnBack.setBounds(450, 139, 142, 41);
		panel_1.add(btnBack);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Bill Number");
		lblNewJgoodiesLabel_3.setForeground(Color.RED);
		lblNewJgoodiesLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_3.setBounds(34, 223, 124, 38);
		panel_1.add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Distance Traveled");
		lblNewJgoodiesLabel_4.setForeground(Color.RED);
		lblNewJgoodiesLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_4.setBounds(30, 285, 162, 41);
		panel_1.add(lblNewJgoodiesLabel_4);
		
		JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("Taxi Type");
		lblNewJgoodiesLabel_5.setForeground(Color.RED);
		lblNewJgoodiesLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_5.setBounds(30, 339, 124, 47);
		panel_1.add(lblNewJgoodiesLabel_5);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(188, 345, 186, 38);
		panel_1.add(price);
		
		disttra = new JTextField();
		disttra.setEditable(false);
		disttra.setColumns(10);
		disttra.setBounds(188, 285, 137, 38);
		panel_1.add(disttra);
		
		billno = new JTextField();
		billno.setEditable(false);
		billno.setColumns(10);
		billno.setBounds(188, 225, 137, 38);
		panel_1.add(billno);
		
		JLabel bg = DefaultComponentFactory.getInstance().createLabel("");
		bg.setBounds(452, 223, 162, 249);
		panel_1.add(bg);
		Image img5 = new ImageIcon(this.getClass().getResource("/invoice-icon.png")).getImage();
		bg.setIcon(new ImageIcon(img5));
	}
}
