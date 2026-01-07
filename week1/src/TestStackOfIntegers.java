public class TestStackOfIntegers {
    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();

        for (int i = 0; i < 10; i++)
            stack.push(i);

        System.out.println("Peek test 1: " + stack.peek());
        System.out.println("Pop test 1: " + stack.pop());
        System.out.println("Peek test 2: " + stack.peek());
        System.out.println("Pop test 2: " + stack.pop());
        System.out.println("Peek test 3: " + stack.peek());

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");

        System.out.println();

        StackOfIntegers stack2 = new StackOfIntegers();

        for (int i = 0; i < 17; i++) {
            stack2.push(i);
            if (i == 15)
                System.out.println("Capacity Reached");
            else if (i == 16)
                System.out.println("Capacity increased successfully");
        }

        while (!stack2.isEmpty())
            System.out.print(stack2.pop() + " ");
    }
}
