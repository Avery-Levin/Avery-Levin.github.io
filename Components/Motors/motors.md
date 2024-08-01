
# Motors

In FTC, there are 2 classes that are used to control your motors: DcMotor and DcMotorEx. These 2 classes are very similar, and if you don't plan on using the encoders attached to your motors, either of them will work.

However, if you do intend to use the encoders on your motors for features such as measuring velocity or error correction, using the DcMotorEx class is required. That being said, if you are using Mecanum wheels and want to know where your robot is on the field during autonomous, I would invest in external encoders in the form of dead wheels due to how Mecanum wheels can slip.

## Direction

As you might expect, there are two possible directions that a motor can be set to go in, with those being FORWARD and BACKWARD. You can set a motor to run in these directions by running the following:

`motor.setDirection(DcMotor.Direction.FORWARD)`

`motor.setDirection(DcMotor.Direction.BACKWARD)`

By default, the direction is set to FORWARD. `exampleMotor.power = 1.0` will run the motor forwards by default, and backwards under BACKWARD mode. The opposite is true for `exampleMotor.power = -1.0`.  

## Run Modes

TODO
