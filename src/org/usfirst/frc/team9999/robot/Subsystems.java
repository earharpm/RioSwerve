package org.usfirst.frc.team9999.robot;

import org.usfirst.frc.team9999.robot.commands.RunPIDDrive;
import org.usfirst.frc.team9999.robot.subsystems.DriveBase;

public class Subsystems {
	
	public static Subsystems instance = new Subsystems();
	public final DriveBase driveBase;
	
	public RunPIDDrive runPIDDrive;
	
	public Subsystems(){
		driveBase = new DriveBase();
	}
	
	public void initCommands(){
		runPIDDrive = new RunPIDDrive();
	}
}
