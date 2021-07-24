package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.DB;
import model.dao.impl.ClienteDaoImplementacao;
import model.dao.impl.FreteDaoImplementacao;
import model.dao.impl.FuncionarioDaoImplementacao;
import model.dao.impl.StatusDaoImplementacao;
import model.entities.Cliente;
import model.entities.Frete;
import model.entities.Funcionario;
import model.entities.Status;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;


public class TelaCadastroFrete extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldDescricao;
	private JTextField textFieldValor;
	private JTextField textFieldNfe;
	private JTextField textFieldEndereco;
	private JTextField textFieldNumero;
	
	static DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFrete frame = new TelaCadastroFrete();
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
	public TelaCadastroFrete() {
		setTitle("Registro de Fretes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Relat\u00F3rio");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTabelaFrete frame = new TelaTabelaFrete();
				frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
// ----------------------------------------COMBO --------------------------		
		//JComboBox<Cliente> comboBox = new JComboBox<Cliente>();
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(45, 62, 239, 32);
		contentPane.add(comboBox);
		
		Connection conn = DB.getConnection();
		ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
		//System.out.println(	clienteimp.findAll());
		
		ArrayList<Cliente> usuArray = new ArrayList<Cliente>();
		usuArray = clienteimp.findAll();
		ArrayList<Integer> idCli = new ArrayList<Integer>();
		
		for (Cliente cli : usuArray) {
			comboBox.addItem(cli.getNome());
			idCli.add(cli.getIdCliente());
			
		}
		
		//System.out.println(comboBox.getSelectedIndex());
	
		
		//System.out.println(comboBox.getSelectedItem());
		
		
	
		
		
//		---------------------------------------------------------------
		JComboBox<String> comboBoxFun = new JComboBox<String>();
		comboBoxFun.setBounds(311, 62, 239, 32);
		contentPane.add(comboBoxFun);
		
		Connection connFun = DB.getConnection();
		FuncionarioDaoImplementacao funcionarioimp = new FuncionarioDaoImplementacao(connFun);
		
		ArrayList<Funcionario> usuArrayFun = new ArrayList<Funcionario>();
		usuArrayFun = funcionarioimp.findAll();
		ArrayList<Integer> idFun = new ArrayList<Integer>();
		
		for (Funcionario fun : usuArrayFun) {
			comboBoxFun.addItem(fun.getNome());
			idFun.add(fun.getIdFuncionario());
			
		}
		//System.out.println(idFun);
	
		
		
		
//		-----------------------------------------------------------------------
		
		JComboBox<String> comboBoxStatus = new JComboBox<String>();
		comboBoxStatus.setBounds(268, 177, 96, 22);
		
		Connection connStat = DB.getConnection();
		StatusDaoImplementacao statusimp = new StatusDaoImplementacao(connStat);
		
		ArrayList<Status> statArray = new ArrayList<Status>();
		statArray = statusimp.findAll();
		ArrayList<Integer> idStat = new ArrayList<Integer>();
		
		for (Status stat : statArray) {
			comboBoxStatus.addItem(stat.getDescricao());
			idStat.add(stat.getIdStatus());
			
		}
		
		//System.out.println(idStat);
		
		
//-----------------------------------------------------------------------------
		
//		JButton btnNewButton = new JButton("Load Cliente");
//		btnNewButton.setBounds(80, 105, 171, 23);
//		btnNewButton.setFont(new Font("Unispace", Font.PLAIN, 11));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				System.out.println("Cliente");
//				System.out.println(comboBox.getSelectedIndex());
//				System.out.println(idCli.get(comboBox.getSelectedIndex()));
//			}
//		});
//		contentPane.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("Load Funcionario");
//		btnNewButton_1.setBounds(339, 105, 171, 23);
//		btnNewButton_1.setFont(new Font("Unispace", Font.PLAIN, 11));
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				System.out.println("Funcionario");
//				System.out.println(comboBoxFun.getSelectedIndex());
//				System.out.println(idFun.get(comboBoxFun.getSelectedIndex()));
//			}
//		});
//		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 162, 561, 226);
		panel.setBorder(new TitledBorder(null, "Cadastro de frete", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Cod. controle");
		lblNewLabel.setBounds(32, 47, 96, 14);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(32, 61, 96, 20);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1.setBounds(32, 102, 112, 14);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(32, 127, 211, 20);
		textFieldDescricao.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor R$");
		lblNewLabel_2.setBounds(473, 47, 59, 14);
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(473, 67, 59, 20);
		textFieldValor.setColumns(10);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(textFieldId);
		panel.add(lblNewLabel_1);
		panel.add(textFieldDescricao);
		panel.add(lblNewLabel_2);
		panel.add(textFieldValor);
		
		JLabel lblNewLabel_3 = new JLabel("NFe");
		lblNewLabel_3.setBounds(258, 47, 65, 14);
		panel.add(lblNewLabel_3);
		
		textFieldNfe = new JTextField();
		textFieldNfe.setBounds(258, 67, 96, 20);
		panel.add(textFieldNfe);
		textFieldNfe.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Endere\u00E7o");
		lblNewLabel_4.setBounds(258, 102, 96, 14);
		panel.add(lblNewLabel_4);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(258, 127, 211, 20);
		panel.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("N\u00FAmero");
		lblNewLabel_5.setBounds(473, 102, 65, 14);
		panel.add(lblNewLabel_5);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(473, 127, 65, 20);
		panel.add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Status");
		lblNewLabel_6.setBounds(268, 158, 85, 14);
		panel.add(lblNewLabel_6);
		
		panel.add(comboBoxStatus);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(32, 174, 110, 28);
		panel.add(btnLimpar);
		btnLimpar.setFont(new Font("Unispace", Font.PLAIN, 11));
		
//		JButton btnNewButton_3 = new JButton("Temp");
//		btnNewButton_3.setFont(new Font("Unispace", Font.PLAIN, 11));
//		btnNewButton_3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				System.out.println("Status");
//				System.out.println(comboBoxStatus.getSelectedIndex());
//				System.out.println(idStat.get(comboBoxStatus.getSelectedIndex()));
//				
//			}
//		});
//		btnNewButton_3.setBounds(393, 177, 89, 23);
//		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 391, 561, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(149, 0, 2, 50);
		separator.setOrientation(SwingConstants.VERTICAL);
		panel_1.add(separator);
		
		JButton btnNewButton_2 = new JButton("Registrar");
		btnNewButton_2.setBounds(23, 11, 112, 23);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//				if ((textFieldDescricao.getText() == "a") || (textFieldNfe.getText() == "" ) || (textFieldEndereco.getText() == "") || (textFieldId.getText() == "") || (textFieldValor.getText() == "") || (textFieldId.getText() == "") || (textFieldNumero.getText() == "")){
//					JOptionPane.showMessageDialog(null, "Favor preencher todos os campos");
//				
//				}
				
				int b = 0;
				double c = 0;
				int d = 0;

				b = Integer.parseInt(textFieldId.getText());
				c = Double.parseDouble(textFieldValor.getText());
				d = Integer.parseInt(textFieldNumero.getText());
				//, idCli.get(comboBox.getSelectedIndex()), idFun.get(comboBoxFun.getSelectedIndex())
				
				Connection conn = DB.getConnection();
				FreteDaoImplementacao freteImp = new FreteDaoImplementacao(conn);
				
				Connection connCli = DB.getConnection();
				ClienteDaoImplementacao clienteImp = new ClienteDaoImplementacao(connCli);
				
				Cliente cli = clienteImp.findById(idCli.get(comboBox.getSelectedIndex()));
				
				Connection connFun = DB.getConnection();
				FuncionarioDaoImplementacao funcionarioImp = new FuncionarioDaoImplementacao(connFun);
				
				Funcionario fun = funcionarioImp.findById(idFun.get(comboBoxFun.getSelectedIndex()));
				
				Connection connStat = DB.getConnection();
				StatusDaoImplementacao statusImp = new StatusDaoImplementacao(connStat);
				
				Status status = statusImp.findById(idStat.get(comboBoxStatus.getSelectedIndex()));
				
				
				Frete frete = new Frete(b  , textFieldDescricao.getText(), c, textFieldNfe.getText(), textFieldEndereco.getText(), d, cli, fun, status);
				
				
				
				
				
			//	int b = 0;

				
				
				
				
			
				
				
				freteImp.insert(frete);
				
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso:\r\n");	
				}catch (Exception erro) {
					//System.out.println("Preencha todos os campos:"+erro);
					JOptionPane.showMessageDialog(null, "Preencha todos os campos:\r\n"+erro);
				}
				finally {
				
			}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Unispace", Font.PLAIN, 11));
		
		JLabel lblNewLabel_7 = new JLabel("Cliente");
		lblNewLabel_7.setBounds(45, 34, 48, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setBounds(311, 34, 116, 14);
		contentPane.add(lblFuncionrio);
		
		
		
		setSize(628, 601);
		setLocationRelativeTo(null);
		
		
	}
}
