package frc.robot.commands.TurretAuto;
//this command enaables the feeder and then the shooter in order to shoot them lemons, aim first
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

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
    RobotContainer.m_shooterSubsystem.setShooterSpeed(
      0.66
      //RobotContainer.m_shooterSubsystem.getRangeOfTrajectory()/6380
    );


    if(timer.get() > shootDuration) {
      RobotContainer.m_intakeSystem.setFeederSystem(1, 0.7);
      RobotContainer.m_intakeSystem.setConveyorSpeed(-1, 1);
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
    return !RobotContainer.m_controllerSubsystem.m_operatorController.getR2Button();
    // return timer.get() > shootDuration;
    // return (timer.get() > shootDuration) || !RobotContainer.m_controllerSubsystem.m_operatorController.getB();
  }
}