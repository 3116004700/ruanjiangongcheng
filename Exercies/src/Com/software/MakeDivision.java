package Com.software;

public class MakeDivision {
	public static int Get_max(int a,int b) {
		int temp;
		if(a < b){
			temp = a;
		    a = b;
		    b = temp;
		        
		    }
		while(a%b != 0){
		    temp = a%b;
		    a = b;
		    b = temp;
		    }
		 return b;
	}
	public static int Get_min(int a,int b) {
		int c=MakeDivision.Get_max(a, b);
		return a*b/c;
	}
	public static float Get_float(String a) {
		if (a.contains("'")) {
			String[] string1=a.split("'|/");
			int a1=Integer.parseInt(string1[0]);
			int a2=Integer.parseInt(string1[1]);
			int a3=Integer.parseInt(string1[2]);
			return a1+(float)a2/a3;
		}
		else{
			String[] string1=a.split("/");
			int a1=Integer.parseInt(string1[0]);
			int a2=Integer.parseInt(string1[1]);
			return (float)a1/a2;
		}
	}

}
