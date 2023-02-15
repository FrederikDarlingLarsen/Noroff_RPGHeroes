import java.util.ArrayList;
import java.util.HashMap;

public abstract class Hero {
    private final String name;
    private final String heroClass;
    private int level = 1;
    private final HeroAttributes levelAttributes;
    private final HashMap<Slot, Item> equipment;
    private final ArrayList<WeaponType> validWeaponTypes;
    private final ArrayList<ArmorType> validArmorTypes;

    public Hero (String _name, HeroAttributes _attributes, String _heroClass){
        this.name = _name;
        this.levelAttributes = _attributes;
        this.heroClass = _heroClass;

        equipment = new HashMap<>();
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.LEGS, null);

        validWeaponTypes = new ArrayList<WeaponType>();
        validArmorTypes = new ArrayList<ArmorType>();
    }

    public void levelUp(){
        level++;
    }
    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return this.level;
    }

    public void addAttributes(int strength, int dexterity, int intelligence){
        levelAttributes.addAttributes(new HeroAttributes(strength, dexterity, intelligence));
    }


    public HeroAttributes getAttributes(){
            HeroAttributes attribute = new HeroAttributes(levelAttributes.getStrength(),
                    levelAttributes.getDexterity(),levelAttributes.getIntelligence());

      for (Slot slot : Slot.values()) {

          if(!slot.equals(Slot.WEAPON)){
            if(getArmor(slot) != null) {
                attribute.addAttributes(new HeroAttributes(
                        getArmor(slot).getArmorAttributes().getStrength(),
                        getArmor(slot).getArmorAttributes().getDexterity(),
                        getArmor(slot).getArmorAttributes().getIntelligence()));
            }
        }}
        return attribute;
    }

    public void addValidWeaponType(WeaponType weaponType){
        this.validWeaponTypes.add(weaponType);
    }

    public void addValidArmorType(ArmorType armorType){
        this.validArmorTypes.add(armorType);
    }

    public ItemWeapon getWeapon(){
        return (ItemWeapon) equipment.get(Slot.WEAPON);
    }

    public ItemArmor getArmor(Slot slot){
        return (ItemArmor) equipment.get(slot);
    }

    public void equipWeapon(ItemWeapon weapon)  {

        try {
            if (this.validWeaponTypes.contains(weapon.getWeaponType())) {


                if(weapon.getRequiredLevel() <= this.level){
                    equipment.put(Slot.WEAPON, weapon);
                    System.out.println("You just equipped: " + weapon.getName());
                } else {
                    throw new InvalidWeaponException("You are not at a high enough level to equip this weapon: " + weapon.getName() +
                            "   of type: " + weapon.getWeaponType().name());
                }
            } else {
                throw new InvalidWeaponException("The following weapon can not be equipped by your class: " + weapon.getName() +
                        "   of type: " + weapon.getWeaponType().name());
            }
        }
        catch(InvalidWeaponException e){
            System.out.println(e.toString());
        }
    }

    public void equipArmor(ItemArmor armor) {

        try {
            if (this.validArmorTypes.contains(armor.getArmorType())) {

                if(armor.getRequiredLevel() <= this.level) {
                    equipment.put(armor.getSlot(), armor);
                    System.out.println("You just equipped: " + armor.getName());
                }else{
                    throw new InvalidArmorException("You can not equip this armor: " + armor.getName()  + "   of type: " +
                            armor.getArmorType().name());
                }
            } else {
                throw new InvalidArmorException("You can not equip this armor: " + armor.getName()  + "   of type: " +
                        armor.getArmorType().name());
            }
        }
        catch(InvalidArmorException e){
            System.out.println(e.toString());
        }
    }

    public abstract int damage();


    public StringBuilder display(){
        // Get Name,Class,Level,the 3 attributes, damage,
        //StringBuilder str = new StringBuilder();
        //str.append("GFG");


        /*String details =
        "Name: " + this.name + "\n" +
        "Class: " + this.heroClass + "\n" +
        "Level: " + this.level + "\n" +
        "Strength: " + this.levelAttributes.getStrength() + "\n" +
        "Dexterity: " + this.levelAttributes.getDexterity() + "\n" +
        "Intelligence: " + this.levelAttributes.getIntelligence() + "\n" +
        "Damage: " + this.damage();
        System.out.println(details);*/


        StringBuilder details = new StringBuilder("Details of Hero:" + "\n");

        String name = "Name: " + this.name + "\n";
        details.append(name);

        String className = "Class: " + this.heroClass + "\n";
        details.append(className);

        String level = "Level: " + this.level + "\n";
        details.append(level);

        String attributes = "Strength: " + this.levelAttributes.getStrength() + ", " +
                "Dexterity: " + this.levelAttributes.getDexterity() + ", " +
                "Intelligence: " + this.levelAttributes.getIntelligence() + "\n";
        details.append(attributes);

        String damage = "Damage: " + this.damage();
        details.append(damage);

        return details;
    }
}