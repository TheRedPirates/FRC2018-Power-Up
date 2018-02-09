package org.usfirst.frc.team4661.robot.command.groups;

import org.usfirst.frc.team4661.robot.drive.commands.DriveByDegree;
import org.usfirst.frc.team4661.robot.drive.commands.RotateAutomaticaly;

public class Left_Autonomous_Left extends CommandGroupBase {
	public Left_Autonomous_Left() {
		buildParamaters();
		addSequential(new DriveByDegree(timeBlock, speedBlock, 0, (short) 1));
		addSequential(new DriveByDegree(timeSideSwitch, speedSideSwitch, degreeSideSwitch, (short) 1));
		addSequential(new RotateAutomaticaly(rotateSpeed, degreeSideSwitch, (short) 1));
		addSequential(new DriveByDegree(timeScale, speedScale, 0, (short) 1));

	}
}
