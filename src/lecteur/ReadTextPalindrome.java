package lecteur;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTextPalindrome extends TextReader {
	
	private BufferedReader buffer;


	public ReadTextPalindrome(BufferedReader buffer) {
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
		
		
		String palindrom = null;
		// Lire le fichier de façon palindromique
		for(int i = lines.size() -1; i >= 0; i--) {
			
			for(int j = lines.get(i).length() - 1; j >=0; j--) {
				
				palindrom += lines.get(i).charAt(j);
			}
			
			palindrom += "\n";
		}
		System.out.println(palindrom);
	}


	
	@Override
	public void ejectFile() {
		super.ejectFile();
	}
}
