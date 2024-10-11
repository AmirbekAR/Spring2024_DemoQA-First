package demoqa.enums;

public enum OldStyleSelectMenuValues {

    GREEN("Green"),
    BLACK("Black");

    String color;

    OldStyleSelectMenuValues(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
