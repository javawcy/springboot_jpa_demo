package dev.lowdad.jpa_demo.enums;

/**
 * <p>
 *
 * </P>
 *
 * @author Chongyu
 * @since 2020/10/12
 */
public enum Gender {
    UN_KNOW("未知"),
    MALE("男"),
    FEMALE("女")

    ;
    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
