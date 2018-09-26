package Com.software;



public class GetResult {
	public static int Num_add_Num(int a,int b) {
		return a+b;
	}
	public static int Num_sub_Num(int a,int b) {
		return a-b;
	}
	public static int Num_mul_Num(int a,int b) {
		return a*b;
	}
	public static String Num_div_Num(int a,int b) {
		if(a%b==0) {
			int c=a/b;
			return String.valueOf(c);
		}
		else {
			int c=MakeDivision.Get_max(a, b);
			if(c==1) {
				if(a<b) {
					return a+"/"+b;
				}
				else {
					return a/b+"'"+a%b+"/"+b;
				}
			}
			else {
				int x=a/c;
				int y=b/c;
				if(x<y) {
					return x+"/"+y;
				}
				else {
					return x/y+"'"+x%y+"/"+y;
				}
			}
		}
	}
	
	public static String Num_add_Fra(int a,String b) {
		String result=null;
		if(b.contains("'")) {
			String[] news=b.split("'");
			int a1=Integer.parseInt(news[0]);
			String a2=news[1];
			int p=a+a1;
			result=p+"'"+a2;
		}
		else {
			result=a+"'"+b;
		}
		return result;
	}
	public static String Num_sub_Fra(int a,String b) {
		String result=null;
		if(b.contains("'")) {
			String[] news=b.split("'|/");
			int a1=Integer.parseInt(news[0]);
			int a2=Integer.parseInt(news[1]);
			int a3=Integer.parseInt(news[2]);
			int t=a-a1-1;
			int p=a3-a2;
			if(t==0) {
				result=p+"/"+a3;
			}
			else {
				result=t+"'"+p+"/"+a3;
			}
			
		}
		else {
			String[] news=b.split("/");
			int a1=Integer.parseInt(news[0]);
			int a2=Integer.parseInt(news[1]);
			int t=a-1;
			int n=a2-a1;
			if (t==0) {
				result=n+"/"+a2;
			}
			else {
				result=t+"'"+n+"/"+a2;
			}
		}
		return result;
	}
	public static String Num_mul_Fra(int a,String b) {
		String result=null;
		if(b.contains("'")) {
			String[] news=b.split("'|/");
			int a1=Integer.parseInt(news[0]);
			int a2=Integer.parseInt(news[1]);
			int a3=Integer.parseInt(news[2]);
			int p=a*a1+a*a2/a3;
			int k=a*a2%a3;
			int c=MakeDivision.Get_max(a, a3);
			if(c==1) {
				if(p==0) {
					result=k+"/"+a3;
				}
				else if (p!=0) {
					result=p+"'"+k+"/"+a3;
				}
				
			}
			else {
				k=k/c;
				a3=a3/c;
				if(a3==1) {
					result=String.valueOf(a*a1+a2);
				}
				else {
					if (p==0) {
						result=k+"/"+a3;
					}
					else if (p!=0) {
						result=p+"'"+k+"/"+a3;
					}
					
				}
			}
			
		}
		else {
			String[] news=b.split("/");
			int a1=Integer.parseInt(news[0]);
			int a2=Integer.parseInt(news[1]);
			int p=a*a1/a2;
			int k=a*a1%a2;
			if (MakeDivision.Get_max(a, a2)==1) {
				if(p==0) {
					result=k+"/"+a2;
				}
				else if(p!=0){
					result=p+"'"+k+"/"+a2;
				}
			}
			else {
				int c=MakeDivision.Get_max(a, a2);
				a=a/c;
				a2=a2/c;
				if(a2==1) {
					result=String.valueOf(a*a1);
				}
				else {
					p=+a*a1/a2;
					k=a*a1%a2;
					if (p==0) {
						result=k+"/"+a2;
					}
					else if (p!=0) {
						result=p+"'"+k+"/"+a2;
					}
					
				}
			}
		}
		return result;
	}
	public static String Num_div_Fra(int a,String b) {
		if(b.contains("'")) {
			String[] news=b.split("'|/");
			int a1=Integer.parseInt(news[0]);
			int a2=Integer.parseInt(news[1]);
			int a3=Integer.parseInt(news[2]);
			int p=a1*a3+a2;
			String c=String.valueOf(a3)+"/"+String.valueOf(p);
			return GetResult.Num_mul_Fra(a, c);
		}
		else {
			String[] news=b.split("/");
			int a1=Integer.parseInt(news[0]);
			int a2=Integer.parseInt(news[1]);
			String c=String.valueOf(a2/a1)+"'"+String.valueOf(a2%a1)+"/"+a1;
			return GetResult.Num_mul_Fra(a, c);
		}
	}
	public static String Fra_add_Fra(String a,String b) {
		String result=null;
		if(a.contains("'")&&b.contains("'")) {
			String[] news1=a.split("'|/");
			String[] news2=b.split("'|/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int a3=Integer.parseInt(news1[2]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int b3=Integer.parseInt(news2[2]);
			int c1=a1+b1;
			int p=MakeDivision.Get_min(a3, b3);
			int c2=a2*p/a3+b2*p/b3;
			int k=MakeDivision.Get_max(p, c2);
			if(c2<p) {
				c2=c2/k;
				p=p/k;
				result=c1+"'"+c2+"/"+p;
				
			}
			if(c2==p) {
				int t=c1+1;
				result=String.valueOf(t);
			}
			else if(c2>p){
				int t=c1+c2/p;
				if(k==1) {
					int n=c2%p;
					result=t+"'"+n+"/"+p;	
				}
				else {
					c2=c2/k;
					p=p/k;
					int n=c2%p;
					result=t+"'"+n+"/"+p;
				}
			}
		}
		if(!a.contains("'")&&!b.contains("'")) {
			String[] news1=a.split("/");
			String[] news2=b.split("/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int p=MakeDivision.Get_min(a2, b2);
			int c1=a1*p/a2+b1*p/b2;
			int k=MakeDivision.Get_max(c1, p);
			if(c1<p) {
				if(k==1) {
					result=c1+"/"+p;
				}
				else {
					c1=c1/k;
					p=p/k;
					result=c1+"/"+p;
				}
			}
			if(c1==p) {
				result=String.valueOf(1);
			}
			else if(c1>p){
				if (k==1) {
					int n=c1%p;
					result=String.valueOf(1)+"'"+n+"/"+p;
				}
				else {
					c1=c1/k;
					p=p/k;
					int n=c1%p;
					result=String.valueOf(1)+"'"+n+"/"+p;
				}
				
			}
		}
		if(a.contains("'")&&!b.contains("'")) {
			String[] news1=a.split("'|/");
			String[] news2=b.split("/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int a3=Integer.parseInt(news1[2]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int p=MakeDivision.Get_min(a3, b2);
			int c1=a2*p/a3+b1*p/b2;
			int k=MakeDivision.Get_max(c1,p);
			if(c1<p) {
				if(k==1) {
					result=String.valueOf(a1)+"'"+c1+"/"+p;
				}
				else {
					c1=c1/k;
					p=p/k;
					result=String.valueOf(a1)+"'"+c1+"/"+p;
				}
			}
			if(c1==p) {
				int t=a1+1;
				result=String.valueOf(t);
			}
			else if(c1>p){
				if(k==1) {
					int t=a1+c1/p;
					int n=c1%p;
					result=String.valueOf(t)+"'"+n+"/"+p;
				}
				else {
					int t=a1+c1/p;
					c1=c1/k;
					p=p/k;
					int n=c1%p;
					result=String.valueOf(t)+"'"+n+"/"+p;
				}
			}
		}
		else if(!a.contains("'")&&b.contains("'")){
			String[] news1=a.split("/");
			String[] news2=b.split("'|/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int b3=Integer.parseInt(news2[2]);
			int p=MakeDivision.Get_min(a2, b3);
			int c1=a1*p/a2+b2*p/b3;
			int k=MakeDivision.Get_max(c1, p);
			if(c1<p) {
				if(k==1) {
					result=String.valueOf(b1)+"'"+c1+"/"+p;
				}
				else {
					c1=c1/k;
					p=p/k;
					result=String.valueOf(b1)+"'"+c1+"/"+p;
				}
			}
			if(c1==p) {
				int t=b1+1;
				result=String.valueOf(t);
			}
			else {
				if (k==1) {
					int t=b1+c1/p;
					int n=c1%p;
					result=String.valueOf(t)+"'"+n+"/"+p;
				}
				else {
					int t=b1+c1/p;
					c1=c1/k;
					p=p/k;
					int n=c1%p;
					result=String.valueOf(t)+"'"+n+"/"+p;
				}
			}

		}
		return result;
	}
	public static String Fra_sub_Fra(String a,String b) {
		String result=null;
		if (a.contains("'")&&b.contains("'")) {
			String[] news1=a.split("'|/");
			String[] news2=b.split("'|/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int a3=Integer.parseInt(news1[2]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int b3=Integer.parseInt(news2[2]);
			if((float)a2/a3<(float)b2/b3){
				int c1=a1-b1-1;
				int n=a2+a3;
				int p=MakeDivision.Get_min(a3, b3);
				int t=n*p/a3-b2*p/b3;
				int k=MakeDivision.Get_max(t,p);
				if(k==1) {
					if (c1!=0) {
						result=c1+"'"+t+"/"+p;
					}
					if (c1==0) {
						result=t+"/"+p;
					}
					
					
				}
				else {
					t=t/k;
					p=p/k;
					if(c1!=0) {
						result=c1+"'"+t+"/"+p;	
					}
					else {
						result=t+"/"+p;
					}
				}
			}
			if((float)a2/a3==(float)b2/b3) {
				int c1=a1-b1;
				result=String.valueOf(c1);
			}
			if((float)a2/a3>(float)b2/b3) {
				int c1=a1-b1;
				int p=MakeDivision.Get_min(a3, b3);
				int t=a2*p/a3-b2*p/b3;
				int k=MakeDivision.Get_max(t,p);
				if(k==1) {
					if(c1==0) {
						result=t+"/"+p;
					}
					if (c1!=0) {
						result=c1+"'"+t+"/"+p;
					}
					
				}
				else {
					t=t/k;
					p=p/k;
					if (c1==0) {
						result=t+"/"+p;
					}
					if(c1!=0) {
						result=c1+"'"+t+"/"+p;
					}
					
				}
			}
		}
		else if (a.contains("'")&&!b.contains("'")) {
			String[] news1=a.split("'|/");
			String[] news2=b.split("/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int a3=Integer.parseInt(news1[2]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			if((float)a2/a3<(float)b1/b2){
				int c1=a1-1;
				int n=a2+a3;
				int p=MakeDivision.Get_min(a3, b2);
				int t=n*p/a3-b1*p/b2;
				int k=MakeDivision.Get_max(t,p);
				if (k==1) {
					if(c1==0) {
						result=t+"/"+p;
					}
					else {
						result=c1+"'"+t+"/"+p;
					}
					
				}
				else {
					t=t/k;
					p=p/k;
					if (c1==0) {
						result=t+"/"+p;
					}
					else {
						result=c1+"'"+t+"/"+p;
					}
					
				}
			}
			if((float)a2/a3==(float)b1/b2) {
				result=String.valueOf(a1);
			}
			if((float)a2/a3>(float)b1/b2) {
				int p=MakeDivision.Get_min(a3, b2);
				int t=a2*p/a3-b1*p/b2;
				int k=MakeDivision.Get_max(t,p);
				if (k==1) {
					result=a1+"'"+t+"/"+p;
				}
				else {
					t=t/k;
					p=p/k;
					result=a1+"'"+t+"/"+p;
				}
			}
		}
		else if (!a.contains("'")&&!b.contains("'")){
			String[] news1=a.split("/");
			String[] news2=b.split("/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int c=MakeDivision.Get_min(a2, b2);
			int t=a1*c/a2-b1*c/b2;
			int k=MakeDivision.Get_max(t, c);
			t=t/k;
			c=c/k;
			result=t+"/"+c;
		}
		else {
			result="-";
		}
		return result;
	}
	public static String Fra_mul_Fra(String a,String b) {
		String result=null;
		if (a.contains("'")&&b.contains("'")) {
			String[] news1=a.split("'|/");
			String[] news2=b.split("'|/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int a3=Integer.parseInt(news1[2]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int b3=Integer.parseInt(news2[2]);
			int a4=a1*a3+a2;
			int b4=b1*b3+b2;
			int a5=a4*b4;
			int b5=a3*b3;
			int p=MakeDivision.Get_max(a5, b5);
			a5=a5/p;
			b5=b5/p;
			if(b5==1) {
				result=String.valueOf(a5);
			}
			else {
				int n=a5/b5;
				int k=a5%b5;
				if (n==0) {
					result=k+"/"+b5;
				}
				else if (n!=0) {
					result=n+"'"+k+"/"+b5;
				}
			}
		}
		if (!a.contains("'")&&!b.contains("'")) {
			String[] news1=a.split("/");
			String[] news2=b.split("/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int a3=a1*b1;
			int b3=a2*b2;
			int p=MakeDivision.Get_max(a3, b3);
			a3=a3/p;
			b3=b3/p;
			result=a3+"/"+b3;
		}
		if (a.contains("'")&&!b.contains("'")) {
			String[] news1=a.split("'|/");
			String[] news2=b.split("/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int a3=Integer.parseInt(news1[2]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int c1=(a1*a3+a2)*b1;
			int c2=a3*b2;
			int p=MakeDivision.Get_max(c1, c2);
			c1=c1/p;
			c2=c2/p;
			int j=c1/c2;
			int k=c1%c2;
			if (j==0) {
				result=k+"/"+c2;
			}
			else if (j!=0) {
				result=j+"'"+k+"/"+c2;
			}
		}
		if (!a.contains("'")&&b.contains("'")) {
			String[] news1=a.split("/");
			String[] news2=b.split("'|/");
			int a1=Integer.parseInt(news1[0]);
			int a2=Integer.parseInt(news1[1]);
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int b3=Integer.parseInt(news2[2]);
			int c1=a1*b2;
			int c2=a2*b3;
			int p=MakeDivision.Get_max(c1, c2);
			c1=c1/p;
			c2=c2/p;
			result=b1+"'"+c1+"/"+c2;
		}
		return result;
	}
	public static String Fra_div_Fra(String a,String b) {
		String result=null;
		if (b.contains("'")) {
			String[] news2=b.split("'|/");
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int b3=Integer.parseInt(news2[2]);
			int a1=b1*b3+b2;
			String n=b3+"/"+a1;
			result=Fra_mul_Fra(a, n);
		}
		else if (!b.contains("'")){
			String[] news2=b.split("/");
			int b1=Integer.parseInt(news2[0]);
			int b2=Integer.parseInt(news2[1]);
			int c1=b2/b1;
			int c2=b2%b1;
			String n=c1+"'"+c2+"/"+b2;
			result=Fra_mul_Fra(a, n);
		}
		return result;
	}
	public static String Fra_add_Num(String a,int b) {
		String result=null;
		if (a.contains("'")) {
			String[] news=a.split("'");
			int a1=Integer.parseInt(news[0]);
			String a2=news[1];
			int t=a1+b;
			result=t+"'"+a2;
		}
		else if (!a.contains("'")) {
			result=b+"'"+a;
		}
		return result;
	}
	public static String Fra_sub_Num(String a,int b) {
		String result=null;
		if (a.contains("'")) {
			String[] news=a.split("'");
			int a1=Integer.parseInt(news[0]);
			String a2=news[1];
			int t=a1-b;
			if (t==0) {
				result=a2;
			}
			else if (t!=0) {
				result=t+"'"+a2;
			}
			
		}
		else if (!a.contains("'")) {
			result="-";
		}
		return result;
	}
	public static String Fra_mul_Num(String a,int b) {
		return GetResult.Num_mul_Fra(b, a);
	}
	public static String Fra_div_Num(String a,int b) {
		String c=1+"/"+b;
		return GetResult.Fra_mul_Fra(a, c);
	}
}










