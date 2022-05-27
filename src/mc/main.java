package mc;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.print.attribute.standard.OutputDeviceAssigned;

import mc.Materia.Componente;
import vista.MenuPrincipal;

public class main {
	public static final int CREDITS_PER_SEMESTER = 20;
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Materia> lista = new ArrayList<Materia>();
		Carrera ingElectronica = new Carrera(lista);
		
// 		Se crean instancias de la clase Materias  con la información básica		
//		Materia cdf = new Materia("calculo diferencial", true, 4, Componente.Fundamentacion, 1);
//		Materia cit = new Materia("calculo integral", true, 4, Componente.Fundamentacion, 2);
//		Materia cvv = new Materia("calculo en varias variables", true, 4, Componente.Fundamentacion, 3);
		
//		Se pueden crear instancias con subclases anonimas que permiten especificar requisitos especiales como avance en disciplinar o 
//		avance general
//		Materia tpi = new Materia("taller de proyectos interdisciplinarios", false, 3, Componente.Disciplinar, 9, new VerificadorPrerrequisitos() {
//			@Override
//			public boolean canBeTaken() {
//				return ingElectronica.approvedCredits() >= 121;//alta cohesion, implementacion temporal
//			}
//		});
		
//		Es necesario añadir los prerrequisitos manualmente con el fin de armar el árbol de materias 
//		cit.addDependant(igc);
//		cit.addDependant(cvv);
//		cit.addDependant(ecd);
//		cit.addDependant(fs2);
//
//		cdf.addDependant(pro);
//		cdf.addDependant(fs1);
//		cdf.addDependant(cit);
//		cdf.addDependant(alg);

//		Es necesario añadir las materias a la lista de materias de la carrera
//		lista.add(cdf);
//		lista.add(cit);
//		lista.add(cvv);

		
		
		Storage.getInstance().saveCarrera(ingElectronica);
		
//		ingElectronica.generateView();
		
		try {
//			System.out.println(ingElectronica.armaHorario(27));
			ingElectronica.simularCarrera(CREDITS_PER_SEMESTER);
//			Storage almacenamiento = Storage.getInstance(); 
//			Carrera test = almacenamiento.loadCarrera();
			//MenuPrincipal menu = new MenuPrincipal();
//			test.generateView();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ingElectronica.showPercentage();
	}
}
