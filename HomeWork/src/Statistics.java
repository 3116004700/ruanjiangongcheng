
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Statistics {
	int char_num;
	int word_num;
	int row_num;
	
	int charSum(String fName){
		int flag;
		int num = 0;
		File file = new File(fName);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("�ļ�·����������");
		}
		try {
		while((flag=fr.read())!=-1){
			num++;
		}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return num;
	}
	int wordSum(String fName){
		int num = 0;
		String str = null;
		String s = "\\d+.\\d+|\\w+";
		Pattern  pattern=Pattern.compile(s);  
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fName);
		} catch (FileNotFoundException e2) {
			// TODO �Զ����ɵ� catch ��
			e2.printStackTrace();
			System.out.println("�ļ�·����������");
		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			while((str = bufferedReader.readLine()) != null)
			{
				  Matcher  ma=pattern.matcher(str); 
				   while(ma.find()){ 
//					   	if(num%10 == 0 &&num>1)System.out.println();
//			            System.out.print(ma.group()+" ");  
			            num++;
			        }  
			}
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}      
		return num;
	}
	int rowSum(String fName){
		String flag = null;
		int num = 0;
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fName);
		} catch (FileNotFoundException e2) {
			// TODO �Զ����ɵ� catch ��
			e2.printStackTrace();
			System.out.println("�ļ�·����������");
		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			while((flag = bufferedReader.readLine()) != null)
			{
				num++;
			}
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		return num;
	}
}
