package no.hiof.softwareEngineering.Model;




public class Organizer{
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
