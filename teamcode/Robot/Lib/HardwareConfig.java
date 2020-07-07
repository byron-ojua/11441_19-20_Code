package org.firstinspires.ftc.teamcode.Robot.Lib;

import org.firstinspires.ftc.teamcode.Robot.Lib.OrientationModule;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import java.util.EnumSet;
import java.util.ArrayList;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareConfig {

    private List<Module> modules = new ArrayList<Module>();
    
    public EnumSet<Capability> capabilities = EnumSet.noneOf(Capability.class);
    
    public OrientationModule orientation; 
    
    public void init(HardwareMap hwMap) {
        for(Module m : modules){
            m.init(hwMap);
            capabilities.addAll(m.capabilities);
            
            if(m instanceof OrientationModule) {
                orientation = (OrientationModule)m;
            }
        }
    }
    
    public void addModule(Module m){
        this.modules.add(m);
    }
    
    public <T extends Module> T getModule(Class<T> cls){
        for(Module m : modules){
            if(m.getClass() == cls){
                return (T)m;
            }
        }
        return null;
    }
    
    public void stop(){
        for(Module m : modules){
            m.eStop();
        }
    }
    
    //Things for navigation
    public int getHeading(){
        //if(capabilities.contains(Capability.GET_HEADING)){
            return orientation.getHeading();
        //}else{
        //    throw new CapabilityMissingException(Capability.GET_HEADING, "No module available with a GET_HEADING capability");
        //}
    }
}