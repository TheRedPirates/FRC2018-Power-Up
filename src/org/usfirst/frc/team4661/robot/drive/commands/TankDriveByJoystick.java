package org.usfirst.frc.team4661.robot.drive.commands;

import org.usfirst.frc.team4661.robot.Consts;
import org.usfirst.frc.team4661.robot.Robot;
import org.usfirst.frc.team4661.robot.StringConsts;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		if (Math.abs(leftSpeed) < SmartDashboard.getNumber(StringConsts.LIMIT, 0)) {
			leftSpeed = 0;
		}
		if (Math.abs(rightSpeed) < SmartDashboard.getNumber(StringConsts.LIMIT, 0)) {
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
