package frc.robot.commands.Manual;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotContainer;

public class TimedIntakeForward extends CommandBase { 
    Timer timer;
    private final double seconds;

    public TimedIntakeForward(double duration) {
        timer = new Timer();
        seconds = duration;
    }
    public void initialize() {
        timer.reset();
        timer.start();
        RobotContainer.m_pnuematicSubsystem.setIntakeReverse();
    }

    public void execute() {
        RobotContainer.m_pnuematicSubsystem.setIntakeReverse();
    }

    public boolean isFinished() {
        return timer.get() > seconds;
    }

    public void end() {
        RobotContainer.m_pnuematicSubsystem.setIntakeReverse();
    }
}
