package com.garbarino.migrator.form;

import java.awt.EventQueue;

import javax.print.attribute.standard.SheetCollate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.garbarino.migrator.context.Context;
import com.garbarino.migrator.enums.ContextGenesis;
import com.garbarino.migrator.enums.SchemaBoe;
import com.garbarino.migrator.manager.MigratorManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class MigratorForm extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Resultado");
    private final JLabel lblResultado;
    private JTextField txtRegistro;
    private JComboBox cmbBoe;
    private JLabel lblEsquemaBoe;
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
		lblNewLabel.setBounds(25, 207, 121, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnProcesar = new JButton("procesar");
		btnProcesar.setBounds(173, 159, 117, 25);
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
		
		txtRegistro = new JTextField();
		txtRegistro.setText("100");
		txtRegistro.setBounds(218, 35, 191, 19);
		contentPane.add(txtRegistro);
		txtRegistro.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Registros");
		lblNewLabel_1.setBounds(61, 37, 98, 15);
		contentPane.add(lblNewLabel_1);
		
		cmbBoe = new JComboBox(SchemaBoe.values());
		cmbBoe.setBounds(173, 77, 236, 24);
		contentPane.add(cmbBoe);
		
		lblEsquemaBoe = new JLabel("esquema boe");
		lblEsquemaBoe.setBounds(61, 82, 155, 15);
		contentPane.add(lblEsquemaBoe);
	}
	private void procesar(){
		try{

			SchemaBoe boe = (SchemaBoe) cmbBoe.getSelectedItem();
			
			Context.getInstance().setContext(boe);
			Context.getInstance().changeContext();
			
			MigratorManager manager = new MigratorManager(getRows());
			manager.migrate();


			lblResultado.setText("Ok");
		}catch(Exception ex){
			System.out.println(ex.getCause());
			lblResultado.setText("Ha ocurrido un error");
		}
	}
	
	private Integer getRows(){
		Integer row=0;
		
		try{
			row = Integer.valueOf(txtRegistro.getText());
		}catch(Exception ex){
			
		}
		
		return row;
		
	}
}
