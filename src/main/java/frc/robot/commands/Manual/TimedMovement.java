package frc.robot.commands.Manual;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TimedMovement extends CommandBase {
    Timer timer;
    private final double seconds;

    public TimedMovement(double duration) {
        timer = new Timer();
        seconds = duration;
    }

    public void initialize() {
        timer.reset();
        timer.start();
        RobotContainer.m_driveSubsystem.tankDrive(Constants.autoSpeed, Constants.autoSpeed);
    }

    public void execute() {
        RobotContainer.m_driveSubsystem.tankDrive(Constants.autoSpeed, Constants.autoSpeed);
    }

    public boolean isFinished() {
        return timer.get() > seconds;
    }

    public void end() {
        RobotContainer.m_driveSubsystem.tankDrive(0, 0);
    }
}
