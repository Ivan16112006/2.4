import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		if(!(a/100000>=1 & a/100000<=99999))return;
		
		int k[] = mass(a);
		int l = prov(k);
		if(l!=0){
			System.out.println("Билет выйгрышный");
			System.out.println("Сумма: "+l);
			
		}
		else{
			for(int i = 0; l == 0; i++){
				k = mass(a+i);
				l = prov(k);
			}
			System.out.println("Билет проигрышный");
			System.out.println("Следующий выйгрышный билет");
			for(int i:k)System.out.print(i);
			System.out.println();
			System.out.println("Сумма: "+l);
		}
		
	}
	static int step(int a, int b){
		int h = 1;
		for(int i = 0;i<b;i++) h*=a;
		return h;
	}
	static int[] mass(int a){
		int y;
		int[] o = new int[6];
		int k = a;
		int n = 0;
		for(int i =5;i>-1;i--){
			y = k/step(10, i);
			k-=y*step(10, i);
			o[n]=y;
			n++;
			}
			return o;
	}
	static int prov(int[] a) {
		int s2 = 0;
		int s1 = 0;
		for(int i: a){
			if(i%2 == 1) s1+=i;
			else  s2+=i;
		}
		if(s2 == s1) return s1;
		else return 0;
	}
}
