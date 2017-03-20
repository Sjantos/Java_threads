package data;

public class Circle // Klasa poruszaj¹cych siê kó³ek
{
	private double x=0.0, y=0.0, r=0.0;//r to œrednica
	private double cX=0.0, cY=0.0;
	private double kat=0.0;
	private int numer=0;
	
	public Circle(double x1, double y1, double r1, double k, int n)
	{
		x=x1;
		y=y1;
		r=r1;
		kat=k;
		cX=x+r;
		cY=y+r;
		numer=n;
	}
	
	public double getX() { return x; }
	public double getY() { return y; }
	public double getR() { return r; }
	public double getKat() { return kat; }
	public double getcX() { return cX; }
	public double getcY() { return cY; }
	public String getNumer() { return ""+numer; }
	public void setX(double l) { x=l; }
	public void setY(double l) { y=l; }
	public void setR(double l) { r=l; }
	public void setKat(double l) { kat=l; }

	public String toString()
	{
		return x+" "+y+" "+r;
	}
}
