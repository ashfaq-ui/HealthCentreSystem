import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;
import java.time.*;

public class WestminsterHealthCentreManager implements HealthCenterManager{
    List<StaffMember> staff = new ArrayList<>();
    private int staffLimit;
    Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        WestminsterHealthCentreManager manager = new WestminsterHealthCentreManager();

        while (manager.runMenu()) {
        }

        System.out.println("Exiting system. Goodbye!");
    }

    public boolean runMenu(){

        try {
            System.out.println("\n\t=== Westminster Health Centre Management System ===\n"
                    + "\n1 - Add New Staff Member"
                    + "\n2 - Remove Staff Member"
                    + "\n3 - View All Staff"
                    + "\n4 - Search Staff by ID"
                    + "\n5 - Sort Staff by Name"
                    + "\n0 - Exit without Saving"


            );
            System.out.print("Enter your choice:");
            String userInput = input.nextLine();
            int choise = Integer.parseInt(userInput);


            switch (choise) {
                case 1:
                    addStaff();
                    return true;
                case 2:
                    removeStaff();
                    return true;
                case 3:
                    viewStaff();
                    return true;

                case 4:
                    System.out.print("Enter the Id: ");
                    String id = input.nextLine();
                    System.out.println(searchById(id));
                    return true;

                case 5:
                    System.out.println("before sorting");
                    System.out.println(staff);
                    sortByName();

                case 0:
                    return false;
                default:
                    System.out.println("Invalid option. Please try Again.");
                    return true;
            }
        } catch(NumberFormatException e){
            System.out.println("\nError: Invalid input. Please enter a whole number.\n");
            return true;
        }




    }

    @Override
    public void addStaff(){


        System.out.println("""
                
                1 - Add new Doctor\

                2 - Add new Receptionist"""
        );
        System.out.print("Enter here:");
        String inputAddStaff = input.nextLine();
        int inputAddStaffInt = Integer.parseInt(inputAddStaff);

        switch(inputAddStaffInt){
            case 1:
                try {
                    String dId ;
                    while(true){
                        System.out.print("Id :");
                        dId = input.next();

                        boolean idExits = false;

                        for (int i = 0 ; i < staff.size() ; i++){
                            if(dId.equals(staff.get(i).getId())){
                                System.out.println("entered id already exits! try again..");
                                idExits = true;
                                break;
                            }

                        }


                        if(!idExits){
                            break;
                        }

                    }



                    System.out.print("Name :");
                    String dName = input.next();

                    System.out.print("Surname :");
                    String dSurname = input.next();

                    input.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String requiredFormat = "yyyy-MM-dd";

                    LocalDate validDate = null;
                    String dDob = "";

                    while (validDate == null) {
                        System.out.print("Please enter your birth date (e.g., 1995-08-25): ");
                        String rawInput = input.nextLine(); // Get raw input


                        try {
                            String cleanedInput = rawInput.strip();
                            validDate = LocalDate.parse(cleanedInput, formatter);
                            dDob = cleanedInput;
                            // If it succeeds, this line will run:
                            System.out.println("Success! That is a valid date: " + validDate);

                        } catch (DateTimeParseException e) {
                            // 5. If it fails, the user was NOT compliant.
                            // We catch the error and loop again.
                            System.out.println("Error: Format is not compliant.");
                            System.out.println("Please use the exact format: " + requiredFormat);
                            System.out.println("--------------------------------------");
                        }
                    }


                    System.out.print("Contact Number :");
                    String dContactNumber = input.next();

                    System.out.print("Licence Number :");
                    String licenceNumber = input.next();

                    System.out.print("Specialisation :");
                    String specialisation = input.next();

                    int consultPerWeek; // Declare it here so you can use it after the loop
                    input.nextLine();
                    while(true) {
                        System.out.print("Consultation Per Week: ");
                        String consultationPerWeekStr = input.nextLine(); // Renamed to avoid confusion

                        try {
                            // Try to convert the string to an int
                            consultPerWeek = Integer.parseInt(consultationPerWeekStr);

                            // If it succeeds, break out of the loop
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please insert a number. Try again!");
                        }
                    }

                    StaffMember doctor = new Doctor(dId, dName, dSurname, dDob, dContactNumber, licenceNumber, specialisation, consultPerWeek);

                    staff.add(doctor);
                    break;
                } catch(NumberFormatException e){
                    System.out.println("Error: Invalid input.");
                    addStaff();
                }


            case 2:


                String rId ;
                while(true){
                    System.out.print("Id :");
                    rId = input.next();

                    boolean idExits = false;

                    for (int i = 0 ; i < staff.size() ; i++){
                        if(rId.equals(staff.get(i).getId())){
                            System.out.println("entered id already exits! try again..");
                            idExits = true;
                            break;
                        }

                    }


                    if(!idExits){
                        break;
                    }

                }

                System.out.print("Name :");
                String rName = input.next();

                System.out.print("Surname :");
                String rSurname = input.next();

                input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String requiredFormat = "yyyy-MM-dd";

                LocalDate validDate = null;
                String rDob = "";

                while (validDate == null) {
                    System.out.print("Please enter your birth date (e.g., 1995-08-25): ");
                    String rawInput = input.nextLine(); // Get raw input


                    try {
                        String cleanedInput = rawInput.strip();
                        validDate = LocalDate.parse(cleanedInput, formatter);
                        rDob = cleanedInput;
                        // If it succeeds, this line will run:
                        System.out.println("Success! That is a valid date: " + validDate);

                    } catch (DateTimeParseException e) {
                        // 5. If it fails, the user was NOT compliant.
                        // We catch the error and loop again.
                        System.out.println("Error: Format is not compliant.");
                        System.out.println("Please use the exact format: " + requiredFormat);
                        System.out.println("--------------------------------------");
                    }
                }

                System.out.print("Contact Number :");
                String rContactNumber = input.next();

                int deskNumber;
                input.nextLine();
                while(true) {

                    System.out.print("Desk Number :");
                    String strDeskNumber = input.nextLine();

                    try{
                        deskNumber = Integer.parseInt(strDeskNumber);
                        break;
                    } catch(NumberFormatException e){
                        System.out.println("Please enter a number!");
                    }

                }

                int hourPerWeek ;
                while(true){
                    System.out.print("Hour Per Week :");
                    String strHourPerWeek = input.nextLine();

                    try{
                        hourPerWeek = Integer.parseInt(strHourPerWeek);
                        break;
                    } catch(NumberFormatException e){
                        System.out.println("Please enter a number");
                    }
                }






                StaffMember receptionist = new Receptionist(rId,rName,rSurname,rDob,rContactNumber,deskNumber, hourPerWeek);

                staff.add(receptionist);

                break;

        }


    }

    @Override
    public void viewStaff() {
        System.out.println("\n" + staff + "\n");
    }

    @Override
    public void removeStaff(){
        System.out.print("Enter the ID of the staff to remove: ");
        String idToRemove = input.nextLine();

        int indexToRemove = -1;
        StaffMember staffToRemove = null;

        for(int i = 0; i < staff.size() ; i++ ){
            if(staff.get(i).getId().equals(idToRemove)){
                staffToRemove = staff.get(i);
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            staff.remove(indexToRemove);
            System.out.println("Successfully removed staff member.");
            System.out.print(staffToRemove + "\n");
            input.nextLine();
        } else {
            System.out.println("Error: Staff member with ID " + idToRemove + " not found.");
        }



    }

    public StaffMember searchById(String id){

        for(StaffMember findStaff : staff){

            if(findStaff.getId().equals(id)){
                return findStaff ;
            }
        }

        return null;

    }

    public void sortByName(){
//        4.	Collections.sort(staffList, Comparator.comparing(StaffMember::getSurname)

        Collections.sort(staff, Comparator.comparing(StaffMember::getSurname)
                .thenComparing(StaffMember::getName));
        System.out.println(staff);

    }

}