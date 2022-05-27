package mc;
import java.util.List;
import java.util.ArrayList;

public class Semestre {
	private int creditos;
	private List<Materia> materias = new ArrayList<Materia>();
	
	public Semestre(int creditos) throws Exception{
		if(creditos < 1) {
			throw new Exception("Se debe ver al menos un crédito durante el semestre");
		}
		this.creditos = creditos;
	}
	
	public void addMateria(Materia m) throws Exception {
		if(creditosTaken() + m.getCreditos() <= this.creditos && m.canBeTaken()) {
			materias.add(m);
		}
		else {
			throw new Exception("Esta materia supera el número de créditos para el semestre o no cumple con los prerequisitos");
		}
	}
	
	public int creditosTaken() {
		int creditos = 0;
		for(Materia m : materias) {
			creditos += m.getCreditos();
		}
		return creditos;
	}
	
	public int availableCreditsInscription() {
		return creditos - creditosTaken();
	}
	
	public void approveAll() {
		for(Materia m : materias) {
			m.approve();
		}
	}
	
	public void reprobeAll() {
		for(Materia m : materias) {
			m.reprobe();
		}
	}
	
	public String toString() {
		String toReturn = "";
		toReturn += "\nMaterias a tomar\t(semestres,dependientes,créditos)\n";
		for(Materia m: materias) {
			toReturn += m + "\n";
		}
		toReturn += "Total de créditos " + this.creditosTaken()+ "\n";
		return toReturn;
	}
	
	public boolean emptySemester(){
		return materias.isEmpty();
	}
}
