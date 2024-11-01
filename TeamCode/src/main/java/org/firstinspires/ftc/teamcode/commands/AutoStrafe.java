package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystems.MechaDrive;

import java.util.concurrent.TimeUnit;

public class AutoStrafe extends CommandBase {
    private final MechaDrive drive;
    private final double pfr, pfl, pbr, pbl;
    Timing.Timer timer = new Timing.Timer(2000, TimeUnit.MILLISECONDS);

    public AutoStrafe(MechaDrive drive, int pfr, int pfl, int pbr, int pbl) {
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
    }    }






