import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.Color;

public class result extends JFrame {

	JPanel contentPane;
	private JTextField sports1;
	private JTextField sports2;
	private JTextField cultural1;
	private JTextField cultural2;
	private JTextField social1;
	private JTextField social2;
	private JTextField coding1;
	private JTextField coding2;
	static Statement myStmt;
	ResultSet myRs;
	String[] nam = new String[50];
	int i = 1;
	
	
	public result() {
		
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubs polling","root","");
			myStmt = myConn.createStatement();
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("Results       IIIT Kottayam Clubs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Sports Club");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		
		JLabel lblCulturalClub = new JLabel("Cultural Club");
		lblCulturalClub.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		
		JLabel lblSocialClub = new JLabel("Social Club");
		lblSocialClub.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		
		JLabel lblCodingClub = new JLabel("Coding Club");
		lblCodingClub.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		
		sports1 = new JTextField();
		sports1.setForeground(Color.WHITE);
		sports1.setBackground(Color.BLACK);
		sports1.setEditable(false);
		sports1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		sports1.setColumns(10);
		
		sports2 = new JTextField();
		sports2.setForeground(Color.WHITE);
		sports2.setBackground(Color.BLACK);
		sports2.setEditable(false);
		sports2.setFont(new Font("Sitka Small", Font.BOLD, 13));
		sports2.setColumns(10);
		
		cultural1 = new JTextField();
		cultural1.setForeground(Color.WHITE);
		cultural1.setBackground(Color.BLACK);
		cultural1.setEditable(false);
		cultural1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		cultural1.setColumns(10);
		
		cultural2 = new JTextField();
		cultural2.setForeground(Color.WHITE);
		cultural2.setBackground(Color.BLACK);
		cultural2.setEditable(false);
		cultural2.setFont(new Font("Sitka Small", Font.BOLD, 13));
		cultural2.setColumns(10);
		
		social1 = new JTextField();
		social1.setForeground(Color.WHITE);
		social1.setBackground(Color.BLACK);
		social1.setEditable(false);
		social1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		social1.setColumns(10);
		
		social2 = new JTextField();
		social2.setForeground(Color.WHITE);
		social2.setBackground(Color.BLACK);
		social2.setEditable(false);
		social2.setFont(new Font("Sitka Small", Font.BOLD, 13));
		social2.setColumns(10);
		
		coding1 = new JTextField();
		coding1.setForeground(Color.WHITE);
		coding1.setBackground(Color.BLACK);
		coding1.setEditable(false);
		coding1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		coding1.setColumns(10);
		
		coding2 = new JTextField();
		coding2.setForeground(Color.WHITE);
		coding2.setBackground(Color.BLACK);
		coding2.setEditable(false);
		coding2.setFont(new Font("Sitka Small", Font.BOLD, 13));
		coding2.setColumns(10);
		
		
		try {
			myRs = myStmt.executeQuery("select `name` from `sports` order by `points` desc ");
			while(myRs.next()){
				nam[i] = myRs.getString("name");
				i++;
			}
			sports1.setText(nam[1].toUpperCase());
			sports2.setText(nam[2].toUpperCase());
			
        }
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		i=1;

		try {
			myRs = myStmt.executeQuery("select `name` from `cultural` order by `points` desc ");
			while(myRs.next()){
				nam[i] = myRs.getString("name");
				i++;
			}
			cultural1.setText(nam[1].toUpperCase());
			cultural2.setText(nam[2].toUpperCase());
			
        }
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		i=1;
		
		try {
			myRs = myStmt.executeQuery("select `name` from `social` order by `points` desc ");
			while(myRs.next()){
				nam[i] = myRs.getString("name");
				i++;
			}
			social1.setText(nam[1].toUpperCase());
			social2.setText(nam[2].toUpperCase());
			
        }
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		i=1;

		try {
			myRs = myStmt.executeQuery("select `name` from `coding` order by `points` desc ");
			while(myRs.next()){
				nam[i] = myRs.getString("name");
				i++;
			}
			coding1.setText(nam[1].toUpperCase());
			coding2.setText(nam[2].toUpperCase());
			
        }
        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCulturalClub)
							.addContainerGap(406, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSocialClub)
							.addContainerGap(420, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(sports1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
								.addComponent(sports2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
								.addComponent(social2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
								.addComponent(social1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
								.addComponent(cultural1, Alignment.LEADING, 291, 291, Short.MAX_VALUE)
								.addComponent(cultural2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(171)))
							.addGap(197))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCodingClub)
									.addPreferredGap(ComponentPlacement.RELATED, 217, GroupLayout.PREFERRED_SIZE))
								.addComponent(coding1)
								.addComponent(coding2))
							.addGap(43))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addComponent(sports1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(sports2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCulturalClub)
					.addGap(18)
					.addComponent(cultural1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cultural2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSocialClub)
					.addGap(18)
					.addComponent(social1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(social2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCodingClub)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(coding1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(coding2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
