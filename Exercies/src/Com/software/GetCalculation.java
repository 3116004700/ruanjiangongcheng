package Com.software;

public class GetCalculation {
	
	//String string=String.valueOf(Getnum.Get_num(10))+GetSymbol.Get_Symbol()+Getnum.Get_Frac(m)+"=";
	public static String Get_Calculation1(int m) {
		String strings=String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+String.valueOf(Getnum.Get_num(m))+" "+"=";
		String answer=null;
		String string =strings.replaceAll(" ", "");
		String[] news=string.split("\\-|\\=|\\+|\\¡Á|\\¡Â");
		int a=Integer.parseInt(news[0]);
		int b=Integer.parseInt(news[1]);
		if(string.contains("-")) {
			if(a<b) {
				return Get_Calculation1(m);
			}
			else {
				answer=String.valueOf(GetResult.Num_sub_Num(a, b));
				return strings+"&"+answer;
			}
		}
		if (string.contains("+")) {
			answer=String.valueOf(GetResult.Num_add_Num(a, b));
			return strings+"&"+answer;
		}
		if (string.contains("¡Á")) {
			answer=String.valueOf(GetResult.Num_mul_Num(a, b));
			return strings+"&"+answer;
		}else {
			answer=GetResult.Num_div_Num(a, b);
			return strings+"&"+answer;
		}
	}
	
	public static String Get_Calculation2(int m) {
		String strings=String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+Getnum.Get_Frac(m)+" "+"=";
		String string =strings.replaceAll(" ", "");
		String[] string1=string.split("\\+|\\-|\\¡Á|\\¡Â|\\=");
		String answer=null;
		int n=Integer.parseInt(string1[0]);
		String string2=string1[1];
		if(string.contains("-")) {
			answer=GetResult.Num_sub_Fra(n, string2);
			if (answer.contains("-")) {
				return Get_Calculation2(m);
			}
			else if (!answer.contains("-")) {
				return strings+"&"+answer;
			}
		}
		if(string.contains("+")) {
			answer=GetResult.Num_add_Fra(n, string2);
			return strings+"&"+answer;
		}
		if (string.contains("¡Á")) {
			answer=GetResult.Num_mul_Fra(n, string2);
			return strings+"&"+answer;
		}
		else {
			answer=GetResult.Num_div_Fra(n, string2);
			return strings+"&"+answer;
		}
	}
	
	public static String Get_Calculation3(int m) {
		String strings=Getnum.Get_Frac(m)+" "+GetSymbol.Get_Symbol()+" "+Getnum.Get_Frac(m)+" "+"=";
		String string =strings.replaceAll(" ", "");
		String[] string1=string.split("\\+|\\-|\\¡Á|\\¡Â|\\=");
		String stringa=string1[0];
		String stringb=string1[1];
		String answer=null;
		if (string.contains("-")) {
			answer=GetResult.Fra_sub_Fra(stringa, stringb);
			if (answer.contains("-")) {
				return Get_Calculation3(m);
			}
			else if (!answer.contains("-")) {
				return strings+"&"+answer;
			}
		}
		if (string.contains("+")) {
			if (stringa.contains("'")&&stringb.contains("'")) {
				answer=GetResult.Fra_add_Fra(stringa, stringb);
			}
			else {
				return strings+"&"+answer;
			}
		}
		if (string.contains("¡Á")) {
			answer=GetResult.Fra_mul_Fra(stringa, stringb);
		}
		else if (string.contains("¡Â")) {
			answer=GetResult.Fra_div_Fra(stringa, stringb);
		}
		return strings+"&"+answer;
	}
	
