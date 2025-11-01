public class Receptionist extends StaffMember{

    private int deskNumber;
    private int hourPerWeek;

    public Receptionist(String id, String name, String surname, String dob, String contactNo, int deskNumber, int hourPerWeek){
        super(id, name, surname, dob, contactNo);

        this.deskNumber = deskNumber;
        this.hourPerWeek = hourPerWeek;
    }

    @Override
    public String getRole(){
        return "Doctor";
    }

    public int getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(int deskNumber) {
        this.deskNumber = deskNumber;
    }

    public int getHourPerWeek() {
        return hourPerWeek;
    }

    public void setHourPerWeek(int hourPerWeek) {
        this.hourPerWeek = hourPerWeek;
    }

    @Override
    public String toString(){
        return "Id: " + getId() + " Name: " + getName() + " Surname: " + getSurname() + " Dob: " + getDob() + " Contact No: " + getContactNo()
                + " Desk Number: " + this.deskNumber + " Hour Per Week: " + this.hourPerWeek ;
    }
}