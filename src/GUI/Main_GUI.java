package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_GUI frame = new Main_GUI();
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
	public Main_GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJokuKlasikoak = new JLabel("JOKU KLASIKOAK");
		lblJokuKlasikoak.setFont(new Font("Zapfino", Font.PLAIN, 20));
		lblJokuKlasikoak.setBounds(55, 6, 343, 55);
		contentPane.add(lblJokuKlasikoak);
		
		JLabel lblSortzaileak = new JLabel("Bingen Ros, Goizane Alonso, Ander Uribarri, Galder Villa");
		lblSortzaileak.setBounds(42, 52, 356, 16);
		contentPane.add(lblSortzaileak);
		
		JButton btnSudoku = new JButton("Sudoku");
		btnSudoku.setBounds(51, 191, 117, 29);
		contentPane.add(btnSudoku);
		btnSudoku.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnBuscaminas = new JButton("Buscaminas");
		btnBuscaminas.setBounds(281, 191, 117, 29);
		contentPane.add(btnBuscaminas);
		btnBuscaminas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel lblAukeraketa = new JLabel("Aukeratu Bat:");
		lblAukeraketa.setBounds(180, 151, 94, 16);
		contentPane.add(lblAukeraketa);
	}
}
