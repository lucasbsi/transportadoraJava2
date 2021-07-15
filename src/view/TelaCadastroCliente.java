package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DB;
import model.dao.impl.ClienteDaoImplementacao;
import model.dao.impl.FuncionarioDaoImplementacao;
import model.dao.impl.UsuarioDaoImplementacao;
import model.entities.Cliente;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroCliente extends JFrame {

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Central do Cliente");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// ----------------------------- EVENTO CADASTRAR ----------------------------------------------
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setBounds(387, 26, 114, 39);
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TelaCadastroCliente.clearTable();
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
				TelaCadastroCliente.clearTable();
				TelaCadastroCliente.loadTable();
				//Usuario userr = usuarioImp.findById(30);
				//System.out.println(userr);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(botaoCadastrar);
		// -------------------------------------EVENTO ATUALIZAR --------------------------------------------------------
		JButton botaoAtualizar = new JButton("Atualizar Senha");
		botaoAtualizar.setBounds(387, 76, 114, 39);
		botaoAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idConvertido = 0;

				idConvertido = Integer.parseInt(textFieldID.getText());
				
				Connection conn = DB.getConnection();
				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
				
				Cliente cli = clienteimp.findById(idConvertido);
				
				cli.setIdCliente(idConvertido);
				cli.setNome(textFieldNome.getText());
				cli.setTelefone(textFieldTelefone.getText());
				cli.setLogin(textFieldLogin.getText());
				cli.setSenha(textFieldSenha.getText());
				cli.setEmail(textFieldEmail.getText());
				
				clienteimp.update(cli);
				TelaCadastroCliente.clearTable();
				TelaCadastroCliente.loadTable();
				
			}
		});
		contentPane.add(botaoAtualizar);
		botaoAtualizar.setEnabled(false);
		//--------------------------------- EVENTO DELETAR ----------------------------------------------
		JButton botaoDeletar = new JButton("Deletar");
		botaoDeletar.setBounds(385, 126, 114, 39);
		botaoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idConvertido = 0;

				idConvertido = Integer.parseInt(textFieldID.getText());
				
				Connection conn = DB.getConnection();
				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
				clienteimp.deleteById(idConvertido);
				TelaCadastroCliente.clearTable();
				TelaCadastroCliente.loadTable();
			}
		});
		contentPane.add(botaoDeletar);
		botaoDeletar.setEnabled(false);
		
		//---------------------------------EVENTO LISTAR TODOS -------------------------------------------------
		JButton btnListar = new JButton("Listar Todos");
		btnListar.setBounds(387, 224, 114, 39);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				botaoDeletar.setEnabled(true);
				botaoAtualizar.setEnabled(true);
					
				TelaCadastroCliente.loadTable();
				Connection conn = DB.getConnection();
				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
				System.out.println(	clienteimp.findAll());
			//	ArrayList<Cliente> lista = new ArrayList<Cliente>();
			//lista = clienteimp.findAll();
				
				TelaCadastroCliente.clearTable();
				TelaCadastroCliente.loadTable();
				
//				for(Cliente cli : clienteimp.findAll()) {
//				modelo.addRow(new Object[] {cli.getIdCliente(), cli.getNome(), cli.getTelefone(), cli.getEmail(), cli.getLogin(), cli.getSenha()});
//				}
//				DB.closeConnection();
				
//				ArrayList<Cliente> lista = new ArrayList<Cliente>();
//				lista = clienteimp.findAll();
//				
//				for(Cliente cli : lista) {
//				modelo.addRow(new Object[] {cli.getIdCliente(), cli.getNome(), cli.getTelefone(), cli.getEmail(), cli.getLogin(), cli.getSenha()});
//				}
//				DB.closeConnection();
				
				//TelaCadastroCliente.loadTable();
				
				
			}
		});
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 331, 579, 180);
		contentPane.add(scrollPane);
		
		table = new JTable(modelo);
		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				table.getSelectedRow()
//			}
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
		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		modelo.addColumn("Id_cliente");
		modelo.addColumn("Nome");
		modelo.addColumn("Telfone");
		modelo.addColumn("Email");
		modelo.addColumn("Login");
		modelo.addColumn("Senha");
		modelo.setColumnCount(6);
		
		TelaCadastroCliente.clearTable();
		TelaCadastroCliente.loadTable();
		
		JLabel lblNewLabel_3 = new JLabel("BUSCAR: Informe o ID e clique em Buscar");
		lblNewLabel_3.setBounds(10, 201, 304, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(387, 174, 114, 39);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoDeletar.setEnabled(true);
				botaoAtualizar.setEnabled(true);
				int idConvertido = 0;

				idConvertido = Integer.parseInt(textFieldID.getText());
				Connection conn = DB.getConnection();
				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
				
				Cliente cli = clienteimp.findById(idConvertido);
				System.out.println(cli);
				
				TelaCadastroCliente.clearTable();
				TelaCadastroCliente.loadTable(cli);
			}
		});
		contentPane.add(btnBuscar);
		
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
		botaoLimpar.setBounds(20, 117, 89, 23);
		panel.add(botaoLimpar);
		setSize(628, 576);
		setLocationRelativeTo(null);
	}
	
	public static void loadTable() {
		Connection conn = DB.getConnection();
		ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
		for(Cliente cli : clienteimp.findAll()) {
			modelo.addRow(new Object[] {cli.getIdCliente(), cli.getNome(), cli.getTelefone(), cli.getEmail(), cli.getLogin(), cli.getSenha()});

			}
		
		
	}
	public static void clearTable() {
		Connection conn = DB.getConnection();
		ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
		for(Cliente cli : clienteimp.findAll()) {
			//modelo.addRow(new Object[] {"", "", "", "", "", ""});
			modelo.setNumRows(0);
			
			}
		
	}
	
	public static void loadTable(Cliente cli2) {
		Connection conn = DB.getConnection();
		ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
//		for(Funcionario fun : funcionarioimp.findAll()) {
//			modelo.addRow(new Object[] {cli2.getIdFuncionario(), cli2.getNome(), cli2.getTelefone(), cli2.getEmail(), cli2.getLogin(), cli2.getSenha()});
//			}
		modelo.addRow(new Object[] {cli2.getIdCliente(), cli2.getNome(), cli2.getTelefone(), cli2.getEmail(), cli2.getLogin(), cli2.getSenha()});
		
		
	}
	
	public static void createColumn(){
		
	
	}
}
