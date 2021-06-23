package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DB;
import model.dao.impl.FuncionarioDaoImplementacao;
import model.dao.impl.UsuarioDaoImplementacao;
import model.entities.Cargo;
import model.entities.Funcionario;
import model.entities.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TelaCadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldSenha;
	private JTextField textFieldLogin;
	private JTextField textFieldEmail;
	private JTable table;
	static DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		setTitle("Central do Funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(387, 26, 114, 39);
		
		contentPane.setLayout(null);
		contentPane.add(botaoCadastrar);
		
		JButton btnNewButton = new JButton("Atualizar Senha");
		btnNewButton.setBounds(387, 76, 114, 39);

		contentPane.add(btnNewButton);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(385, 126, 114, 39);
		contentPane.add(btnDeletar);
		
		JButton btnListar = new JButton("Listar Todos");
		btnListar.setBounds(387, 224, 114, 39);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 331, 579, 180);
		contentPane.add(scrollPane);
		//------------------------------table--------------
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		modelo.addColumn("Id_funcionario");
		modelo.addColumn("Nome");
		modelo.addColumn("Telfone");
		modelo.addColumn("Email");
		modelo.addColumn("Login");
		modelo.addColumn("Senha");
	//	TelaCadastroFuncionario.loadTable();
		
		
		
		//--------------------------------------------
		JLabel lblNewLabel_1 = new JLabel("S\u00F3 \u00E9 poss\u00EDvel alterar a senha.");
		lblNewLabel_1.setBounds(10, 225, 261, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ALTERAR SENHA: Informe o ID e SENHA e clique em Atualizar");
		lblNewLabel_2.setBounds(10, 250, 353, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblParaDeletarInforme = new JLabel("DELETAR: informe apenas o ID e clique Deletar");
		lblParaDeletarInforme.setBounds(10, 288, 304, 14);
		contentPane.add(lblParaDeletarInforme);
		
		JLabel lblNewLabel_3 = new JLabel("BUSCAR: Informe o ID e clique em Buscar");
		lblNewLabel_3.setBounds(10, 201, 304, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(387, 174, 114, 39);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idConvertido = 0;

				idConvertido = Integer.parseInt(textFieldID.getText());
				Connection conn = DB.getConnection();
				FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
				
				Funcionario fun = funcionarioimp.findById(idConvertido);
				System.out.println(fun);
			}
		});
		contentPane.add(btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 346, 150);
		panel.setBorder(new TitledBorder(null, "Cadastrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelID = new JLabel("ID:");
		labelID.setBounds(10, 36, 48, 14);
		panel.add(labelID);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 61, 48, 14);
		panel.add(labelNome);
		
		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(10, 92, 48, 14);
		panel.add(labelTelefone);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(174, 33, 48, 14);
		panel.add(labelEmail);
		
		JLabel labelLogin = new JLabel("Login:");
		labelLogin.setBounds(174, 61, 48, 14);
		panel.add(labelLogin);
		
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setBounds(174, 92, 48, 14);
		panel.add(labelSenha);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(68, 30, 96, 20);
		panel.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(68, 55, 96, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(68, 86, 96, 20);
		panel.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(218, 92, 96, 20);
		panel.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(218, 61, 96, 20);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(218, 30, 96, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		setSize(628, 576);
		setLocationRelativeTo(null);
	}
	
//	public static void loadTable() {
//		Connection conn = DB.getConnection();
//		FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
//		for(Funcionario fun : funcionarioimp.findAll()) {
//			modelo.addRow(new Object[] {fun.getIdFuncionario(), fun.getNome(), fun.getTelefone(), fun.getEmail(), fun.getLogin(), fun.getSenha()});
//			}
//		
//	}
//	public static void clearTable() {
//		Connection conn = DB.getConnection();
//		FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
//		for(Funcionario fun : funcionarioimp.findAll()) {
//			//modelo.addRow(new Object[] {"", "", "", "", "", ""});
//			modelo.setNumRows(0);
//			}
//		
//	}
}
