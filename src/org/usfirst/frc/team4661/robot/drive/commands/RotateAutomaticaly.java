package org.usfirst.frc.team4661.robot.drive.commands;

import org.usfirst.frc.team4661.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RotateAutomaticaly extends Command{
	double speed;
	short direction;
	double finishDegree;
	public RotateAutomaticaly(double speed,double finishDegree, short direction) {
		this.speed = speed;
		this.direction = direction;
		this.finishDegree = finishDegree;
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Unlimited
		//Gyro function goes here
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		speed *= direction; //1 - right, -1 - left
		Robot.drive.tank(speed, -speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false; //I need a Gyro to determine this
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {

	}
}
