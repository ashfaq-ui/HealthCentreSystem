public class Doctor extends StaffMember{

    private String licenceNumber;
    private String specialisation;
    private int consultationPerWeek;

    public Doctor(String id, String name, String surname, String dob, String contactNo, String licenceNumber, String specialisation, int consultationPerWeek){
        super(id, name, surname, dob, contactNo);

        this.licenceNumber = licenceNumber;
        this.specialisation = specialisation;
        this.consultationPerWeek = consultationPerWeek;
    }
    @Override
    public String getRole(){
        return "Doctor" ;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getConsultationPerWeek() {
        return consultationPerWeek;
    }

    public void setConsultationPerWeek(int consultationPerWeek) {
        this.consultationPerWeek = consultationPerWeek;
    }

    @Override
    public String toString(){
        return "Id: " + getId() + " Name: " + getName() + " Surname: " + getSurname() + " Dob: " + getDob() + " Contact No: " + getContactNo()
                + " Licence Number: " + this.licenceNumber + " Specialisation: " + this.specialisation + " consultationPerWeek: " + this.consultationPerWeek;
    }
}