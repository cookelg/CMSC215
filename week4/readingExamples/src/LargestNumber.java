import java.util.ArrayList;
import java.math.*;

public class LargestNumber {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(45); // add an integer
        list.add(3445.53); // add a double
        // Add a BigInteger
        list.add(new BigInteger("343232323434434101"));
        // Add a BigDecimal
        list.add(new BigDecimal("2.0909090909090909123412"));

        System.out.println("the largest number is " + getLargestNumber(list));
    }

    public static Number getLargestNumber(ArrayList<Number> list) {
        if (list == null || list.size() == 0)
            return null;

        Number number = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (number.doubleValue() < list.get(i).doubleValue())
                number = list.get(i);
        }
        return number;
    }
}
