package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DB;
import model.dao.impl.FuncionarioDaoImplementacao;
import model.dao.impl.UsuarioDaoImplementacao;
import model.entities.Funcionario;
import model.entities.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class TelaCadastroFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldSenha;
	private JTextField textFieldLogin;
	private JTextField textFieldEmail;
	static DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;
	

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//----------------------------------EVENTO CADASTRAR --------------------------------
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Unispace", Font.PLAIN, 11));
		botaoCadastrar.setBounds(387, 26, 135, 39);
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int b = 0;

				b = Integer.parseInt(textFieldID.getText());
				
				Connection conn = DB.getConnection();
				FuncionarioDaoImplementacao funcionarioImp = new FuncionarioDaoImplementacao(conn);
				
				Funcionario fun = new Funcionario(b, textFieldNome.getText(), textFieldTelefone.getText(), textFieldEmail.getText(), textFieldLogin.getText(), textFieldSenha.getText(), null);
				//textFieldNome.getText(), textFieldTelefone.getText(), textFieldEmail.getText(), textFieldLogin.getText(), textFieldSenha.getText()
				
			//	int b = 0;

				b = Integer.parseInt(textFieldID.getText());
				
				System.out.println();
				
			
				
				
				funcionarioImp.insert(fun);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso:\r\n");
				
				}catch (Exception erro) {
					//System.out.println("Preencha todos os campos:"+erro);
					JOptionPane.showMessageDialog(null, "Preencha todos os campos:\r\n"+erro);
				}
				finally {
				}
				TelaCadastroFuncionario.clearTable();
				TelaCadastroFuncionario.loadTable();
				//Usuario userr = usuarioImp.findById(30);
				//System.out.println(userr);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(botaoCadastrar);
		// ----------------------------- EVENTO ATUALIZAR -------------------------------
		JButton botaoAtualizar = new JButton("Atualizar");
		botaoAtualizar.setFont(new Font("Unispace", Font.PLAIN, 11));
		botaoAtualizar.setBounds(387, 76, 135, 39);
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int idConvertido = 0;

				idConvertido = Integer.parseInt(textFieldID.getText());
				
				Connection conn = DB.getConnection();
				FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
				
				Funcionario fun = funcionarioimp.findById(idConvertido);
				
				fun.setIdFuncionario(idConvertido);
				fun.setNome(textFieldNome.getText());
				fun.setTelefone(textFieldTelefone.getText());
				fun.setLogin(textFieldLogin.getText());
				fun.setSenha(textFieldSenha.getText());
				fun.setEmail(textFieldEmail.getText());
				
				
				
				funcionarioimp.update(fun);
				TelaCadastroFuncionario.clearTable();
				TelaCadastroFuncionario.loadTable();
					JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso:\r\n");
				}catch (Exception erro) {
					//System.out.println("Preencha todos os campos:"+erro);
					JOptionPane.showMessageDialog(null, "Erro para atualizar:\r\n"+erro);
				}
				finally {
					
				}
			}
		});
		contentPane.add(botaoAtualizar);
		botaoAtualizar.setEnabled(false);
		// ------------------------ ----------- EVENTO DELETAR -----------------------------------------
		JButton botaoDeletar = new JButton("Deletar");
		botaoDeletar.setFont(new Font("Unispace", Font.PLAIN, 11));
		botaoDeletar.setBounds(385, 126, 137, 39);
		botaoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idConvertido = 0;
	
					idConvertido = Integer.parseInt(textFieldID.getText());
					
					Connection conn = DB.getConnection();
					FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
					funcionarioimp.deleteById(idConvertido);
					TelaCadastroFuncionario.clearTable();
					TelaCadastroFuncionario.loadTable();
				
					JOptionPane.showMessageDialog(null, "Funcionario deletado:\r\n");
				}catch (Exception erro) {
					//System.out.println("Preencha todos os campos:"+erro);
					JOptionPane.showMessageDialog(null, "Erro para deletar:\r\n"+erro);
				}
				finally {
				
				}
			}
		});
		contentPane.add(botaoDeletar);
		botaoDeletar.setEnabled(false);
		// --------------------------------- EVENTO LISTAR TODOS ----------------------------------
		JButton botaoListar = new JButton("Listar Todos");
		botaoListar.setFont(new Font("Unispace", Font.PLAIN, 11));
		botaoListar.setBounds(387, 224, 135, 39);
		botaoListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				botaoDeletar.setEnabled(true);
				botaoAtualizar.setEnabled(true);
				TelaCadastroFuncionario.loadTable();
				
				Connection conn = DB.getConnection();
				FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
				System.out.println(	funcionarioimp.findAll());
			//	ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
			//lista = funcionarioimp.findAll();
				
				TelaCadastroFuncionario.clearTable();
				TelaCadastroFuncionario.loadTable();
				
//				for(Funcionario fun : funcionarioimp.findAll()) {
//				modelo.addRow(new Object[] {fun.getIdFuncionario(), fun.getNome(), fun.getTelefone(), fun.getEmail(), fun.getLogin(), fun.getSenha()});
//				}
//				DB.closeConnection();
				
