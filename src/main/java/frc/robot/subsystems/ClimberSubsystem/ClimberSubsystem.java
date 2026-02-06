package frc.robot.subsystems.ClimberSubsystem;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer;
import frc.robot.Constants.ClimberConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANConfig;




    public class ClimberSubsystem extends SubsystemBase{
        
        private final SparkMax climber1 = new SparkMax(CANConfig.climber1, MotorType.kBrushless);
        private final SparkMax climber2 = new SparkMax(CANConfig.climber2, MotorType.kBrushless);
        
        private SparkMaxConfig climber1Config = new SparkMaxConfig();
        private SparkMaxConfig climber2Config = new SparkMaxConfig();

        
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
    }