	public static String Get_Calculation4(int m) {
		String strings=String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+Getnum.Get_Frac(m)+" "+"=";
		String string =strings.replaceAll(" ", "");
		String[] string2=string.split("\\+|\\-|\\¡Á|\\¡Â|\\=");
		String stringa=string2[0];
		String stringb=string2[1];
		String stringc=string2[2];
		String answer=null;
		int a1=Integer.parseInt(stringa);
		int a2=Integer.parseInt(stringb);
		int flag1=string.indexOf("+");
		int flag2=string.indexOf("-");
		int flag3=string.indexOf("¡Á");
		int flag4=string.indexOf("¡Â");
		if (flag1>0&&flag2<0&&flag3<0&&flag4<0) {
			int answer1=GetResult.Num_add_Num(a1, a2);
			answer=GetResult.Num_add_Fra(answer1, stringc);
		}
		else if (flag1>0&&flag1<flag2) {
			int answer1=GetResult.Num_add_Num(a1, a2);
			answer=GetResult.Num_sub_Fra(answer1, stringc);
		}
		else if (flag1>0&&flag1<flag3) {
			String answer1=GetResult.Num_mul_Fra(a2, stringc);
			if (answer1.contains("/")) {
				answer=GetResult.Num_add_Fra(a1, answer1);
			}
			else if (!answer1.contains("/")) {
				int answer2=GetResult.Num_add_Num(a1,Integer.parseInt(answer1));
				answer=String.valueOf(answer2);
			}
		}
		else if (flag1>0&&flag1<flag4) {
			String answer1=GetResult.Num_div_Fra(a2, stringc);
			if (answer1.contains("/")) {
				answer=GetResult.Num_add_Fra(a1, answer1);
			}
			else if (!answer1.contains("/")) {
				int answer2=GetResult.Num_add_Num(a1,Integer.parseInt(answer1));
				answer=String.valueOf(answer2);
			}
		}
		else if (flag2>0&&flag1<0&&flag3<0&&flag4<0) {
			int answer1=GetResult.Num_sub_Num(a1, a2);
			if (answer1<=0) {
				return Get_Calculation4(m);
			}
			else if (answer1>0) {
				answer=GetResult.Num_sub_Fra(answer1, stringc);
				if (answer.contains("-")) {
					return Get_Calculation4(m);
				}
				else if (!answer.contains("-")) {
					answer=GetResult.Num_sub_Fra(answer1, stringc);
				}
			}
		}
		else if (flag2>0&&flag2<flag1) {
			int answer1=GetResult.Num_sub_Num(a1, a2);
			if (answer1<0) {
				return Get_Calculation4(m);
			}
			else if(answer1>0) {
				answer=GetResult.Num_add_Fra(answer1, stringc);
			}
		}
		else if (flag2>0&&flag2<flag3) {
			String answer1=GetResult.Num_mul_Fra(a2, stringc);
			if (answer1.contains("/")) {
				String answer2=GetResult.Num_sub_Fra(a1, answer1);
				if (answer2.contains("-")) {
					return Get_Calculation4(m);
				}
				else if (!answer2.contains("-")) {
					answer=answer2;
				}
			}
			else if (!answer1.contains("/")) {
				int c=Integer.parseInt(answer1);
				if (a1<c) {
					return Get_Calculation4(m);
				}
				else if (a1>=c) {
					int c1=GetResult.Num_sub_Num(a1, c);
					answer=String.valueOf(c1);
				}
			}
		}
		else if (flag2>0&&flag2<flag4) {
			String answer1=GetResult.Num_div_Fra(a2, stringc);
			if (answer1.contains("/")) {
				String answer2=GetResult.Num_sub_Fra(a1, answer1);
				if (answer2.contains("-")) {
					return Get_Calculation4(m);
				}
				else if (!answer2.contains("-")) {
					answer=answer2;
				}
			}
			else if (!answer1.contains("/")) {
				int c=Integer.parseInt(answer1);
				if (a1<c) {
					return Get_Calculation4(m);
				}
				else if (a1>=c) {
					int c1=GetResult.Num_sub_Num(a1, c);
					answer=String.valueOf(c1);
				}
			}
		}
		else if (flag3>0&&flag1<0&&flag2<0&&flag4<0) {
			int answer1=GetResult.Num_mul_Num(a1, a2);
			answer=GetResult.Num_mul_Fra(answer1, stringc);
		}
		else if (flag3>0&&flag3<flag1) {
			int answer1=GetResult.Num_mul_Num(a1, a2);
			answer=GetResult.Num_add_Fra(answer1, stringc);
		}
		else if (flag3>0&&flag3<flag2) {
			int answer1=GetResult.Num_mul_Num(a1, a2);
			String answer2=GetResult.Num_sub_Fra(answer1, stringc);
			if (answer2.contains("-")) {
				return Get_Calculation4(m);
			}
			else if (!answer2.contains("-")) {
				answer=answer2;
			}
		}
		else if (flag3>0&&flag3<flag4) {
			int answer1=GetResult.Num_mul_Num(a1, a2);
			answer=GetResult.Num_div_Fra(answer1, stringc);
		}
		else if (flag4>0&&flag1<0&&flag2<0&&flag3<0) {
			String answer2=GetResult.Num_div_Num(a1, a2);
			if (answer2.contains("/")) {
				answer=GetResult.Fra_div_Fra(answer2, stringc);
			}
			else if (!answer2.contains("/")) {
				int c=Integer.parseInt(answer2);
				answer=GetResult.Num_div_Fra(c, stringc);
			}
		}
		
		else if (flag4>0&&flag4<flag2) {
			String answer2=GetResult.Num_div_Num(a1, a2);
			if (answer2.contains("/")) {
				String answer3=GetResult.Fra_sub_Fra(answer2, stringc);
				if (answer3.contains("-")) {
					return Get_Calculation4(m);
				}
				else if (!answer3.contains("-")) {
					answer=answer3;
				}
			}
			else if (!answer2.contains("/")) {
				int c=Integer.parseInt(answer2);
				answer=GetResult.Num_sub_Fra(c, stringc);
			}
		}
		else if (flag4>0&&flag4<flag3) {
			String answer2=GetResult.Num_div_Num(a1, a2);
			if (answer2.contains("/")) {
				answer=GetResult.Fra_mul_Fra(answer2, stringc);
			}
			else if (!answer2.contains("/")) {
				int c=Integer.parseInt(answer2);
				answer=GetResult.Num_mul_Fra(c, stringc);
			}
		}
		else {
			return Get_Calculation4(m);
		}
		return strings+"&"+answer;
	}
	
