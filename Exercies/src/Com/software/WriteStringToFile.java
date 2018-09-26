package Com.software;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteStringToFile {
	public void writeToFile(String filePath,String string){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath,true);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//true表示在文件末尾追加 
		try {
			fos.write(string.getBytes());
//			fos.write("\n".getBytes());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
		try {
			fos.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}


}
