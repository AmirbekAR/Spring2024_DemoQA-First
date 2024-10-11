package demoqa.entities;

import java.util.Objects;

public class TextBox {

    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    public TextBox(String fullName, String email, String currentAddress, String permanentAddress) {
        this.fullName = fullName;
        this.email = email;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextBox textBox = (TextBox) o;
        return Objects.equals(fullName, textBox.fullName) && Objects.equals(email, textBox.email) && Objects.equals(currentAddress, textBox.currentAddress) && Objects.equals(permanentAddress, textBox.permanentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, email, currentAddress, permanentAddress);
    }

    @Override
    public String toString() {
        return "TextBox{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                '}';
    }
}
