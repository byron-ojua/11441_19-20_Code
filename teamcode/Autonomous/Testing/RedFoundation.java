package org.firstinspires.ftc.teamcode.Autonomous.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;
import org.firstinspires.ftc.teamcode.Robot.Modules.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.Modules.Virtual4Bar;
import org.firstinspires.ftc.teamcode.Robot.Modules.SyringePump;
import org.firstinspires.ftc.teamcode.Robot.Modules.FoundationGrab;
import org.firstinspires.ftc.teamcode.Robot.Modules.GyroscopeModule;
import org.firstinspires.ftc.teamcode.Utilities.Constants;

@Autonomous

public class RedFoundation extends LinearOpMode{     

    HardwareCompBot robot = new HardwareCompBot();
    Virtual4Bar level;
    SyringePump pump;
    FoundationGrab latch;
    MecanumDrive drive;
    
    public void runOpMode() {
        
        robot.init(hardwareMap);
        
        pump = robot.getModule(SyringePump.class);
        latch  = robot.getModule(FoundationGrab.class);
        drive = robot.getModule(MecanumDrive.class);
        
       telemetry.addData("Heading", robot.getHeading());
        
        waitForStart();
        
        
        drive.setSpeed(.75).strafeEncoders(16);
        sleep(200);
        drive.setSpeed(0.5).driveEncoders(30);
        latch.grab();
        sleep(500);
        drive.setSpeed(.85).driveEncoders(-34);
        latch.release();
        sleep(500);
        drive.setSpeed(.75).strafeEncoders(-37);
        drive.setSpeed(1).driveEncoders(20);
        drive.setSpeed(1).strafeEncoders(17);
        drive.setSpeed(1).strafeEncoders(-12);
        drive.driveRaw(-0.8,-0.8,0.8,0.8);
        while(opModeIsActive() && (robot.getHeading()<80 || robot.getHeading()>355)){    //90 degrees is actually 70
            telemetry.addData("Heading", robot.getHeading());
            telemetry.update();
            }
        drive.driveRaw(0,0,0,0);        
        drive.driveEncoders(21);
        
    }
}