package org.usfirst.frc.team4661.robot.command.groups;

import org.usfirst.frc.team4661.robot.drive.commands.DriveByDegree;
import org.usfirst.frc.team4661.robot.drive.commands.RotateAutomaticaly;

public class Middle_Autonomous_Right extends CommandGroupBase {
	public Middle_Autonomous_Right() {
		buildParamaters();
		addSequential(new DriveByDegree(timeBlock, speedBlock, 0, (short) 1));
		addSequential(new DriveByDegree(timeSideSwitch, speedSideSwitch, -degreeSideSwitch, (short) 1));
		addSequential(new RotateAutomaticaly(rotateSpeed, degreeSideSwitch, (short) -1));
		addSequential(new DriveByDegree(timeScale, speedScale, 0, (short) 1));

	}
}
