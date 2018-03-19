import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.util.Date;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class backgrount extends JDialog {
	private JTextField textField;
	private JTextField counter;
	static Statement myStmt;
	

	/**
	 * Create the dialog.
	 */
	public backgrount() {
		
		
		setResizable(false);
		getContentPane().setBackground(Color.ORANGE);
		setUndecorated(true);
		setBounds(0,0, 1366, 768);
		
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs polling","root","");
			myStmt = myConn.createStatement();
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		JLabel lblAcountingSystem = new JLabel("IIIT VOTING E.V.M.");
		lblAcountingSystem.setForeground(Color.RED);
		lblAcountingSystem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 29));
		
		JLabel lblAllYouNeed = new JLabel("all you need");
		lblAllYouNeed.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 22));
		
		JLabel lblCreatedByShivendra = new JLabel("created by shivendra & shubham");
		lblCreatedByShivendra.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		Date date=new Date();
		textField.setText(date.toString());
		textField.setBackground(Color.PINK);
		textField.setEditable(false);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("see result(ADMIN)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {                      // result button
		String pass=JOptionPane.showInputDialog("ENTER PASSWORD");
				if(pass.equals("screenpoda")){
					result m = new result();
					m.setVisible(true);
				}
				else{
				    JOptionPane.showMessageDialog(null, "ACCESS DENIED");
				}
				
			}
		});
		
		JButton btnCloseApplication = new JButton("CLOSE APPLICATION");
		btnCloseApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			System.exit(ABORT);
			}
		});
		btnCloseApplication.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCloseApplication.setBackground(Color.RED);
		
		JLabel lblInstuctionFirst = new JLabel("INSTRUCTION : FIRST VOTING HAVE MORE PRIORITY");
		lblInstuctionFirst.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		counter = new JTextField();
		counter.setFont(new Font("Tahoma", Font.BOLD, 21));
		counter.setColumns(10);
		int num=0;
		try {
			ResultSet myRs = myStmt.executeQuery("select * from `sports` ");
			while(myRs.next()){
				num = myRs.getInt("votes")+ num;
			}
        }
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int vo = num/2;
		
		String vot = String.valueOf(vo);
		
		counter.setText(vot);
		
		JLabel lblVoteCounter = new JLabel("VOTE COUNTER");
		lblVoteCounter.setFont(new Font("Sitka Small", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(903, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAcountingSystem)
							.addGap(204))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAllYouNeed)
							.addGap(165))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCreatedByShivendra))
							.addGap(139))))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
					.addGap(644)
					.addComponent(btnCloseApplication, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(887, Short.MAX_VALUE)
					.addComponent(lblInstuctionFirst, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(885, Short.MAX_VALUE)
					.addComponent(lblVoteCounter)
					.addGap(62)
					.addComponent(counter, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(124))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCloseApplication, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(lblAcountingSystem)
					.addGap(31)
					.addComponent(lblAllYouNeed)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(counter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVoteCounter, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(123)
					.addComponent(lblInstuctionFirst)
					.addPreferredGap(ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
					.addComponent(lblCreatedByShivendra)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		getContentPane().setLayout(groupLayout);
	}
}
