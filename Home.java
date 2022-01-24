package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class Home extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 484, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setForeground(new Color(255, 99, 71));
		panel.setBounds(0, 0, 468, 87);
		frame.getContentPane().add(panel);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Welcome To our\r\n Cab Service ");
		lblNewJgoodiesLabel.setForeground(new Color(255, 69, 0));
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblNewJgoodiesLabel);
		
		JButton btnNewButton = new JButton("USER");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ulogin u = new ulogin();
				u.setVisible(true);
			}
		});
		btnNewButton.setBounds(163, 153, 121, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DRIVER");
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				dlogin d = new dlogin();
				d.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(163, 253, 121, 46);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("OWNER");
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ologin o = new ologin();
				o.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(163, 355, 121, 46);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 169, 169));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(139, 69, 19), new Color(34, 139, 34), null, null));
		panel_1.setBounds(10, 99, 448, 372);
		frame.getContentPane().add(panel_1);
	}
}
