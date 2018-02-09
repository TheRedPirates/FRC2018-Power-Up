package org.usfirst.frc.team4661.robot;

import org.usfirst.frc.team4661.robot.commands.Move;
import org.usfirst.frc.team4661.robot.drive.commands.DriveStraightByJoystick;
import org.usfirst.frc.team4661.robot.drive.commands.RotateByJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	Joystick leftJoystick;
	Joystick rightJoystick;

	public OI() {
		if (SmartDashboard.containsKey(StringConsts.CLIMB_UP_BUTTON)) {
			SmartDashboard.putNumber(StringConsts.CLIMB_UP_BUTTON, 1);
		}
		if (SmartDashboard.containsKey(StringConsts.CLIMB_DOWN_BUTTON)) {
			SmartDashboard.putNumber(StringConsts.CLIMB_DOWN_BUTTON, 1);
		}
		if (SmartDashboard.containsKey(StringConsts.LIFT_UP_BUTTON)) {
			SmartDashboard.putNumber(StringConsts.LIFT_UP_BUTTON, 1);
		}
		if (SmartDashboard.containsKey(StringConsts.LIFT_DOWN_BUTTON)) {
			SmartDashboard.putNumber(StringConsts.LIFT_DOWN_BUTTON, 1);
		}
		if (SmartDashboard.containsKey(StringConsts.GRIP_CLOSE_BUTTON)) {
			SmartDashboard.putNumber(StringConsts.GRIP_CLOSE_BUTTON, 1);
		}
		if (SmartDashboard.containsKey(StringConsts.GRIP_OPEN_BUTTON)) {
			SmartDashboard.putNumber(StringConsts.GRIP_OPEN_BUTTON, 1);
		}
		if (SmartDashboard.containsKey(StringConsts.DRIVE_STRAIGHT_BUTTON)) {
			SmartDashboard.putNumber(StringConsts.DRIVE_STRAIGHT_BUTTON, 1);
		}
		if (SmartDashboard.containsKey(StringConsts.ROTATE_BUTTON)) {
			SmartDashboard.putNumber(StringConsts.ROTATE_BUTTON, 3);
		}
		JoystickButton driveStraight = new JoystickButton(rightJoystick,
				(int) SmartDashboard.getNumber(StringConsts.DRIVE_STRAIGHT_BUTTON, 1));
		driveStraight.whileHeld(new DriveStraightByJoystick());
		
		JoystickButton rotate = new JoystickButton(rightJoystick,
				(int) SmartDashboard.getNumber(StringConsts.DRIVE_STRAIGHT_BUTTON, 3));
		rotate.whileHeld(new RotateByJoystick());
		
		JoystickButton liftUp = new JoystickButton(leftJoystick,
				(int) SmartDashboard.getNumber(StringConsts.LIFT_UP_BUTTON, 1));
		liftUp.whileHeld(new Move(Robot.lift, (short) 1));

		JoystickButton liftDown = new JoystickButton(leftJoystick,
				(int) SmartDashboard.getNumber(StringConsts.LIFT_DOWN_BUTTON, 1));
		liftDown.whileHeld(new Move(Robot.lift, (short) -1));

		JoystickButton climbUp = new JoystickButton(leftJoystick,
				(int) SmartDashboard.getNumber(StringConsts.CLIMB_UP_BUTTON, 1));
		climbUp.whileHeld(new Move(Robot.climber, (short) 1));

		JoystickButton climbDown = new JoystickButton(leftJoystick,
				(int) SmartDashboard.getNumber(StringConsts.CLIMB_DOWN_BUTTON, 1));
		climbDown.whileHeld(new Move(Robot.climber, (short) -1));

		JoystickButton closeGrip = new JoystickButton(leftJoystick,
				(int) SmartDashboard.getNumber(StringConsts.GRIP_CLOSE_BUTTON, 1));
		closeGrip.whileHeld(new Move(Robot.climber, (short) 1));

		JoystickButton openGrip = new JoystickButton(leftJoystick,
				(int) SmartDashboard.getNumber(StringConsts.GRIP_OPEN_BUTTON, 1));
		openGrip.whileHeld(new Move(Robot.climber, (short) -1));

	}

	public double getLeftY() {

		return -leftJoystick.getY();
	}

	public double getRightY() {
		return -rightJoystick.getY();
	}

	public double getLeftX() {
		return rightJoystick.getX();
	}

	public double getRightX() {
		return rightJoystick.getX();
	}
}