//				ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
//				lista = funcionarioimp.findAll();
//				
//				for(Funcionario fun : lista) {
//				modelo.addRow(new Object[] {fun.getIdFuncionario(), fun.getNome(), fun.getTelefone(), fun.getEmail(), fun.getLogin(), fun.getSenha()});
//				}
//				DB.closeConnection();
				
				//TelaCadastroFuncionario.loadTable();
				}catch (Exception erro) {
					//System.out.println("Preencha todos os campos:"+erro);
					JOptionPane.showMessageDialog(null, "Erro :\r\n"+erro);
				}
				finally {
				
			}
				
			}
		});
		contentPane.add(botaoListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 331, 579, 180);
		contentPane.add(scrollPane);
		//------------------------------table--------------
		table = new JTable(modelo);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int number = table.getSelectedRow();
				textFieldID.setText(table.getValueAt(number, 0).toString());
				textFieldNome.setText(table.getValueAt(number, 1).toString());
				textFieldTelefone.setText(table.getValueAt(number, 2).toString());
				textFieldLogin.setText(table.getValueAt(number, 3).toString());
				textFieldSenha.setText(table.getValueAt(number, 4).toString());
				textFieldEmail.setText(table.getValueAt(number, 5).toString());
				botaoDeletar.setEnabled(true);
				botaoAtualizar.setEnabled(true);
				botaoCadastrar.setEnabled(false);
			}
		});
		scrollPane.setViewportView(table);
		
		modelo.addColumn("Id_funcionario");
		modelo.addColumn("Nome");
		modelo.addColumn("Telfone");
		modelo.addColumn("Email");
		modelo.addColumn("Login");
		modelo.addColumn("Senha");
		modelo.setColumnCount(6);
		
		TelaCadastroFuncionario.clearTable();
		TelaCadastroFuncionario.loadTable();
		
		JLabel lblNewLabel_3 = new JLabel("BUSCAR: Informe o ID e clique em Buscar");
		lblNewLabel_3.setBounds(10, 201, 304, 14);
		contentPane.add(lblNewLabel_3);
		//--------------------------------------EVENTO BUSCAR -------------------------------
		JButton botaoBuscar = new JButton("Buscar");
		botaoBuscar.setFont(new Font("Unispace", Font.PLAIN, 11));
		botaoBuscar.setBounds(387, 174, 135, 39);
		botaoBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int idConvertido = 0;

				idConvertido = Integer.parseInt(textFieldID.getText());
				Connection conn = DB.getConnection();
				FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
				
				Funcionario fun = funcionarioimp.findById(idConvertido);
				System.out.println(fun);
				
				TelaCadastroFuncionario.clearTable();
				TelaCadastroFuncionario.loadTable(fun);
				JOptionPane.showMessageDialog(null, "Funcionario localizado:\r\n");
				
				}catch (Exception erro) {
					//System.out.println("Preencha todos os campos:"+erro);
					JOptionPane.showMessageDialog(null, "CPF não localizado:\r\n"+erro);
				}
				finally {
					
				}
			
			}
		});
		contentPane.add(botaoBuscar);
		// ----------------------------------- JPANEL
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 346, 150);
		panel.setBorder(new TitledBorder(null, "Cadastrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelID = new JLabel("CPF:");
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
		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.setFont(new Font("Unispace", Font.PLAIN, 11));
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldID.setText(null);
				textFieldNome.setText(null);
				textFieldTelefone.setText(null);
				textFieldLogin.setText(null);
				textFieldSenha.setText(null);
				textFieldEmail.setText(null);
				botaoDeletar.setEnabled(false);
				botaoAtualizar.setEnabled(false);
				botaoCadastrar.setEnabled(true);
			}
		});
		botaoLimpar.setBounds(33, 116, 89, 23);
		panel.add(botaoLimpar);
		setSize(628, 576);
		setLocationRelativeTo(null);
	}
	
	public static void loadTable() {
		Connection conn = DB.getConnection();
		FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
		for(Funcionario fun : funcionarioimp.findAll()) {
			modelo.addRow(new Object[] {fun.getIdFuncionario(), fun.getNome(), fun.getTelefone(), fun.getEmail(), fun.getLogin(), fun.getSenha()});
			}
		
	}
	public static void clearTable() {
		Connection conn = DB.getConnection();
		FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
		for(Funcionario fun : funcionarioimp.findAll()) {
			//modelo.addRow(new Object[] {"", "", "", "", "", ""});
			modelo.setNumRows(0);
			}
		
	}
	
	public static void loadTable(Funcionario fun2) {
		Connection conn = DB.getConnection();
		FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(conn);
//		for(Funcionario fun : funcionarioimp.findAll()) {
//			modelo.addRow(new Object[] {fun2.getIdFuncionario(), fun2.getNome(), fun2.getTelefone(), fun2.getEmail(), fun2.getLogin(), fun2.getSenha()});
//			}
		modelo.addRow(new Object[] {fun2.getIdFuncionario(), fun2.getNome(), fun2.getTelefone(), fun2.getEmail(), fun2.getLogin(), fun2.getSenha()});
		
	}
}
