package org.firstinspires.ftc.teamcode.Robot.Modules;

import org.firstinspires.ftc.teamcode.Robot.Lib.HardwareConfig;
import org.firstinspires.ftc.teamcode.Robot.Lib.OrientationModule;
import java.util.EnumSet;
import org.firstinspires.ftc.teamcode.Robot.Lib.Capability;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.GyroSensor;

public class GyroscopeModule extends OrientationModule{
    
    private GyroSensor gyro;
    
    public GyroscopeModule(HardwareConfig c, String sensorName){
        super(c, sensorName);
    }
    
    public void init(HardwareMap hwMap){
        gyro = hwMap.get(GyroSensor.class, this.mapping.get(0));
        
        gyro.calibrate();
    }
    
    public int getHeading(){
        return gyro.getHeading();
    }

    public String getName(){
        return "GyroSensor";
    }
}
