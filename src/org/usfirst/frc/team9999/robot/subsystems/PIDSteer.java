package org.usfirst.frc.team9999.robot.subsystems;

import org.usfirst.frc.team9999.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDSteer extends PIDSubsystem {
	
	Talon steerMotor;
	Encoder steerEncoder;

    // Initialize your subsystem here
    public PIDSteer(int wheelNum) {
    	super("PIDSteer" + wheelNum, 1, 0, 0);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	steerMotor  = new Talon(RobotMap.steerMotors[wheelNum-1]);
    	steerEncoder = new Encoder(RobotMap.steerEncoders[wheelNum*2], RobotMap.steerEncoders[wheelNum*2 + 1]);
    	
    	setSetpoint(0.0);
    	enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return steerEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	steerMotor.set(output);
    }
    
    public double getAngle(){
    	return steerEncoder.getDistance();
    }
}
