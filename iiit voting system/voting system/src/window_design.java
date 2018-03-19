import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class window_design extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup sports = new ButtonGroup();
	private final ButtonGroup cultural = new ButtonGroup();
	private final ButtonGroup social = new ButtonGroup();
	private final ButtonGroup coding = new ButtonGroup();
	static Statement myStmt;
	ResultSet myRs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window_design frame = new window_design();
					
					
					
					backgrount bg =new backgrount();
				    bg.setVisible(true);
					
				    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs polling","root","");
					myStmt = myConn.createStatement();
				    

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
	public window_design() {
		setTitle("Polling Portal         IIIT Kottayam, Clubs");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 714, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSportsClub = new JLabel("Sports club");
		lblSportsClub.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSportsClub.setBackground(Color.ORANGE);
		
		JLabel lblCulturalClub = new JLabel("Cultural club");
		lblCulturalClub.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblSocialClub = new JLabel("Social club");
		lblSocialClub.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblCodingClub = new JLabel("Coding club");
		lblCodingClub.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JSeparator separator = new JSeparator();
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		
		JButton btnNewButton = new JButton("Submit FULL VOTE");
		btnNewButton.addActionListener(new ActionListener() {       ////// action listner to submit
			public void actionPerformed(ActionEvent arg0) {
			if(sports.isSelected(null)|| cultural.isSelected(null)|| social.isSelected(null)|| coding.isSelected(null)){
				JOptionPane.showMessageDialog(null, "PLEASE VOTE FOR EACH CLUB");
				
			}
			else{
				String club1=sports.getSelection().getActionCommand();
				String club2=cultural.getSelection().getActionCommand();
		        String club3=social.getSelection().getActionCommand();
		        String club4=coding.getSelection().getActionCommand();

		        ///////////////////////////////////////
		    	//database;
		        ////////////////////////////////
		        
		        try {
					myStmt.executeUpdate("update `sports` set `votes`=`votes`+1 , `points`=`points`+2 where `name`='"+club1+"' ");
		        }
		        catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		        try {
					myStmt.executeUpdate("update `cultural` set `votes`=`votes`+1 , `points`=`points`+2 where `name`='"+club2+"' ");
		        }
		        catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		        try {
					myStmt.executeUpdate("update `social` set `votes`=`votes`+1 , `points`=`points`+2 where `name`='"+club3+"' ");
		        }
		        catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		        try {
					myStmt.executeUpdate("update `coding` set `votes`=`votes`+1 , `points`=`points`+2 where `name`='"+club4+"' ");
		        }
		        catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		 
				
				dispose();
				JOptionPane.showMessageDialog(null,"Full voting done !\n VOTE for SECOND priority");
				
			   halfvoting k= new halfvoting (club1,club2,club3,club4);
                     k.setVisible(true);
				
			}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSportsClub, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(lblCulturalClub)
					.addGap(75)
					.addComponent(lblSocialClub)
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(lblCodingClub, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblSportsClub, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCodingClub, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSocialClub)
								.addComponent(lblCulturalClub))))
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JRadioButton anil = new JRadioButton("Anil Kumar Yadav");
		sports.add(anil);
		
		anil.setActionCommand("anil");
		
		JRadioButton darla = new JRadioButton("Darla Prashanth");
		sports.add(darla);
		
		darla.setActionCommand("darla");
		
		JRadioButton harsh = new JRadioButton("Harsh Kumar Singh");
		sports.add(harsh);
		
		harsh.setActionCommand("harsh");
		
		
		JRadioButton jaswanth = new JRadioButton("K. Jaswanth Kr.");
		sports.add(jaswanth);
		
		jaswanth.setActionCommand("jaswanth");
		
		JRadioButton juhal = new JRadioButton("Juhal Siby");
		sports.add(juhal);
		
		juhal.setActionCommand("juhal");
		
		JRadioButton dinesh = new JRadioButton("M. Dinesh");
		sports.add(dinesh);
		
		dinesh.setActionCommand("dinesh");
		
		JRadioButton prem = new JRadioButton("V. Prem Kumar");
		sports.add(prem);
		
		prem.setActionCommand("prem");
		
		JRadioButton manik = new JRadioButton("A. V. Manikyala Rao");
		cultural.add(manik);
		
		manik.setActionCommand("manik");
		
		JRadioButton anuj = new JRadioButton("Anuj Bhatla");
		cultural.add(anuj);
		
		anuj.setActionCommand("anuj");
		
		JRadioButton pushpak = new JRadioButton("J. Pushpak");
		cultural.add(pushpak);
		
		pushpak.setActionCommand("pushpak");
		
		JRadioButton savio = new JRadioButton("Savio Jose");
		cultural.add(savio);
		
		savio.setActionCommand("savio");
		
		JRadioButton akash = new JRadioButton("T. Akash");
		cultural.add(akash);
		
		akash.setActionCommand("akash");
		
		JRadioButton ravi = new JRadioButton("B. Ravi Varma ");
		social.add(ravi);
		
		ravi.setActionCommand("ravi");
		
		JRadioButton anju = new JRadioButton("Anju Mary Peter");
		social.add(anju);
		
		anju.setActionCommand("anju");
		
		JRadioButton anand = new JRadioButton("Anand Bharath");
		social.add(anand);
		
		anand.setActionCommand("anand");
		
		JRadioButton shubh = new JRadioButton("Shubham Kumar");
		social.add(shubh);
		
		shubh.setActionCommand("shubham");
		
		JRadioButton sandeep = new JRadioButton("Sandeep Kumar");
		social.add(sandeep);
		
		sandeep.setActionCommand("sandeep");
		
		JRadioButton KSS = new JRadioButton("K. S. S. Varma");
		coding.add(KSS);
		
		KSS.setActionCommand("kss");
		
		JRadioButton sam = new JRadioButton("Shivendra Singh");
		coding.add(sam);
		
		sam.setActionCommand("sam");
		
		JRadioButton bhullu = new JRadioButton("Rajat Kumar");
		coding.add(bhullu);
		
		bhullu.setActionCommand("rajat");
		
		JRadioButton rahul = new JRadioButton("Shivshanker Pandey");
		cultural.add(rahul);
		
		rahul.setActionCommand("rahul");
		
		JRadioButton srija = new JRadioButton("Srija Asritha");
		cultural.add(srija);
		
		srija.setActionCommand("srija");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(anil)
						.addComponent(darla)
						.addComponent(harsh)
						.addComponent(jaswanth)
						.addComponent(juhal)
						.addComponent(dinesh)
						.addComponent(prem))
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(rahul)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(manik)
										.addComponent(anuj)
										.addComponent(pushpak)
										.addComponent(savio)
										.addComponent(akash))
									.addGap(33)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(ravi)
										.addComponent(anju)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(sandeep)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(anand)
												.addComponent(shubh))))))
							.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(KSS)
								.addComponent(sam)
								.addComponent(bhullu))
							.addGap(9))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(srija)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(17)
							.addComponent(anil)
							.addGap(13)
							.addComponent(darla)
							.addGap(15)
							.addComponent(harsh)
							.addGap(17)
							.addComponent(jaswanth)
							.addGap(17)
							.addComponent(juhal)
							.addGap(17)
							.addComponent(dinesh)
							.addGap(13)
							.addComponent(prem))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(17)
							.addComponent(manik)
							.addGap(13)
							.addComponent(anuj)
							.addGap(15)
							.addComponent(pushpak)
							.addGap(17)
							.addComponent(savio)
							.addGap(17)
							.addComponent(akash)
							.addGap(18)
							.addComponent(rahul)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(srija))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(ravi)
									.addGap(13)
									.addComponent(anju))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(KSS)
									.addGap(13)
									.addComponent(sam)
									.addGap(15)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(bhullu)
										.addComponent(shubh))))
							.addGap(18)
							.addComponent(anand)
							.addGap(16)
							.addComponent(sandeep)))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
