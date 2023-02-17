package org.exceptions;

//Custom exception for when a hero attempts to equip an invalid weapon.
public class InvalidWeaponException extends Exception {
    public InvalidWeaponException(String err) {
        super(err);
    }
}
