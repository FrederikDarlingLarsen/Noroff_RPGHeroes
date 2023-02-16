package org.items;

import org.enums.ArmorType;
import org.enums.Slot;
import org.items.Item;
import org.heroes.HeroAttributes;


public class ItemArmor extends Item{

    private final ArmorType armorType;

    private final HeroAttributes armorAttributes;

    public ItemArmor(String _name, int _reqLevel, Slot _slot, ArmorType _armorType, HeroAttributes _armorAttributes){
        super(_name, _reqLevel, _slot);
        this.armorType = _armorType;
        this.armorAttributes = _armorAttributes;
    }

    public ArmorType getArmorType (){
        return this.armorType;
    }

    public HeroAttributes getArmorAttributes(){ return this.armorAttributes; }


}