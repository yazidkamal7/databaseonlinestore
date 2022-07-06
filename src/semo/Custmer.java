package semo;

public class Custmer {
    private String cuid;
    private String name;
    private String phonenumber;
    private String socialAccount;
    private String adress;
    public Custmer(String string, String name, String phonenumber, String socialAccount, String adress){
        this.name=name;
        this.phonenumber=phonenumber;
        this.socialAccount=socialAccount;
        this.adress=adress;

    }
    public Custmer() {

    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSocialAccount() {
        return socialAccount;
    }

    public void setSocialAccount(String socialAccount) {
        this.socialAccount = socialAccount;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
       this.adress=adress;

    }

    @Override
    public String toString() {
        return "Custmer{" +
                "cuid='" + getCuid() + "' " +
                "name='" + getName() + "' " +
                ", phonenumber='" + getPhonenumber() + "' " +
                ", socialAccount='" + getSocialAccount() + "' " +
                ",Adress='"  + getAdress() +
                '}';
    }

}
