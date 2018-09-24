package Com.software;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;



public class GetSymbol {
	static WriteStringToFile writeIO = new WriteStringToFile();
	public static char Get_Symbol() {
		Random random=new Random();
		char[] c= {'+','-','×','÷'};
		return c[random.nextInt(4)];
	}
	public static void main(String[] args) {
		System.out.println("请输入范围：");
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		System.out.println("请输入题目数：");
		int m=in.nextInt();
		String string=null;
		String string3=null;
		String[] strings1=new String[m];
		String[] strings2=new String[m];
		File file1 = new File("question.txt");
		File file2 = new File("answer.txt");
		file1.delete();
		file2.delete();
		for(int i=1;i<m+1;i++) {
			Random random=new Random();
			int c=random.nextInt(8);
			switch (c) {
			case 0:
				string="第"+i+"题:"+GetCalculation.Get_Calculation1(n);
				break;
			case 1:
				string="第"+i+"题:"+GetCalculation.Get_Calculation2(n);
				break;
			case 2:
				string="第"+i+"题:"+GetCalculation.Get_Calculation3(n);
				break;
			case 3:
				string="第"+i+"题:"+GetCalculation.Get_Calculation4(n);
				break;
			case 4:
				string="第"+i+"题:"+GetCalculation.Get_Calculation5(n);
				break;
			case 5:
				string="第"+i+"题:"+GetCalculation.Get_Calculation6(n);
				break;
			case 6:
				string="第"+i+"题:"+GetCalculation.Get_Calculation7(n);
				break;
			case 7:
				string="第"+i+"题:"+GetCalculation.Get_Calculation8(n);
				break;

			default:
				break;
			}
			String[] news=string.split(":|&");
			String stringa=news[0];
			String stringb=news[1];
			String stringc=news[2];
//			writeIO.clearFile("question.txt");
//			writeIO.clearFile("answer.txt");

			writeIO.writeToFile("question.txt",stringb);
			writeIO.writeToFile("question.txt","\n");
			writeIO.writeToFile("answer.txt",stringc);
			writeIO.writeToFile("answer.txt","\n");
//			System.out.println(stringa);
//			System.out.println(stringb);
//			System.out.println(stringc);
			
		}
		
		
	}
}
