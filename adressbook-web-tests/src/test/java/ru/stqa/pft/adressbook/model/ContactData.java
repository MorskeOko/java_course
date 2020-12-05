package ru.stqa.pft.adressbook.model;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickName;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String mobilePhone;
    private final String workPhone;
    private final String fax;
    private final String email;
    private final String homepage;
    private final String birthDay;
    private final String birthMonth;
    private final String birthYear;
    private final String secondaryAddress;
    private final String secondaryHome;
    private final String selectGroup;

    public ContactData(String firstName,
                       String middleName,
                       String lastName,
                       String nickName,
                       String title,
                       String company,
                       String address,
                       String home,
                       String mobilePhone,
                       String workPhone,
                       String fax,
                       String email,
                       String homepage,
                       String birthDay,
                       String birthMonth,
                       String birthYear,
                       String selectGroup,
                       String secondaryAddress,
                       String secondaryHome
                          )
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.fax = fax;
        this.email = email;
        this.homepage = homepage;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.selectGroup = selectGroup;
        this.secondaryAddress = secondaryAddress;
        this.secondaryHome = secondaryHome;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getSelectGroup() {
        return selectGroup;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public String getSecondaryHome() {
        return secondaryHome;
    }

}
