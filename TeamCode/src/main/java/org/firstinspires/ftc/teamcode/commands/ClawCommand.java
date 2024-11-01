package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.lift.Lift;
import org.firstinspires.ftc.teamcode.subsystems.Claw;

import java.util.function.DoubleSupplier;

public class ClawCommand extends CommandBase {
    public final Claw claw;
    public final Telemetry telemetry;
    static int clawChange = 1;
    public static int clawCheck = 0;

    public ClawCommand(Claw claw, Telemetry telemetry){
        this.claw = claw;
        this.telemetry = telemetry;
        addRequirements(claw);
    }

    @Override
    public void execute(){

        if(clawCheck == 0) {
            claw.Open();
            //telemetry.addLine("ClawOpen");
            //telemetry.update();
        }
        if (clawCheck == 1) {
            claw.Close();
            //telemetry.addLine("ClawClose");
            //telemetry.update();
        }

        if (clawCheck > 1) {
            clawCheck = 1;
        }

        if (clawCheck < 0){clawCheck = 0;}

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
