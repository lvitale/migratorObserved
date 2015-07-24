package com.garbarino.migrator.form;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMigrator = new JButton("Migrador");
		btnMigrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMigratorForm();
			}
		});
		btnMigrator.setBounds(52, 47, 226, 25);
		contentPane.add(btnMigrator);
		
		JButton btnTesteoModuloObservados = new JButton("Testeo modulo observados");
		btnTesteoModuloObservados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTestBoeForm();
			}
		});
		btnTesteoModuloObservados.setBounds(52, 96, 226, 25);
		contentPane.add(btnTesteoModuloObservados);
		
		
		
	}
	
	private void showMigratorForm(){
		MigratorForm form = new MigratorForm();
		form.setVisible(true);
		this.dispose();
	}
	private void showTestBoeForm(){
		BoeObservedForm form = new BoeObservedForm();
		form.setVisible(true);
		this.dispose();
	}
}
