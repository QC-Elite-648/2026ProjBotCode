package frc.robot.subsystems.ClimberSubsystem;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.LimitSwitchConfig.Type;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.Constants.CanConstants;
import frc.robot.Constants.Climb;

import edu.wpi.first.math.controller.PIDController;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

    public class ClimberSubsystem extends SubsystemBase{

        //setting up the motors
        private final SparkMax climbMotor = new SparkMax(CanConstants.ClimbMotorCanID, MotorType.kBrushless);
        
        private SparkMaxConfig climbMotorConfig = new SparkMaxConfig();

    //set speed
        public void setSpeedClimbMotor(double speed) {
        climbMotor.set(speed);
    }

    public void setSpeed(double speed){
        climbMotor.set(speed);
    }
    private PIDController climberPID = new PIDController(.8,0,0);
    

        //limit switches
        private final DigitalInput limitSwitchClimb = new DigitalInput(0);
    


    public ClimberSubsystem() {

        // Hardware Limit Switches (Normally Closed is safer!)
        climbMotorConfig.limitSwitch
            .forwardLimitSwitchType(Type.kNormallyClosed)
            .reverseLimitSwitchType(Type.kNormallyClosed)
            .forwardLimitSwitchEnabled(true)  
            .reverseLimitSwitchEnabled(true); 

        // Soft limits (Now using INCHES instead of rotations)
        climbMotorConfig.softLimit
            .forwardSoftLimitEnabled(true)
            .forwardSoftLimit(Constants.Climb.kMaxHeightInches);

        //Right follows Left
        climbMotorConfig.inverted(true);
        
        //Brake
        climbMotorConfig.idleMode(IdleMode.kBrake);
        
        climberPID.setTolerance(1);
    }

    }





