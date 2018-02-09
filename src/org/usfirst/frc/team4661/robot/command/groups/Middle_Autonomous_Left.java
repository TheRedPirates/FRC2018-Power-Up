package org.usfirst.frc.team4661.robot.command.groups;

import org.usfirst.frc.team4661.robot.drive.commands.DriveByDegree;
import org.usfirst.frc.team4661.robot.drive.commands.RotateAutomaticaly;

public class Middle_Autonomous_Left extends CommandGroupBase {
	public Middle_Autonomous_Left() {
		buildParamaters();
		addSequential(new DriveByDegree(timeBlock, speedBlock, 0, (short) 1));
		addSequential(new DriveByDegree(timeMidSwitch, speedMidSwitch, -degreeMidSwitch, (short) 1));
		addSequential(new RotateAutomaticaly(rotateSpeed, degreeMidSwitch, (short) -1));
		addSequential(new DriveByDegree(timeScale, speedScale, 0, (short) 1));

	}
}
