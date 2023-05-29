package by.tms.entity;

import java.time.LocalDateTime;

public class Operation implements Comparable<Operation> {
    private final double num1;
    private final double num2;
    private double result;
    private OperationType type;
    private LocalDateTime time;

    public Operation(double num1, double num2, OperationType type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    public OperationType getType() {
        return type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Operation setResult(double result) {
        this.result = result;
        return this;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Operation{" +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", result=" + result +
                ", type=" + type +
                ", time=" + time +
                '}';
    }

    @Override
    public int compareTo(Operation o) {
        if (this.getTime().isBefore(o.getTime())) {
            return 1;
        } else if (this.getTime().isAfter(o.getTime())) {
            return -1;
        }
        return 0;
    }

}