	public static String Get_Calculation5(int m) {
		String strings="("+" "+String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+String.valueOf(Getnum.Get_num(m))+" "+")"+" "+GetSymbol.Get_Symbol()+" "+Getnum.Get_Frac(m)+" "+"=";
		
		String newstring1 =strings.replaceAll(" ", "");
		String string =newstring1.replaceAll("\\(|\\)", "");
		String[] strings2=string.split("\\+|\\-|\\¡Á|\\¡Â|\\=");
		int a1=Integer.parseInt(strings2[0]);
		int a2=Integer.parseInt(strings2[1]);
		String stringc=strings2[2];
		String answer=null;
		int flag1=string.indexOf("+");
		int flag2=string.indexOf("-");
		int flag3=string.indexOf("¡Á");
		int flag4=string.indexOf("¡Â");
		if (flag1>0&&flag1<flag3) {
			int answer1=GetResult.Num_add_Num(a1, a2);
			answer=GetResult.Num_mul_Fra(answer1, stringc);
		}
		else if (flag1>0&&flag1<flag4) {
			int answer1=GetResult.Num_add_Num(a1, a2);
			answer=GetResult.Num_div_Fra(answer1, stringc);
		}
		else if (flag2>0&&flag2<flag3) {
			int answer1=GetResult.Num_sub_Num(a1, a2);
			if (answer1<0||answer1==0) {
				return Get_Calculation5(m);
			}
			else if (answer1>=0) {
				answer=GetResult.Num_mul_Fra(answer1, stringc);
			}
		}
		else if (flag2>0&&flag2<flag4) {
			int answer1=GetResult.Num_sub_Num(a1, a2);
			if (answer1<0||answer1==0) {
				return Get_Calculation5(m);
			}
			else if (answer1>0) {
				answer=GetResult.Num_div_Fra(answer1, stringc);
			}
		}
		else {
			return Get_Calculation5(m);
		}
		return strings+"&"+answer;
			
	}





	
	public static String Get_Calculation6(int m) {
String strings=String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+"("+" "+String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+Getnum.Get_Frac(m)+" "+")"+" "+"=";
		
		String newstring1 =strings.replaceAll(" ", "");		
		String string =newstring1.replaceAll("\\(|\\)", "");
		String[] string2=string.split("\\+|\\-|\\¡Á|\\¡Â|\\=");
		int a1=Integer.parseInt(string2[0]);
		int a2=Integer.parseInt(string2[1]);
		String stringc=string2[2];
		String answer=null;
		int flag1=string.indexOf("+");
		int flag2=string.indexOf("-");
		int flag3=string.indexOf("¡Á");
		int flag4=string.indexOf("¡Â");
		if (flag2>0&&flag1<0&&flag3<0&&flag4<0) {
			String answer1=GetResult.Num_sub_Fra(a2, stringc);
			String answer2=GetResult.Num_sub_Fra(a1, answer1);
			if (answer2.contains("-")) {
				return Get_Calculation6(m);
			}
			else if (!answer2.contains("-")) {
				answer=answer2;
			}
		}
		else if (flag2>0&&flag2<flag1) {
			String answer1=GetResult.Num_add_Fra(a2, stringc);
			String answer2=GetResult.Num_sub_Fra(a1, answer1);
			if (answer2.contains("-")) {
				return Get_Calculation6(m);
			}
			else if (!answer2.contains("-")) {
				answer=answer2;
			}
		}
		else if (flag3>0&&flag1<0&&flag2<0&&flag4<0) {
			String answer1=GetResult.Num_mul_Fra(a2, stringc);
			if (answer1.contains("/")) {
				answer=GetResult.Num_mul_Fra(a1, answer1);
			}
			else if (!answer1.contains("/")) {
				int c=Integer.parseInt(answer1);
				int answer2=GetResult.Num_mul_Num(a1, c);
				answer=String.valueOf(answer2);
			}
		}
		else if (flag3>0&&flag3<flag1) {
			String answer1=GetResult.Num_add_Fra(a2, stringc);
			answer=GetResult.Num_mul_Fra(a1, answer1);
		}
		else if (flag3>0&&flag3<flag2) {
			String answer1=GetResult.Num_sub_Fra(a2, stringc);
			answer=GetResult.Num_mul_Fra(a1, answer1);
		}
		else if (flag4>0&&flag1<0&&flag2<0&&flag3<0) {
			String answer1=GetResult.Num_div_Fra(a2, stringc);
			if (answer1.contains("/")) {
				answer=GetResult.Num_div_Fra(a1, answer1);
			}
			else if (!answer1.contains("/")) {
				int c=Integer.parseInt(answer1);
				answer=GetResult.Num_div_Num(a1,c);
			}
		}
		else if (flag4>0&&flag4<flag1) {
			String answer1=GetResult.Num_add_Fra(a2, stringc);
			answer=GetResult.Num_div_Fra(a1, answer1);
		
		}
		else if (flag4>0&&flag4<flag2) {
			String answer1=GetResult.Num_sub_Fra(a2, stringc);
			answer=GetResult.Num_div_Fra(a1, answer1);
		}
		else if (flag4>0&&flag4<flag3) {
			String answer1=GetResult.Num_mul_Fra(a2, stringc);
			if (answer1.contains("/")) {
				answer=GetResult.Num_div_Fra(a1, answer1);
			}
			else if (!answer1.contains("/")) {
				int c=Integer.parseInt(answer1);
				answer=GetResult.Num_div_Num(a1,c);
			}
		}
		else {
			return Get_Calculation6(m);
		}
		return strings+"&"+answer;
	}
	
