package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import mc.Materia;
import mc.Semestre;

public class EditorMaterias extends JFrame{
	private ArrayList<Materia> lista;
	private ArrayList<JPanel> containers;
	
	public EditorMaterias(ArrayList<Materia> l) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.lista = l;
		
		Container pane = this.getContentPane();
		JPanel header = new JPanel();	
		header.setLayout(new GridBagLayout());
		
		JLabel m = new JLabel("Materia");
		JLabel a = new JLabel("Aprobada");
		JLabel c = new JLabel("Creditos");
		
		GridBagConstraints constraint =  new GridBagConstraints();
		constraint.weightx=.5;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx=0;
		constraint.gridy=0;
		constraint.gridwidth=3;
		header.add(m, constraint);
		
		constraint.gridwidth=1;
		constraint.gridx=3;
		header.add(a, constraint);
		
		constraint.gridx=4;
		header.add(c, constraint);
		
		pane.add(header, BorderLayout.NORTH);
		pane.add(new JSeparator(), BorderLayout.CENTER);
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(0, 3));
		for(Materia mm : lista) {
			listPanel.add(new JLabel(mm.getName()));
			listPanel.add(new JCheckBox("", mm.getAprobada()));
			listPanel.add(new JTextField(mm.getCreditos()));
//			listPanel.add(new JLabel(Boolean.toString(mm.getAprobada())));
//			listPanel.add(new JLabel(Integer.toString(mm.getCreditos())));
		}
		pane.add(listPanel, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
	}
}
