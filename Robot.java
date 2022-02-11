// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   * /
   * 
   */

  private static final int TopLeftID = 1; 
  private static final int TopLeft2ID = 2;
  private static final int TopRightID = 5; 
  private static final int TopRight2ID = 6;
  private static final int BottomLeftID = 3; 
  private static final int BottomLeft2ID = 4;
  private static final int BottomRightID = 7; 
  private static final int BottomRight2ID = 8;
  
  //private final XboxController xbox = new XboxController(0);
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  private DifferentialDrive m_myRobotTL;
  private DifferentialDrive m_myRobotTR;
  private DifferentialDrive m_myRobotBL;
  private DifferentialDrive m_myRobotBR;




  private Spark T_leftMotor;
  private Spark T_leftMotor2;
  private Spark T_rightMotor;
  private Spark T_rightMotor2;
  private Spark B_leftMotor;
  private Spark B_leftMotor2;
  private Spark B_rightMotor;
  private Spark B_rightMotor2;

  private double speed;

  @Override
  public void robotInit() {
  T_leftMotor = new Spark (TopLeftID);
  T_leftMotor2 = new Spark (TopLeft2ID);
  T_rightMotor = new Spark (TopRightID);
  T_rightMotor2 = new Spark (TopRight2ID);
  B_leftMotor = new Spark (BottomLeftID);
  B_leftMotor2 = new Spark (BottomLeft2ID);
  B_rightMotor = new Spark (BottomRightID);
  B_rightMotor2 = new Spark (BottomRight2ID);

  //m_myRobotTL = new DifferentialDrive(T_leftMotor, T_leftMotor2 );
  //m_myRobotTR = new DifferentialDrive(T_rightMotor, T_rightMotor2);
  //m_myRobotBL = new DifferentialDrive(B_leftMotor, B_leftMotor2);
  //m_myRobotBR = new DifferentialDrive(B_rightMotor, B_rightMotor2);

  m_myRobotTL = new DifferentialDrive(T_leftMotor, B_leftMotor );
  m_myRobotTR = new DifferentialDrive(T_rightMotor, B_rightMotor);
  m_myRobotBL = new DifferentialDrive(T_leftMotor2, B_leftMotor2);
  m_myRobotBR = new DifferentialDrive(T_rightMotor2, B_rightMotor2);

  m_leftStick = new Joystick(0);
  m_rightStick = new Joystick(0);

  //double speed;
  T_leftMotor2.set(-speed);
  B_leftMotor2.set(-speed);
  B_leftMotor.set(-speed);
  T_leftMotor.set(-speed);


  T_rightMotor2.set(-speed);
  B_rightMotor2.set(-speed);
  B_rightMotor.set(-speed);
  T_rightMotor.set(-speed);

  }

  



  @Override
  public void robotPeriodic() {
  m_myRobotTL.tankDrive(-m_leftStick.getY(), m_leftStick.getX());
  m_myRobotBL.tankDrive(-m_leftStick.getY(), m_leftStick.getX());
  m_myRobotTR.tankDrive(m_rightStick.getY(), m_rightStick.getX());
  m_myRobotBR.tankDrive(m_rightStick.getY(), m_rightStick.getX());

  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
     
  }

  public void setLeftMotors (double speed) {
    T_leftMotor2.set(-speed);
    T_leftMotor.set(-speed);
    B_leftMotor.set(-speed);
    B_leftMotor2.set(-speed);
  } 
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
