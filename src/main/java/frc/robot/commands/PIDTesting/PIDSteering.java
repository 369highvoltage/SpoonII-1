package frc.robot.commands.PIDTesting;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class PIDSteering extends CommandBase{

    PIDController pid;

    double direction;

    double currentDegrees;
    double targetDegrees;

    public PIDSteering(double targetDegrees){
        this.targetDegrees = targetDegrees;
        
        pid = new PIDController(Constants.sP, Constants.sI, Constants.sD);
        pid.setTolerance(0.1);
        pid.setIntegratorRange(-Constants.sILimit, Constants.sILimit);
    }

    @Override
    public void initialize() {
        //reset pigeon and PID
        pid.reset();
        RobotContainer.m_driveSubsystem.pigeonReset();
        /**
         * Check direction of target based on whether it's
         * clockwise (+) or counterclockwise (-)
         */
        if(targetDegrees > 0)
            direction = 1;
        else if(targetDegrees < 0)
            direction = -1;

    }

    @Override
    public void execute() {
        //get absolute value of encoder and input
        double absTarg = Math.abs(targetDegrees);
        currentDegrees = Math.abs(RobotContainer.m_driveSubsystem.getRotation());
        
        //apply speeds to motor via PID
        double speed = pid.calculate(currentDegrees, absTarg);
        RobotContainer.m_driveSubsystem.arcadeDrive(0, speed*direction*Constants.steeringModifier);

        SmartDashboard.putNumber("PID Steering", speed*direction*Constants.steeringModifier);
    }

    @Override
    public void end(boolean interrupted){
        RobotContainer.m_driveSubsystem.arcadeDrive(0, 0);
    }

    @Override
    public boolean isFinished(){
        return pid.atSetpoint();
    }

}
