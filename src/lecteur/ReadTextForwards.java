package lecteur;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadTextForwards extends TextReader {

	private BufferedReader buffer;
	
	
	public ReadTextForwards(BufferedReader buffer) {
		super(buffer);
	}
	
	
	public void workFile() {
		String line;
		try {
			// Afficher les lignes du buffer dans l'ordre
			while((line = this.buffer.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Impossible de lire le fichier.");
		}
		
	}
	

	
	@Override
	public void ejectFile() {
		super.ejectFile();
	};
}
