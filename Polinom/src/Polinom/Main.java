/*package Polinom;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 

public class Main { 
	public static void main(String[] args) throws NumberFormatException, IOException { 
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in)); 
		
		
		System.out.println("Введите количество узлов"); 
		
		int ku;//количество узлов 
		try{ 
			ku =Integer.parseInt(br.readLine()) ; 
		} 
		catch(Exception l){ 
			ku=0; 
		} 
		if(ku<=0){ 
			System.out.println("Неверное количество узлов"); 
			return; 
		} 
		double [][]Uzly= new double [2][ku]; 
		for(int i=0; i<ku;i++){ 
			System.out.print("x"+i+"="); 
			try{ 
				Uzly[0][i] =Double.parseDouble(br.readLine()) ;//считывание узлов с клавиатуры x[i] 
			} 
			catch(Exception l){ 
				Uzly[0][i]=0; 
			} 
			System.out.print("y"+i+"="); 
			try{ 
				Uzly[1][i] =Double.parseDouble(br.readLine()) ;//считывание узлов с клавиатуры y[i] 
			} 
			catch(Exception l){ 
				Uzly[1][i]=0; 
			} 
		}
		Lagrange Lag=new Lagrange (Uzly); 
		System.out.println("Полином Лагранжа:"+ Lag);
		}
	}	
/*		int stP=0; 
		System.out.println("Введите степень первого полинома."); 
		try{ 
			stP=Integer.parseInt(br.readLine()); 
		} 
		catch(Exception e){ 
			stP=0; 
		} 
		double[] koefs = new double[stP+1]; 
		for(int i = 0; i < stP+1; i++) { 
			System.out.println("Введите коэффициент при x^"+i+"="); 
			try{ 
				koefs[i] =Double.parseDouble(br.readLine()); 
			} 
			catch(Exception e){ 
				koefs[i]=0; 
			} 
		} 
		Polinom p=new Polinom(0, 0); 
		for(int i = 0; i < koefs.length; i++) { 
			Polinom p1 = (Polinom) new Polinom(koefs[i],i); 
			
			p = p1.sum(p); 
		} 
		System.out.println(" Ваш первый полином p(x) = " + p); 
		int stP2=0; 
		System.out.println("Введите степень второго полинома."); 
		try{ 
			stP2=Integer.parseInt(br.readLine()); 
		} 
		catch(Exception e){ 
			stP2=0; 
		} 
		double[] koefss = new double[stP2+1]; 
		for(int i = 0; i < stP2+1; i++) { 
			System.out.println("Введите коеффициент при x^"+i+"="); 
			try{ 
				koefss[i] =Double.parseDouble(br.readLine()) ; 
			} 
			catch(Exception e){ 
				koefss[i]=0; 
			} 
		} 
		Polinom q=new Polinom(0, 0); 
		for(int i = 0; i < koefss.length; i++) { 
			Polinom q1 = (Polinom) new Polinom(koefss[i], i); 
			q = q1.sum(q); 
		} 
		System.out.println(" Ваш второй полином q(x) = " + q); 
		Polinom s = p.sum(q); 
		Polinom r = p.razn(q); 
		Polinom u = p.umnog(q); 
		System.out.println("p(x) + q(x) = " + s); 
		System.out.println("p(x) - q(x) = " + r); 
		System.out.println("p(x) * q(x) = " + u); 
		System.out.println("Введите число, на которое умножаем полином 1:"); 
		double e; 
		try{ 
			e =Double.parseDouble(br.readLine()) ; 
		} 
		catch(Exception l){ 
			e=0; 
		} 
		Polinom ch = p.umnogCh(e); 
		System.out.println("p(x) * x = " + ch); 
		System.out.println("Введите число, на которое делим полином 1:"); 
		double h; 
		try{ 
			h =Double.parseDouble(br.readLine()) ; 
		} 
		catch(Exception l){ 
			h=0; 
		} 
		System.out.println ("Введите точку, в которой хотим вычислить значение полинома. "); 
		double znt; 
		try{ 
			znt =Double.parseDouble(br.readLine()) ; 
		} 
		catch(Exception l){ 
			znt=0; 
		} 
		double Zn = p.ZnT(znt); 
		System.out.println ("Значение полинома " + p + ", при x = " + znt + ", равно " + Zn); 		
	} 
	}
}*/