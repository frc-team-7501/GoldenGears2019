package frc.robot.extensions;

public abstract class PID {
    double Kp, Ki, Kd;
    double nonZeroCycles = 0, lastError = 0, setpoint = 0;

    // Calls PID values (posistion, integral, and derivitive)
    public PID(double p, double i, double d) {
        Kp = p;
        Ki = i;
        Kd = d;
    }

    public abstract double getInput();
    public abstract void useOutput(double output);

    public double getSetpoint() {
        return setpoint;
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public double getLastError() {
        return lastError;
    }

    public void execute() {
        double current = getInput();
        double error = setpoint - current;

        if (Math.abs(error) < 2) {
            lastError = error;
            nonZeroCycles = 0;
            useOutput(0);
            return;
        }

        nonZeroCycles++;

        double i = error * nonZeroCycles;
        double d = error - lastError / 50;

        // Uses this equation to auto adjust arm to keep it at it's target
        double result = (Kp * error) + (Ki * i) + (Kd * d);
        useOutput(result);

        lastError = error;
    }
}
