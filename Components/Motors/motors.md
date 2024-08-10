
# Motors

In FTC, there are 2 classes that are used to control your motors: DcMotor and DcMotorEx. These 2 classes are very similar, and if you don't plan on using the encoders attached to your motors, either of them will work.

However, if you do intend to use the encoders on your motors for features such as measuring velocity or error correction, using the DcMotorEx class is required. That being said, if you are using Mecanum wheels and want to know where your robot is on the field during autonomous, I would invest in external encoders in the form of dead wheels due to how Mecanum wheels can slip.

## Encoders

Encoders are the devices built into your motors that track how many times that they have rotated in terms of "ticks", where each encoder has a designated amount ticks per rotation that can be found on the manufacturer's website.

 There are two types of encoders: absolute and relative. Absolute encoders give you the angle that the shaft has rotated in starting from the starting point. In a world where these encoders gave you measurements in degrees, they would give you a number between 0 and 360. A relative encoder, on the other hand, gives the amount of times it has rotated forward since being reset, which would give you an answer from -∞ to +∞. You can get the position of the encoder in code by calling the method `getCurrentPosition` on a DcMotor object.

 The encoders on any motor that you would use in FTC today are relative and keep the number of ticks recorded until you reset them in code or restart the Robot Controller.

## Direction

As you might expect, there are two possible directions that a motor can be set to go in, with those being FORWARD and BACKWARD. You can set a motor to run in these directions by running the following:

`motor.setDirection(DcMotor.Direction.FORWARD)`

`motor.setDirection(DcMotor.Direction.BACKWARD)`

By default, the direction is set to FORWARD. `exampleMotor.power = 1.0` will run the motor forwards by default, and backwards under BACKWARD mode. The opposite is true for `exampleMotor.power = -1.0`.  

## Run Modes

Run modes determine how your motor will react to the input that you give it, which is usually the `power` variable. To change the run mode of a motor, use the method `motor.setMode(DcMotor.RunMode.RUN_MODE)`

### RUN_WITHOUT_ENCODERS

`RUN_WITHOUT_ENCODERS` is by far the simplest way of running a motor. The motor will be provided with the amount of electricity specified in the `power` variable, with 1.0 being the maximum amount of electricity going in the direction specified, and 0.0 resulting in no power delivered to the motor

### RUN_WITH_ENCODERS

`RUN_WITH_ENCODERS` uses the motor's built in encoder (assuming you plugged it in) to run the motor to the specified speed specified in the `power` variable, with 1.0 being full speed ahead and 0 being idle. While one might think that this is the same as the previously specified run mode, this is incorrect. Under the previous mode, you can run the motor at 0.5 electricity while the motor itself runs 10% faster or slower. However, running the motor on this mode will always result in the motor running at the specified speed because the encoder reads how fast the motor is turning and adjusts the amount of electricity provided.

### RUN_TO_POSITION

In order to use the `RUN_TO_POSITION` run mode, you have to make sure you have already set a position for the motor to go to. Simply set the value of the variable `targetPosition` to the amount of encoder ticks you want it to travel, and the motor will run to that position when you change the run mode.

#### Note

`RUN_TO_POSITION` should only be used in single motor mechanisms such as a claw because multiple motor mechanisms are significantly harder to control with this mode in comparison to others.

### STOP_AND_RESET_ENCODER

`STOP_AND_RESET_ENCODER` will force the motor to come to a complete stop and reset the number of ticks that the encoders have recorded. After that, you have to chose another run mode to set the motor to.

## Zero Power Behaviors

Zero power behaviors effect how your motors come to a stop when power is not applied.

There are two different zero power behaviors available in the FTC SDK, with those being brake and float.

`BRAKE` will slow your motor down by applying force in the opposite direction.

`FLOAT` will let your motors slow down using friction alone.

To change your zero power behavior, use the method `motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BEHAVIOR_NAME)`.

## DcMotorEx addendum

For people wanting to use certain encoder features, you should instantiate your motors using the DcMotorEx class. This gives you a few more extra features.

### Velocity

The DcMotorEx class allows you to set your motor to a certain velocity in terms of encoder ticks. To do such, set the value of the `velocity` variable of the DcMotorEx object to the amount of ticks per second you want it to run at.
