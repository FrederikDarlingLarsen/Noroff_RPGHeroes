package org.example;

public abstract class Hero {

    private String name = "";

    private int level = 1;

    private HeroAttributes attributes;

    private int levelAttributes = 0;

    private Item[] equipment;

    private String[] validWeaponTypes;

    private String[] validArmorTypes;

    public Hero (String _name){
        this.name = _name;
        attributes = new HeroAttributes();
    }

    public void LevelUp(){}

    public void setAttributes(int strength, int dexterity, int intelligence){
        attributes.setStrength(strength);
        attributes.setDexterity(dexterity);
        attributes.setIntelligence(intelligence);
    }
    public void EquipWeapon(ItemWeapon weapon){}

    public void EquipArmor(ItemArmor armor){}

    public void Damage(){}

    public void TotalAttributes(){}

    public void Display(){
        System.out.println("details");
    }

}
