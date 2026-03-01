public class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    private String meridian;

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

    public int getMilitaryTime() {
        int milHour = hour * 100;
        if (meridian.equals("PM") && hour < 12)
            milHour += 1200;
        else if (meridian.equals("AM") && hour == 12)
            milHour = 0;
        return milHour + minute;
    }

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

    public static void main(String[] args) {
        try {
            Interval<Time> interval1 = new Interval<Time>(new Time(2, 30, "AM"), new Time(1, 30, "PM"));
            Interval<Time> interval2 = new Interval<Time>(new Time(1, 15, "PM"), new Time(1, 30, "PM"));
            Interval<Time> interval3 = new Interval<Time>(new Time(1, 45, "PM"), new Time(2, 30, "PM"));
            Time time1 = new Time(3, 30, "AM");
            Time time2 = new Time(1, 45, "PM");
            Time time3 = new Time(12, 0, "AM");
            System.out
                    .println("is " + time1.toString() + " within " + interval1.toString() + "? "
                            + interval1.within(time1));
            System.out
                    .println("is " + time2.toString() + " within " + interval1.toString() + "? "
                            + interval1.within(time2));
            System.out.println("interval1 subinterval of 2?" + interval1.subinterval(interval2));
            System.out.println("interval2 subinterval of 1?" + interval2.subinterval(interval1));
            System.out.println("interval2 overlaps 1?" + interval2.overlaps(interval1));
            System.out.println("interval2 overlaps 3?" + interval2.overlaps(interval3));
            System.out.println(interval1.toString() + " = " +
                    interval1.getIntervalStart().getMilitaryTime() + " to " +
                    interval1.getIntervalEnd().getMilitaryTime());
            System.out.println(time3.getMilitaryTime());
        } catch (InvalidTimeException ex) {
            System.out.println(ex);
        }

    }
}

class InvalidTimeException extends Exception {
    private int hour;
    private int minute;
    private String meridian;

    public InvalidTimeException(int hour, int minute) {
        super("Invalid time entered: " + hour + ":" + minute);
        this.hour = hour;
        this.minute = minute;
    }

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
