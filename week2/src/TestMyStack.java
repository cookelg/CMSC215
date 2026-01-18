public class TestMyStack {
    public static void main(String[] args) {
        MyStack list = new MyStack();
        list.push(Integer.valueOf(5));
        list.push("Test");
        list.push(Double.valueOf(5.0));
        System.out.println(list.toString());
    }

}
