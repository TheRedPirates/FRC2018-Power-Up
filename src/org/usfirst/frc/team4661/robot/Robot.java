
package org.usfirst.frc.team4661.robot;

import org.usfirst.frc.team4661.robot.command.groups.Left_Autonomous_Left;
import org.usfirst.frc.team4661.robot.command.groups.Left_Autonomous_Left_Block;
import org.usfirst.frc.team4661.robot.command.groups.Middle_Autonomous_Left;
import org.usfirst.frc.team4661.robot.command.groups.Middle_Autonomous_Left_Block;
import org.usfirst.frc.team4661.robot.command.groups.Middle_Autonomous_Right;
import org.usfirst.frc.team4661.robot.command.groups.Middle_Autonomous_Right_Block;
import org.usfirst.frc.team4661.robot.command.groups.Right_Autonomous_Right;
import org.usfirst.frc.team4661.robot.command.groups.Right_Autonomous_Right_Block;
import org.usfirst.frc.team4661.robot.drive.commands.DriveByDegree;
import org.usfirst.frc.team4661.robot.drive.commands.RotateAutomaticaly;
import org.usfirst.frc.team4661.robot.inoutsystems.commands.Move;
import org.usfirst.frc.team4661.robot.subsystems.Climber;
import org.usfirst.frc.team4661.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4661.robot.subsystems.Gripper;
import org.usfirst.frc.team4661.robot.subsystems.Lift;
import org.usfirst.frc.team4661.robot.subsystems.Vision;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static Climber climber;
	public static Gripper gripper;
	public static Lift lift;
	public static DriveTrain drive;
	public static Vision vision;
	public static CameraServer cam;
	public static OI oi;
	Command autonomousCommand;
	SendableChooser<Command> chooser;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		if (SmartDashboard.containsKey(StringConsts.DRIVETRAIN_LIMIT)) {
			SmartDashboard.putNumber(StringConsts.DRIVETRAIN_LIMIT, 1);
		}
		double speed = SmartDashboard.getNumber(StringConsts.DRIVETRAIN_LIMIT, 1);
		System.out.println("init");
		vision = new Vision(CameraServer.getInstance().startAutomaticCapture());

		TalonSRX liftTalon = new TalonSRX(RobotMap.LIFT_TALON_PORT);
		DigitalInput liftMax = new DigitalInput(RobotMap.LIFT_MAX_LIMIT);
		DigitalInput liftMin = new DigitalInput(RobotMap.LIFT_MIN_LIMIT);
		lift = new Lift(liftTalon, liftMax, liftMin);

		TalonSRX climbUpTalon = new TalonSRX(RobotMap.CLIMB_UP_TALON_PORT);
		TalonSRX climbDownTalon = new TalonSRX(RobotMap.CLIMB_DOWN_TALON_PORT);
		DigitalInput climbMax = new DigitalInput(RobotMap.CLIMB_MAX_LIMIT);
		DigitalInput climbMin = new DigitalInput(RobotMap.CLIMB_MIN_LIMIT);
		climber = new Climber(climbUpTalon, climbDownTalon, climbMax, climbMin);

		TalonSRX leftGripTalon = new TalonSRX(RobotMap.LEFT_GRIP_TALON_PORT);
		TalonSRX rightGripTalon = new TalonSRX(RobotMap.RIGHT_GRIP_TALON_PORT);
		DigitalInput gripMax = new DigitalInput(RobotMap.GRIP_MAX_LIMIT);
		DigitalInput gripMin = new DigitalInput(RobotMap.GRIP_MIN_LIMIT);
		gripper = new Gripper(leftGripTalon, rightGripTalon, gripMax, gripMin);

		Talon leftRear = new Talon(RobotMap.LEFT_REAR_TALON_PORT);
		Talon leftFront = new Talon(RobotMap.LEFT_FRONT_TALON_PORT);
		Talon rightRear = new Talon(RobotMap.RIGHT_REAR_TALON_PORT);
		Talon rightFront = new Talon(RobotMap.RIGHT_FRONT_TALON_PORT);
		GearBox left = new GearBox(leftFront, leftRear);
		GearBox right = new GearBox(rightFront, rightRear);
		drive = new DriveTrain(left, right);

		oi = new OI();
		chooser = new SendableChooser<>();
		DriveByDegree driveByDegree = new DriveByDegree(1, speed, 0, (short) 1);
		RotateAutomaticaly rotateRightAutomaticaly = new RotateAutomaticaly(speed, 90, (short) 1);
		RotateAutomaticaly rotateLeftAutomaticaly = new RotateAutomaticaly(speed, 90, (short) -1);
		Move liftUp = new Move(lift, 1, (short) 1);
		Move liftDown = new Move(lift, 1, (short) 1);
		Move gripIn = new Move(gripper, Consts.COMPLETE_OPEN_TIME, (short) 1);
		Move gripOut = new Move(gripper, Consts.COMPLETE_OPEN_TIME, (short) -1);
		Left_Autonomous_Left_Block left_Autonomous_Left_Block = new Left_Autonomous_Left_Block();
		Left_Autonomous_Left left_Autonomous_Left = new Left_Autonomous_Left();
		Middle_Autonomous_Left_Block middle_Autonomous_Left_Block = new Middle_Autonomous_Left_Block();
		Middle_Autonomous_Left middle_Autonomous_Left = new Middle_Autonomous_Left();
		Middle_Autonomous_Right_Block middle_Autonomous_Right_Block = new Middle_Autonomous_Right_Block();
		Middle_Autonomous_Right middle_Autonomous_Right = new Middle_Autonomous_Right();
		Right_Autonomous_Right_Block right_Autonomous_Right_Block = new Right_Autonomous_Right_Block();
		Right_Autonomous_Right right_Autonomous_Right = new Right_Autonomous_Right();

		chooser.addDefault("by constant speed", driveByDegree);
		chooser.addObject("rotateRight", rotateRightAutomaticaly);
		chooser.addObject("rotateLeft", rotateLeftAutomaticaly);
		chooser.addObject("liftUp", liftUp);
		chooser.addObject("liftDown", liftDown);
		chooser.addObject("gripIn", gripIn);
		chooser.addObject("gripOut", gripOut);
		chooser.addObject("left_Autonomous_Left_Block", left_Autonomous_Left_Block);
		chooser.addObject("middle_Autonomous_Left", middle_Autonomous_Left);
		chooser.addObject("middle_Autonomous_Left_Block", middle_Autonomous_Left_Block);
		chooser.addObject("middle_Autonomous_Left", middle_Autonomous_Left);
		chooser.addObject("middle_Autonomous_Right_Block", middle_Autonomous_Right_Block);
		chooser.addObject("middle_Autonomous_Right", middle_Autonomous_Right);
		chooser.addObject("right_Autonomous_Right_Block", right_Autonomous_Right_Block);
		chooser.addObject("right_Autonomous_Right", right_Autonomous_Right);

		SmartDashboard.putData(driveByDegree);
		SmartDashboard.putData(rotateRightAutomaticaly);
		SmartDashboard.putData(rotateLeftAutomaticaly);
		SmartDashboard.putData(liftUp);
		SmartDashboard.putData(liftDown);
		SmartDashboard.putData(gripIn);
		SmartDashboard.putData(gripOut);
		SmartDashboard.putData(left_Autonomous_Left_Block);
		SmartDashboard.putData(left_Autonomous_Left);
		SmartDashboard.putData(middle_Autonomous_Left_Block);
		SmartDashboard.putData(middle_Autonomous_Left);
		SmartDashboard.putData(middle_Autonomous_Right_Block);
		SmartDashboard.putData(middle_Autonomous_Right);
		SmartDashboard.putData(right_Autonomous_Right_Block);
		SmartDashboard.putData(right_Autonomous_Right);
		SmartDashboard.putData("Auto mode", chooser);

	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		System.out.println("teleop: " + Timer.getMatchTime());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
