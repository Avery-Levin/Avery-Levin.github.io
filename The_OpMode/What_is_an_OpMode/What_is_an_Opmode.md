# What is an OpMode?
An OpMode is a class that you create that is runnable on your robot. There are two types of classes that can be extended to make an OpMode: LinearOpMode and OpMode. Both will be explained in this guide, but LinearOpMode will be used for any further examples for simplicity sake.

``` kt
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp

@TeleOp // You have to specify whether an OpMode is for Autonomous or for teleop. If I wanted to make an autonomous OpMode, I would put @Autonomous
class AveryTeeLeeOop : LinearOpMode()  { // Make sure your OpMode class is an extension of the correct class. Otherwise, your code won't run.

    override fun runOpMode() // For methods that specify when code is run, you must override them. {
        val averyMecanum = AveryMecanum(hardwareMap)
        val telemetry =  telemetry
        waitForStart()
        while(opModeIsActive()){
            averyMecanum.control(gamepad1)
            averyMecanum.telemetry(telemetry, gamepad1)
        }

    }


}
```

Here is a small example LinearOpMode that I wrote. You don't have to know what everything means, but make sure to read the comments for some good advice regarding what you have to do to get your code to run.