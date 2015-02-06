package org.usfirst.frc.team9999.robot.commands;

import org.usfirst.frc.team9999.robot.OI;
import org.usfirst.frc.team9999.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunPIDDrive extends Command {
	
	private static OI oi;
	private final Subsystems ss = Subsystems.instance;
	
	private double FWD;
	private double STR;
	
	private final int trackWidth = 24;
	private final int wheelBase = 43;
	private final double radius = Math.sqrt(trackWidth^2 + wheelBase^2);
	
    public RunPIDDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	oi = new OI();
    	requires(ss.driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {  
    	ss.driveBase.stop();
    	
    	FWD = 0;
    	STR = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = oi.driveX.get();
    	double y = oi.driveY.get();
    	double RCW = oi.steer.get();
    	
    	double fieldAngle = Math.PI/2;
    	
    	FWD = -y;
    	STR = x;
    	
    	double temp = FWD * Math.cos(fieldAngle) + STR * Math.sin(fieldAngle);
    	STR = -1*FWD * Math.sin(fieldAngle) + STR * Math.cos(fieldAngle);
    	FWD = temp;
    	
    	
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	ss.driveBase.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	ss.driveBase.stop();
    }
    
}
