package org.usfirst.frc.team9999.robot;

import org.usfirst.frc.team9999.robot.subsystems.PIDDrive;
import org.usfirst.frc.team9999.robot.commands.RunPIDDrive;

public class Subsystems {
	
	public static Subsystems instance = new Subsystems();
	public final PIDDrive pidDrive;
	public RunPIDDrive runPIDDrive;
	
	public Subsystems(){
		pidDrive = new PIDDrive();
	}
	
	public void initCommands(){
		runPIDDrive = new RunPIDDrive();
	}
}
