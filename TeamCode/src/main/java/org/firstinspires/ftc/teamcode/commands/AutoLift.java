package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.lift.Lift;

import java.util.concurrent.TimeUnit;

public class AutoLift extends CommandBase {
    private final Lift lift;
    private final double power;
    Timing.Timer timer = new Timing.Timer(1500, TimeUnit.MILLISECONDS);

    public AutoLift(Lift s_lift, double power){
        this.lift = s_lift;
        this.power = power;
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        lift.rise(power);

    }


    @Override
    public void end(boolean interrupted) {

        lift.stop();

    }

    @Override
    public boolean isFinished() {
        return timer.done();
    }
}


