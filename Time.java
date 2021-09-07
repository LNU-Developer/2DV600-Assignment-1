/*
* Date: 2021-09-07.
* File Name: Time.Java
* Author: Rickard Marjanovic
*
*/

/**
 * Class Description: This class is to create and calculate time in different
 * ways
 *
 * @version 1, 2021-09-07
 * @author Rickard Marjanovic
 */
public class Time {
    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;

    public Time() {
    }

    public Time(int _hours, int _minutes, int _seconds) {
        setHours(_hours);
        setMinutes(_minutes);
        setSeconds(_seconds);
    }

    public Time(int _seconds) {
        setClock(_seconds);
    }

    public void setClock(int seconds) {
        this.hours = (seconds / 60) / 60;
        this.minutes = (seconds / 60) % 60;
        this.seconds = seconds % 60;
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setHours(int hours) {
        if (hours < 0) {
            this.hours = 0;
        } else if (hours > 0 && hours < 24)
            this.hours = hours;
        else if (hours > 23) {
            this.hours = 23;
        }
    }

    public void setMinutes(int minutes) {
        if (minutes < 0) {
            this.minutes = 0;
        } else if (minutes > 0 && minutes < 60)
            this.minutes = minutes;
        else if (minutes > 59) {
            this.minutes = 59;
        }
    }

    public void setSeconds(int seconds) {
        if (seconds < 0) {
            this.seconds = 0;
        } else if (seconds > 0 && seconds < 60)
            this.seconds = seconds;
        else if (seconds > 59) {
            this.seconds = 59;
        }
    }

    public void tick() {
        this.seconds++;
    }

    public void tickDown() {
        this.seconds--;
    }

    public Time addTime(Time time) {
        return new Time(time.hours + this.hours, time.minutes + this.minutes, time.seconds + this.seconds);
    }

    public Time substracTime(Time time) {
        return new Time(this.hours - time.hours, this.minutes - time.minutes, this.seconds - time.seconds);
    }

    public String toString() {
        String hours = getHours() < 10 ? "0" + getHours() : String.valueOf(getHours());
        String minutes = getMinutes() < 10 ? "0" + getMinutes() : String.valueOf(getMinutes());
        String seconds = getSeconds() < 10 ? "0" + getSeconds() : String.valueOf(getSeconds());
        return hours + ":" + minutes + ":" + seconds;
    }
}
