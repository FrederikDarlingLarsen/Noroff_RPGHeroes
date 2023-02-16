public class HeroRanger extends Hero {
    public HeroRanger(String _name){
        super(_name, new HeroAttributes(1,7,1), HeroClass.RANGER);

        addValidWeaponType(WeaponType.BOW);

        addValidArmorType(ArmorType.LEATHER);
        addValidArmorType(ArmorType.MAIL);
    }
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(1,5,1);
    }

}