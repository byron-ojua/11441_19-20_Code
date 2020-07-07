package org.firstinspires.ftc.teamcode.Robot.Modules;

import org.firstinspires.ftc.teamcode.Robot.Lib.HardwareConfig;
import org.firstinspires.ftc.teamcode.Robot.Lib.Module;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SyringePumpV2 extends Module{

    public DcMotor pump;
    private DigitalChannel limit;
    
    private double speed = 0.5;
    private double outSpeed = -0.3;
    private double holdSpeed = 0.1;
    
    private int tickLimit = 450;

    public SyringePumpV2(HardwareConfig c, String p, String limitSwitch){
        super(c, p, limitSwitch);
    }
    
    public void init(HardwareMap hwMap){
        pump = hwMap.get(DcMotor.class, this.mapping.get(0));
        limit = hwMap.get(DigitalChannel.class, this.mapping.get(1));
        
        pump.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        pump.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
    }
    
    public void reset(){
        while (!limit.getState()){
            pump.setPower(outSpeed);
        }
        pump.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        pump.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void grab(){
        if (pump.getCurrentPosition() < tickLimit){
            pump.setPower(speed);
        }else{
            pump.setPower(holdSpeed);
        }
    }
    
    public void stop(){
        pump.setPower(0);
    }
    
    public void release(){
        if(!limit.getState()){
            pump.setPower(outSpeed);
        }else{
            stop();
        }
    }
    
    public String getName(){
        return "SyringePumpV2";
    }
}