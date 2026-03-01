public class Interval<E extends Comparable<E>> {
    private E intervalStart;
    private E intervalEnd;

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

    public boolean within(E obj) {
        if (obj.compareTo(intervalStart) >= 0 && obj.compareTo(intervalEnd) <= 0)
            return true;
        else
            return false;
    }

    // is this a subinterval of Interval<E>
    public boolean subinterval(Interval<E> i) {
        if (i.within(intervalStart) && i.within(intervalEnd))
            return true;
        else
            return false;
    }

    // Does this overlap with Interval<E>
    public boolean overlaps(Interval<E> i) {
        if (i.within(intervalStart) || i.within(intervalEnd))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return intervalStart.toString() + " through " + intervalEnd.toString();
    }

    public static void main(String[] args) {
        Interval<Integer> interval1 = new Interval<>(1, 10);
        Interval<Integer> interval2 = new Interval<>(2, 10);
        Interval<Integer> interval3 = new Interval<>(1, 9);
        Interval<Integer> interval4 = new Interval<>(10, 12);

        System.out.println("is 2 within interval " + interval1.toString() + " ? "
                + interval1.within(2));
        System.out.println("is 11 within interval " + interval1.toString() + " ? "
                + interval1.within(11));
        System.out.println("is interval " + interval1.toString() + " a sub-interval of "
                + interval2.toString() + "? " + interval1.subinterval(interval2));
        System.out.println("is interval " + interval3.toString() + " a sub-interval of "
                + interval1.toString() + "? " + interval3.subinterval(interval1));
        System.out.println("does interval " + interval1.toString() + " overlap with "
                + interval4.toString() + "? " + interval1.overlaps(interval4));
        System.out.println("does interval " + interval3.toString() + " overlap with "
                + interval4.toString() + "? " + interval3.overlaps(interval4));
    }

}
