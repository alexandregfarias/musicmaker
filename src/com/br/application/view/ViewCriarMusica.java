package com.br.application.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.br.application.external_api.SunoApiService;

import javax.swing.JRadioButton;

public class ViewCriarMusica {

	private JFrame frame;
	private JTextField textPrompt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCriarMusica window = new ViewCriarMusica();
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
	public ViewCriarMusica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JRadioButton rdbtnInstrumental = new JRadioButton("Apenas Instrumental");
		rdbtnInstrumental.setSelected(true);
		rdbtnInstrumental.setBounds(10, 63, 193, 23);
		frame.getContentPane().add(rdbtnInstrumental);

		JButton btnCriarMusica = new JButton("Criar Música");
		btnCriarMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(rdbtnInstrumental.isSelected());
				SunoApiService.generateMusic(textPrompt.getText(), rdbtnInstrumental.isSelected());
			}
		});
		btnCriarMusica.setBounds(10, 93, 414, 23);
		frame.getContentPane().add(btnCriarMusica);

		JLabel lblDescricaoMusica = new JLabel("Descrição da Música:");
		lblDescricaoMusica.setBounds(10, 11, 180, 14);
		frame.getContentPane().add(lblDescricaoMusica);

		textPrompt = new JTextField();
		textPrompt.setBounds(10, 36, 414, 20);
		frame.getContentPane().add(textPrompt);
		textPrompt.setColumns(10);

	}
}
