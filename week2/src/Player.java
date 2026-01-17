public class Player {
    private String name;
    private int age;
    private Height height;

    public Player(String name, int age, int feet, int inches) {
        this.name = name;
        this.age = age;
        this.height = new Height(feet, inches);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHeight() {
        return height.toString();
    }

    public int toInches() {
        return height.toInches();
    }

    public String toString() {
        return "Name: " + name + " Age: " + age + " Height: " + height.toString();
    }

    public static void main(String[] args) {
        Player x = new Player("Steve", 21, 6, 13);
        Player y = new Player("franklin", 16, 3, 21);
        System.out.println(x.toString());
        System.out.println(y.toString());
        System.out.println(x.toInches());
        System.out.println(y.toInches());
    }
}
