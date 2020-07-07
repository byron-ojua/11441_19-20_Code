package org.firstinspires.ftc.teamcode.Autonomous.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Robot.Modules.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;

@Autonomous
public class ForwardDriveBlue extends LinearOpMode{
    HardwareCompBot robot = new HardwareCompBot();
    
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        
        waitForStart();
        
        driveEncoders(24);
        
        robot.stop();
    }
    
    private void driveEncoders(double dist){
        robot.getModule(MecanumDrive.class).driveEncoders(dist);
        
        while(!robot.getModule(MecanumDrive.class).encodersDone() && opModeIsActive()){
            telemetry.addData("Driving", "beep beep");
            telemetry.update();
        }
        
        robot.getModule(MecanumDrive.class).driveRaw(0, 0, 0, 0);
    }
}
