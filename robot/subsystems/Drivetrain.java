// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivetrain extends SubsystemBase {
  private WPI_TalonSRX lfrontTalon = new WPI_TalonSRX(2);
  private WPI_TalonSRX lbackTalon = new WPI_TalonSRX(1);
  private WPI_TalonSRX rfrontTalon = new WPI_TalonSRX(4);
  private WPI_TalonSRX rbackTalon = new WPI_TalonSRX(3);
  edu.wpi.first.wpilibj.Encoder ldriveEncoder = new edu.wpi.first.wpilibj.Encoder(2,3);
  edu.wpi.first.wpilibj.Encoder rdriveEncoder = new edu.wpi.first.wpilibj.Encoder(0,1);
  double change = 0;

  public Drivetrain() {
    lbackTalon.follow(lfrontTalon);
    rbackTalon.follow(rfrontTalon);
    ldriveEncoder.reset();
    rdriveEncoder.reset();
  }

  public double getMetersDriven() {
    return ldriveEncoder.getDistance()/2*DriveConstants.wheelCircumference/480;
  }
  public void resetEncoders() {
    ldriveEncoder.reset();
    rdriveEncoder.reset();
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public void move(double linput, double rinput) {
    double error = (ldriveEncoder.getRate()-rdriveEncoder.getRate())/40960;
    double lmove = -linput*(DriveConstants.teleopDriveMult+change);
    double rmove = rinput*(DriveConstants.teleopDriveMult+change);

    if(RobotContainer.getltrigger()) {
      change = -DriveConstants.triggerSpeedChange;
    }
    else if(RobotContainer.getrtrigger()) {
      change = DriveConstants.triggerSpeedChange;
    }
    else {
      change = 0;
    }

    //lfrontTalon.set(drivePID.calculate(driveEncoder.getRate(), lmove));
    //rfrontTalon.set(drivePID.calculate(driveEncoder.getRate(), rmove));
    lfrontTalon.set(lmove);
    rfrontTalon.set(rmove);
    SmartDashboard.putNumber("Left input", lmove);
    SmartDashboard.putNumber("Right input", rmove);
    SmartDashboard.putNumber("Error", error);
    SmartDashboard.putNumber("Left Drive Distance (360 = one full rotation)", ldriveEncoder.getDistance()/5.689);
    SmartDashboard.putNumber("Left Rotations of Drivetrain", ldriveEncoder.getDistance()/2048);
    SmartDashboard.putNumber("Left Rotations per second", ldriveEncoder.getRate()/2048);
    SmartDashboard.putNumber("Left Velocity (Meters per second)", ldriveEncoder.getRate()*DriveConstants.wheelCircumference/2048);
    SmartDashboard.putNumber("Right Drive Distance (360 = one full rotation)", rdriveEncoder.getDistance()/5.689);
    SmartDashboard.putNumber("Right Rotations of Drivetrain", rdriveEncoder.getDistance()/2048);
    SmartDashboard.putNumber("Right Rotations per second", rdriveEncoder.getRate()/2048);
    SmartDashboard.putNumber("Right Velocity (Meters per second)", rdriveEncoder.getRate()*DriveConstants.wheelCircumference/2048);
    SmartDashboard.putNumber("Velocity (Meters per second)", (ldriveEncoder.getRate()+rdriveEncoder.getRate())/2*DriveConstants.wheelCircumference/2048);
    SmartDashboard.putNumber("Meters Driven", getMetersDriven());
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
  
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}