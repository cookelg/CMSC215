/*
 * 
 * Design a class named Time. The class contains:
 * 
 * - The data fields hour, minute, and second that represent a time.
 * 
 * - A no-arg constructor that creates a Time object for the current time. (The
 * values
 * of the data fields will represent the current time)
 * 
 * - A constructor that constructs a Time object with a specified elapsed time
 * since
 * midnight, January 1, 1970, in milliseconds. (The values of the data fields
 * will
 * represent this time)
 * 
 * - A constructor that constructs a Time object with the specified hour,
 * minute, and
 * second.
 * 
 * - Three getter methods for the data fields hour, minute, and second,
 * respectively.
 * 
 * - A method named setTime(long elapseTime) that sets a new time for the object
 * using
 * the elapsed time. For example, if the elapsed time is 555550000 milliseconds,
 * the
 * hour is 10, the minute is 19, and the second is 10
 * 
 * - Write a main method that creates three Time objects (using new Time(),
 * new Time(555550000), and new Time(5, 23, 55)) and displays their hour,
 * minute, and
 * second in the format hour:minute:second.
 * 
 * Hint: The first two constructors will extract the hour, minute, and second
 * from the
 * elapsed time. For the no-arg constructor, the current time can be obtained
 * using
 * System.currentTimeMillis(), as shown in LiveExample 2.7,
 * ShowCurrentTime.java.
 * Assume the time is in GMT.
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        hour = (int) ((System.currentTimeMillis()) / 1000 / 60 / 60 % 24);
        minute = (int) ((System.currentTimeMillis()) / 1000 / 60 % 60);
        second = (int) ((System.currentTimeMillis()) / 1000 % 60);
    }

    public Time(long elapsedTime) {
        hour = (int) (elapsedTime / 1000 / 60 / 60 % 24);
        minute = (int) (elapsedTime / 1000 / 60 % 60);
        second = (int) (elapsedTime / 1000 % 60);
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

}
