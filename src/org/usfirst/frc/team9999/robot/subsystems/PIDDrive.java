package org.usfirst.frc.team9999.robot.subsystems;

import org.usfirst.frc.team9999.robot.Robot;
import org.usfirst.frc.team9999.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDDrive extends PIDSubsystem {

	Talon driveMotor1 = new Talon(RobotMap.driveMotor1);
	Encoder driveEncoder = new Encoder(RobotMap.encoder1A, RobotMap.encoder1B);
	
	boolean rateBasedDrive;
	
    // Initialize your subsystem here
    public PIDDrive() {
    	super("PIDDrive", 1.0, 0.0, 0.0);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	setSetpoint(0.0);
    	enable();
    	rateBasedDrive = Robot.rateBasedDrive;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return rateBasedDrive ? driveEncoder.getRate() : driveEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	driveMotor1.set(output);
    }
}
