import java.util.Scanner;

class test {
	Scanner scanner = new Scanner(System.in);
	Statistics sta = new Statistics();
	
	void choose(){
		System.out.println("请输入文件名：（退出-exit）");
		String f_name = scanner.nextLine();
		if(f_name.equals("exit")){
			System.out.println("退出成功。");
			return;
		}
	
		System.out.println("请选择输出内容：字符数（-c）,单词数（-w），行数（-r）");
		System.out.println("退出（exit）");
		String choose = scanner.nextLine();
		if(choose.equals("-c")){
			sta.char_num = sta.charSum(f_name);
			System.out.println("字符数:"+sta.char_num);
			choose();
		}else if(choose.equals("-w")){
			sta.word_num = sta.wordSum(f_name);
			System.out.println("单词数:"+sta.word_num);
			choose();
		}else if(choose.equals("-r")){
			sta.row_num = sta.rowSum(f_name);
			System.out.println("行数:"+sta.row_num);
			choose();
		}else if(choose.equals("exit")){
			System.out.println("退出成功。");
		}else{
			System.out.println("输入有误，请重新输入。");
			choose();
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		test test = new test();
		test.choose();
	}
}