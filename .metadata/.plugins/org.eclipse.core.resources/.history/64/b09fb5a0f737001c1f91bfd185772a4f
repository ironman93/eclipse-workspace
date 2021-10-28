
public class RocketLaunch {
	
	double t;
	double a;
	double v;
	double interval;
	double k;
	double g;
	double m;
	double x;
	
	public RocketLaunch(double interval, double k, double m) {
		t = 0;
		g = 9.81;
		a = g;
		v = 0;
		x = 0;
		this.interval = interval;
		this.k = k;
		this.m = m;
	}
	
	
	public double calcAccelaration() {
		a = g-(k/m)*v*v;
		return a;
	}
	
	
	public double calcVelocity() {
		v = a*interval+v;
		return v;
	}
	
	
	public double calcDistance() {
		x = v*interval+x;
		return x;
	}
	
	
	public double calcTime() {
		t = t+interval;
		return t;
	}
	
	
	public void calcFreeFall(int steps) {
		for(int i = 0; i < steps; i++) {
			System.out.print(calcAccelaration());
			System.out.print("         ");
			System.out.print(calcVelocity());
			System.out.print("         ");
			System.out.print(calcDistance());
			System.out.print("         ");
			System.out.println(calcTime());
		}
	}
	
	
	public static void main(String[] args) {
		RocketLaunch launch = new RocketLaunch(1, 0.3, 100);
		launch.calcFreeFall(10);

	}

}
