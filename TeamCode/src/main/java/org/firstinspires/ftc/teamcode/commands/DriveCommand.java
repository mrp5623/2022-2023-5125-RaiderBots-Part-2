package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Gyro;
import org.firstinspires.ftc.teamcode.subsystems.MechaDrive;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    public final MechaDrive drive;

    public final Gyro gyro;

    public final DoubleSupplier leftX, leftY, rightX;

    public final BooleanSupplier reset;

    public final Telemetry telemetry;

    static boolean state = false;
    static boolean speed = true;

    public double slow = .25;
    public double fast = .75;

    public DriveCommand(MechaDrive drive, Gyro gyro, DoubleSupplier leftX, DoubleSupplier leftY, DoubleSupplier rightX, BooleanSupplier reset, Telemetry telemetry) {
        this.drive = drive;
        this.gyro = gyro;
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.reset = reset;
        this.telemetry = telemetry;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.powerInit();
    }

    @Override
    public void execute() {

        if (reset.getAsBoolean()) {
            gyro.resetAngle();
        }
        if (state && speed) {
            drive.fieldCentricDrive(leftX.getAsDouble()*slow, leftY.getAsDouble()*slow, rightX.getAsDouble()*slow, gyro.getAngle());
        }
        if (state && !speed) {
            drive.fieldCentricDrive(leftX.getAsDouble()*fast, leftY.getAsDouble()*fast, rightX.getAsDouble()*fast, gyro.getAngle());
        }
        if (!state && speed) {
            drive.robotCentricDrive(leftX.getAsDouble()*slow, leftY.getAsDouble()*slow, rightX.getAsDouble()*slow);
        }
        if (!state && !speed) {
            drive.robotCentricDrive(leftX.getAsDouble()*fast, leftY.getAsDouble()*fast, rightX.getAsDouble()*fast);
        }
    }
    @Override
    public boolean isFinished() {
        return false;
    }

}