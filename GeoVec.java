package Kaws;

public class GeoVec {
	private double x;
	private double y;
	private double Angle;
	private double Lenght;

	
	private void CountLenght(){
		this.Lenght=Math.sqrt((this.x*this.x)+(this.y*this.y));
	}
	
	private void CountAngle(){
		this.Angle=Math.asin((this.x*this.y)/this.Lenght);
	}
	
	public GeoVec(double x, double y) {
		this.x=x;
		this.y=y;
		
		this.CountLenght();
		this.CountAngle();
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x=x;
	}
	
	public void setY(double y) {
		this.y=y;
	}
	
	public double getAngle() {
		return this.Angle;
	}
	
	
	public void setAngle(double Angle) {
		this.Angle=Angle;
		GeoVec temp = new GeoVec(this.getX(), this.getY());
        temp.setX(this.x * Math.cos(Angle) - this.y * Math.sin(Angle));
        temp.setY(this.x * Math.sin(Angle) + this.y * Math.cos(Angle));
        this.x=temp.getX();
        this.y=temp.getY();
	}
	
	public double getLenght() {
		return this.Lenght;
	}
	
	public void setLength(double Lenght) {
		
		this.CountLenght();
	}
	
	public void Add(GeoVec Addition) {
		this.x+=Addition.getX();
		this.y+=Addition.getY();
		this.CountAngle();
		this.CountLenght();
	}
	
}
