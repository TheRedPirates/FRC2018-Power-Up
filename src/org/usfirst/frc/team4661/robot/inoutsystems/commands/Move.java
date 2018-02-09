package org.usfirst.frc.team4661.robot.inoutsystems.commands;

import org.usfirst.frc.team4661.robot.StringConsts;
import org.usfirst.frc.team4661.robot.subsystems.InOutSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Move extends Command {
	InOutSystem inOutSystem;
	short direction;
	double timer;
	public Move(InOutSystem inOutSystem,double timer, short direction) {
		this.inOutSystem = inOutSystem;
		this.direction = direction;
		this.timer = timer;
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
