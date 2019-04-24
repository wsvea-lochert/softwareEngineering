package no.hiof.softwareEngineering.Model;


public class Organizer {
    private String companyName;
    private String email;
    private String password;
    private String fornavn;
    private String etternavn;

    public Organizer(){ }

    public Organizer(String companyName, String email, String password, String fornavn, String etternavn) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.etternavn = etternavn;
        this.fornavn = fornavn;
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

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFornavn() { return fornavn; }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }
}
