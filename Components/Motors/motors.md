
# Motors

In FTC, there are 2 classes that are used to control your motors: DcMotor and DcMotorEx. These 2 classes are very similar, and if you don't plan on using the encoders attached to your motors, either of them will work.

However, if you do intend to use the encoders on your motors for features such as measuring velocity or error correction, using the DcMotorEx class is required. That being said, if you are using Mecanum wheels and want to know where your robot is on the field during autonomous, I would invest in external encoders in the form of dead wheels due to how Mecanum wheels can slip.

## Direction

As you might expect, there are two possible directions that a motor can be set to go in, with those being FORWARD and BACKWARD. You can set a motor to run in these directions by running the following:

`motor.setDirection(DcMotor.Direction.FORWARD)`

`motor.setDirection(DcMotor.Direction.BACKWARD)`

By default, the direction is set to FORWARD. `exampleMotor.power = 1.0` will run the motor forwards by default, and backwards under BACKWARD mode. The opposite is true for `exampleMotor.power = -1.0`.  

## Run Modes

Run modes determine how your motor will react to the input that you give it, which is usually the `power` variable. To change the run mode of a motor, run `motor.setMode(DcMotor.RunMode.RUN_MODE)` 

### RUN_WITHOUT_ENCODERS

`RUN_WITHOUT_ENCODERS` is by far the simplest way of running a motor. The motor will be provided with the amount of electricity specified in the `power` variable, with 1.0 being the maximum amount of electricity going in the direction specified, and 0.0 resulting in no power delivered to the motor

### RUN_WITH_ENCODERS

`RUN_WITH_ENCODERS` uses the motor's built in encoder (assuming you plugged it in) to run the motor to the specified speed specified in the `power` variable, with 1.0 being full speed ahead and 0 being idle. While one might think that this is the same as the previously specified run mode, this is incorrect. Under the previous mode, you can run the motor at 0.5 electricity while the motor itself runs 10% faster or slower. However, running the motor on this mode will always result in the motor running at the specified speed because the encoder reads how fast the motor is turning and adjusts the amount of electricity provided.
