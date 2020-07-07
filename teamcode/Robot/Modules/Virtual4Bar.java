package org.firstinspires.ftc.teamcode.Robot.Modules;

import org.firstinspires.ftc.teamcode.Robot.Lib.Module;
import org.firstinspires.ftc.teamcode.Robot.Lib.HardwareConfig;
import org.firstinspires.ftc.teamcode.Utilities.Constants;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Virtual4Bar extends Module{

    private int encoderThreshold = 15;
    
    public DcMotor left;
    public DcMotor right;

    public Virtual4Bar(HardwareConfig conf, String left, String right){
        super(conf, left, right);
    }
    
    public void init(HardwareMap hwMap){
        left = hwMap.get(DcMotor.class, this.mapping.get(0));
        right = hwMap.get(DcMotor.class, this.mapping.get(1));
        
        left.setDirection(DcMotor.Direction.REVERSE);
        
        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    
    public void raw(double power){
        left.setPower(power);
        right.setPower(power);
    }
    
    public void stay(){
        left.setPower(0.1);
        right.setPower(0.1);
    }
    
    public void bstay(){
        left.setPower(-0.1);
        right.setPower(-0.1);
    }
    
    private boolean armEncodersDone(){
        int leftDist =  Math.abs(left.getTargetPosition()-left.getCurrentPosition());
        int rightDist =  Math.abs(right.getTargetPosition()-right.getCurrentPosition());
        
        int distance = (leftDist + rightDist) / 2;
        
        if(distance >= -encoderThreshold && distance <= encoderThreshold){
            return true;
        }
        return false;
    }
    
    public void setLevel(int level){
        switch (level){
            case 0:
                posDegrees(250);
                break;
            case 1:
                posDegrees(235);
                break;
            case 2:
                posDegrees(215);
                break;
            case 3:
                posDegrees(205);
                break;
        }
    }
    
    private void posDegrees(int degrees){
        double radians = (degrees * Math.PI / 180);
        double rotations = (radians / (2 * Math.PI) * 4/3);
        int ticks = (int) Math.round(rotations * Constants.AM_401_MOTOR_TICKS_PER_REV);
        
        left.setTargetPosition(ticks);
        right.setTargetPosition(ticks);
        
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        if(left.getCurrentPosition()> -ticks){
            left.setPower(-1);
            right.setPower(-1);
        }else{
            left.setPower(1);
            right.setPower(1);
        }
        while(!armEncodersDone()){}
    }

    public String getName(){
        return "Virtual4Bar";
    }
}