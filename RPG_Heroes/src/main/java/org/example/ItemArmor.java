package org.example;


enum ArmorType{
    CLOTH,
    LEATHER,
    MAIL,
    PLATE
}

public class ItemArmor extends Item{

    ArmorType armorType;

    private HeroAttributes armorAttribute;

    public ItemArmor(ArmorType _armorType){
        this.armorType = _armorType;
    }

    public ArmorType GetArmorType (){
        return armorType;
    }

}