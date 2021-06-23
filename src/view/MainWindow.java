package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import db.DB;
import model.dao.impl.UsuarioDaoImplementacao;

import javax.swing.JTable;
import javax.swing.JButton;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setTitle("Transportadora FastE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/img/iconkombi.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuBar.add(menuCadastro);
		
		JMenuItem mmlCliente = new JMenuItem("Cliente");
		mmlCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
				telaCadastroCliente.setVisible(true);
			//	TelaCadastroUsuario telaCadNew = new TelaCadastroUsuario();
			//	telaCadNew.setVisible(true);
			}
		});
		menuCadastro.add(mmlCliente);
		
		JMenuItem mnlFuncionario = new JMenuItem("Funcionario");
		mnlFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario telaCadastroFuncionario2 = new TelaCadastroFuncionario();
				telaCadastroFuncionario2.setVisible(true);
			}
		});
		menuCadastro.add(mnlFuncionario);
		
		JMenu mnFrete = new JMenu("Frete");
		menuBar.add(mnFrete);
		
		JMenuItem mnlGeraFrete = new JMenuItem("Gerar Frete");
		mnlGeraFrete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon !!!!!");
			}
		});
		mnFrete.add(mnlGeraFrete);
		
		JMenuItem mnlConsultaFrete = new JMenuItem("Consultar Frete");
		mnlConsultaFrete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon !!!!!");
			}
		});
		mnFrete.add(mnlConsultaFrete);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/img/truck4.jpg")));
		lblNewLabel.setBounds(0, 0, 886, 539);
		panel.add(lblNewLabel);
		setSize(900, 600);
		setLocationRelativeTo(null);
		
	}
}
