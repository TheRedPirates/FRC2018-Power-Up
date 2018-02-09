package org.usfirst.frc.team4661.robot.drive.commands;

import org.usfirst.frc.team4661.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveByDegree extends Command {
	double timer;
	double speed;
	double degreeCorrection;
	short direction;

	public DriveByDegree(double timer, double speed, double degreeCorrection, short direction) {
		this.timer = timer;
		this.speed = speed;
		this.degreeCorrection = degreeCorrection;
		this.direction = direction;
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(timer);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//The Usage of Degree May Only be Implemnted Once A Gyro Is Connected
		speed *= direction;
		Robot.drive.tank(speed, speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
