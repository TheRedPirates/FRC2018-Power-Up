package org.usfirst.frc.team4661.robot.drive.commands;

import org.usfirst.frc.team4661.robot.Consts;
import org.usfirst.frc.team4661.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDriveByJoystick extends Command {

	public TankDriveByJoystick() {
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double leftSpeed = Robot.oi.getLeftY();
		double rightSpeed = Robot.oi.getRightY();
		if (Math.abs(leftSpeed) < Consts.LIMIT) {
			leftSpeed = 0;
		}
		if (Math.abs(rightSpeed) < Consts.LIMIT) {
			rightSpeed = 0;
		}

		rightSpeed *= Math.abs(rightSpeed);
		leftSpeed *= Math.abs(leftSpeed);

		Robot.drive.tank(leftSpeed, rightSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
