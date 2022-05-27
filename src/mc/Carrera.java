package mc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mc.Materia.Componente;
import vista.EditorMaterias;

public class Carrera implements Serializable{
	private int creditos = 184;
	private ArrayList<Materia> materias;
	public Carrera(ArrayList<Materia> pensum) {
		this.materias = pensum;
	}
	
	public List<Semestre> simularCarrera(int creditos) {
		Semestre nextSemester;
		int semester = 1;
		
		List<Semestre> notApprovedYet = new ArrayList<Semestre>();
		//las materias en este ArrayList se aprobaran temporalmente
		//para simular varios semestres, sin embargo deben reprobarse al final
		//para manterner la consistencia de los datos.
		
		try {
			do {		
				nextSemester = this.armaHorario(creditos);
				nextSemester.approveAll();
				notApprovedYet.add(nextSemester);
				
				if(!nextSemester.emptySemester()) {
					System.out.println("SEMESTRE " + semester + "\n" + nextSemester);
					semester++;
				}
			}
			while(!nextSemester.emptySemester());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Semestre s: notApprovedYet){
		//se reprueban las materias aprobadas para la simulación
			s.reprobeAll();
		}
		return notApprovedYet;
	}
	
	
	public Semestre armaHorario(int creditos) throws Exception {
		materias.sort(new MateriaComparator());
		try {
			Semestre proximo = new Semestre(creditos);
			
			
			for(Materia m : materias) {
				if(!m.getAprobada() && m.canBeTaken() && m.getCreditos() <= proximo.availableCreditsInscription() )
				{
					proximo.addMateria(m);
				}
			}
			return proximo;
		}
		catch(Exception e) {
			throw new Exception();
		}
	}
	
	public void showApproved() {
		for (Materia i : materias) {
			if(i.getAprobada())
				System.out.println(i);
		}
	}
	
	public void showPendingSorted() {
		materias.sort(new MateriaComparator());
		for(Materia m: materias) {
		//if(!m.getAprobada() && m.canBeTaken())
				System.out.println(m);
		}
	}
	
	public void generateView() {
		EditorMaterias e = new EditorMaterias(this.materias);
	}
	
	public void showPercentage() {
		int approved = 0;
		int total = 0;
		for(Materia m : materias) {
			if(m.getAprobada()) {
				approved += m.getCreditos();
			}
			total += m.getCreditos();
		}
		System.out.println("Porcentaje aprobado " + approved*1.0/total*100.0);
		System.out.println("Total creditos " + total + " Total aprobados " + approved);
	}
	
	public int approvedCredits() {
		int approved = 0;
		for(Materia m : materias) {
			if(m.getAprobada()) {
				approved += m.getCreditos();
			}
		}
		return approved;
	}
	
	public int approvedCredits(Componente c) {
		int approved = 0;
		for(Materia m : materias) {
			if(m.getAprobada() && m.getComponente() == c) {
				approved += m.getCreditos();
			}
		}
		return approved;
	}
}
