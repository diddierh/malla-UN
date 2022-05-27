package mc;

import java.io.Serializable;
import java.util.ArrayList;

public class VerificadorArbolPrerrequisitos implements VerificadorPrerrequisitos{
	ArrayList<Materia> requiresOf;
	
	public boolean canBeTaken() {
		for(Materia m: requiresOf) {
			if(!m.getAprobada())
				return false;
		}
		return true;
	}
	
	public VerificadorArbolPrerrequisitos(ArrayList<Materia> prereqs) {
		this.requiresOf = prereqs;
	}
}
