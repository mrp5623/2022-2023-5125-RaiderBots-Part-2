package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.lift.Lift;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.MechaDrive;

import java.util.Timer;
import java.util.concurrent.TimeUnit;


public class AutoForward extends CommandBase {
    private final MechaDrive drive;
    private final double pfr,pfl,pbr,pbl;

    Timing.Timer timer = new Timing.Timer(4000, TimeUnit.MILLISECONDS);
    public AutoForward(MechaDrive drive, double pfr, double pfl, double pbr, double pbl) {
        this.drive = drive;
        this.pfr = pfr;
        this.pfl = pfl;
        this.pbl = pbl;
        this.pbr = pbr;


    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        drive.tankDrive(pfr,pfl,pbr,pbl);


    }


    @Override
    public void end(boolean interrupted) {

        drive.stop();

    }

    @Override
    public boolean isFinished() {
        return timer.done();
    }
}





