package Com.software;

public class Getnum {
	public static int Get_num(int m) {
		return (int) (Math.random()*(m-1)+1);
		
	}
	
	public static String Get_Frac(int m) {
		
		int a=(int) (Math.random()*2*m)+2;//·Ö×Ó
		int b=(int) (Math.random()*m)+2;//·ÖÄ¸
		int x=a;
		int y=b;
		int t=0;
		while(b!=0) {
			t=b;
			b=a%b;
			a=t;
		}
		if (a==1) {
			if(x/y==0) {
				return x+"/"+y;
			}
			else {
				return x/y+"'"+x%y+"/"+y;
			}
			
		}
		else
			return Get_Frac(m);
	}
}
