package org.firstinspires.ftc.teamcode.Robot.Modules;

import org.firstinspires.ftc.teamcode.Robot.Lib.HardwareConfig;
import org.firstinspires.ftc.teamcode.Robot.Lib.Module;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import org.firstinspires.ftc.teamcode.Robot.HardwareCompBot;
import org.firstinspires.ftc.teamcode.Utilities.Constants;
import com.qualcomm.robotcore.util.ElapsedTime;


public class SyringePump extends Module{
    
    private CRServo servoPump;
    
    private TouchSensor min;
    
    private DigitalChannel max;
    
    private ElapsedTime runtime = new ElapsedTime();
    
    public SyringePump(HardwareConfig c, String p, String maxLimit, String minLimit){
        super(c, p, maxLimit, minLimit);
    }
    
    public void init(HardwareMap hwMap) {
        servoPump = hwMap.get(CRServo.class, this.mapping.get(0));
        max = hwMap.get(DigitalChannel.class, this.mapping.get(1));
        min = hwMap.get(TouchSensor.class, this.mapping.get(2));
        
        max.setMode(DigitalChannel.Mode.INPUT);
    }
    
    public void grab(){
        if(true){
            servoPump.setDirection(DcMotorSimple.Direction.FORWARD);
            servoPump.setPower(1);
        }else{
            servoPump.setPower(0);
        }
    }
    
    public void release(){
        if(!min.isPressed()){
            servoPump.setDirection(DcMotorSimple.Direction.REVERSE);
            servoPump.setPower(1);
        }else{
            servoPump.setPower(0);
        }
    }
    
    public void raw(DcMotorSimple.Direction dir, double power){
        servoPump.setDirection(dir);
        servoPump.setPower(power);
    }
    
    public String getName(){
        return "SyringePump";
    }
}