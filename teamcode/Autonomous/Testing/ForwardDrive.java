package org.firstinspires.ftc.teamcode.Autonomous.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Robot.Modules.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;

@Autonomous
public class ForwardDrive extends OpMode{
    HardwareCompBot robot = new HardwareCompBot();
    
    public void init(){
        robot.init(hardwareMap);
    }
    
    @Override
    public void start() {
        
    }
    
    public void loop(){
        robot.getModule(MecanumDrive.class).driveEncoders(24);
        
    }
    
    private void driveEncoders(double dist){
        robot.getModule(MecanumDrive.class).driveEncoders(dist);
        
        robot.getModule(MecanumDrive.class).driveRaw(0, 0, 0, 0);
    }
}