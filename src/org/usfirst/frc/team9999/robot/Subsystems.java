package org.usfirst.frc.team9999.robot;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team9999.robot.subsystems.PIDDrive;
import org.usfirst.frc.team9999.robot.commands.*;

public class Subsystems {
	
	public static Subsystems instance = new Subsystems();
	public final PIDDrive pidDrive;
	
	public Subsystems(){
		pidDrive = new PIDDrive();
	}
}