	public static String Get_Calculation7(int m) {
		String strings=String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+String.valueOf(Getnum.Get_num(m))+" "+"=";
		String string =strings.replaceAll(" ", "");
		String[] news=string.split("\\+|\\-|\\¡Á|\\¡Â|\\=");
		int a1=Integer.parseInt(news[0]);
		int a2=Integer.parseInt(news[1]);
		int a3=Integer.parseInt(news[2]);
		String answer=null;
		int flag1=string.indexOf("+");
		int flag2=string.indexOf("-");
		int flag3=string.indexOf("¡Á");
		int flag4=string.indexOf("¡Â");
		if (flag1>0&&flag2<0&&flag3<0&&flag4<0) {
			int c1=GetResult.Num_add_Num(a1, a2);
			int c2=GetResult.Num_add_Num(c1, a3);
			answer=String.valueOf(c2);
		}
		else if (flag1>0&&flag1<flag2) {
			int c1=GetResult.Num_add_Num(a1, a2);
			int c2=GetResult.Num_sub_Num(c1, a3);
			answer=String.valueOf(c2);
		}
		else if (flag1>0&&flag1<flag3) {
			int c1=GetResult.Num_mul_Num(a2, a3);
			int c2=GetResult.Num_add_Num(a1, c1);
			answer=String.valueOf(c2);
		}
		else if (flag1>0&&flag1<flag4) {
			String answer1=GetResult.Num_div_Num(a2, a3);
			if (answer1.contains("/")) {
				answer=GetResult.Num_add_Fra(a1, answer1);
			}
			else if (!answer1.contains("/")) {
				int c1=Integer.parseInt(answer1);
				int c2=GetResult.Num_add_Num(a1, c1);
				answer=String.valueOf(c2);
			}
		}
		else if (flag2>0&&flag1<0&&flag3<0&&flag4<0) {
			int answer1=GetResult.Num_sub_Num(a1, a2);
			if (answer1<0||answer1==0) {
				return Get_Calculation7(m);
			}
			else if (answer1>0) {
				int c=GetResult.Num_sub_Num(answer1, a3);
				if (c<0) {
					return Get_Calculation7(m);
				}
				else {
					answer=String.valueOf(c);
				}
			}
		}
		else if (flag2>0&&flag2<flag1) {
			int answer1=GetResult.Num_sub_Num(a1, a2);
			if (answer1<0) {
				return Get_Calculation7(m);
			}
			else if (answer1>0||answer1==0) {
				int c=GetResult.Num_add_Num(answer1, a3);
				answer=String.valueOf(c);
			}
		}
		else if (flag2>0&&flag2<flag3) {
			int answer1=GetResult.Num_mul_Num(a1, a2);
			int c=GetResult.Num_sub_Num(a1, answer1);
			if (c<0) {
				return Get_Calculation7(m);
			}
			else if (c>0||c==0) {
				answer=String.valueOf(c);
			}
		}
		else if (flag2>0&&flag2<flag4) {
			String answer1=GetResult.Num_div_Num(a2, a3);
			if (answer1.contains("/")) {
				String c=GetResult.Num_sub_Fra(a1, answer1);
				if (c.contains("-")) {
					return Get_Calculation7(m);
				}
				else if (!c.contains("-")) {
					answer=c;
				}
			}
			else if (!answer1.contains("/")) {
				int c1=Integer.parseInt(answer1);
				int c2=GetResult.Num_sub_Num(a1, c1);
				if (c2<0) {
					return Get_Calculation7(m);
				}
				else if (c2>0||c2==0) {
					answer=String.valueOf(c2);
				}
			}
		}
		else if (flag3>0&&flag1<0&&flag2<0&&flag4<0) {
			int answer1=GetResult.Num_mul_Num(a1, a2);
			int answer2=GetResult.Num_mul_Num(answer1, a3);
			answer=String.valueOf(answer2);
			
		}
		else if (flag3>0&&flag3<flag1) {
			int answer1=GetResult.Num_mul_Num(a1, a2);
			int answer2=GetResult.Num_add_Num(answer1, a3);
			answer=String.valueOf(answer2);
		}
		else if (flag3>0&&flag3<flag2) {
			int answer1=GetResult.Num_mul_Num(a1, a2);
			int answer2=GetResult.Num_sub_Num(answer1, a3);
			if (answer2<0) {
				return Get_Calculation7(m);
			}
			else if (answer2>0||answer2==0) {
				answer=String.valueOf(answer2);
			}
		}
		else if (flag3>0&&flag3<flag4) {
			int answer1=GetResult.Num_mul_Num(a1, a2);
			answer=GetResult.Num_div_Num(answer1, a3);
		}
		else if (flag4>0&&flag1<0&&flag2<0&&flag3<0) {
			String answer1=GetResult.Num_div_Num(a1, a2);
			if (answer1.contains("/")) {
				answer=GetResult.Fra_div_Num(answer1, a3);
			}
			else if (!answer1.contains("/")) {
				int c1=Integer.parseInt(answer1);
				answer=GetResult.Num_div_Num(c1, a3);
			}
		}
		else if (flag4>0&&flag4<flag1) {
			String answer1=GetResult.Num_div_Num(a1, a2);
			if (answer1.contains("/")) {
				answer=GetResult.Fra_add_Num(answer1, a3);
			}
			else if (!answer1.contains("/")) {
				int c1=Integer.parseInt(answer1);
				int c2=GetResult.Num_add_Num(c1, a3);
				answer=String.valueOf(c2);
			}
		}
		else if (flag4>0&&flag4<flag2) {
			String answer1=GetResult.Num_div_Num(a1, a2);
			if (answer1.contains("/")) {
				String answer2=GetResult.Fra_sub_Num(answer1, a3);
				if (answer2.contains("-")) {
					return Get_Calculation7(m);
				}
				else if (!answer2.contains("-")) {
					answer=answer2;
				}
			}
			else if (!answer1.contains("/")) {
				int c=Integer.parseInt(answer1);
				int answer2=GetResult.Num_sub_Num(c,a3);
				if (answer2<0) {
					return Get_Calculation7(m);
				}else if (answer2>0||answer2==0) {
					int c2=GetResult.Num_sub_Num(answer2, a3);
					answer=String.valueOf(c2);
				}
			}
			
		}
		else if (flag4>0&&flag4<flag3) {
			String answer1=GetResult.Num_div_Num(a1, a2);
			if (answer1.contains("/")) {
				answer=GetResult.Fra_mul_Num(answer1, a3);
			}
			else if (!answer1.contains("/")) {
				int c1=Integer.parseInt(answer1);
				int c2=GetResult.Num_mul_Num(c1, a3);
				answer=String.valueOf(c2);
			}
		}
		return strings+"&"+answer;
		
		
	}
	
