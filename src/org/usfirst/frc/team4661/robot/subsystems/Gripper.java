package org.usfirst.frc.team4661.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

public class Gripper extends InOutSystem{
	TalonSRX leftMotor;
	TalonSRX rightMotor;
	DigitalInput limitIn;
	DigitalInput limitOut;
	public Gripper(TalonSRX leftMotor, TalonSRX rightMotor, DigitalInput limitIn,DigitalInput limitOut) {
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
		this.limitIn = limitIn;
		this.limitOut = limitOut;
	}
	@Override
	public void move(double speedValue, short direction) {
		speedValue *= direction;
		leftMotor.set(ControlMode.Velocity, speedValue);
		leftMotor.set(ControlMode.Velocity, -speedValue);

	}

	@Override
	public boolean isIn() {
		return limitIn.get();
	}

	@Override
	public boolean isOut() {
		return limitOut.get();
	}
	

	@Override
	public boolean hasInLimit() {
		return limitIn != null;
	}

	@Override
	public boolean hasOutLimit() {
		return limitOut != null;
	}

	@Override
	public void stop() {
		move(0, (short) 1);
	}

}
