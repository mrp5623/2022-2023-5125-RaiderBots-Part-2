/*
package org.firstinspires.ftc.teamcode.commands;


import static org.firstinspires.ftc.teamcode.lift.LiftCommand.heightCheck;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.lift.Lift;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.MechaDrive;

public class Display extends CommandBase {
    public final Lift lift;
    public final MechaDrive drive;
    public final Claw claw;
    public final Telemetry telementry;
public Display(Lift lift, MechaDrive drive, Claw claw,Telemetry telementry){

    this.lift = lift;
    this.drive = drive;
    this.claw = claw;
    this.telementry = telementry;
    addRequirements(lift,claw,drive);

}

@Override
public void execute(){

    if (DriveCommand.state && DriveCommand.speed) {
        telementry.addData("Drive Mode:", "Field Centric");
        telementry.addLine().addData("Drive Speed:", "Slow");
    }
    if (DriveCommand.state && !DriveCommand.speed) {

        telementry.addLine().addData("Drive Mode:", "Field Centric");
        telementry.addLine().addData("Drive Speed:", "Fast");
    }
    if (!DriveCommand.state && DriveCommand.speed) {

        telementry.addLine().addData("Drive Mode:", "Robot Centric");
        telementry.addLine().addData("Drive Speed:", "Slow");
    }
    if (!DriveCommand.state && !DriveCommand.speed) {

        telementry.addLine().addData("Drive Mode:", "Robot Centric");
        telementry.addLine().addData("Drive Speed:", "Fast");
    }
    telementry.addLine().addData("LiftL", lift.liftL.getCurrentPosition());
    telementry.addLine().addData("LiftR", lift.liftR.getCurrentPosition());
    telementry.addLine().addData("Height", heightCheck);
    telementry.addLine().addData("Claw", claw.clawS.getAngle());
    telementry.update();
}

}

*/