package examen3;
import java.util.HashMap;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Lector {
	
	public void ejecutar(long id) {
		File file = new File("C:\\Users\\52733\\OneDrive\\Documentos\\programación\\emails.csv");
		FileReader fileReader;
		
		try {
			fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String myString;
			int[] sumas = new int[3002];
			HashMap<String, Integer> miMapa = new HashMap<>();	
			
			//modificar id
			String number = Long.toString(id);
			int length = number.length();
			String subString = number.substring(length-3,length);
			int idInicio = Integer.parseInt(subString);
			int idFinal=0;
			if(idInicio==0) {
				idFinal = 50;
			}else if(idInicio!=0) {
				idFinal = idInicio+49;
			}
			System.out.println(idInicio);
			System.out.print(idFinal);
			
			
			try {
				
			myString = bufReader.readLine();	
			String[] words = myString.split(",");
			
				
			for(int i=0; i<5172; i++) {
				
				myString = bufReader.readLine();
				String[] cantidades = myString.split(",");
				
				if(i>=idInicio-1 && i<idFinal) {
					
					for(int p=1; p<sumas.length; p++) {
						String a = cantidades[p];
						int q = Integer.parseInt(a);
						sumas[p] = sumas[p]+q;
						}
				}
			}
			
			//hacer mapa completo
			for(int i=1; i<words.length-1; i++) {
				miMapa.put(words[i], sumas[i]);
			}
			
			//crear archivo txt
			String name = id + ".txt";
			File writeFile = new File(name);
			FileWriter miFileWriter = new FileWriter(writeFile);
			PrintWriter miPrintWriter = new PrintWriter(miFileWriter);
			
			if (!writeFile.exists()) {
				try {
					writeFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			for(int i=1; i<miMapa.size()+1; i++) {
				miPrintWriter.print(words[i] + ", " + miMapa.get(words[i])+"\n");
			}
			
			miPrintWriter.close();
		

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
