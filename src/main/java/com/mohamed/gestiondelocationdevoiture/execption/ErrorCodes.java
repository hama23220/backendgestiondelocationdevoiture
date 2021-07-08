package com.mohamed.gestiondelocationdevoiture.execption;

public enum ErrorCodes {

    CLIENT_NOT_FOUND(1000),
    CLIENT_NOT_VALID(1001),
    CLIENT_ALREADY_IN_USE(1002),
    CLIENT_CHANGE_PASSWORD_OBJECT_NOT_VALID(1003),

    CONDUCTEUR_NOT_FOUND(2000),
    CONDUCTEUR_NOT_VALID(2001),
    CONDUCTEUR_ALREADY_IN_USE(2002),

    CONTRAT_NOT_FOUND(3000),
    CONTRAT_NOT_VALID(3001),
    CONTRAT_ALREADY_IN_USE(3002),

    ENTRETIEN_NOT_FOUND(4000),
    ENTRETIEN_NOT_VALID(4001),
    ENTRETOEN_ALREADY_IN_USE(4002),

    MODELE_NOT_FOUND(5000),
    MODELE_NOT_VALID(5001),
    MODELE_ALREADY_IN_USE(5002),

    RESERVATIONCLIENT_NOT_FOUND(6000),
    RESERVATIONCLIENT_NOT_VALID(6001),
    RESERVATIONCLIENT_ALREADY_IN_USE(6002),

    VOITURE_NOT_FOUND(7000),
    VOITURE_NOT_VALID(7001),
    VOITURE_ALREADY_IN_USE(7002),

    UPDATE_PHOTO_EXCEPTION(8000),
    UNKNOWN_CONTEXT(8001)
    ;

    //ici on a déclarer un code qui va etre constant et on l'attribus un num spécifique a chaque error
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
