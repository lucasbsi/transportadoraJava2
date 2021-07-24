package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import db.DB;
import model.dao.impl.ClienteDaoImplementacao;
import model.dao.impl.FreteDaoImplementacao;
import model.dao.impl.StatusDaoImplementacao;
import model.entities.Cliente;
import model.entities.Frete;
import model.entities.Status;

import java.awt.Font;

public class TelaTabelaFrete extends JFrame {

	
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
					TelaTabelaFrete frame = new TelaTabelaFrete();
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
	public TelaTabelaFrete() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Relat\u00F3rio de Frete");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		----------------------------------- COMBOBOX
		JComboBox<String> comboBoxStatus = new JComboBox<String>();
		comboBoxStatus.setBounds(357, 502, 122, 39);
		contentPane.add(comboBoxStatus);
		
		Connection connStat = DB.getConnection();
		StatusDaoImplementacao statusimp = new StatusDaoImplementacao(connStat);
		
		ArrayList<Status> statArray = new ArrayList<Status>();
		statArray = statusimp.findAll();
		ArrayList<Integer> idStat = new ArrayList<Integer>();
		ArrayList<Integer> idCountStat = new ArrayList<Integer>();
		int i=0;
		
		for (Status stat : statArray) {
			comboBoxStatus.addItem(stat.getDescricao());
			idStat.add(stat.getIdStatus());
			idCountStat.add(i);
			i++;
			
		}
		
		//System.out.println(idStat);
		
		// ----------------------------- EVENTO CADASTRAR ----------------------------------------------

//		// -------------------------------------EVENTO ATUALIZAR --------------------------------------------------------

		//--------------------------------- EVENTO DELETAR ----------------------------------------------
		JButton botaoDeletar = new JButton("Deletar");
		botaoDeletar.setFont(new Font("Unispace", Font.PLAIN, 11));
		botaoDeletar.setBounds(34, 502, 114, 39);
		botaoDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int number = table.getSelectedRow();
					
					int codigoSelecionadoConvertido = Integer.parseInt(table.getValueAt(number, 0).toString());
					
					Connection conn = DB.getConnection();
					FreteDaoImplementacao freteImp = new FreteDaoImplementacao(conn);
					
					System.out.println();
					
					freteImp.deleteById(codigoSelecionadoConvertido);
					TelaTabelaFrete.clearTable();
					TelaTabelaFrete.loadTable();
					JOptionPane.showMessageDialog(null, "Frete removido:\r\n");	
				}catch (Exception erro) {
					//System.out.println("Preencha todos os campos:"+erro);
					JOptionPane.showMessageDialog(null, "Preencha todos os campos:\r\n"+erro);
				}
				finally {
				
			}
			}
		});
		contentPane.add(botaoDeletar);
		botaoDeletar.setEnabled(true);
		
		//-------------------------------------EVENTO ALTERAR STATUS------------------------------		
				JButton btnNewButton = new JButton("Alterar Status");
				btnNewButton.setFont(new Font("Unispace", Font.PLAIN, 11));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					try {
						
						int number = table.getSelectedRow();
						
						int codigoSelecionadoConvertido = Integer.parseInt(table.getValueAt(number, 0).toString());
						System.out.println("Cod frete");
						System.out.println(codigoSelecionadoConvertido);
						
						System.out.println("Status");
						System.out.println(comboBoxStatus.getSelectedIndex());//pega o index
						System.out.println(idStat.get(comboBoxStatus.getSelectedIndex()));// retorna o valor correspondente através no array idStat do index
						
						int codigoStatusSelecionado = idStat.get(comboBoxStatus.getSelectedIndex());
						Connection conn = DB.getConnection();
						FreteDaoImplementacao freteImp = new FreteDaoImplementacao(conn);
						
						System.out.println();
						
						freteImp.updateStatus(codigoSelecionadoConvertido, codigoStatusSelecionado);
						TelaTabelaFrete.clearTable();
						TelaTabelaFrete.loadTable();
						JOptionPane.showMessageDialog(null, "Status alterado com sucesso:\r\n");	
					}catch (Exception erro) {
						//System.out.println("Preencha todos os campos:"+erro);
						JOptionPane.showMessageDialog(null, "Erro:\r\n"+erro);
					}
					finally {
					
				}
						
						//idStat.get(comboBoxStatus.getSelectedIndex())
					}
				});
				btnNewButton.setBounds(496, 502, 153, 39);
				contentPane.add(btnNewButton);
				setSize(767, 602);
				setLocationRelativeTo(null);
				
				
			
		
