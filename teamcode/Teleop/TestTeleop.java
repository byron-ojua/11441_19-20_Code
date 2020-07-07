package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;
import org.firstinspires.ftc.teamcode.Robot.Modules.*;
import org.firstinspires.ftc.teamcode.Robot.Modules.GyroscopeModule;


@TeleOp(name = "Test Teleop")
public class TestTeleop extends OpMode {

    HardwareCompBot robot = new HardwareCompBot();

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void start() {
        runtime.reset();
        robot.getModule(SyringePumpV2.class).reset();
    }

    @Override
    public void loop() {
        
        if (gamepad1.right_bumper) {
            robot.getModule(MecanumDrive.class).setSpeed(0.75);
        } else {
            robot.getModule(MecanumDrive.class).setSpeed(1);
        }
        
        robot.getModule(MecanumDrive.class).driveMecanum(gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
        
        if(gamepad2.dpad_up){
            robot.getModule(Virtual4Bar.class).raw(0.60);
        }else if(gamepad2.dpad_down){
            robot.getModule(Virtual4Bar.class).raw(-0.60);
        }else if(gamepad2.left_bumper){
            robot.getModule(Virtual4Bar.class).stay();
        }else if(gamepad2.right_bumper){
            robot.getModule(Virtual4Bar.class).bstay();
        }else{
            robot.getModule(Virtual4Bar.class).raw(0);
        }
        
        if (gamepad2.a){
            robot.getModule(SyringePumpV2.class).grab();
            telemetry.addData("adsf", robot.getModule(SyringePumpV2.class).pump.getCurrentPosition());
        }else if(gamepad2.b){
            robot.getModule(SyringePumpV2.class).stop();
        }else{
            robot.getModule(SyringePumpV2.class).release();
        }
        
        if (gamepad1.right_bumper){
            robot.getModule(GreenIntake.class).intake();
        }else if (gamepad1.left_bumper){
            robot.getModule(GreenIntake.class).outtake();
        }else{
            robot.getModule(GreenIntake.class).stop();
        }
        
        if(gamepad1.x){
            robot.getModule(FoundationGrab.class).grab();
        }else if(gamepad1.y){
            robot.getModule(FoundationGrab.class).release();
        }
        
        telemetry.addData("Heading", robot.getHeading());
        telemetry.update();
    }
}
