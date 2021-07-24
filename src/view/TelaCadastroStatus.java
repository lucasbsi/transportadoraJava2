package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import db.DB;
import model.dao.impl.ClienteDaoImplementacao;
import model.dao.impl.StatusDaoImplementacao;
import model.entities.Cliente;
import model.entities.Status;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Canvas;
import java.awt.TextArea;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TelaCadastroStatus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;
	private JLabel labelID;
	private JTextField textFieldID;
	private JLabel labelDescricao;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroStatus frame = new TelaCadastroStatus();
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
	public TelaCadastroStatus() {
		setTitle("Configura\u00E7\u00E3o de Status");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 31, 176, 180);
		contentPane.add(scrollPane);
		
		table = new JTable(modelo);
		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Novo Status", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 11, 181, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		labelID = new JLabel("ID");
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelID.setBounds(10, 23, 96, 21);
		panel.add(labelID);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(10, 55, 39, 20);
		panel.add(textFieldID);
		
		labelDescricao = new JLabel("Descri\u00E7\u00E3o");
		labelDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDescricao.setBounds(10, 108, 96, 29);
		panel.add(labelDescricao);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 148, 128, 20);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnNewButton.setBounds(215, 22, 98, 34);
		contentPane.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnAtualizar.setBounds(215, 67, 98, 34);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnExcluir.setForeground(Color.RED);
		btnExcluir.setBounds(215, 166, 98, 34);
		contentPane.add(btnExcluir);
		
		
		
		
	
		
		
		
		modelo.addColumn("Id");
		modelo.addColumn("Descrição");
		
		TelaCadastroStatus.clearTable();
		TelaCadastroStatus.loadTable();
		setLocationRelativeTo(null);
		
		
	}
	
	public static void loadTable() {
		Connection conn = DB.getConnection();
		StatusDaoImplementacao statusimp = new StatusDaoImplementacao(conn);
		for(Status stat : statusimp.findAll()) {
			modelo.addRow(new Object[] {stat.getIdStatus(), stat.getDescricao()});

			}
		
		
	}
	public static void clearTable() {
		Connection conn = DB.getConnection();
		StatusDaoImplementacao statusimp = new StatusDaoImplementacao(conn);
		for(Status stat : statusimp.findAll()) {
			//modelo.addRow(new Object[] {"", "", "", "", "", ""});
			modelo.setNumRows(0);
			
			}
		
	}
}
