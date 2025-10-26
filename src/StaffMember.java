public abstract class StaffMember{
//    id, name, surname, dob, contactNo
    private int id;
    private String name;
    private String surname;
    private int dob;
    private int contactNo;

    public StaffMember(int id, String name, String surname, int dob, int contactNo){
        this.id = id;
        this.name= name;
        this.surname= surname;
        this.dob = dob;
        this.contactNo = contactNo;

    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "Id: " + this.id + "Name:" + this.name + "surname: " + this.surname + "Dob: " + this.dob + "Contact No: " + this.contactNo ;
    }

    public abstract void getRole();
}