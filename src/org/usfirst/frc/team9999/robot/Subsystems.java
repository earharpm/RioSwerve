package org.usfirst.frc.team9999.robot;

import org.usfirst.frc.team9999.robot.commands.RunPIDDrive;
import org.usfirst.frc.team9999.robot.subsystems.DriveBase;
import org.usfirst.frc.team9999.robot.subsystems.PIDDrive;
import org.usfirst.frc.team9999.robot.subsystems.PIDSteer;

public class Subsystems {
	
	public static Subsystems instance = new Subsystems();
	public final PIDDrive pidDrive1;
	public final PIDDrive pidDrive2;
	public final PIDDrive pidDrive3;
	public final PIDDrive pidDrive4;
	public final PIDSteer pidSteer1;
	public final PIDSteer pidSteer2;
	public final PIDSteer pidSteer3;
	public final PIDSteer pidSteer4;
	
	public final DriveBase driveBase;
	
	public RunPIDDrive runPIDDrive;
	
	public Subsystems(){
		pidDrive1 = new PIDDrive(1);
		pidDrive2 = new PIDDrive(2);
		pidDrive3 = new PIDDrive(3);
		pidDrive4 = new PIDDrive(4);
		
		pidSteer1 = new PIDSteer(1);
		pidSteer2 = new PIDSteer(2);
		pidSteer3 = new PIDSteer(3);
		pidSteer4 = new PIDSteer(4);
		
		driveBase = new DriveBase();
	}
	
	public void initCommands(){
		runPIDDrive = new RunPIDDrive();
	}
}
