
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Statistics {
	int char_num;
	int word_num;
	int row_num;
	boolean on_off =true;
	int charSum(String fName){
		int flag;
		int num = 0;
		on_off = true;
		File file = new File(fName);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
			System.out.println("文件路径输入有误");
			on_off = false;
		}
		if(on_off){
			try {
			while((flag=fr.read())!=-1){
				num++;
			}
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return num;
		}else{
			return -1;
		}
	}
	int wordSum(String fName){
		on_off = true;
		int num = 0;
		String str = null;
		String s = "\\d+.\\d+|\\w+";
		Pattern  pattern=Pattern.compile(s);  
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fName);
		} catch (FileNotFoundException e2) {
			// TODO 自动生成的 catch 块
			//e2.printStackTrace();
			System.out.println("文件路径输入有误");
			on_off = false;
		}
		if(on_off){
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
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			} 
			return num;
		}else{
			return -1;
		}
		
	}
	int rowSum(String fName){
		on_off = true;
		String flag = null;
		int num = 0;
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fName);
		} catch (FileNotFoundException e2) {
			// TODO 自动生成的 catch 块
			//e2.printStackTrace();
			System.out.println("文件路径输入有误");
			on_off = false;
		}
		if(on_off){
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			try {
				while((flag = bufferedReader.readLine()) != null)
				{
					num++;
				}
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			return num;
		}else{
			return -1;
		}
	}
}
