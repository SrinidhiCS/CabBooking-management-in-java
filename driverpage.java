package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class driverpage extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					driverpage frame = new driverpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public driverpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(50, 205, 50), new Color(65, 105, 225), null, null));
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 11, 567, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("DRIVER LOGIN PAGE");
		lblNewJgoodiesLabel.setBackground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 32));
		lblNewJgoodiesLabel.setBounds(131, 11, 320, 43);
		panel.add(lblNewJgoodiesLabel);
		Image img = new ImageIcon(this.getClass().getResource("/driver-icon.jpg")).getImage();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(139, 0, 0), new Color(255, 0, 0), null, null));
		panel_1.setBounds(10, 87, 567, 427);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("VIEW TRIP DETAILS");
		Image img1 = new ImageIcon(this.getClass().getResource("/Map-icon.png")).getImage();
		 btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				dtrip dt = new dtrip();
				dt.show();
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton.setBounds(147, 67, 305, 66);
		panel_1.add(btnNewButton);
		
		JButton btnViewFeedback = new JButton("VIEW FEEDBACK");
		btnViewFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				vfback vf= new vfback();
				vf.show();
			}
			
		});
		btnViewFeedback.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		Image img2 = new ImageIcon(this.getClass().getResource("/rating-icon.png")).getImage();
		btnViewFeedback.setIcon(new ImageIcon(img2));
		btnViewFeedback.setBounds(147, 208, 305, 66);
		panel_1.add(btnViewFeedback);
		
		JButton btnNewButton_1 = new JButton("Logout");
		Image img3 = new ImageIcon(this.getClass().getResource("/back-icon.pNg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img3));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home h= new Home();
				h.show();
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnNewButton_1.setBounds(373, 326, 163, 50);
		panel_1.add(btnNewButton_1);
		
		JLabel bground = DefaultComponentFactory.getInstance().createLabel("");
		bground.setBounds(10, 0, 547, 416);
		panel_1.add(bground);
		bground.setIcon(new ImageIcon(img));
	}
}
