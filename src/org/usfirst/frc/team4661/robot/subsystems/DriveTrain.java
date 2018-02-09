package org.usfirst.frc.team4661.robot.subsystems;

import org.usfirst.frc.team4661.robot.GearBox;
import org.usfirst.frc.team4661.robot.StringConsts;
import org.usfirst.frc.team4661.robot.drive.commands.TankDriveByJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	GearBox left;
	GearBox right;

	public DriveTrain(GearBox left, GearBox right) {
		this.left = left;
		this.right = right;
		if(SmartDashboard.containsKey(StringConsts.DRIVETRAIN_LEFT_CORRECTION)) {
			SmartDashboard.putNumber(StringConsts.DRIVETRAIN_LEFT_CORRECTION, 1);
		}
	}

	public void tank(double leftSpeed, double rightSpeed) {
		if(SmartDashboard.containsKey(StringConsts.DRIVETRAIN_LEFT_CORRECTION)) {
			SmartDashboard.putNumber(StringConsts.DRIVETRAIN_LEFT_CORRECTION, 1);
		}
		double factor = SmartDashboard.getNumber(StringConsts.DRIVETRAIN_LEFT_CORRECTION, 1);
		leftSpeed *= factor;
		left.set(leftSpeed);
		right.set(-rightSpeed);
	}

	public void stop() {
		tank(0, 0);
	}

	/*
	 * public void rotate(double speed) { tank(speed,-speed); }
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDriveByJoystick());
	}
}
