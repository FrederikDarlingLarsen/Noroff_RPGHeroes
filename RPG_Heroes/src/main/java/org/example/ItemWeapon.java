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


    public ItemWeapon(WeaponType _weapontype){
        this.weaponType = _weapontype;

    }

    public WeaponType GetWeaponType(){
        return weaponType;
    }

    public int GetWeaponDamage (){
        return weaponDamage;
    }
}
