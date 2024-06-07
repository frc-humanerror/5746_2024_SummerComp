// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kljoystickport = 2;
    public static final int krjoystickport = 1;
  }
  public static class DriveConstants {
    public static final double teleopDriveMult = 0.75;
    public static final double wheelCircumference = 0.478778720406; // This value is in meters
    public static final double autoDriveMult = 0.5;
    public static final double triggerSpeedChange = 0;
  }
  public static class LauncherConstants {
    public static final double launchSpeed = 0.85; //.88
    public static final double autoLaunchSpeed = .7;//.92
  }
  public static class IntakeConstants {
    public static final double intakeSpeed = 0.4;
    public static final double outtakeSpeed = -0.5;
  }
  public static class WristIntakeConstants {
    public static final double wristIntakeSetpointB = -171;
    public static final double wristIntakeSetpointA = 0;
    public static final double PscaleFactor = 425; // Equal to multiplying by a kP of 0.00222..., so maybe drop it to 0.002 when/if switching to kP to start and tune it by like 0.0001 per test to make it faster
  }
  public static class ClimberConstants {
    public static final double climbExtendSpeed = 0.4;
    public static final double climberExtendLimit = 710;
  }
}
