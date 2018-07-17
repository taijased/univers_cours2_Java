package Polinom;

	public class Polinom {
		protected double[] coef;  // коэффициенты
	    protected int pow;     // степень полинома

	    public Polinom(double koefs, double d) {
	        coef = new double[(int) (d+1)];
	        coef[(int) d]=koefs;
	        pow = pow1();
	    }

	    // Возвращает степень этого многочлена
	    public int pow1() {
	        int d = 0;
	        for (int i = 0; i < coef.length; i++)
	            if (coef[i] != 0) d = i;
	        return d;
	    }
	   
	    public Polinom sum(Polinom b) {
	        Polinom c = new Polinom(0, Math.max(this.pow, b.pow));
	        for (int i = 0; i <= this.pow; i++) c.coef[i] += this.coef[i];
	        for (int i = 0; i <= b.pow; i++) c.coef[i] += b.coef[i];
	        c.pow = c.pow1();
	        return c;
	    }
	 
	    public Polinom razn(Polinom b) {
	        Polinom c = new Polinom(0,Math.max(this.pow, b.pow));
	        for (int i = 0; i <= this.pow; i++) c.coef[i] += this.coef[i];
	        for (int i = 0; i <= b.pow; i++) c.coef[i] -= b.coef[i];
	        c.pow = c.pow1();
	        return c;
	    }

	    public Polinom umnog(Polinom b) {
	        Polinom c = new Polinom(0, this.pow + b.pow);
	        for (int i = 0; i <= this.pow; i++)
	            for (int j = 0; j <= b.pow; j++)
	                c.coef[i+j] += (this.coef[i] * b.coef[j]);
	        c.pow = c.pow1();
	        return c;
	    }
	    
	    public Polinom umnogCh(double x) {
	        Polinom b = new Polinom(0, this.pow);
	        for (int i = 0; i <= this.pow; i++)
	        	b.coef[i] += (this.coef[i] * x);
	        b.pow = b.pow1();
	        return b;
	    }
	    
	    public double ZnT(double x) {
	        double zn=this.coef[0];         
	        for (int i = 1; i < this.coef.length; i++){ 
	        	double t = Math.pow(x,i);
				zn=zn+this.coef[i]*t ;
	        }
	        return zn;
	    }
	    
	    public String toString() { 
	    	if (pow == 0) return "" + coef[0]; 
	    	if (pow == 1) return coef[1] + "x + " + coef[0]; 
	    	int stPow = pow; 
	    	while(stPow>0&&coef[stPow]==0){ 
	    		stPow--; 
	    	}
	    	String s=""; 
	    	if(coef[stPow]!=1) s+=coef[stPow]; 
	    	s =s+ "x^" + stPow; 
	    	for (int i = stPow-1; i >= 0; i--) { 
	    		if (coef[i] !=0) { 
	    			if (coef[i] > 0) s = s + " + "; 
	    			else if (coef[i] < 0) s = s + " - ";
	    			if(coef[i]!=1||i==0) 
	    				s=s+Math.abs(coef[i]); 
	    			if (i == 1) s = s + "x"; 
	    			else if (i > 1) s = s + "x^" + i; 
	    		}
	    	}
	    	return s;
	    }
	}