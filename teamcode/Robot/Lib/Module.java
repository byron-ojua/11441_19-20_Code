package org.firstinspires.ftc.teamcode.Robot.Lib;

import java.util.List;
import java.util.Arrays;
import java.util.EnumSet;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.util.Hardware;

public abstract class Module {
    
    protected List<String> mapping;
    
    protected boolean active;
    
    protected HardwareConfig robot;
    
    protected EnumSet<Capability> capabilities = EnumSet.noneOf(Capability.class);
    
    public Module(HardwareConfig conf, String... map){
        this.mapping = Arrays.asList(map);
    }

    public abstract void init(HardwareMap map);
    
    public abstract String getName();
    
    void eStop(){
        active = false;
    }
}