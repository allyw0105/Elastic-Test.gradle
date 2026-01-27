
package frc.robot.subsystems.Elastic;

import java.util.ArrayList;
import java.util.List;

import com.pathplanner.lib.config.ModuleConfig;
import com.pathplanner.lib.config.RobotConfig;
import com.pathplanner.lib.path.PathPlannerPath;
import com.pathplanner.lib.path.PathPoint;
import com.pathplanner.lib.trajectory.PathPlannerTrajectory;
import com.pathplanner.lib.util.PathPlannerLogging;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FieldWidget<Elastic> extends SubsystemBase{


//Initialization for Field and Trajectories
public Field2d m_Field = new Field2d();
public Trajectory elastic = new Trajectory();
//public Trajectory Path2 = new Trajectory();
//public Trajectory Path3 = new Trajectory();


//Field Widget
public FieldWidget() {
    SmartDashboard.putData("Field", m_Field);
}

public void addPath(String pathName,PathPlannerPath path ){
    m_Field.getObject(pathName).setPoses(path.getPathPoses());
}


//Trajectory Generation
public void TrajGen(){

          
            // First Trajectory Generation
             elastic = TrajectoryGenerator.generateTrajectory(
                new Pose2d(7, 2, Rotation2d.fromDegrees(0)),
                List.of(new Translation2d(8.1, 1.3), new Translation2d(
                8.1, 1.3)),
                new Pose2d(3.7, 3.7, Rotation2d.fromDegrees(90)),
                new TrajectoryConfig(Units.metersToFeet(1.0), Units.metersToFeet(1.0))
                );
                m_Field.getObject("Elastic Test").setTrajectory(elastic);


                // Second Trajectory Generation
           /*  Path2 = TrajectoryGenerator.generateTrajectory(
                new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                List.of(new Translation2d(1, 1), new Translation2d(
                2, -1)),
                new Pose2d(3, 0, Rotation2d.fromDegrees(0)),
                new TrajectoryConfig(Units.metersToFeet(3.0), Units.metersToFeet(3.0))
                );
                m_Field.getObject("Path2").setTrajectory(Path2);*/
             
                // Third Trajectory Generation
           /* Path3 = TrajectoryGenerator.generateTrajectory(
                new Pose2d(9, 0, Rotation2d.fromDegrees(0)),
                List.of(new Translation2d(1, 1), new Translation2d(
                2, -1)),
                new Pose2d(3, 0, Rotation2d.fromDegrees(0)),
                new TrajectoryConfig(Units.feetToMeters(3.0), Units.feetToMeters(3.0))
                );
                m_Field.getObject("Path3").setTrajectory(Path3); */
}
}

