package mc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

public class Materia implements Serializable {
	private String nombre;
	private ArrayList<Materia> requirementOf;//las que dependen de esta
	private ArrayList<Materia> requiresOf;//las necesarias para ver esta
	private boolean aprobada = false;//indica si la materia ya se aprobo
	private int creditos;
	private Componente comp;
	private VerificadorPrerrequisitos verificador;
	private int suggestedSemester;
	
	public enum Componente{
		Disciplinar, Fundamentacion, Electiva
	}
	
	public Materia(String n, boolean a, int c, Componente co, int s) {
		this.nombre = n;
		this.aprobada = a;
		this.creditos = c;
		this.comp = co;
		this.suggestedSemester = s;
		
		requirementOf = new ArrayList<Materia>();
		requiresOf = new ArrayList<Materia>();
		this.verificador = new VerificadorArbolPrerrequisitos(requiresOf);
	}
	
	public Materia(String n, boolean a, int c, Componente co, int s, VerificadorPrerrequisitos verificador) {
		this(n, a, c, co, s);
		this.verificador =  verificador;
	}
	
	public boolean getAprobada() {
		return aprobada;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public int getPeso() {//@TODO
		return this.getDependants().size();
	}
	
	public Set<Materia> getDependants(){
		if(requirementOf.isEmpty()) {
			return new HashSet<Materia>();
		}
		else {
			HashSet <Materia> toReturn = new HashSet<Materia>();
			for(Materia m: requirementOf) {
				toReturn.add(m);
				toReturn.addAll(m.getDependants());
			}
			return toReturn;
		}
	}
		
	public int getDepth(){
		if(requirementOf.isEmpty()){
			return 1;
		}
		else {
			int maxDepth=0;
			for(Materia m : requirementOf){
				maxDepth = m.getDepth() > maxDepth ? m.getDepth() : maxDepth;
				
			}
			return 1 + maxDepth;
		}
	}
	
	public void printChildren() {
		printChildren(0);
	}
	
	private void printChildren(int ident) {
		//String tabs = new String(new char[ident]).replace("\0","\t");
		for(int i=0; i < ident; i++) {
			System.out.print("\t");
		}
		System.out.println(this);
		for(Materia i: requirementOf) {
			i.printChildren(ident+1);
		}
	}
	
	public void addDependant(Materia m) {
		requirementOf.add(m);
		m.requiresOf.add(this);
	}
	
	public boolean canBeTaken() {
		return verificador.canBeTaken();
	}
	
	public void approve() {
		this.aprobada = true;
	}
	
	public void reprobe() {
		this.aprobada = false;
	}
	
	public String getName() {
		return this.nombre;
	}
	
	public Componente getComponente() {
		return this.comp;
	}
	
	public int getSemester() {
		return suggestedSemester;
	}
	
	//@Override
	public String toString() {
		return nombre + "\t(" + this.getDepth() + "," + this.getPeso() + "," + this.getCreditos() + ")";
	}
	
}
