package swing;

import java.sql.*;
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
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class dtrip extends JFrame {

	private JPanel contentPane;
	private JTextField driverid;
	private JTable table;
	private JTextField dcontno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dtrip frame = new dtrip();
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
	Connection con;
	
	MouseEvent e1;
	public dtrip() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 675, 79);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(218, 165, 32), new Color(220, 20, 60), null, null));
		panel.setBackground(new Color(0, 128, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("DRIVER TRIP DETAILS");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 31));
		lblNewJgoodiesLabel.setBounds(194, 27, 319, 41);
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(106, 90, 205), new Color(128, 0, 128), null, null));
		panel_1.setBounds(10, 101, 679, 536);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Enter Driver_ID ");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewJgoodiesLabel_1.setBounds(42, 135, 163, 39);
		panel_1.add(lblNewJgoodiesLabel_1);
		
		driverid = new JTextField();
		driverid.setBounds(202, 138, 180, 39);
		panel_1.add(driverid);
		driverid.setColumns(10);
		JButton btnNewButton = new JButton("Submit");
		Image s=new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(s));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				String did=driverid.getText();
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
						if (rs.next())
						{	String sql1 = "Select * from trip_details where driver_id='"+did+"'";
							PreparedStatement pst = con.prepareStatement(sql1);
							ResultSet rs1 = pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs1)); 
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Driver_ID or Contact_No is wrong","ERROR",JOptionPane.ERROR_MESSAGE);
							driverid.setText("");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 288, 624, 226);
		panel_1.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cabbooking","root","");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try{
					dtrip frame = new dtrip();
				    Statement stm = con.createStatement();
				    int row= table.getSelectedRow();
				    String uid= table.getModel().getValueAt(row, 1).toString();
				    String sql2= "SELECT * from user where user_id ='"+uid+"'";
				    ResultSet rs2 = stm.executeQuery(sql2);
				    rs2.next();
				    String uname =rs2.getString(2);
				    String cno = rs2.getString(3);
				    JOptionPane.showMessageDialog(frame,"User Name is :'"+uname+"'"+"\n Contact number:'"+cno+"'");
				     con.close();
			} 
				catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
				
		});
		scrollPane.setViewportView(table);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(139, 69, 19), null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Trip_id", "Strat_date", "Taxi_type", "Start_loc", "Dest_loc", "Taxi_id","Driver_id", "User_Name"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton.setBounds(292, 243, 138, 34);
		panel_1.add(btnNewButton);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Enter Contact Number");
		lblNewJgoodiesLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewJgoodiesLabel_2.setBounds(42, 190, 193, 34);
		panel_1.add(lblNewJgoodiesLabel_2);
		
		dcontno = new JTextField();
		dcontno.setBounds(245, 193, 218, 39);
		panel_1.add(dcontno);
		dcontno.setColumns(10);
		
		JLabel bg = DefaultComponentFactory.getInstance().createLabel("");
		bg.setBounds(290, 0, 157, 139);
		panel_1.add(bg);
		Image img = new ImageIcon(this.getClass().getResource("/maps-icon.png")).getImage();
		bg.setIcon(new ImageIcon(img));
		
		JButton btnReset = new JButton("Reset");
		Image img1 = new ImageIcon(this.getClass().getResource("/clear-icon.png")).getImage();
		btnReset.setIcon(new ImageIcon(img1));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				driverid.setText("");
				dcontno.setText("");
				
			}
		});
		btnReset.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnReset.setBounds(67, 243, 138, 34);
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
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnBack.setBounds(496, 243, 138, 34);
		panel_1.add(btnBack);
	

	
	}
}
