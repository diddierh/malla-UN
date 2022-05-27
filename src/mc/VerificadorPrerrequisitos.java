package mc;

import java.io.Serializable;

public interface VerificadorPrerrequisitos extends Serializable {
//Esta interfaz define la api de los verificadores de cada asignatura
//sus clases derivadas serán clases anonimas definidas en la instanciacion de la materia para los
//casos de TPI y trabajo de grado para las demás será una clase previamente definida
	public boolean canBeTaken();
}
