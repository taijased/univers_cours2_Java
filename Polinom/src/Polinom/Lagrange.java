package Polinom;

import java.util.ArrayList;
public class Lagrange extends Polinom {
	
   Lagrange(){
	   super (0,0);
	   ArrList= new ArrayList<double[]>();
   }
   
   public ArrayList<double[]> ArrList;
   
	Lagrange(double[][]nodes){
		super(0,0);
		int n = nodes[0].length;
	    Polinom res = new Polinom(0,0);
	     
	    for(int i=0;i<n;i++){
	    	Polinom l = new Polinom(1,0);
	    	for(int j=0;j<n;j++){
	    		if(j!=i){
	    			Polinom tmp = new Polinom(-1*nodes[0][j],0);
	    			Polinom tmp2=new Polinom(1,1);
	    			tmp=tmp.sum(tmp2); 
	    			double r = nodes[0][i]-nodes[0][j];
	    			tmp=tmp.umnogCh(1/r);
	    			l=l.umnog(tmp);
	    		}
	    	}
	    	l=l.umnogCh(nodes[1][i]);
	    	res=res.sum(l);	
	    }	    
	    coef = new double[res.coef.length];
	    pow=res.coef.length-1;
	    for(int i=0;i<res.coef.length;i++){
	    	coef[i]=res.coef[i];
	    }
	 //   System.out.println("������� ��������:");
	 //   System.out.println(this);
	}
}