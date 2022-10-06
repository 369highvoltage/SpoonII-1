/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TurretAuto;
//this command enaables the feeder and then the shooter in order to shoot them lemons, aim first
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShootingCommand extends CommandBase {
  private final byte shootDuration = 2;
  Timer timer;
  boolean buttonPressed;
  double mod;
  double maximum = 17300;
  double acc;
  
  public ShootingCommand() {
    timer = new Timer();
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    
    

    SmartDashboard.putBoolean("Shooting", true);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    final PS4Controller operatorController = new PS4Controller(1);
    Double Speed = 0.0; 

    
    if (operatorController.getR2Button() == true) {
      Speed = 0.40;
   }

    RobotContainer.m_shooterSubsystem.setShooterSpeed(
      Speed
    );

    if(timer.get() > shootDuration) {
      RobotContainer.m_intakeSystem.setFeederSystem(1, 0.25);
      RobotContainer.m_intakeSystem.setConveyorSpeed(1, 1);
    }
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_shooterSubsystem.setShooterSpeed(0.0);
    RobotContainer.m_intakeSystem.setFeederSystem(0.0, 1);
    RobotContainer.m_intakeSystem.setConveyorSpeed(0, 0.0);

    timer.reset();
    
    SmartDashboard.putBoolean("Shooting", false);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return !RobotContainer.m_controllerSubsystem.m_operatorController.getCrossButtonPressed();
    // return timer.get() > shootDuration;
    // return (timer.get() > shootDuration) || !RobotContainer.m_controllerSubsystem.m_operatorController.getB();
  }
}