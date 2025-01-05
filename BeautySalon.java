import java.util.ArrayList;
import java.util.Scanner;

public class BeautySalon {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<BeautyProcedure> procedures = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    public void addUser(String name, boolean isVIP) {
        users.add(new User(name, isVIP));
    }

    public void addProcedure(String name, double price) {
        procedures.add(new BeautyProcedure(name, price));
    }

    public void bookProcedure(String userName, String procedureName) {
        User user = users.stream().filter(u -> u.getName().equals(userName)).findFirst().orElse(null);
        BeautyProcedure procedure = procedures.stream().filter(p -> p.getName().equals(procedureName)).findFirst().orElse(null);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        if (procedure == null) {
            System.out.println("Procedure not found!");
            return;
        }

        bookings.add(new Booking(user, procedure));
        System.out.println("Booking successful!");
    }

    public void showBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking.getBookingDetails());
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to the Beauty Salon! Choose an option:");
            System.out.println("1) Add User");
            System.out.println("2) Add Procedure");
            System.out.println("3) Book Procedure");
            System.out.println("4) Show Bookings");
            System.out.println("5) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Is VIP (true/false): ");
                    boolean isVIP = scanner.nextBoolean();
                    addUser(name, isVIP);
                    System.out.println("User added!");
                }
                case 2 -> {
                    System.out.print("Enter procedure name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter procedure price: ");
                    double price = scanner.nextDouble();
                    addProcedure(name, price);
                    System.out.println("Procedure added!");
                }
                case 3 -> {
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter procedure name: ");
                    String procedureName = scanner.nextLine();
                    bookProcedure(userName, procedureName);
                }
                case 4 -> showBookings();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
