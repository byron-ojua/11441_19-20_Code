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

public class RedBlock extends LinearOpMode{     

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
        
        
        
    }
}