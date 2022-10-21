// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoAim.AutoAimCommand;
import frc.robot.commands.AutonomousSequencing.AutonomousCommand;
import frc.robot.commands.AutonomousSequencing.TestCommand;
import frc.robot.commands.OLD.DriveBackwards;
import frc.robot.commands.TurretAuto.IntakeCommand;
import frc.robot.commands.TurretAuto.ShootingCommand;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private RobotContainer m_robotContainer;
  private Command m_autoCommand;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    //CameraServer.startAutomaticCapture();
    m_robotContainer = new RobotContainer(); //starts everything within RobotContainer
    m_robotContainer.m_driveSubsystem.getLinearDistanceEncoder(); //gets distance from the driven motors
    m_robotContainer.m_driveSubsystem.getRotation(); //gets rotation angle from the pigeon
    //m_autoCommand = new AutonomousCommand();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    m_robotContainer.SetupDashboard();
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autoCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    m_autoCommand.schedule();

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {    
    /** 
     * 
     * Due to no longer having the limelight attached for
     * varying lighting conditions every 5 minutes, this is unnecessary.
    
    double leftAdjust = -1.0; 
    double rightAdjust = -1.0; // default speed values for chase
    double mindistance = 10;
    leftAdjust -= m_robotContainer.m_limelight.steeringAdjust();//adjust each side according to tx
    rightAdjust += m_robotContainer.m_limelight.steeringAdjust();
    System.out.println(m_robotContainer.m_limelight.getDistance());
   // new DriveBackwards(5,5);
   // new IntakeCommand(5, 5);
   */
  

    System.out.println("auto periodic");
  }
    
    



  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    
    //Initializes shooters for preparation
    m_robotContainer.ShooterInit();

    //FOR TESTING ONLY, DO NOT USE FOR PRACTICE AND FIELD
    //m_robotContainer.testing();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    m_robotContainer.controllerPeriodic(); //activates shooter
    m_robotContainer.driveRobot(); //drives robot
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }
}
