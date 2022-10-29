package br.com.xavero.projetofinal.enums;


public enum PossibleHourEnum {

    FIRST_HOUR("18 as 19 horas"),
    SECOND_HOUR("19 as 20 horas"),
    THIRD_HOUR("20 as 21"),
    FOURTH_HOUR("21 as 22");

    private String description;

    PossibleHourEnum(String description) {
        this.description = description;
    }
}
