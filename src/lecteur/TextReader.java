package lecteur;


import java.io.BufferedReader;
import java.io.IOException;

abstract class TextReader implements Interface {

	protected BufferedReader buffer;
	
	
	public TextReader(BufferedReader buffer) {
		this.buffer = buffer;
	}
	
	
	public abstract void workFile();
	

	
	public void ejectFile() {
		try {
			this.buffer.close();			
		} catch (IOException e) {
			System.err.println("Impossible de fermer le fichier.");
		}
	}
		
	
}
