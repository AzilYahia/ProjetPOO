package enums;

public enum Gender {
    FEMELLE("f"),
    MALE("m");
    private final String value;
    Gender(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static Gender fromString(String text) {
        for (Gender g : Gender.values()) {
            if (g.value.equalsIgnoreCase(text)) {
                return g;
            }
        }
        return null;
    }
}