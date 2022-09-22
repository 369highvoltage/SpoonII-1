// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {

  public CANSparkMax leftMotor,rightMotor;
  public DoubleSolenoid climberSolenoid;
  public RelativeEncoder leftEncoder,rightEncoder;

  PneumaticHub ph;

  /** Creates a new ClimberSubsystem. */
  public ClimberSubsystem() {

    ph = new PneumaticHub(20);

    leftMotor = new CANSparkMax(16, MotorType.kBrushless);
    rightMotor = new CANSparkMax(17, MotorType.kBrushless);

    //Gets encoders from the motor controllers attached
    leftEncoder = leftMotor.getEncoder();
    rightEncoder = rightMotor.getEncoder();

    //resets encoders to 0, MAKE SURE EVERYTHING IS RESET INTO THE BOTTOM POSITION BEFORE STARTING!
    rightEncoder.setPosition(0);
    leftEncoder.setPosition(0);

    climberSolenoid = ph.makeDoubleSolenoid(3,4);
  }

  public void setClimberSpeed(double speed, double mod) {
    leftMotor.setInverted(true);
    rightMotor.setInverted(false);
    rightMotor.set(speed*mod);
    leftMotor.set(speed*mod);
  }


  public void setClimberSolenoid(Value direction) {
    climberSolenoid.set(direction);
  }


  public void climberOutput(){
    SmartDashboard.putNumber("Climber RIGHT", rightEncoder.getPosition());
    SmartDashboard.putNumber("Climber LEFT", leftEncoder.getPosition());

  }
}
