public class TestGenericStack {
    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Test1");
        stack.push("Test2");
        stack.push("Test3");
        System.out.println("stack length: " + stack.getSize());
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.toString());
    }
}
