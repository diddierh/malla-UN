package mc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class Storage {
	//Esta clase se encarga de mantener actualizado el objeto Carrera y de guardar cada
	//vez que se hagan cambios en este.

	private static Storage instance;
	public static Storage getInstance() {
		if(instance == null) {
			instance = new Storage();
			return instance;
		}
		else {
			return instance;
		}
	}
	
	public Carrera loadCarrera() throws IOException, ClassNotFoundException{
		
		FileInputStream fin = new FileInputStream("archivo.txt");
		ObjectInputStream oin = new ObjectInputStream(fin);
		
		Carrera toReturn = (Carrera) oin.readObject();
		fin.close();
		oin.close();
		
		return toReturn;
	}
	
	public void saveCarrera(Carrera c) throws IOException {
		FileOutputStream fou = new FileOutputStream("archivo.txt");
		ObjectOutputStream oou = new ObjectOutputStream(fou);
		
		oou.writeObject(c);
		fou.close();
		oou.close();
	}
}
