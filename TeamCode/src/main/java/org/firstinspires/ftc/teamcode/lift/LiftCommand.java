package org.firstinspires.ftc.teamcode.lift;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.lift.Lift;

import java.util.function.DoubleSupplier;

public class LiftCommand extends CommandBase {
    public final Lift lift;
    public final Telemetry telemetry;
    public final DoubleSupplier gp2RightY;
    static int heightChange = 1;
    public static int heightCheck = 0;
    static boolean speed = true;

    public double slow = .5;

    public LiftCommand(Lift lift, DoubleSupplier gp2RightY, Telemetry telemetry){
        this.lift = lift;
        this.gp2RightY = gp2RightY;
        this.telemetry = telemetry;
        addRequirements(lift);
    }

    @Override
    public void initialize() {
        lift.powerInit();
    }

    @Override
    public void execute(){
        lift.rise(gp2RightY.getAsDouble());




        if(heightCheck == 0) {
            lift.Bottom();
        }
        if (heightCheck == 1) {
            lift.Small();
        }
        if (heightCheck == 2){
            lift.Medium();
        }
        if (heightCheck == 3){
            lift.Large();
        }
        if (heightCheck > 3){heightCheck = 3;}

        if (heightCheck < 0){heightCheck = 0;}
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}

