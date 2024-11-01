package org.firstinspires.ftc.teamcode.auto;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.ScheduleCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.StartEndCommand;
import com.arcrobotics.ftclib.util.Timing;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.commands.AutoForward;
import org.firstinspires.ftc.teamcode.commands.AutoLift;
import org.firstinspires.ftc.teamcode.commands.AutoStrafe;
import org.firstinspires.ftc.teamcode.commands.ClawClose;
//import org.firstinspires.ftc.teamcode.commands.colorScan;
import org.firstinspires.ftc.teamcode.lift.Lift;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.MechaDrive;


import java.util.Timer;

@Autonomous (name = "RaiderBotAuto")
public class RaiderBotsAuto extends CommandOpMode {

    MechaDrive drive;
    Lift lift;
    Claw claw;
    Command approachDrive;
    Command approachLift;
    Command oneForward;
    Command oneStrafe;
    Command twoForward;
    Command threeForward;
    Command threeStrafe;
    Command closeclaw;
    Command colorscan;

    @Override
    public void initialize() {

        drive = new MechaDrive(hardwareMap, telemetry);
        lift = new Lift(hardwareMap, telemetry);
        claw = new Claw(hardwareMap, telemetry);
        closeclaw = new ClawClose();
        //colorscan = new colorScan(drive);
        approachDrive = new AutoForward(drive, -.25,.25,-.25,.25);
        approachLift = new AutoLift(lift, .5);
        oneForward = new AutoForward(drive, -.25,.25,.25,.25);
        //oneStrafe = new AutoStrafe(drive, -100, -100, -100, -100);
        //twoForward = new AutoForward(drive, 50, 50, 50, 50,.5);
        //threeForward = new AutoForward(drive, 50, 50, 50, 50,.5);
        //threeStrafe = new AutoStrafe(drive, 100, 100, 100, 100);

        SequentialCommandGroup approach = new SequentialCommandGroup(approachLift,approachDrive, colorscan);

        SequentialCommandGroup zoneOne = new SequentialCommandGroup(oneForward, oneStrafe);

        SequentialCommandGroup zoneTwo = new SequentialCommandGroup(twoForward);

        SequentialCommandGroup zoneThree = new SequentialCommandGroup(threeForward, threeStrafe);

        waitForStart();

        schedule(approach);


    }


}
