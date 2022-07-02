package br.com.xavero.projetofinal.enuns;

public enum PossibleHour {

    FIRST_HOUR("18 as 19 horas"),
    SECOND_HOUR("19 as 20 horas"),
    THIRD_HOUR("20 as 21"),
    FOURTH_HOUR("20 as 21");

    private String description;

    PossibleHour(String description) {
        this.description = description;
    }
}
