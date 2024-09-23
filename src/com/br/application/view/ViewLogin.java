package com.br.application.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.br.application.database.dao.UsuarioDAO;

public class ViewLogin {

	private JFrame frame;
	private JTextField txtLogin;
	private JButton btnEntrar;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
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
	public ViewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 224, 234);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(10, 36, 188, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 78, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkLogin(txtLogin.getText(), new String(txtSenha.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema.");					
					ViewCriarMusica.main(null);					
					frame.dispose();					
				} else {
					JOptionPane.showMessageDialog(null, "Dados inválidos.");
				}
			}
		});
		btnEntrar.setBounds(60, 161, 89, 23);
		frame.getContentPane().add(btnEntrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(10, 103, 188, 20);
		frame.getContentPane().add(txtSenha);
	}
	
	public boolean checkLogin(String login, String senha) {
		 UsuarioDAO usuarioDAO = new UsuarioDAO();
		 return usuarioDAO.checkLogin(login, senha);
	}
	
	public static void exibirTelaDeLogin() {
		ViewLogin.main(null);
	}
}