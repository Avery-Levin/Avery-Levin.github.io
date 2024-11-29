# Servos

The FTC SDK provides 2 classes for servos: Servo and CRServo (continuous rotation servo). These refer to different device types in configuration, so make sure the class you use reflects the device type you set in configuration. Most servos lack a continuous rotation mode, so ensure you use a compatible servo for mechanisms requiring continuous rotation.

## Servo Class

The servo class only has one variable that you will use frequently in programming.

### Position

Servo.position refers to the current position of the servo, with 0.0 being fully retracted and 1.0 being fully extended. If you use a servo programmer to change where the servo starts and stops, 0.0 will be the retracted state you set, and 1.0 will be the extended state you set. For example:

```
servo.position = 0.0
servo.position = 0.5
servo.position = 1.0

```
will move the servo to its retracted state, exactly halfway between retracted and extended, and finally all the way to extended.

## CRServo

CRServo has two methods that you will use. These are very similar to the methods of DcMotor.

### Power

CRServos are controlled by setting their power exactly like a DcMotor. Please refer to that section again if necessary.

### Direction

For direction, CRServos are controlled exactly the same as a DcMotor, using the enumerated class `DcMotorSimple.Direction`. Please refer to that section again if necessary.
