
# What is an OpMode?

An OpMode is a class that you create that is runnable on your robot.

There are two types of classes that can be extended to make an OpMode: **linearOpMode** and **OpMode**. Both will be explained in this guide, but **LinearOpMode** will be used for the remainder of this guide.

The general rule is that code in a regular OpMode is divided up based on the **conditions** where it will be executed, while code in a LinearOpMode runs **consecutively** using methods to pause execution.

## LinearOpMode

Here are the most important methods included in the LinearOpMode class. Certain methods have been excluded because they aren't needed for amateur programmers, but you can find all of them in FIRST's documentation.

- `runOpMode( )`  All code within this method will run once when the OpMode is initialized on your Driver Station. This is **required** for every LinearOpMode class.

---

- `waitForStart()` This method will **pause** execution of code until you press the "**Start**" button on your driver station. This would be used if you wanted to run code in between initializing the code and the start of the period during a match.
- `isStarted()` This method will return **true** if the "**Start**" button has been pressed.
- `isStopRequested()` This method will return **true** if the "**Stop**" button was pressed.
- `opModeIsActive()` will return `isStarted() && !isStopRequested()`
- `opModeInInit()`   will return `!isStarted() && !isStopRequested()`  

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

Two methods in the OpMode class are required for your opmode to work.

- `init()` The code within this method will run **once** when the "**Init**" button is pressed
- `loop()` The code within this method will run **continuously** when you press "**Start**" and until you press "**Stop**"

There are other methods within the OpMode class that help you control the flow of your code.

- `start()` The code within this method will run **once** when you press the "**Start**" button. This will **always** run before the code in the `loop()` method.
- `init_loop` The code within this method will run **continously** when you press the "**Init**" button. This will always run after the code in the `init()` method.
- `stop()` The code within this method will run **once** when you press the "**Stop**" button.

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

### Warning regarding `while()` loops

Only use a `while()` loop if you have an **exit condition**

Otherwise, it will take an additional 5 seconds to stop the robot when you press the "Stop" button. This will cause you to incur **penalties** during autonomous if it keeps running after the 30 second period. Your code should be programmed in a way to be **responsive** to the "**Stop**" button. One way of doing this in a LinearOpMode is adding `opModeIsActive()` as a condition for the loop, as the loop will know to **exit** after you press stop.