	public static String Get_Calculation8(int m) {
		String strings=String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+"("+" "+String.valueOf(Getnum.Get_num(m))+" "+GetSymbol.Get_Symbol()+" "+String.valueOf(Getnum.Get_num(m))+" "+")"+" "+"=";
		String newstring1 =strings.replaceAll(" ", "");
		String string =newstring1.replaceAll("\\(|\\)", "");
		String[] strings2=string.split("\\+|\\-|\\¡Á|\\¡Â|\\=");
		int a1=Integer.parseInt(strings2[0]);
		int a2=Integer.parseInt(strings2[1]);
		int a3=Integer.parseInt(strings2[2]);
		String answer=null;
		int flag1=string.indexOf("+");
		int flag2=string.indexOf("-");
		int flag3=string.indexOf("¡Á");
		int flag4=string.indexOf("¡Â");
		if (flag1>0&&flag2<0&&flag3<0&&flag4<0) {
			return Get_Calculation8(m);
		}
		else if (flag1>0&&flag1<flag2) {
			return Get_Calculation8(m);
		}
		else if (flag1>0&&flag1<flag3) {
			return Get_Calculation8(m);
		}
		else if (flag1>0&&flag1<flag4) {
			return Get_Calculation8(m);
		}
		else if (flag2>0&&flag1<0&&flag3<0&&flag4<0) {
			int answer1=GetResult.Num_sub_Num(a2, a3);
			if (answer1<0) {
				return Get_Calculation8(m);
			}
			else if (answer1>0||answer1==0){
				int answer2=GetResult.Num_sub_Num(a1, answer1);
				if (answer2<0) {
					return Get_Calculation8(m);
				}
				else if (answer2>0||answer2==0) {
					answer=String.valueOf(answer2);
				}
			}
		}
		else if (flag2>0&&flag2<flag1) {
			int answer1=GetResult.Num_add_Num(a2, a3);
			int answer2=GetResult.Num_sub_Num(a1, answer1);
			if (answer2<0) {
				return Get_Calculation8(m);
			}
			else if (answer2>0||answer2==0) {
				answer=String.valueOf(answer2);
			}
		}
		else if (flag2>0&&flag2<flag3) {
			return Get_Calculation8(m);
		}
		else if (flag2>0&&flag2<flag4) {
			return Get_Calculation8(m);
		}
		else if (flag3>0&&flag1<0&&flag2<0&&flag4<0) {
			return Get_Calculation8(m);
		}
		else if (flag3>0&&flag3<flag1) {
			int answer1=GetResult.Num_add_Num(a2, a3);
			int answer2=GetResult.Num_mul_Num(a1, answer1);
			answer=String.valueOf(answer2);
		}
		else if (flag3>0&&flag3<flag2) {
			int answer1=GetResult.Num_sub_Num(a2, a3);
			if (answer1<0||answer1==0) {
				return Get_Calculation8(m);
			}
			else if (answer1>0) {
				int answer2=GetResult.Num_mul_Num(a1, answer1);
				answer=String.valueOf(answer2);
			}
		}
		else if (flag3>0&&flag3<flag4) {
			return Get_Calculation8(m);
		}
		else if (flag4>0&&flag1<0&&flag2<0&&flag3<0) {
			String answer1=GetResult.Num_div_Num(a2, a3);
			if (answer1.contains("/")) {
				answer=GetResult.Num_div_Fra(a1, answer1);
				}
			else if (!answer1.contains("/")) {
				int c=Integer.parseInt(answer1);
				answer=GetResult.Num_div_Num(a1,c);
			}
		}
		else if (flag4>0&&flag4<flag1) {
			int answer1=GetResult.Num_add_Num(a2, a3);
			answer=GetResult.Num_div_Num(a1, answer1);
		}
		else if (flag4>0&&flag4<flag2) {
			int answer1=GetResult.Num_sub_Num(a2, a3);
			if (answer1<0||answer1==0) {
				return Get_Calculation8(m);
			}
			else if (answer1>0) {
				answer=GetResult.Num_div_Num(a1, answer1);
			}
		}
		else if (flag4>0&&flag4<flag3) {
			int answer1=GetResult.Num_mul_Num(a2, a3);
			answer=GetResult.Num_div_Num(a1, answer1);
		}
		return strings+"&"+answer;
	}
	
}
	
	

