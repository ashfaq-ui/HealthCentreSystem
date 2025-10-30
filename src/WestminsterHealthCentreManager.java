import java.util.*;

public class WestminsterHealthCentreManager implements HealthCenterManager{
    List<StaffMember> staff = new ArrayList<>();
    private int staffLimit;
    Scanner input = new Scanner(System.in);

//    void addStaff();
//    void viewStaff();
//    void removeStaff();

    public static void main(String[] args) {

        WestminsterHealthCentreManager manager = new WestminsterHealthCentreManager();

        while (manager.runMenu()) {
            manager.runMenu();
        }

        System.out.println("Exiting system. Goodbye!");
    }

    public boolean runMenu(){

        System.out.println("\n1 - Add New Staff Member"
                + "\n2 - Remove Staff Member"
                + "\n3 - View All Staff"
                + "\n4 - Search Staff by ID"
                + "\n0 - Exit without Saving"

        );
        System.out.print("Enter your choice:");
        int userInput = input.nextInt();

        switch (userInput) {
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
                String id = input.next();
                System.out.println(searchById(id));
                return true;
            case 0:
                return false;
            default:
                System.out.println("Invalid option. Please try Again.");
                return true;
        }


    }

    @Override
    public void addStaff(){


        System.out.println("\n1 - Add new Doctor" +
                "\n2 - Add new Receptionist"
        );
        System.out.print("Enter here:");
        int inputAddStaff = input.nextInt();

        switch(inputAddStaff){
            case 1:
                System.out.print("Id :");
                String dId = input.next();

                System.out.print("Name :");
                String dName = input.next();

                System.out.print("Surname :");
                String dSurname = input.next();

                System.out.print("dob :");
                String dDob = input.next();

                System.out.print("Contact Number :");
                String dContactNumber = input.next();

                System.out.print("Licence Number :");
                String licenceNumber = input.next();

                System.out.print("Specialisation :");
                String specialisation = input.next();

                System.out.print("Consultation Per Week :");
                String consultationPerWeek = input.next();


                StaffMember doctor = new Doctor(dId,dName,dSurname,dDob,dContactNumber,licenceNumber,specialisation, consultationPerWeek);

                staff.add(doctor);

                break;

            case 2:

                System.out.print("Id :");
                String rId = input.next();

                System.out.print("Name :");
                String rName = input.next();

                System.out.print("Surname :");
                String rSurname = input.next();

                System.out.print("dob :");
                String rDob = input.next();

                System.out.print("Contact Number :");
                String rContactNumber = input.next();

                System.out.print("Desk Number :");
                String deskNumber = input.next();

                System.out.print("Hour Per Week :");
                String hourPerWeek = input.next();



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
        String idToRemove = input.next();

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

//    public void sortByName(String name){
////        4.	Collections.sort(staffList, Comparator.comparing(StaffMember::getSurname)
//
//        Collections.sort(staff);
//
//
//
//    }

}