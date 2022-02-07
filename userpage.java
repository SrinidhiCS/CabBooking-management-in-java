package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class userpage extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userpage frame = new userpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public userpage() {
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBounds(10, 11, 509, 74);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("USER HOME PAGE");
		lblNewJgoodiesLabel.setBackground(new Color(255, 69, 0));
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 32));
		lblNewJgoodiesLabel.setBounds(101, 11, 305, 46);
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 94, 509, 432);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel BGROUND = DefaultComponentFactory.getInstance().createLabel("");
		BGROUND.setBounds(0, 0, 509, 432);
		panel_1.add(BGROUND);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 565, 83);
		panel_2.setBackground(new Color(255, 69, 0));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("USER HOME PAGE");
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 35));
		lblNewJgoodiesLabel_1.setBounds(135, 11, 320, 61);
		panel_2.add(lblNewJgoodiesLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 0, 0), new Color(60, 179, 113), null, null));
		panel_3.setBounds(10, 117, 565, 386);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home h = new Home();
				h.show();
			}
		});
		btnNewButton_3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		Image img4 = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(img4));
		btnNewButton_3.setBounds(402, 308, 132, 55);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Book a New Trip");
		Image img = new ImageIcon(this.getClass().getResource("/map-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				utrip t= new utrip();
				t.show();
				}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton.setBounds(147, 11, 251, 55);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Bill details");
		Image img1 = new ImageIcon(this.getClass().getResource("/Purse-icon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ubill ub = new ubill();
				ub.show();
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton_1.setBounds(147, 90, 251, 55);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Give Feedback");
		Image img3 = new ImageIcon(this.getClass().getResource("/rating-icon.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img3));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				fback fb = new fback();
				fb.show();
			}
		});
		
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton_2.setBounds(147, 242, 251, 55);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Cancel A Trip");
		Image img5 = new ImageIcon(this.getClass().getResource("/close-icon.png")).getImage();
		btnNewButton_2_1.setIcon(new ImageIcon(img5));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				dispose();
				tcancel tc = new tcancel();
				tc.show();
			}
		});
		btnNewButton_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton_2_1.setBounds(147, 167, 251, 55);
		panel_3.add(btnNewButton_2_1);
		
		
		JLabel bg = DefaultComponentFactory.getInstance().createLabel("");
		bg.setBounds(-82, 0, 663, 383);
		panel_3.add(bg);
		Image img2 = new ImageIcon(this.getClass().getResource("/customer-icon.png")).getImage();
		bg.setIcon(new ImageIcon(img2));

	}
}
