package org.usfirst.frc.team4661.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class InOutSystem extends Subsystem{
public abstract void move(double speedValue,short direction);
public abstract boolean isIn();
public abstract boolean isOut();
public abstract boolean hasInLimit();
public abstract boolean hasOutLimit();
public abstract void stop();

public static final short DIR_OUT = -1, DIR_IN = 1;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
