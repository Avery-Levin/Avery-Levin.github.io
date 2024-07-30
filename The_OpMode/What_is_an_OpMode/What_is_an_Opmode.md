# What is an OpMode?
An OpMode is a class that you create that is runnable on your robot.

There are two types of classes that can be extended to make an OpMode: LinearOpMode and OpMode. Both will be explained in this guide, but LinearOpMode will be used for any further examples for simplicity sake. 

The general rule is that code in a regular OpMode is divided up based on the conditions where it will be executed, while code in a LinearOpMode runs consecutively using methods to pause execution.

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

@TeleOp /* You have to specify whether an OpMode is for Autonomous or for teleop.
 If I wanted to make an autonomous OpMode, I would put @Autonomous */
class AveryTeeLeeOop : LinearOpMode()  { // Make sure you extend the correct class

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



## OpMode
Here are all of the methods included in the OpMode class. Note that the first two are mandatory and you will get an error if you don't override both of them.

- `init()` The code within this method will run once when the "Init" button is pressed
- `loop()` The code within this method will run continuously when you press "Start" and until you press "Stop"
- `start()` The code within this method will run once when you press the "Start" button. This will always run before the code in the `loop()` method.
- `init_loop` The code within this method will run continously when you press the "Init" button. This will always run after the code in the `init()` method.
- `stop()` The code within this method will run once when you press the "Stop" button. You should not have any code that controls the drivetrain in this method because you may be penalized in competition for moving after the match is over.

Here is an example OpMode.

``` kt
class OpModeDemonstration : OpMode() {
    var counter : Int = 0
    override fun init() {
       telemetry.addLine("Beans") // This posts data that is viewable on the Driver Station
    }

    override fun loop() {
        telemetry.addLine(counter.toString())
        Thread.sleep(1000) /* Do not do this in real life!
        All of the code running on your robot will freeze! */
        counter += 1
    }


}


```
