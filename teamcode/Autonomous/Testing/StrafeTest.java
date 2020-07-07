package org.firstinspires.ftc.teamcode.Autonomous.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;
import org.firstinspires.ftc.teamcode.Robot.Modules.MecanumDrive;
//import org.firstinspires.ftc.teamcode.Robot.Modules.SetLevel;
import org.firstinspires.ftc.teamcode.Robot.Modules.SyringePump;
import org.firstinspires.ftc.teamcode.Robot.Modules.FoundationGrab;
import org.firstinspires.ftc.teamcode.Utilities.Constants;

@Autonomous

public class StrafeTest extends LinearOpMode{       

    HardwareCompBot robot = new HardwareCompBot();
    //SetLevel level = new SetLevel();
    SyringePump pump;
    FoundationGrab latch;
    MecanumDrive drive;
    
    @Override
    public void runOpMode() {
        
        robot.init(hardwareMap);
        
        pump = robot.getModule(SyringePump.class);
        latch  = robot.getModule(FoundationGrab.class);
        drive = robot.getModule(MecanumDrive.class);
        
        drive.setSpeed(1);
        
        waitForStart();
        
        drive.setSpeed(0.85).strafeEncoders(12);
        sleep(500);
        drive.setSpeed(0.85).strafeEncoders(-12);

        //drive.setSpeed(1).driveEncoders(24);
      
    }
}