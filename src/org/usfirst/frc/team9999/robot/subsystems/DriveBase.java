package org.usfirst.frc.team9999.robot.subsystems;

import org.usfirst.frc.team9999.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Oversees the PIDDrive and PIDSteer Subsystems.
 * 
 * Commands should point to this class rather than PIDDrive or PIDSteer.
 */
public class DriveBase extends Subsystem {
	
	private final Subsystems ss = Subsystems.instance;
	
	private PIDSteer[] steerSystem;
	private PIDDrive[] driveSystem; 
	
	
	private final int trackWidth = 24;
	private final int wheelBase = 43;
	private final double radius = Math.sqrt(trackWidth^2 + wheelBase^2);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void stop(){
		ss.pidDrive1.setSetpoint(0);
		ss.pidDrive2.setSetpoint(0);
		ss.pidDrive3.setSetpoint(0);
		ss.pidDrive4.setSetpoint(0);
		driveSystem = new PIDDrive[] {ss.pidDrive1, ss.pidDrive2, ss.pidDrive3, ss.pidDrive4};
		
		ss.pidSteer1.setSetpoint(0);
		ss.pidSteer2.setSetpoint(0);
		ss.pidSteer3.setSetpoint(0);
		ss.pidSteer4.setSetpoint(0);
		steerSystem = new PIDSteer[] {ss.pidSteer1, ss.pidSteer2, ss.pidSteer3, ss.pidSteer4};
	}
	
	public void drive(double fwd, double str, double rcw){
		double a = str - rcw * (wheelBase / radius);
		double b = str + rcw * (wheelBase / radius);
		double c = fwd - rcw * (trackWidth / radius);
		double d = fwd + rcw * (trackWidth / radius);
		
		double[] wheelSpeeds = getWheelSpeeds(a, b, c, d);
		double[] wheelAngles = getWheelAngles(a, b, c, d);
		
		// THIS WONT WORK.... Breaks on the 180 -> -180 point
		for(int i = 0; i < wheelAngles.length; i++){
			double pAngle = steerSystem[i].getAngle();
			if(Math.abs(wheelAngles[i] - pAngle) > 90) wheelSpeeds[i] *= -1;
		}
	}

	private double[] getWheelSpeeds(double a, double b, double c, double d){
		double ws1 = Math.sqrt(b*b + c*c);
		double ws2 = Math.sqrt(b*b + d*d);
		double ws3 = Math.sqrt(a*a + d*d);
		double ws4 = Math.sqrt(a*a + c*c);
		
		// Binds the wheel speeds to [0, +1]
		double max = ws1;
		if(ws2 > max) max = ws2;
		if(ws3 > max) max = ws3;
		if(ws4 > max) max = ws4;
		if(max > 1){
			ws1 /= max;
			ws2 /= max;
			ws3 /= max;
			ws4 /= max;
		}
		
		return new double[] {ws1, ws2, ws3, ws4};
	}
	
	private double[] getWheelAngles(double a, double b, double c, double d){
		// Wheel angles -180 to 180. 0 is straight forward
		double wa1 = Math.atan2(b, c);
		double wa2 = Math.atan2(b, d);
		double wa3 = Math.atan2(a, d);
		double wa4 = Math.atan2(a, c);
		
		return new double[] {wa1, wa2, wa3, wa4};
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

