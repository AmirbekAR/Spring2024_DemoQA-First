package demoqa.entities;

import java.util.Objects;

public class PracticeForm {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String currentAddress;

    private String male;
    private String female;
    private String sports;
    protected String reading;
    private String music;

    public PracticeForm(String fullName, String lastName, String email, String mobileNumber,  String currentAddress) {
        this.firstName = fullName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.currentAddress = currentAddress;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public PracticeForm getPracticeForm() {
        return this;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFullName(String fullName) {
        this.firstName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }


    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeForm that = (PracticeForm) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(mobileNumber, that.mobileNumber)  && Objects.equals(currentAddress, that.currentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, mobileNumber,  currentAddress);
    }

    @Override
    public String toString() {
        return "PracticeForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", male='" + male + '\'' +
                ", female='" + female + '\'' +
                ", sports='" + sports + '\'' +
                ", reading='" + reading + '\'' +
                ", music='" + music + '\'' +
                '}';
    }
}

