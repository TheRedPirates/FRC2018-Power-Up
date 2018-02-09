package org.usfirst.frc.team4661.robot.command.groups;

import org.usfirst.frc.team4661.robot.Consts;
import org.usfirst.frc.team4661.robot.Robot;
import org.usfirst.frc.team4661.robot.drive.commands.DriveByDegree;
import org.usfirst.frc.team4661.robot.drive.commands.RotateAutomaticaly;
import org.usfirst.frc.team4661.robot.inoutsystems.commands.Move;

public class Middle_Autonomous_Right_Block extends CommandGroupBase {
	public Middle_Autonomous_Right_Block() {
		buildParamaters();
		addSequential(new DriveByDegree(timeBlock, speedBlock, 0, (short) 1));
		addSequential(new DriveByDegree(timeBlock, speedBlock, 0, (short) -1));
		addSequential(new Move(Robot.gripper, Consts.COMPLETE_OPEN_TIME, (short) 1));
		addSequential(new DriveByDegree(timeBlock, speedBlock, 0, (short) 1));
		addSequential(new Move(Robot.gripper, Consts.OPEN_TIME, (short) -1));
		addParallel(new Move(Robot.lift, 15, (short) 1));
		addSequential(new DriveByDegree(timeMidSwitch, speedMidSwitch, -degreeMidSwitch, (short) 1));
		addSequential(new RotateAutomaticaly(rotateSpeed, 90 + degreeMidSwitch, (short) -1));
		addSequential(new DriveByDegree(timeSwitch, speedSwitch, 0, (short) 1));
		addSequential(new Move(Robot.gripper, Consts.OPEN_TIME, (short) 1));
		addParallel(new Move(Robot.gripper, Consts.COMPLETE_OPEN_TIME, (short) -1));
		addSequential(new DriveByDegree(timeSwitch, speedSwitch, 0, (short) -1));
		addParallel(new Move(Robot.lift, 15, (short) -1));
		addSequential(new RotateAutomaticaly(rotateSpeed, 90, (short) 1));
		addSequential(new DriveByDegree(timeScale, speedScale, 0, (short) 1));

	}
}
