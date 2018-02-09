package org.usfirst.frc.team4661.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

public class Climber extends InOutSystem {
	TalonSRX motorUp;
	TalonSRX motorDown;
	DigitalInput limitUp;
	DigitalInput limitDown;

	public Climber(TalonSRX motorUp, TalonSRX motorDown, DigitalInput limitUp, DigitalInput limitDown) {
		this.motorUp = motorUp;
		this.motorDown = motorDown;
		this.limitUp = limitUp;
		this.limitDown = limitDown;
	}

	@Override
	public void move(double speedValue, short direction) {
		switch (direction) {
		case InOutSystem.DIR_IN:
			motorDown.set(ControlMode.Velocity, speedValue);
			break;
		case InOutSystem.DIR_OUT:
			motorDown.set(ControlMode.Velocity, speedValue);
			break;
		}
	}

	@Override
	public boolean isIn() {
		return limitDown.get();
	}

	@Override
	public boolean isOut() {
		return limitUp.get();
	}

	@Override
	public boolean hasInLimit() {
		return limitDown != null;
	}

	@Override
	public boolean hasOutLimit() {
		return limitUp != null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		move(0, (short) 1);
	}

}
