package org.items;

import org.enums.Slot;
import org.enums.WeaponType;

public class ItemWeapon extends Item {
    private final WeaponType weaponType;
    private final int weaponDamage;

    public ItemWeapon(String _name, int _reqLevel, WeaponType _weapontype, int _weaponDamage){
        super(_name, _reqLevel, Slot.WEAPON);
        this.weaponType = _weapontype;
        this.weaponDamage = _weaponDamage;

    }

    public WeaponType getWeaponType(){
        return weaponType;
    }

    public int getWeaponDamage (){
        return weaponDamage;
    }
}
