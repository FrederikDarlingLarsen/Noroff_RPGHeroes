package org.example;

enum WeaponType{
    AXE,
    BOW,
    DAGGER,
    HAMMER,
    STAFF,
    SWORD,
    WAND
}

public class ItemWeapon extends Item {

    private WeaponType weaponType;

    private int weaponDamage;


    public ItemWeapon(String _name, int _reqLevel, WeaponType _weapontype, int _weaponDamage){
        super(_name, _reqLevel, Slot.WEAPON);
        this.weaponType = _weapontype;
        this.weaponDamage = _weaponDamage;

    }

    public WeaponType GetWeaponType(){
        return weaponType;
    }

    public int GetWeaponDamage (){
        return weaponDamage;
    }
}
