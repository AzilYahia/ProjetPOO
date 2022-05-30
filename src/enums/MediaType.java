package enums;

public enum MediaType {
    CD(1),
    LIVRE(2),
    MEMOIRE(3);
    int num;
    MediaType(int num) {
        this.num = num;
    }
    public static MediaType fromNum(int num) {
        for (MediaType type : MediaType.values()) {
            if (type.num == num) {
                return type;
            }
        }
        return null;
    }
}
