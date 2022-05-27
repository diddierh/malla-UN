package vista;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPrincipal extends JFrame{
	private JButton verAprobadas = new JButton("Ver asignaturas aprobadas");
	private JButton simularSemestres =  new JButton("Simular semestres");
	private JButton establecerCreditos =  new JButton("Establecer número de créditos a tomar por semestre");
	
	public MenuPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		
		this.getContentPane().add(verAprobadas);
		verAprobadas.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.getContentPane().add(simularSemestres);
		simularSemestres.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.getContentPane().add(establecerCreditos);
		establecerCreditos.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.pack();
		this.setVisible(true);
	}
}
