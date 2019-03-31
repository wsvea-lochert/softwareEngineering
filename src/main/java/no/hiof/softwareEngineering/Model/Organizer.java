package no.hiof.softwareEngineering.Model;




public class Organizer {
    private String orgNo;
    private String companyName;
    private String email;
    private String password;

    public Organizer(){ }

    public Organizer(String orgNo, String companyName, String email, String password) {

        this.orgNo = orgNo;
        this.companyName = companyName;
        this.email = email;
        this.password = password;
    }

    //ToDo: Tanken var at Organizer arver fra Person siden vi trenger den samme info som for person
    // Viktig å tenke på at det også er privat personer som skal kunne opprette arrangement og at orgNo ikke er obligatoisk da


    public String getOrgNo() {
        return orgNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
