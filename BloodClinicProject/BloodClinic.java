import java.util.Scanner;
/*
 * Filipe Lutz Mariano
 * 
 * Student ID: 25956
 * 
 * 25956@student.dorset-college.ie
 * 
 */

public class BloodClinic{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for their first name, last name, and donor/receiver status
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Are you a donor or receiver? Enter 'D' for donor or 'R' for receiver: ");
        String status = scanner.nextLine();

        // Create a new Donor or Receiver object based on the user's choice
        if (status.equalsIgnoreCase("D")) {
            System.out.println("Enter the blood type you can give (A+, O+, B+, AB+, A-, O-, B-, AB- ): ");
            String bloodType = scanner.nextLine().toUpperCase();

            // Prompt the user to re-enter the blood type if it's not valid
            while (!isValidBloodType(bloodType)) {
                System.out.println("Invalid blood type. Please enter a valid blood type: ");
                bloodType = scanner.nextLine().toUpperCase();
            }

            Donor donor = new Donor(firstName, lastName, bloodType);
            System.out.println("As a donor, you can give blood type: " + donor.getBloodType());
            
        } else if (status.equalsIgnoreCase("R")) {
            System.out.println("Enter your blood type (A+, O+, B+, AB+, A-, O-, B-, AB- ): ");
            String bloodType = scanner.nextLine().toUpperCase();

            // Prompt the user to re-enter the blood type if it's not valid
            while (!isValidBloodType(bloodType)) {
                System.out.println("Invalid blood type. Please enter a valid blood type: ");
                bloodType = scanner.nextLine().toUpperCase();
            }

            Receiver receiver = new Receiver(firstName, lastName, bloodType);
            System.out.println("As a receiver, you can receive blood type: " + receiver.getBloodType());
        } else {
            System.out.println("Invalid status. Please enter 'D' for donor or 'R' for receiver.");
        }
    }
    
    // Helper method to check if a blood type is valid
    static boolean isValidBloodType(String bloodType){ 
        return bloodType.equalsIgnoreCase("A+") ||
                bloodType.equalsIgnoreCase("A-") ||
                bloodType.equalsIgnoreCase("B+") ||
                bloodType.equalsIgnoreCase("B-") ||
                bloodType.equalsIgnoreCase("AB+") ||
                bloodType.equalsIgnoreCase("AB-") ||
                bloodType.equalsIgnoreCase("O+") ||
                bloodType.equalsIgnoreCase("O-");
    }
}