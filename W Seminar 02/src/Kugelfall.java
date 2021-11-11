import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.*;
import javax.swing.Timer;


public class Kugelfall extends StandardAnwendung implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		starteAnwendung();
	}

	int fallpos = 25;
	double t = 0;
	double v = 0;
	double dt = 0.017;
	double k = 0.5;
	double g = 9.81;
	double a = g;
	double m = 100;
	double x = 25;
	Color bg = new Color(100,100,100);
	Color ball = new Color(0,220,255);
	Timer timer = new Timer((int)(dt*1000), this);
	JLabel velocityLabel = new JLabel(""+v);
	JLabel distanceLabel = new JLabel(""+x);
	Container panel = new Container();
	GroupLayout telemetryLayout = new GroupLayout(panel);
	
	
	
	public Kugelfall() {
		super("titel", 250, 500);
		this.setBackground(bg);
		JButton startButton = new JButton("start");
		add(startButton);
		startButton.setVisible(true);
		startButton.addActionListener(this);
		panel.setLayout(telemetryLayout);
		telemetryLayout.setAutoCreateGaps(true);
		telemetryLayout.setAutoCreateContainerGaps(true);
		
	}
	
	public void calcAccelaration() {
		a = g-(k/m)*v*v;
	}
	
	public void calcVelocity() {
		v = a*dt+v;
	}
	
	public void calcDistance() {
		x = v*dt+x;
	}
	
	public void fall() {
		calcAccelaration();
		calcVelocity();
		calcDistance();
		if(x > 550) {
			x = 10;
		}
		this.repaint();
		updateTelemetry();
	}
	
	public void updateTelemetry() {
		velocityLabel.setText("velocity: "+Math.round(v));
		distanceLabel.setText("distance: "+Math.round(x));
		
	}
	
	@Override
	public void zeichne(Graphics2D g) {
		g.setColor(ball);
		g.fillOval(50, (int)x, 20, 20);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		fall();
		/*telemetryLayout.setVerticalGroup(
				telemetryLayout.createSequentialGroup()
				.addComponent(velocityLabel)
				.addComponent(distanceLabel)	    		  
		);*/
		telemetryLayout.setHorizontalGroup(telemetryLayout.createSequentialGroup()
				.addGroup(telemetryLayout.createParallelGroup()
			        .addComponent(velocityLabel)
			        .addComponent(distanceLabel)
			        )
		);
		add(velocityLabel);
		add(distanceLabel);
		velocityLabel.setVisible(true);
		distanceLabel.setVisible(true);
	}
}
