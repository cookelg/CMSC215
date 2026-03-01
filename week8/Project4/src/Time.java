/**
 * Date: 2026-03-01
 *
 * - Comparable class to store time objects in HH:MM AM/PM format
 * - Instance methods will convert the time into an interger that matches
 * 24-hour format which is then used in the compareTo method to compare two
 * different time objects
 *
 * @author Lawrence cooke
 **/
public class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    private String meridian;

    /**
     * Class Constructor
     *
     * @param hour     integer that represents the hour, must be less than 13
     * @param minute   integer that represents the minute, must be less than 60
     * @param meridian String that represents the meridian, must be AM or PM
     *
     * @throws InvalidTimeException will throw this exception if any fields are out
     *                              of range
     **/
    public Time(int hour, int minute, String meridian) throws InvalidTimeException {
        if (hour >= 1 && hour <= 12 && minute >= 0 && minute < 60) {
            this.hour = hour;
            this.minute = minute;
        } else
            throw new InvalidTimeException(hour, minute);
        if (meridian.equals("AM") || meridian.equals("PM"))
            this.meridian = meridian;
        else
            throw new InvalidTimeException(meridian);
    }

    /**
     * Instance method that returns an integer representing the time object in 24hr
     * format
     **/
    public int getMilitaryTime() {
        int milHour = hour * 100;
        if (meridian.equals("PM") && hour < 12)
            milHour += 1200;
        else if (meridian.equals("AM") && hour == 12)
            milHour = 0;
        return milHour + minute;
    }

    /**
     * Overriden compareTo method converts each time object into an integer and
     * compares them following 24-hour time format
     * 12:00 AM = 0, 1:00 AM = 100, therefore 12:00 AM is less than 1:00 AM
     *
     * @param t Time object for which this time object will be compared against
     **/
    @Override
    public int compareTo(Time t) {
        if (getMilitaryTime() > t.getMilitaryTime())
            return 1;
        else if (getMilitaryTime() < t.getMilitaryTime())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        if (minute >= 10)
            return hour + ":" + minute + " " + meridian;
        else
            return hour + ":" + "0" + minute + " " + meridian;
    }
}

/**
 * Custom exception class used to check the validity of arguments passed to the
 * Time
 * constructor
 **/
class InvalidTimeException extends Exception {
    private int hour;
    private int minute;
    private String meridian;

    /**
     * Class Constructor
     * will be thrown if Time object is instantiated with out of range hour or
     * minute arguments, will exctract both hour and minute arguments and construct
     * the exception's message "Invalid time entered: 13:60"
     *
     * @param hour   integer that represents the hour argument
     * @param minute integer that represents the minute argument
     **/
    public InvalidTimeException(int hour, int minute) {
        super("Invalid time entered: " + hour + ":" + minute);
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Class Constructor
     * will be thrown if the Time object is instantiated with an invalid meridian
     * argument, will extract the meridian argument and construct the exception's
     * message "Invalid meridian entered: XM"
     *
     * @param meridian String that represents the meridian argument
     **/
    public InvalidTimeException(String meridian) {
        super("Invalid meridian entered: " + meridian);
        this.meridian = meridian;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getMeridian() {
        return meridian;
    }
}
