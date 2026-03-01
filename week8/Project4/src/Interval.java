/**
 * Date: 2026-03-01
 * - Generic class that contains two comparable objects as instance variables
 * - The instance methods will detect if it is a subinterval of, or overlaps
 * with another interval
 * 
 * @author Lawrence Cooke
 **/
public class Interval<E extends Comparable<E>> {
    private E intervalStart;
    private E intervalEnd;

    /**
     * Class Constructor
     * 
     * @param intervalStart Generic comparable object, indicates start of interval
     * @param intervalEnd   Generic comparable object, indicates end of interval
     **/
    public Interval(E intervalStart, E intervalEnd) {
        this.intervalStart = intervalStart;
        this.intervalEnd = intervalEnd;
    }

    public E getIntervalStart() {
        return intervalStart;
    }

    public E getIntervalEnd() {
        return intervalEnd;
    }

    /**
     * Returns a boolean indicating if an object of the same type is within the
     * interval
     *
     * @param obj Generic comparable object of the same type as the interval
     **/
    public boolean within(E obj) {
        if (obj.compareTo(intervalStart) >= 0 && obj.compareTo(intervalEnd) <= 0)
            return true;
        else
            return false;
    }

    /**
     * Generic class method that determines whether this interval is a subinterval
     * of another interval of the same type
     *
     * @param i Generic Interval of the same type as this interval
     **/
    public boolean subinterval(Interval<E> i) {
        if (i.within(intervalStart) && i.within(intervalEnd))
            return true;
        else
            return false;
    }

    /**
     * Generic class method that determines whether this interval overlaps another
     * interval of the same type
     *
     * @param i Generic Interval of the same type as this interval
     **/
    public boolean overlaps(Interval<E> i) {
        if (i.within(intervalStart) || i.within(intervalEnd))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Start: " + intervalStart.toString() + " | End: " + intervalEnd.toString();
    }
}
