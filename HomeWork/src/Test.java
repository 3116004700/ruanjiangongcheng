import java.util.Scanner;

class Test {
	Scanner scanner = new Scanner(System.in);
	Statistics sta = new Statistics();
	
	void choose(){
		System.out.println("�������ļ��������˳�-exit��");
		String f_name = scanner.nextLine();
		if(f_name.equals("exit")){
			System.out.println("�˳��ɹ���");
			return;
		}
	
		System.out.println("��ѡ��������ݣ��ַ�����-c��,��������-w����������-l��");
		System.out.println("�˳���exit��");
		String choose = scanner.nextLine();
		if(choose.equals("-c")){
			sta.char_num = sta.charSum(f_name);
			if(sta.char_num == -1){
				choose();
			}else{
				System.out.println("�ַ���:"+sta.char_num);
				choose();
			}
		}else if(choose.equals("-w")){
			sta.word_num = sta.wordSum(f_name);
			if(sta.word_num == -1){
				choose();
			}else{
				System.out.println("������:"+sta.word_num);
				choose();
			}
		}else if(choose.equals("-l")){
			sta.row_num = sta.rowSum(f_name);
			if(sta.row_num == -1){
				choose();
			}else{
				System.out.println("����:"+sta.row_num);
				choose();
			}
		}else if(choose.equals("exit")){
			System.out.println("�˳��ɹ���");
		}else{
			System.out.println("�����������������롣");
			choose();
		}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test test = new Test();
		test.choose();
	}
}