package fractals;

public class Complex {
	double re,im;
	
	public Complex(double r,double i){
		re = r;
		im = i;
	}
	
	public Complex(double r){
		re = r;
		im =0;
	}
	
	public Complex(){
		re = 0;
		im = 0;
	}
	
	public String toString(){	
		return re + " + i"+ im;
	}
	
	public Complex plus(Complex c){	
		return new Complex(re + c.re,im + c.im);
	}
	
	public Complex mult(Complex c){	
		return new Complex(re*c.re - im*c.im,re*c.im + im*c.re);
	}
	
	public double abs(){
		return Math.sqrt(re*re + im*im);	
	}
}
