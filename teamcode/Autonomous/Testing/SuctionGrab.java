package org.firstinspires.ftc.teamcode.Autonomous.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;
import org.firstinspires.ftc.teamcode.Robot.Modules.SyringePump;
import org.firstinspires.ftc.teamcode.Utilities.Constants;
import org.firstinspires.ftc.teamcode.Robot.Modules.Virtual4Bar;

@Autonomous

public class SuctionGrab extends LinearOpMode{
    
    public void updateTelemetry(){
        while(true){
            telemetry.update();
        }
    }
    
    HardwareCompBot robot = new HardwareCompBot();
    Virtual4Bar level;
    //SyringePump pump = robot.getModule(SyringePump.class);
    
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        
        level = robot.getModule(Virtual4Bar.class);
        telemetry.addData("Position", level.left.getTargetPosition());
        telemetry.addData("Position", level.left.getCurrentPosition());
        
        waitForStart();
        
        //pump.grab
        updateTelemetry();
        level.setLevel(0);
        sleep(3000);
        level.setLevel(1);
        sleep(3000);
        level.setLevel(2);
        sleep(3000);
        level.setLevel(3);
        sleep(3000);
        //pump.release();
        
    }
}