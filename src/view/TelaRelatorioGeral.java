package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.DB;
import model.dao.impl.ClienteDaoImplementacao;
import model.dao.impl.FreteDaoImplementacao;
import model.entities.Cliente;
import model.entities.Frete;

import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.print.attribute.standard.PrinterLocation;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRelatorioGeral extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorioGeral frame = new TelaRelatorioGeral();
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
	public TelaRelatorioGeral() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 774, 545);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredCliente = new JLayeredPane();
		layeredCliente.setToolTipText("Cliente");
		tabbedPane.addTab("Cliente", null, layeredCliente, null);
		layeredCliente.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 64, 701, 442);
		layeredCliente.add(scrollPane);
		
		
		table = new JTable(modelo);
		//layeredCliente.add(table);
		scrollPane.setViewportView(table);
		
		// ----------------------------------------COMBO --------------------------	
		JComboBox<String> comboBox = new JComboBox<String>();
//		comboBox.setSelectedIndex(-1);
		Connection conn1 = DB.getConnection();
		ClienteDaoImplementacao clienteimp = new ClienteDaoImplementacao(conn1);
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
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = DB.getConnection();
				FreteDaoImplementacao freteImp = new FreteDaoImplementacao(conn);
				ArrayList<Frete> freteArray = new ArrayList<Frete>();
				freteArray = freteImp.findFreteByClienteId(idCli.get(comboBox.getSelectedIndex()));
				
				TelaRelatorioGeral.clearTable();
				TelaRelatorioGeral.loadTable(freteArray);
				
				
				
//				if (comboBox.getSelectedIndex()!= -1) {
//					
//					JOptionPane.showMessageDialog(null, "agora vai");
//				}
//				if (comboBox.getSelectedIndex()!= 0) {
//					
//					JOptionPane.showMessageDialog(null, "eita");
//				}
			}
		});
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null, "message");
			}
		});
		comboBox.setBounds(236, 4, 236, 47);
		layeredCliente.add(comboBox);
		
		
				
				
		
		
				
			
				
				
//				---------------------------------------------------------------
		
		JLabel lblNewLabel = new JLabel("Selecione o cliente:");
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 14));
		lblNewLabel.setBounds(36, 11, 190, 30);
		layeredCliente.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Imprimir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Lista de frete pro Cliente");
				
				try {
					
					table.print(JTable.PrintMode.NORMAL, header, null);
					
					//table.print
//					JTable.getDefaultLocale();
//					JTable.setDefaultLocale(null);
				
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(rootPane, ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Unispace", Font.PLAIN, 14));
		btnNewButton.setBounds(567, 4, 132, 49);
		layeredCliente.add(btnNewButton);
		
		modelo.addColumn("CPF");
		modelo.addColumn("Cliente");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		modelo.addColumn("ID Frete");
		modelo.addColumn("Item");
		modelo.addColumn("Valor");
		modelo.addColumn("Situacao");
		modelo.addColumn("Encarregado");
		modelo.setColumnCount(9);
		
		TelaRelatorioGeral.clearTable();
		TelaRelatorioGeral.loadTable();
		
		
		
		
		
		JLayeredPane layeredFuncionario = new JLayeredPane();
		layeredFuncionario.setToolTipText("Funcionario");
		tabbedPane.addTab("Funcionario", null, layeredFuncionario, null);
		setLocationRelativeTo(null);
	}
	
	public static void loadTable() {
		Connection conn = DB.getConnection();
		FreteDaoImplementacao freteimp = new FreteDaoImplementacao(conn);
		for(Frete frete : freteimp.findFreteByClienteId(777)) {
			//modelo.addRow(new Object[] {cli.getIdCliente(), cli.getNome(), cli.getTelefone(), cli.getEmail(), cli.getLogin(), cli.getSenha()});
			/////modelo.addRow(new Object[] {frete.getIdFrete(), frete.getDescricao(), frete.getValor(), frete.getNfe(), frete.getEndereco(), frete.getNumero(), frete.getCliente().getNome(), frete.getFuncionario().getNome(), frete.getStatus().getDescricao()});
			modelo.addRow(new Object[] {frete.getCliente().getIdCliente(), frete.getCliente().getNome(),frete.getCliente().getTelefone(), frete.getCliente().getEmail(), frete.getIdFrete(),frete.getDescricao(), frete.getValor(), frete.getStatus().getDescricao(), frete.getFuncionario().getNome()});
			//System.out.println(frete);
			//			, frete.getStatus().getIdStatus()
			//Frete frete = new Frete(9902, "Notebook",(double)4500, "ATK001", "Rua cambuci pg guarus", 9, cli, fun, status);
			}
		
	

	}
	
	public static void loadTable(ArrayList<Frete> frete2) {
		//Connection conn = DB.getConnection();
		//FreteDaoImplementacao freteimp = new FreteDaoImplementacao(conn);
		for(Frete frete : frete2) {
		//modelo.addRow(new Object[] {cli.getIdCliente(), cli.getNome(), cli.getTelefone(), cli.getEmail(), cli.getLogin(), cli.getSenha()});
		/////modelo.addRow(new Object[] {frete.getIdFrete(), frete.getDescricao(), frete.getValor(), frete.getNfe(), frete.getEndereco(), frete.getNumero(), frete.getCliente().getNome(), frete.getFuncionario().getNome(), frete.getStatus().getDescricao()});
		modelo.addRow(new Object[] {frete.getCliente().getIdCliente(), frete.getCliente().getNome(),frete.getCliente().getTelefone(), frete.getCliente().getEmail(), frete.getIdFrete(),frete.getDescricao(), frete.getValor(), frete.getStatus().getDescricao(), frete.getFuncionario().getNome()});
		//System.out.println(frete);
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
