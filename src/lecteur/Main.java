package lecteur;


import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		HashMap<String, String> fileMeta = fileMenu(sc);
		System.out.println(Arrays.asList(fileMeta));
		
		File file = new File(fileMeta.get("path")); // désigner le fichier
		BufferedReader buffer = null; // initialiser un buffer
		

		
		// Ayant défini TextReader comme une classe abstraite, on ne l'instancie pas
		
		// On demande d'abord à l'utilisateur quelle action il veut réaliser sur le fichier
		String action = actionMenu(fileMeta.get("name"), sc);
		
		try {
			
			FileReader reader = new FileReader(file);
			buffer = new BufferedReader(reader);
			TextReader textReader = null;
			
			// Puis on instancie la classe correspondant à l'action voulue par l'utilisateur
			switch(action) {
				case "read-forward": textReader = new ReadTextForwards(buffer); break;
				case "read-lines-backwards": textReader = new ReadTextLinesBackwards(buffer);break;
				case "read-in-palindrome": textReader = new ReadTextPalindrome(buffer); break;
			}
			
			// Enfin, on affiche le résultat de l'action
			textReader.workFile();
			
			
			textReader.ejectFile();
			
			
		
		} catch (FileNotFoundException e){
			System.err.printf("Le fichier %s n'existe pas ", file.toString());
		}
		
		sc.close();
		
		
	}

	
	private static HashMap<String, String> fileMenu(Scanner sc) {
		
		HashMap<String, String> fileMeta = new HashMap<String, String>();
		File baseDir = new File("./files");
		String[] files = baseDir.list();
		
		System.out.println(Arrays.toString(files));
		
		
		// Demander à l'utilisateur le type de fichier qu'il veut charger
		System.out.println("Quel type de fichier voulez-vous lire ?" + "\n" 
				+ "1 - texte"
				// + "2 - image"
				//+ "3 - audio"
				);
		String fileType = null;
		ArrayList<String> filetypeFormats = new ArrayList<String>();
		switch(sc.next().charAt(0)) {
			case '1': fileType = "texte"; Collections.addAll(filetypeFormats, ".txt"); break;
			case '2': fileType = "image"; Collections.addAll(filetypeFormats, ".png", ".jpg", ".gif"); break;
			case '3': fileType = "audio"; Collections.addAll(filetypeFormats, ".mp3", ".wav"); break;
		}
		
		System.out.println(fileType);
		System.out.println(filetypeFormats);
		
		
		
		// Demander à l'utilisateur le fichier qu'il souhaite charger
		System.out.printf("Quel fichier %s voulez-vous lire ?\n", fileType);
		String fileFormat = null;
		String fileName = null;
		
		for(int i = 0; i < files.length; i++) {

			//System.out.println(fileName);
			//System.out.println(fileFormat);
			String[] fileFullName = files[i].split("[.]");
			
			fileName = fileFullName[0];
			fileFormat = fileFullName[1];
			
			if(files[i].endsWith("." + fileFormat) && filetypeFormats.contains("." + fileFormat)) {
				
				//System.out.println(Arrays.toString(fileFullName));
				System.out.println(i + " : " + files[i]);
			}
			
		}
		int chosenFileIndex = sc.nextInt();
		
		String filePath = "./files/" + files[chosenFileIndex];
		fileName = files[chosenFileIndex].split("[.]")[0];
		fileFormat = files[chosenFileIndex].split("[.]")[1];
		
		
		fileMeta.put("type", fileType);
		fileMeta.put("format", fileFormat);
		fileMeta.put("name", fileName);
		fileMeta.put("path", filePath);
		
		return fileMeta;
	}
	

	private static String actionMenu(String fileName, Scanner sc) {
		
		
		System.out.println("Que voulez-vous faire du fichier " + fileName + " ?\n"
				+ "1 - Le lire" + "\n"
				+ "2 - Le lire en inversant l'ordre des lignes" + "\n"
				+ "3 - Le lire de façon palindromique (en inversant l'ordre des caractères)" + "\n"
				+ "\n"
				+ "N - Charger un autre fichier" + "\n\n");
		
		
		//String userChoice = null;
		
		
		switch( sc.next().charAt(0) ) {
			case '1': return "read-forward";
			case '2': return "read-lines-backwards";
			case '3': return "read-in-palindrome";
			case 'N': return "change-file";
			default: return "";
		}
		
		
		//return userChoice;
		
	}
	
	
	
}