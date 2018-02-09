package org.usfirst.frc.team4661.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

public class Lift extends InOutSystem {
	TalonSRX motor;
	DigitalInput limitUp;
	DigitalInput limitDown;

	public Lift(TalonSRX motor, DigitalInput up, DigitalInput down) {
		this.motor = motor;
		this.limitUp = up;
		this.limitDown = down;
	}

	@Override
	public void move(double speedValue, short direction) {
		speedValue *= direction;
		motor.set(ControlMode.Velocity, speedValue);
	}

	@Override
	public boolean isIn() {
		return limitUp.get();
	}

	@Override
	public boolean isOut() {
		return limitDown.get();
	}

	@Override
	public boolean hasInLimit() {
		return limitDown != null;
	}

	@Override
	public boolean hasOutLimit() {
		if (limitDown != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void stop() {
		move(0, (short) 0);
	}
}
