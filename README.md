# Tickanum
A fully-featured mecanum drive implementation

This is Techno Ticks package, just like Updater, MotionProfile, Standard, etc.
This means that it is designed to be easy to incorporate into your robot project,
and it is meant to be abstract enough to run not only on an FRC robot, but any 
robot that runs java.

## Installing

If your robot project (`workspace/robot`) is not a git project, this is very simple.
Just open the command line, navigate to `workspace/robot/src` and type the following
command: `git clone https://https://github.com/Team236/Tickanum.git tickanum`.

If your robot project is a git project, then you have to add it as a git submodule.
This is an experimental feature that hasn't existed for too long, so keep in mind
that it's not perfect for more complex purposes. For what we're doing, however, it's
perfect. Just navigate to `workspace/robot/src` and type the following command:
`git submodule add https://github.com/Team236/Tickanum.git tickanum` then type 
`git submodule init`. This will import the module and create unstaged changes. You
will have to commit this change, and commit your change whenever you update the
module.

After this, your tree should look like this:

    MyRobot
        src
            tickanum
            org
                first
                    ...

# Using

The tickanum drive is very easy to use on your robot. It is a subsystem, so you
can just create an instance of it next to your other subsystems using the ports
constructor like so:

    public class Robot extends IterativeRobot {

        // Subsystems
        public static MecanumDrive drive;
        
        public void RobotInit() {
            drive = new MecanumDrive(0, 1, 2, 3);

In your OI.java, you will have to do things slightly differently. Instead of 
declaring your Extreme 3D Pro joystick as a wpilib `joystick` object, you will
have to use the wrapper class provided, `Extreme3DPro`. This class implements
`VectorSource`, which allows the Mecanum Drive to get its vector inputs from
the joystick. If you're messing around with autonomous modes, make sure your
profile follower is a `VectorSource` so you can feed it to the Mecanum drive.
