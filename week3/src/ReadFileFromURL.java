import java.util.Scanner;

public class ReadFileFromURL {
    public static void main(String[] args) {
        Scanner cli = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String URLString = cli.next();
        cli.close();

        try {
            java.net.URL url = new java.net.URL(URLString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                String line = input.nextLine();
                count += line.length();
            }
            input.close();

            System.out.println("The file size is " + count + " characters");
        } catch (java.net.MalformedURLException ex) {
            System.out.println("Invalid URL");
        } catch (java.io.IOException ex) {
            System.out.println("IO Errors");
        }
    }
}
