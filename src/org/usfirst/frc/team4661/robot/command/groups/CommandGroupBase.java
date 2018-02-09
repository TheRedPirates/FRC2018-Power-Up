package org.usfirst.frc.team4661.robot.command.groups;

import org.usfirst.frc.team4661.robot.StringConsts;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommandGroupBase extends CommandGroup{
	double degreeSideSwitch;
	double degreeMidSwitch;
	double timeSideSwitch;
	double timeMidSwitch;
	double speedSideSwitch;
	double speedMidSwitch;
	double timeSwitch;
	double speedSwitch;
	double timeBlock;
	double speedBlock;
	double timeScale;
	double speedScale;
	double rotateSpeed;

	public void buildParamaters() {
		if (!SmartDashboard.containsKey(StringConsts.DEGREE_SIDE_TO_SWITCH)) {
			SmartDashboard.putNumber(StringConsts.DEGREE_SIDE_TO_SWITCH, 7);
		}
		if (!SmartDashboard.containsKey(StringConsts.DEGREE_MID_TO_SWITCH)) {
			SmartDashboard.putNumber(StringConsts.DEGREE_MID_TO_SWITCH, 22);
		}
		if (!SmartDashboard.containsKey(StringConsts.TIME_SIDE_TO_SWITCH)) {
			SmartDashboard.putNumber(StringConsts.TIME_SIDE_TO_SWITCH, 2);
		}
		if (!SmartDashboard.containsKey(StringConsts.TIME_MID_TO_SWITCH)) {
			SmartDashboard.putNumber(StringConsts.TIME_MID_TO_SWITCH, 3);
		}
		if (!SmartDashboard.containsKey(StringConsts.SPEED_SIDE_TO_SWITCH)) {
			SmartDashboard.putNumber(StringConsts.SPEED_SIDE_TO_SWITCH, 0.7);
		}
		if (!SmartDashboard.containsKey(StringConsts.SPEED_MID_TO_SWITCH)) {
			SmartDashboard.putNumber(StringConsts.SPEED_MID_TO_SWITCH, 0.7);
		}
		if (!SmartDashboard.containsKey(StringConsts.TIME_TO_SWITCH)) {
			SmartDashboard.putNumber(StringConsts.TIME_TO_SWITCH, 0.5);
		}
		if (!SmartDashboard.containsKey(StringConsts.SPEED_TO_SWITCH)) {
			SmartDashboard.putNumber(StringConsts.SPEED_TO_SWITCH, 0.7);
		}
		if (!SmartDashboard.containsKey(StringConsts.TIME_TO_BLOCK)) {
			SmartDashboard.putNumber(StringConsts.TIME_TO_BLOCK, 0.8);
		}
		if (!SmartDashboard.containsKey(StringConsts.SPEED_TO_BLOCK)) {
			SmartDashboard.putNumber(StringConsts.SPEED_TO_BLOCK, 0.7);
		}
		if (!SmartDashboard.containsKey(StringConsts.TIME_TO_SCALE)) {
			SmartDashboard.putNumber(StringConsts.TIME_TO_SCALE, 2.2);
		}
		if (!SmartDashboard.containsKey(StringConsts.SPEED_TO_SCALE)) {
			SmartDashboard.putNumber(StringConsts.SPEED_TO_SCALE, 0.7);
		}
		if (!SmartDashboard.containsKey(StringConsts.ROTATE_SPEED)) {
			SmartDashboard.putNumber(StringConsts.ROTATE_SPEED, 0.7);
		}
		degreeSideSwitch = SmartDashboard.getNumber(StringConsts.DEGREE_SIDE_TO_SWITCH, 7);
		degreeMidSwitch = SmartDashboard.getNumber(StringConsts.DEGREE_MID_TO_SWITCH, 22);
		timeSideSwitch = SmartDashboard.getNumber(StringConsts.TIME_SIDE_TO_SWITCH, 2);
		timeMidSwitch = SmartDashboard.getNumber(StringConsts.TIME_MID_TO_SWITCH, 3);
		speedSideSwitch = SmartDashboard.getNumber(StringConsts.SPEED_SIDE_TO_SWITCH, 0.7);
		speedMidSwitch = SmartDashboard.getNumber(StringConsts.SPEED_MID_TO_SWITCH, 0.7);
		timeSwitch = SmartDashboard.getNumber(StringConsts.TIME_TO_SWITCH, 0.5);
		speedSwitch = SmartDashboard.getNumber(StringConsts.SPEED_TO_SWITCH, 0.7);
		timeBlock = SmartDashboard.getNumber(StringConsts.TIME_TO_BLOCK, 0.8);
		speedBlock = SmartDashboard.getNumber(StringConsts.SPEED_TO_BLOCK, 0.7);
		timeScale = SmartDashboard.getNumber(StringConsts.TIME_TO_SCALE, 2.2);
		speedScale = SmartDashboard.getNumber(StringConsts.SPEED_TO_SCALE, 0.7);
		rotateSpeed = SmartDashboard.getNumber(StringConsts.ROTATE_SPEED, 0.7);
	}
}
