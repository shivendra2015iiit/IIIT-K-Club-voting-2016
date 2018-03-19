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
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class halfvoting extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup sports = new ButtonGroup();
	private final ButtonGroup cultural = new ButtonGroup();
	private final ButtonGroup social = new ButtonGroup();
	private final ButtonGroup coding = new ButtonGroup();
	static Statement myStmt;
	
	
	/**
	 * Create the frame.
	 */
	public halfvoting(String c1,String c2, String c3, String c4) {
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs polling","root","");
			myStmt = myConn.createStatement();
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("Polling Portal         IIIT Kottayam, Clubs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnNewButton = new JButton("Submit HALF VOTE");
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
				
				try {
					myStmt.executeUpdate("update `sports` set `votes`=`votes`+1 , `points`=`points`+1 where `name`='"+club1+"' ");
		        }
		        catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				        try {
							myStmt.executeUpdate("update `cultural` set `votes`=`votes`+1 , `points`=`points`+1 where `name`='"+club2+"' ");
				        }
				        catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				        try {
							myStmt.executeUpdate("update `social` set `votes`=`votes`+1 , `points`=`points`+1 where `name`='"+club3+"' ");
				        }
				        catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				        try {
							myStmt.executeUpdate("update `coding` set `votes`=`votes`+1 , `points`=`points`+1 where `name`='"+club4+"' ");
				        }
				        catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				
				dispose();
				try {
					 Toolkit.getDefaultToolkit().beep();
					Thread.sleep(2000);
					 Toolkit.getDefaultToolkit().beep();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    
			    
			     
			     
				JOptionPane.showMessageDialog(null, "THANKS FOR YOUR VOTES");
				
				window_design.main(null);
				
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
					.addGap(99)
					.addComponent(lblSocialClub)
					.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
					.addComponent(lblCodingClub, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
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
								.addComponent(lblCulturalClub)
								.addComponent(lblSocialClub))))
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JRadioButton anil = new JRadioButton("Anil Kumar Yadav");
		sports.add(anil);
		
		anil.setActionCommand("anil");
		
		if(c1.equals(anil.getActionCommand())){anil.setEnabled(false);}
		
		JRadioButton darla = new JRadioButton("Darla Prashanth");
		sports.add(darla);
		
		darla.setActionCommand("darla");
		
		if(c1.equals(darla.getActionCommand())){darla.setEnabled(false);}
		
		JRadioButton harsh = new JRadioButton("Harsh Kumar Singh");
		
		sports.add(harsh);
		
		harsh.setActionCommand("harsh");
		
		if(c1.equals(harsh.getActionCommand())){harsh.setEnabled(false);}
		
		JRadioButton jaswanth = new JRadioButton("K. Jaswanth Kr.");
		sports.add(jaswanth);
		
		jaswanth.setActionCommand("jaswanth");
		
		if(c1.equals(jaswanth.getActionCommand())){jaswanth.setEnabled(false);}
		
		JRadioButton juhal = new JRadioButton("Juhal Siby");
		sports.add(juhal);
		
		juhal.setActionCommand("juhal");
		
		if(c1.equals(juhal.getActionCommand())){juhal.setEnabled(false);}
		
		JRadioButton dinesh = new JRadioButton("M. Dinesh");
		sports.add(dinesh);
		
		dinesh.setActionCommand("dinesh");
		if(c1.equals(dinesh.getActionCommand())){dinesh.setEnabled(false);}
		
		JRadioButton prem = new JRadioButton("V. Prem Kumar");
		sports.add(prem);
		
		prem.setActionCommand("prem");
		if(c1.equals(prem.getActionCommand())){prem.setEnabled(false);}
		
		JRadioButton manik = new JRadioButton("A. V. Manikyala Rao");
		cultural.add(manik);
		
		manik.setActionCommand("manik");
		
		if(c2.equals(manik.getActionCommand())){manik.setEnabled(false);}
		
		JRadioButton anuj = new JRadioButton("Anuj Bhatla");
		cultural.add(anuj);
		
		anuj.setActionCommand("anuj");
		
		if(c2.equals(anuj.getActionCommand())){anuj.setEnabled(false);}
		
		JRadioButton pushpak = new JRadioButton("J. Pushpak");
		cultural.add(pushpak);
		
		pushpak.setActionCommand("pushpak");
		
		if(c2.equals(pushpak.getActionCommand())){pushpak.setEnabled(false);}
		
		JRadioButton savio = new JRadioButton("Savio Jose");
		cultural.add(savio);
		
		savio.setActionCommand("savio");
		
		if(c2.equals(savio.getActionCommand())){savio.setEnabled(false);}
		
		JRadioButton akash = new JRadioButton("T. Akash");
		cultural.add(akash);
		
		akash.setActionCommand("akash");
		
		if(c2.equals(akash.getActionCommand())){akash.setEnabled(false);}
		
		JRadioButton ravi = new JRadioButton("B. Ravi Varma ");
		social.add(ravi);
		
		ravi.setActionCommand("ravi");
		
		if(c3.equals(ravi.getActionCommand())){ravi.setEnabled(false);}
		
		JRadioButton anju = new JRadioButton("Anju Mary Peter");
		social.add(anju);
		
		anju.setActionCommand("anju");
		
		if(c3.equals(anju.getActionCommand())){anju.setEnabled(false);}
		
		JRadioButton anand = new JRadioButton("Anand Bharath");
		social.add(anand);
		
		anand.setActionCommand("anand");
		
		if(c3.equals(anand.getActionCommand())){anand.setEnabled(false);}
		
		JRadioButton shubh = new JRadioButton("Shubham Kumar");
		social.add(shubh);
		
		shubh.setActionCommand("shubham");
		
		if(c3.equals(shubh.getActionCommand())){shubh.setEnabled(false);}
		
		JRadioButton sandeep = new JRadioButton("Sandeep Kumar");
		social.add(sandeep);
		
		sandeep.setActionCommand("sandeep");
		if(c3.equals(sandeep.getActionCommand())){sandeep.setEnabled(false);}
		
		JRadioButton KSS = new JRadioButton("K. S. S. Varma");
		coding.add(KSS);
		
		KSS.setActionCommand("kss");
		
		if(c4.equals(KSS.getActionCommand())){KSS.setEnabled(false);}
		
		JRadioButton sam = new JRadioButton("Shivendra Singh");
		coding.add(sam);
		
		sam.setActionCommand("sam");
		
		if(c4.equals(sam.getActionCommand())){sam.setEnabled(false);}
		
		JRadioButton bhullu = new JRadioButton("Rajat Kumar");
		coding.add(bhullu);
		
		bhullu.setActionCommand("rajat");
		
		if(c4.equals(bhullu.getActionCommand())){bhullu.setEnabled(false);}
		
		JRadioButton rahul = new JRadioButton("Shivshanker Pandey");
		cultural.add(rahul);
		
		rahul.setActionCommand("rahul");
		
		if(c2.equals(rahul.getActionCommand())){rahul.setEnabled(false);}
		
		JRadioButton srija = new JRadioButton("Srija Asritha");
		cultural.add(srija);
		
		srija.setActionCommand("srija");
		
		if(c2.equals(srija.getActionCommand())){srija.setEnabled(false);}
	
		
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
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(manik)
								.addComponent(anuj)
								.addComponent(pushpak)
								.addComponent(savio)
								.addComponent(akash))
							.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(ravi)
								.addComponent(anju)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(sandeep)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(anand)
										.addComponent(shubh))))
							.addGap(60)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(KSS)
								.addComponent(sam)
								.addComponent(bhullu))
							.addGap(9))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(rahul)
							.addContainerGap(362, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(srija)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
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
							.addGap(19)
							.addComponent(KSS)
							.addGap(13)
							.addComponent(sam)
							.addGap(15)
							.addComponent(bhullu))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(ravi)
											.addGap(13)
											.addComponent(anju))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(74)
											.addComponent(shubh)))
									.addGap(18)
									.addComponent(anand)
									.addGap(16)
									.addComponent(sandeep))
								.addGroup(gl_panel.createSequentialGroup()
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
									.addGap(18)
									.addComponent(srija)))))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}

