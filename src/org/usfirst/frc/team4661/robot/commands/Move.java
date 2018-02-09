package org.usfirst.frc.team4661.robot.commands;

import org.usfirst.frc.team4661.robot.StringConsts;
import org.usfirst.frc.team4661.robot.subsystems.InOutSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Move extends Command {
	InOutSystem inOutSystem;
	short direction;
	public Move(InOutSystem inOutSystem, short direction) {
		this.inOutSystem = inOutSystem;
		this.direction = direction;
		requires(inOutSystem);
		if (SmartDashboard.containsKey(StringConsts.SYSTEM_SPEED)) {
			SmartDashboard.putNumber(StringConsts.SYSTEM_SPEED, 0.5);
		}

	}

	protected void initialize() {
		if (SmartDashboard.containsKey(StringConsts.SYSTEM_SPEED)) {
			SmartDashboard.putNumber(StringConsts.SYSTEM_SPEED, 0.5);
		}
		if (!inOutSystem.hasInLimit()) {
			double timer = 0;
			setTimeout(timer);
		}
	}

	protected void execute() {
		double speed = SmartDashboard.getNumber(StringConsts.SYSTEM_SPEED, 0.5);
		inOutSystem.move(speed, direction);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return inOutSystem.isIn() || isTimedOut();
	}

	protected void end() {
		inOutSystem.stop();
	}

	protected void interrupted() {
		end();
	}

}
