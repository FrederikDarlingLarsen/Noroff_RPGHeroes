package org.exceptions;

//Custom exception for when the hero attempts to equip invalid armor.
public class InvalidArmorException extends Exception {
    public InvalidArmorException(String err) {
        super(err);
    }
}
