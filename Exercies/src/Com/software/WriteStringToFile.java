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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//true��ʾ���ļ�ĩβ׷�� 
		try {
			fos.write(string.getBytes());
//			fos.write("\n".getBytes());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} 
		try {
			fos.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}


}
