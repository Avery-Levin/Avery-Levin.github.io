# What is an OpMode?
An OpMode is a class that you create that is runnable on your robot.

There are two types of classes that can be extended to make an OpMode: LinearOpMode and OpMode. Both will be explained in this guide, but LinearOpMode will be used for any further examples for simplicity sake. 

The general rule is that code in a regular OpMode is divided up based on when and how it runs, while code in a LinearOpMode runs consecutively using methods to pause execution.

## LinearOpMode
Here are the most important methods included in the LinearOpMode class. Certain methods have been excluded because they aren't needed for amateur programmers, but you can find all of them in FIRST's documentation.

- `runOpMode( )`  All code within this method will run once when the OpMode is initialized on your Driver Station.
- `waitForStart()` This method will pause execution of code until you press the "Start" button on your driver station. This would be used if you wanted to run code in between initializing the code and the start of the period during a match.
- `isStarted()` This method will return true if the "Start" button has been pressed.
- `isStopRequested()` This method will return true if the "Stop" button was pressed.
- `opModeIsActive()` will return `isStarted() && !isStopRequested()`
- ` opModeInInit()`   will return ` !isStarted() && !isStopRequested()` 

Here is an example LinearOpMode that uses some of these methods:


``` kt
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp

@TeleOp // You have to specify whether an OpMode is for Autonomous or for teleop. If I wanted to make an autonomous OpMode, I would put @Autonomous
class AveryTeeLeeOop : LinearOpMode()  { // Make sure your OpMode class is an extension of the correct class. Otherwise, your code won't run.

    override fun runOpMode() /* For methods that specify when code is run, you must override them. */ {
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





