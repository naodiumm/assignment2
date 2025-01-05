public class Booking {
    private User user;
    private BeautyProcedure procedure;

    public Booking(User user, BeautyProcedure procedure) {
        this.user = user;
        this.procedure = procedure;
    }

    public String getBookingDetails() {
        if (user.isVIP()) {
            return user.getName() + " booked " + procedure.getName() + " (Free for VIP)";
        } else {
            return user.getName() + " booked " + procedure.getName() + " for $" + procedure.getPrice();
        }
    }
}