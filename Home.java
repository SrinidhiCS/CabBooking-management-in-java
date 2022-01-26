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
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setBackground(new Color(0, 128, 128));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 748, 103);
		panel.setBackground(new Color(240, 128, 128));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(139, 69, 19), new Color(65, 105, 225), null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("  WELCOME TO OUR");
		lblNewJgoodiesLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 39));
		lblNewJgoodiesLabel.setBounds(166, 11, 394, 33);
		panel.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("CAB BOOKING SYSTEM");
		lblNewJgoodiesLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewJgoodiesLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 37));
		lblNewJgoodiesLabel_1.setBounds(176, 55, 394, 37);
		panel.add(lblNewJgoodiesLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(218, 112, 214), new Color(139, 0, 0), null, null));
		panel_1.setBackground(new Color(218, 165, 32));
		panel_1.setBounds(10, 135, 414, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("USER");
		Image u=new ImageIcon(this.getClass().getResource("/user-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(u));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 33));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ulogin u = new ulogin();
				u.setVisible(true);
			}
		});
		btnNewButton.setBounds(143, 25, 197, 57);
		panel_1.add(btnNewButton);
		
		JButton btnDriver = new JButton("DRIVER");
		Image d=new ImageIcon(this.getClass().getResource("/Transport-Driver-icon.png")).getImage();
		btnDriver.setIcon(new ImageIcon(d));
		btnDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {dispose();
			dlogin d = new dlogin();
			d.setVisible(true);
			}
		});
		btnDriver.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		btnDriver.setBounds(143, 114, 197, 57);
		panel_1.add(btnDriver);
		
		JButton btnOwner = new JButton("OWNER");
		Image o=new ImageIcon(this.getClass().getResource("/owner-icon.png")).getImage();
		btnOwner.setIcon(new ImageIcon(o));
		
		btnOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {dispose();
			ologin o = new ologin();
			o.setVisible(true);
			}
		});
		btnOwner.setBackground(new Color(240, 240, 240));
		btnOwner.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnOwner.setBounds(143, 197, 197, 63);
		panel_1.add(btnOwner);
		
		JButton btnCloser = new JButton("CLOSE");
		Image c = new ImageIcon(this.getClass().getResource("/Close-icon.png")).getImage();
		btnCloser.setIcon(new ImageIcon(c));
		btnCloser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCloser.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnCloser.setBackground(SystemColor.menu);
		btnCloser.setBounds(247, 280, 146, 57);
		panel_1.add(btnCloser);
		
		JLabel label = DefaultComponentFactory.getInstance().createLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/taxi-icon.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(468, 135, 290, 368);
		contentPane.add(label);
	}
}