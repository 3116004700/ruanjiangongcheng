package Com.software;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Check {
	WriteStringToFile ws = new WriteStringToFile();
	void checkAnswer(File exercises,File answers) throws IOException{
		
		BufferedReader br_e = new BufferedReader(new FileReader(exercises));
		BufferedReader br_a = new BufferedReader(new FileReader(answers));
		
		String line_e = null;
		String line_a = null;
		File fileGrade = new File("Grade.txt");
		int numTrue = 0;
		int numFalse = 0;
		if(fileGrade.exists())fileGrade.delete();
		while((line_e = br_e.readLine()) != null && (line_a = br_a.readLine()) != null){
			if(!line_e.equals(line_a)){
				ws.writeToFile("Grade.txt", line_e);
				ws.writeToFile("Grade.txt", "\n");
//				System.out.println(line_e);
				numFalse++;
			}else{
				numTrue++;
			}
		}
		br_e.close();
		br_a.close();
		String resultCheck = "一共做错"+numFalse+"道,做对"+numTrue+"道。";
//		System.out.println("共有"+num+"道错题");
		ws.writeToFile("Grade.txt", resultCheck);
	}
}
