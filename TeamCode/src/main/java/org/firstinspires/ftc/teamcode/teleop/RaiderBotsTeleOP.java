package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.ClawClose;
import org.firstinspires.ftc.teamcode.commands.ClawCommand;
import org.firstinspires.ftc.teamcode.commands.ClawOpen;
import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.DriveMode;
import org.firstinspires.ftc.teamcode.commands.DriveSpeed;
import org.firstinspires.ftc.teamcode.lift.HeightCheckDown;
import org.firstinspires.ftc.teamcode.lift.HeightCheckUp;
import org.firstinspires.ftc.teamcode.lift.LiftCommand;
import org.firstinspires.ftc.teamcode.lift.LiftSpeed;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Gyro;
import org.firstinspires.ftc.teamcode.lift.Lift;
import org.firstinspires.ftc.teamcode.subsystems.MechaDrive;

@TeleOp (name = "RaiderBotTele")
public class RaiderBotsTeleOP extends CommandOpMode {
    MechaDrive drive;
    GamepadEx gp1;
    GamepadEx gp2;
    Command clawing;
    Command lifting;
    Command driving;
    Command mode;
    Command dspeed;
    Command lspeed;
    Command up;
    Command down;
    Gyro gyro;
    Lift lift;
    Command open;
    Command close;
    Claw claw;

    Telemetry telemetry;

    Motor lifter;


    @Override
    public void initialize() {

        gp1 = new GamepadEx(gamepad1);
        gp2 = new GamepadEx(gamepad2);
        gyro = new Gyro(hardwareMap);
        drive = new MechaDrive(hardwareMap, telemetry);
        lift = new Lift(hardwareMap, telemetry);
        claw = new Claw(hardwareMap, telemetry);

        mode = new DriveMode();
        dspeed = new DriveSpeed();
        lspeed = new LiftSpeed();
        up = new HeightCheckUp();
        down = new HeightCheckDown();
        open = new ClawOpen();
        close = new ClawClose();

        driving = new DriveCommand(
                drive,
                gyro,
                gp1::getLeftX,
                gp1::getLeftY,
                gp1::getRightX,
                () -> gp1.getButton(GamepadKeys.Button.B),
                telemetry);

                lifting = new LiftCommand(lift, gp2::getLeftY, telemetry);

        clawing = new ClawCommand(claw, telemetry);

        gp1.getGamepadButton(GamepadKeys.Button.Y).whenReleased(mode);
        gp1.getGamepadButton(GamepadKeys.Button.A).whenReleased(dspeed);
        gp2.getGamepadButton(GamepadKeys.Button.A).whenReleased(lspeed);
        gp2.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenReleased(up);
        gp2.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenReleased(down);
        gp1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenReleased(close);
        gp1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenReleased(open);

        register(drive);
        register(claw);
        register(lift);
        drive.setDefaultCommand(driving);
        lift.setDefaultCommand(lifting);
        claw.setDefaultCommand(clawing);



    }


}
