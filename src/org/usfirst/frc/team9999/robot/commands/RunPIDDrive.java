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
    public RunPIDDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	oi = new OI();
    	requires(ss.pidDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ss.pidDrive.setSetpoint(0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = oi.driveX.get();
    	double y = oi.driveY.get();
    	
    	double angle = Math.atan2(y, x);
    	double mag = Math.sqrt(x*x + y*y);
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	ss.pidDrive.setSetpoint(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	ss.pidDrive.setSetpoint(0.0);
    }
}
