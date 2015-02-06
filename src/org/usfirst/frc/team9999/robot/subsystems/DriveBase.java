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
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void stop(){
		ss.pidDrive1.setSetpoint(0);
		ss.pidDrive2.setSetpoint(0);
		ss.pidDrive3.setSetpoint(0);
		ss.pidDrive4.setSetpoint(0);
		
		ss.pidSteer1.setSetpoint(0);
		ss.pidSteer2.setSetpoint(0);
		ss.pidSteer3.setSetpoint(0);
		ss.pidSteer4.setSetpoint(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

