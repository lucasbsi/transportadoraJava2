package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DB;
import model.dao.impl.UsuarioDaoImplementacao;
import model.entities.Usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		setTitle("Cadastro de Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 594, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelID = new JLabel("Id:");
		labelID.setBounds(84, 158, 48, 14);
		contentPane.add(labelID);
		
		JLabel labelLogin = new JLabel("Login:");
		labelLogin.setBounds(84, 205, 48, 14);
		contentPane.add(labelLogin);
		
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setBounds(84, 259, 48, 14);
		contentPane.add(labelSenha);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(158, 155, 96, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setColumns(10);
		textFieldLogin.setBounds(158, 202, 96, 20);
		contentPane.add(textFieldLogin);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(158, 256, 96, 20);
		contentPane.add(textFieldSenha);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = DB.getConnection();
				UsuarioDaoImplementacao usuarioImp = new UsuarioDaoImplementacao(conn);
				//Integer id = textFieldID.getText();
				String login;
				String senha;
				
				
			//	Usuario usu = new Usuario(30,"noe","anta");// não usar 0 a esquerda
				Usuario usu = new Usuario(12,textFieldLogin.getText(),textFieldSenha.getText());// não usar 0 a esquerda
				
				usuarioImp.insert(usu);
				Usuario userr = usuarioImp.findById(30);
				System.out.println(userr);
			}
		});
		botaoCadastrar.setBounds(158, 308, 89, 23);
		contentPane.add(botaoCadastrar);
		setLocationRelativeTo(null);
		setSize(411, 436);
		
		
	}
}
