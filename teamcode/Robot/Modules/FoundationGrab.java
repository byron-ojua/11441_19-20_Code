package org.firstinspires.ftc.teamcode.Robot.Modules;

import org.firstinspires.ftc.teamcode.Robot.Lib.Module;
import org.firstinspires.ftc.teamcode.Robot.Lib.HardwareConfig;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;
import org.firstinspires.ftc.teamcode.Utilities.Constants;
import com.qualcomm.robotcore.util.ElapsedTime;


public class FoundationGrab extends Module{
    
    public Servo fGrab1;
    public Servo fGrab2;
    
    public FoundationGrab(HardwareConfig c, String grabber1, String grabber2) {
        super(c, grabber1, grabber2);
    }
    
    public void init(HardwareMap hwMap) {
        fGrab1 = hwMap.get(Servo.class, this.mapping.get(0));
        fGrab2 = hwMap.get(Servo.class, this.mapping.get(1));
        
        release();
    }
    
    public void grab(){
        fGrab1.setPosition(0);
        fGrab2.setPosition(1);
    }
    
    public void release(){
        fGrab1.setPosition(1);
        fGrab2.setPosition(0);
    }
    
    public String getName(){
        return "FoundationGrab";
    }
}