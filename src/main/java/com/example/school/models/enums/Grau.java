package com.example.school.models.enums;

public enum Grau {
    ENSINO_BASICO(0, "Ensino básico"),
    ENSINO_FUNDAMENTAL_I(1, "Ensino fundamental I"),
    ENSINO_FUNDAMENTAL_II(2, "Ensino fundamental II"),
    ENSINO_MEDIO(3, "Ensino médio");

    private final int cod;
    private final String desc;

    Grau(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static Grau toEnum(int codigo) {
        for (Grau g : Grau.values()) {
            if (g.getCod() == codigo) {
                return g;
            }
        }
        return null;
    }
}