//		//---------------------------------EVENTO LISTAR TODOS -------------------------------------------------

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(10, 10, 709, 468);
		contentPane.add(scrollPane);
		
		table = new JTable(modelo);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int number = table.getSelectedRow();
					
					System.out.println(table.getValueAt(number, 8).toString());// retorna string da tabela
					String CurrentStatus = table.getValueAt(number, 8).toString();
					System.out.println(number);
					System.out.println(CurrentStatus);
					System.out.println((String) CurrentStatus);
					//System.out.println(idStat);// retorna array de status do bd
					//System.out.println(comboBoxStatus);
					//System.out.println(comboBoxStatus.getSelectedItem());//retorna o item do combobox
					//System.out.println(idCountStat.get(1));// retorna o conteudo na posição i do array
					
					// sincronizar table com combobox
					if (CurrentStatus.equals("Novo")) {
						comboBoxStatus.setSelectedIndex(0);
						
					}else if (CurrentStatus.equals("Em rota")) {
						comboBoxStatus.setSelectedIndex(1);
						
					}else if (CurrentStatus.equals("Entregue")) {
						comboBoxStatus.setSelectedIndex(2);
						
					}else if (CurrentStatus.equals("Cancelado")) {
						comboBoxStatus.setSelectedIndex(3);
					}
					
					
					
					//JOptionPane.showMessageDialog(null, "Ok:\r\n");
					
				}catch (Exception erro) {
					//System.out.println("Preencha todos os campos:"+erro);
					JOptionPane.showMessageDialog(null, "Erro:\r\n"+erro);
				}
				finally {
				
				}
				//textFieldID.setText(table.getValueAt(number, 0).toString());
			}
		});
		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		modelo.addColumn("Cod. controle");
		modelo.addColumn("Descrição");
		modelo.addColumn("Valor");
		modelo.addColumn("Nfe");
		modelo.addColumn("Endereço");
		modelo.addColumn("Número");
		modelo.addColumn("Cliente");
		modelo.addColumn("Funcionario");
		modelo.addColumn("Status");
		modelo.setColumnCount(9);
		
		TelaTabelaFrete.clearTable();
		TelaTabelaFrete.loadTable();
		// --------------------------------------EVENTO BUSCAR ------------------------
//		JButton botaoBuscar = new JButton("Buscar");
//		botaoBuscar.setBounds(387, 174, 114, 39);
//		botaoBuscar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				botaoDeletar.setEnabled(true);
//				botaoAtualizar.setEnabled(true);
//				int idConvertido = 0;
//
//				idConvertido = Integer.parseInt(textFieldID.getText());
//				Connection conn = DB.getConnection();
//				ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn);
//				
//				Cliente cli = clienteimp.findById(idConvertido);
//				System.out.println(cli);
//				
//				TelaCadastroCliente.clearTable();
//				TelaCadastroCliente.loadTable(cli);
//			}
//		});
//		contentPane.add(botaoBuscar);
		// ----------------------------------- JPANEL
		JPanel panel = new JPanel();
		panel.setBounds(707, 210, 1, 1);
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
		

		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldID.setText(null);
				textFieldNome.setText(null);
				textFieldTelefone.setText(null);
				textFieldLogin.setText(null);
				textFieldSenha.setText(null);
				textFieldEmail.setText(null);
//				botaoDeletar.setEnabled(false);
//				botaoAtualizar.setEnabled(false);
//				botaoCadastrar.setEnabled(true);
//				
			}
		});
		
		
		
		botaoLimpar.setBounds(20, 117, 89, 23);
		panel.add(botaoLimpar);

		
	}
	
	public static void loadTable() {
		Connection conn = DB.getConnection();
		FreteDaoImplementacao freteimp = new FreteDaoImplementacao(conn);
		for(Frete frete : freteimp.findAll()) {
			//modelo.addRow(new Object[] {cli.getIdCliente(), cli.getNome(), cli.getTelefone(), cli.getEmail(), cli.getLogin(), cli.getSenha()});
			modelo.addRow(new Object[] {frete.getIdFrete(), frete.getDescricao(), frete.getValor(), frete.getNfe(), frete.getEndereco(), frete.getNumero(), frete.getCliente().getNome(), frete.getFuncionario().getNome(), frete.getStatus().getDescricao()});
//			, frete.getStatus().getIdStatus()
			//Frete frete = new Frete(9902, "Notebook",(double)4500, "ATK001", "Rua cambuci pg guarus", 9, cli, fun, status);
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
}
