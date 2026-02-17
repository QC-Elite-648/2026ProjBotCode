package frc.robot.subsystems.ClimberSubsystem;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.Constants.CanConstants;
import frc.robot.Constants.ClimberConstants;

import edu.wpi.first.math.controller.PIDController;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

    public class ClimberSubsystem extends SubsystemBase{

        //setting up the motors
        private final SparkMax climbLeft= new SparkMax(CanConstants.ClimbGoUpMotorCanID, MotorType.kBrushless);
        private final SparkMax climbRight = new SparkMax(CanConstants.ClimbDeployMotorCanID, MotorType.kBrushless);
        
        private SparkMaxConfig climbLeftConfig = new SparkMaxConfig();
        private SparkMaxConfig climbRightConfig = new SparkMaxConfig();

    //set speed
        public void setSpeedClimbLeft(double speed) {
        climbLeft.set(speed);
    }
    
    public void setSpeedRight(double speed) {
        climbRight.set(speed);
    }

    public void setSpeed(double speed){
        climbLeft.set(speed);
        climbRight.set(speed);
    }
    private PIDController climberPID = new PIDController(.8,0,0);
    

        //limit switches
        private final DigitalInput limitSwitchRight = new DigitalInput(0);
        private final DigitalInput limitSwitchLeft = new DigitalInput(1);

        public boolean getLimitSwitchRight()
        {
            return limitSwitchRight.get();
        }

        public boolean getLimitSwitchLeft()
        {
            return limitSwitchLeft.get();
        }

    public ClimberSubsystem() {
        //Right follows Left
        climbLeftConfig.inverted(true);
        climbRightConfig.inverted(false);

        //Brake
        climbLeftConfig.idleMode(IdleMode.kBrake);
        climbRightConfig.idleMode(IdleMode.kBrake);

        climberPID.setTolerance(1);
    }

    }









