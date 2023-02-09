package org.example;


enum ArmorType{
    CLOTH,
    LEATHER,
    MAIL,
    PLATE
}

public class ItemArmor extends Item{

    private ArmorType armorType;

    private HeroAttributes armorAttribute;

    public ItemArmor(String _name, int _reqLevel, Slot _slot, ArmorType _armorType){
        super(_name, _reqLevel, _slot);
        this.armorType = _armorType;
    }

    public ArmorType GetArmorType (){
        return armorType;
    }

}