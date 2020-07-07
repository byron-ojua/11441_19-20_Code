package org.firstinspires.ftc.teamcode.Autonomous.examples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;


@Autonomous(name="Auto", group="Test")

public class AutoExample extends LinearOpMode {
    
    //call config of hardwareMap
    HardwareCompBot robot = new HardwareCompBot();

    @Override
    public void runOpMode() {
        
        robot.init(hardwareMap);
        
        waitForStart();/*
        
        robot.leftFrontDrive.setTargetPosition(1000); //setTargetPosition uses encoder value
        robot.rightFrontDrive.setTargetPosition(-1000);
        robot.leftFrontDrive.setPower(1);//set power or speed
        robot.rightFrontDrive.setPower(1); //no neg power because there is already neg in position
        sleep(2000); //wait command (in milliseconds)
        
        robot.leftFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //sets mode of motors for the following lines of code
        robot.leftFrontDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); // "
        /*while(robot.gyroSensor.getHeading()>355 || robot.gyroSensor.getHeading()<90) { //the "or" statement (the two lines) ensures robot will turn even if it messes up while driving
            robot.leftFrontDrive.setPower(1);
            robot.rightFrontDrive.setPower(1);
        }
        robot.leftFrontDrive.setPower(0);
        robot.rightFrontDrive.setPower(0);*/
    }
}
