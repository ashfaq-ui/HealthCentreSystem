public class Receptionist extends StaffMember{

    private String deskNumber;
    private String hourPerWeek;

    public Receptionist(String id, String name, String surname, String dob, String contactNo, String deskNumber, String hourPerWeek){
        super(id, name, surname, dob, contactNo);

        this.deskNumber = deskNumber;
        this.hourPerWeek = hourPerWeek;
    }

    @Override
    public String getRole(){
        return "Doctor";
    }

    public String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }

    public String getHourPerWeek() {
        return hourPerWeek;
    }

    public void setHourPerWeek(String hourPerWeek) {
        this.hourPerWeek = hourPerWeek;
    }

    @Override
    public String toString(){
        return "Id: " + getId() + " Name: " + getName() + " Surname: " + getSurname() + " Dob: " + getDob() + " Contact No: " + getContactNo()
                + " Desk Number: " + this.deskNumber + " Hour Per Week: " + this.hourPerWeek ;
    }
}