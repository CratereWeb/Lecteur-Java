package lecteur;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadTextLinesBackwards extends TextReader {
	
	private BufferedReader buffer;
	
	public ReadTextLinesBackwards(BufferedReader buffer) {
		super(buffer);
	}
	
	public void workFile() {
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			// Stocker les lignes du fichier dans l'ordre, dans un tableau
			while((line = this.buffer.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			System.err.println("Impossible de lire le fichier.");
		}
		
		// Lire le fichier ligne par ligne dans l'ordre inverse
		for(int i = lines.size() - 1; i >= 0; i--) {
			System.out.println(lines.get(i));
		}
		
	}
	

	
	@Override
	public void ejectFile() {
		super.ejectFile();
	};
}
