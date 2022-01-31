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

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class vfback extends JFrame {

	private JPanel contentPane;
	private JTextField drid;
	private JTextField dcontno;
	private JTable table;
	private JTextField rat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vfback frame = new vfback();
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
	public vfback() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.RED, Color.BLACK, null, null));
		panel.setBackground(new Color(123, 104, 238));
		panel.setBounds(10, 11, 599, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("VIEW DRIVER FEEDBACK");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 31));
		lblNewJgoodiesLabel.setBounds(111, 11, 359, 54);
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 98, 599, 438);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Driver_ID");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_1.setBounds(35, 26, 156, 48);
		panel_1.add(lblNewJgoodiesLabel_1);
		Image img = new ImageIcon(this.getClass().getResource("/feedback-icon.jpg")).getImage();
		
		drid = new JTextField();
		drid.setBounds(181, 33, 156, 32);
		panel_1.add(drid);
		drid.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Contact Number");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_2.setBounds(35, 85, 190, 32);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		dcontno = new JTextField();
		dcontno.setBounds(223, 76, 235, 37);
		panel_1.add(dcontno);
		dcontno.setColumns(10);
		
		
		JLabel rating = DefaultComponentFactory.getInstance().createLabel("Overall Rating");
		rating.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		rating.setBounds(45, 186, 126, 32);
		panel_1.add(rating);
		
		
		rat = new JTextField();
		rat.setBounds(181, 187, 93, 31);
		panel_1.add(rat);
		rat.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Submit");
		Image img1 = new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				String did=drid.getText();
				String dcno = dcontno.getText();
				try {
					dtrip frame = new dtrip();
					if(did.length()==0)
					{ JOptionPane.showMessageDialog(frame, "Please Enter Driver_ID");			
					}
					if(dcno.length()==0)
					{ JOptionPane.showMessageDialog(frame, "Please Enter Contact number");
					}
					
					else{
						Class.forName("com.mysql.jdbc.Driver");
					    con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","");
					    Statement stm = con.createStatement();
					    String sql= "SELECT * from driver where Driver_id ='"+did+"' and Contact_no='"+dcno+"'";
					    ResultSet rs = stm.executeQuery(sql);
					    if(rs.next())
					    { 	String sql1 = "Select f.feedback_id, t.driver_id,f.trip_id,f.rating,f.message from feedback f inner join trip_details t on f.trip_id = t.trip_id and f.trip_id in ( Select trip_id from trip_details where driver_id = '"+did+"')";
					    	PreparedStatement pst = con.prepareStatement(sql1);
					    	ResultSet rs1 = pst.executeQuery();
					    	table.setModel(DbUtils.resultSetToTableModel(rs1)); 
					    	String sql2 = "Select rating from driver where driver_id = '"+did+"'";
					    	PreparedStatement pst2 = con.prepareStatement(sql2);
					    	ResultSet rs2 = pst2.executeQuery();
					    	rs2.next();
					    	rat.setText(rs2.getString(1));
					    }
					    else
					    {
					    	JOptionPane.showMessageDialog(null, "Driver_ID or Contact_No is wrong","ERROR",JOptionPane.ERROR_MESSAGE);
					    	drid.setText("");
					    	dcontno.setText("");
					    }
				con.close();
				} 
				}catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton.setBounds(243, 129, 156, 47);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY, null, null));
		scrollPane.setBounds(10, 241, 579, 186);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Feedback_ID", "Trip_ID", "Rating", "Message"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnReset = new JButton("Reset");
		Image img3 = new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnReset.setIcon(new ImageIcon(img3));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drid.setText("");
				dcontno.setText("");
				rat.setText("");
			}
		});
		btnReset.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnReset.setBounds(35, 128, 156, 47);
		panel_1.add(btnReset);
		
		JButton btnBack = new JButton("Back");
		Image img2 = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				driverpage dp = new driverpage();
				dp.show();
			}
		});
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnBack.setBounds(433, 129, 156, 47);
		panel_1.add(btnBack);
		
		
		JLabel bg = DefaultComponentFactory.getInstance().createLabel("");
		bg.setBounds(-77, -32, 676, 438);
		panel_1.add(bg);
		bg.setIcon(new ImageIcon(img));
	
		
	}
}
