package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DB;
import model.dao.impl.ClienteDaoImplementacao;
import model.dao.impl.UsuarioDaoImplementacao;
import model.entities.Cliente;
import model.entities.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class TelaCadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldSenha;
	private JTextField textFieldLogin;
	private JTextField textFieldEmail;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setTitle("Central do Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelID = new JLabel("ID:");
		labelID.setBounds(10, 63, 48, 14);
		contentPane.add(labelID);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 88, 48, 14);
		contentPane.add(labelNome);
		
		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(10, 119, 48, 14);
		contentPane.add(labelTelefone);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(174, 60, 48, 14);
		contentPane.add(labelEmail);
		
		JLabel labelLogin = new JLabel("Login:");
		labelLogin.setBounds(174, 88, 48, 14);
		contentPane.add(labelLogin);
		
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setBounds(174, 119, 48, 14);
		contentPane.add(labelSenha);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(68, 57, 96, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(68, 82, 96, 20);
		contentPane.add(textFieldNome);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(68, 113, 96, 20);
		contentPane.add(textFieldTelefone);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(218, 119, 96, 20);
		contentPane.add(textFieldSenha);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setColumns(10);
		textFieldLogin.setBounds(218, 88, 96, 20);
		contentPane.add(textFieldLogin);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(218, 57, 96, 20);
		contentPane.add(textFieldEmail);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int b = 0;

				b = Integer.parseInt(textFieldID.getText());
				
				Connection conn = DB.getConnection();
				ClienteDaoImplementacao clienteImp = new ClienteDaoImplementacao(conn);
				
			Cliente cli = new Cliente(b, textFieldNome.getText(), textFieldTelefone.getText(), textFieldEmail.getText(), textFieldLogin.getText(), textFieldSenha.getText());
				//textFieldNome.getText(), textFieldTelefone.getText(), textFieldEmail.getText(), textFieldLogin.getText(), textFieldSenha.getText()
				
			//	int b = 0;

				b = Integer.parseInt(textFieldID.getText());
				
				System.out.println();
				
			
				
				
				clienteImp.insert(cli);
				//Usuario userr = usuarioImp.findById(30);
				//System.out.println(userr);
			}
		});
		botaoCadastrar.setBounds(387, 26, 114, 39);
		contentPane.add(botaoCadastrar);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setBounds(10, 22, 48, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Atualizar Senha");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idConvertido = 0;

				idConvertido = Integer.parseInt(textFieldID.getText());
				
				Connection conn = DB.getConnection();
				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
				
				Cliente cli = clienteimp.findById(idConvertido);
				cli.setSenha(textFieldSenha.getText());
				
				clienteimp.update(cli);
				
			}
		});
		btnNewButton.setBounds(387, 76, 114, 39);
		contentPane.add(btnNewButton);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idConvertido = 0;

				idConvertido = Integer.parseInt(textFieldID.getText());
				
				Connection conn = DB.getConnection();
				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
				clienteimp.deleteById(idConvertido);
			}
		});
		btnDeletar.setBounds(385, 126, 114, 39);
		contentPane.add(btnDeletar);
		
		JButton btnListar = new JButton("Listar Todos");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = DB.getConnection();
				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
				System.out.println(	clienteimp.findAll());
			}
		});
		btnListar.setBounds(387, 224, 114, 39);
		contentPane.add(btnListar);
		
		table = new JTable();
		table.setBounds(10, 327, 579, 180);
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("S\u00F3 \u00E9 poss\u00EDvel alterar a senha.");
		lblNewLabel_1.setBounds(10, 186, 261, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ALTERAR SENHA: Informe o ID e SENHA e clique em Atualizar");
		lblNewLabel_2.setBounds(10, 211, 353, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblParaDeletarInforme = new JLabel("DELETAR: informe apenas o ID e clique Deletar");
		lblParaDeletarInforme.setBounds(10, 249, 304, 14);
		contentPane.add(lblParaDeletarInforme);
		
		JLabel lblNewLabel_3 = new JLabel("BUSCAR: Informe o ID e clique em Buscar");
		lblNewLabel_3.setBounds(10, 162, 304, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idConvertido = 0;

				idConvertido = Integer.parseInt(textFieldID.getText());
				Connection conn = DB.getConnection();
				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
				
				Cliente cli = clienteimp.findById(idConvertido);
				System.out.println(cli);
			}
		});
		btnBuscar.setBounds(387, 174, 114, 39);
		contentPane.add(btnBuscar);
		setSize(628, 576);
		setLocationRelativeTo(null);
	}
}
