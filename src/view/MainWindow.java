package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.Icon;
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

import com.sun.tools.javac.Main;

import db.DB;
import model.dao.impl.UsuarioDaoImplementacao;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;

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
		//------------------------- CHAMADA DA Tela Cliente -------------------------------
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
		//------------------------- CHAMADA DA Tela Funcionario -------------------------------
		JMenuItem mnlFuncionario = new JMenuItem("Funcionario");
		mnlFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionario telaCadastroFuncionario2 = new TelaCadastroFuncionario();
				telaCadastroFuncionario2.setVisible(true);
			}
		});
		menuCadastro.add(mnlFuncionario);
		//------------------------- CHAMADA DA Tela FRETE -------------------------------
		JMenu mnFrete = new JMenu("Frete");
		menuBar.add(mnFrete);
		
		JMenuItem mnlGeraFrete = new JMenuItem("Gerar Frete");
		mnlGeraFrete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Coming Soon !!!!!");
				TelaCadastroFrete telaCadastroFrete = new TelaCadastroFrete();
				telaCadastroFrete.setVisible(true);
			}
		});
		mnFrete.add(mnlGeraFrete);
		//------------------------- CHAMADA DA Tela RELATORIOS -------------------------------
		JMenu mnRelatorio = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorio);
		
		JMenuItem mnIFuncionarios = new JMenuItem("Funcion\u00E1rios");
		mnIFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon !!!!!");
			}
		});
		mnRelatorio.add(mnIFuncionarios);
		
		JMenuItem mnlClientes = new JMenuItem("Clientes");
		mnlClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Coming Soon !!!!!");
			}
		});
		mnRelatorio.add(mnlClientes);
		
		JMenu mnNewMenu = new JMenu("Mais");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Criar Status");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					TelaCadastroStatus telaCadastroStatus = new TelaCadastroStatus();
					telaCadastroStatus.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sobre");
		mnNewMenu.add(mntmNewMenuItem_1);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel labelTestando = new JLabel("");
		labelTestando.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaCadastroStatus telaCadastroStatus = new TelaCadastroStatus();
				telaCadastroStatus.setVisible(true);
				
				
			}
		});
		labelTestando.setBounds(834, 0, 52, 45);
		panel.add(labelTestando);
		//lblFoto.setIcon(new ImageIcon(image.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT)));
		
		
		
		ImageIcon image = new ImageIcon(TelaCadastroStatus.class.getResource("/img/settings.png"));
		labelTestando.setIcon(new ImageIcon(image.getImage().getScaledInstance(30,30,30)));
		

		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 886, 539);
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/img/fastE.png")));
		panel.add(lblNewLabel);
//---------------------------------------
		 
		
//		------------------------------------------------
		setSize(900, 600);
		setLocationRelativeTo(null);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
