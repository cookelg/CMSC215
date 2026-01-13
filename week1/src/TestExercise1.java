public class TestExercise1 {
    public static void main(String[] args) {
        Time time1 = new Time();
        Time time2 = new Time(555550000);
        Time time3 = new Time(5, 23, 55);

        System.out.printf("Time1: %02d:%02d:%02d\n", time1.getHour(), time1.getMinute(), time1.getSecond());
        System.out.printf("Time2: %2d:%2d:%2d\n", time2.getHour(), time2.getMinute(),
                time2.getSecond());
        System.out.printf("Time3: %2d:%2d:%2d\n", time3.getHour(), time3.getMinute(),
                time3.getSecond());

        time1.setTime(10, 10, 10);
        System.out.printf("updated Time1: %2d:%2d:%2d\n", time1.getHour(),
                time1.getMinute(), time1.getSecond());
    }
}
