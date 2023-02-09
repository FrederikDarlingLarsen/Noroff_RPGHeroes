package org.example;


enum ArmorType{
    CLOTH,
    LEATHER,
    MAIL,
    PLATE
}

public class ItemArmor extends Item{

    private final ArmorType armorType;

    private final HeroAttributes armorAttributes;

    public ItemArmor(String _name, int _reqLevel, Slot _slot, ArmorType _armorType, HeroAttributes _armorAttributes){
        super(_name, _reqLevel, _slot);
        this.armorType = _armorType;
        this.armorAttributes = _armorAttributes;
    }

    public ArmorType GetArmorType (){
        return this.armorType;
    }

    public HeroAttributes GetArmorAttributes(){ return this.armorAttributes; }


}