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

import javax.swing.border.BevelBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ownerhome extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ownerhome frame = new ownerhome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ownerhome() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.MAGENTA, Color.YELLOW, null, null));
		panel.setBounds(10, 11, 511, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("OWNER HOME PAGE");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 31));
		lblNewJgoodiesLabel.setBounds(96, 24, 310, 45);
		panel.add(lblNewJgoodiesLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.RED, Color.DARK_GRAY, null, null));
		panel_1.setBounds(10, 102, 511, 319);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnUnregisterAnExisting = new JButton("Unregister An Existing Taxi");
		btnUnregisterAnExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				unreg ur = new unreg();
				ur.show();
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/close-icon.png")).getImage();
		 btnUnregisterAnExisting.setIcon(new ImageIcon(img1));
		btnUnregisterAnExisting.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnUnregisterAnExisting.setBounds(74, 163, 358, 60);
		panel_1.add(btnUnregisterAnExisting);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home h = new Home();
				h.show();
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		 btnLogout.setIcon(new ImageIcon(img2));
		btnLogout.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnLogout.setBounds(335, 260, 154, 48);
		panel_1.add(btnLogout);
		
		JButton btnNewButton_1_1 = new JButton("Register A New Taxi");
		Image img = new ImageIcon(this.getClass().getResource("/owner-icon.png")).getImage();
		btnNewButton_1_1.setIcon(new ImageIcon(img));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				oregister o = new oregister();
				o.show();
			}
		});
		btnNewButton_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(74, 37, 358, 60);
		panel_1.add(btnNewButton_1_1);
		
		JLabel bg = DefaultComponentFactory.getInstance().createLabel("");
		bg.setBounds(121, 11, 248, 297);
		Image img3 = new ImageIcon(this.getClass().getResource("/car-icon.png")).getImage();
		bg.setIcon(new ImageIcon(img3));
		panel_1.add(bg);
	}
}
