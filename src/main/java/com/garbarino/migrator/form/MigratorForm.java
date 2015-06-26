package com.garbarino.migrator.form;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.garbarino.migrator.manager.MigratorManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MigratorForm extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Resultado");
    private final JLabel lblResultado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MigratorForm frame = new MigratorForm();
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
	public MigratorForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(51, 99, 121, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnProcesar = new JButton("procesar");
		btnProcesar.setBounds(139, 29, 117, 25);
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar();
			}
		});
		contentPane.add(btnProcesar);
		
		lblResultado = new JLabel(".....");
		lblResultado.setForeground(Color.GREEN);
		lblResultado.setBounds(51, 144, 358, 15);
		contentPane.add(lblResultado);
	}
	private void procesar(){
		try{
			MigratorManager manager = new MigratorManager();
			manager.migrate(10);
			lblResultado.setText("Ok");
		}catch(Exception ex){
			System.out.println(ex.getCause());
			lblResultado.setText("Ha ocurrido un error");
		}
	}
}
