package frc.robot.commands.SwervedriveCommands.ClimberCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberSubsystem.*;;

public class ClimberCommand extends Command
{

    private final double speed;

    public ClimberCommand(Double _speed)
    {
        addRequirements(RobotContainer.climber);
        speed = _speed;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.climber.setSpeedClimbDeployMotor(speed);
        RobotContainer.climber.setSpeedClimbGoUpMotor(speed);

    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
