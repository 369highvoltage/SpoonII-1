package frc.robot.commands.OLD;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class RevUpShooter extends CommandBase {

    public RevUpShooter() {
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        if(interrupted)
            RobotContainer.m_shooterSubsystem.setShooterSpeed(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
        //return pid.atSetpoint();
    }
}