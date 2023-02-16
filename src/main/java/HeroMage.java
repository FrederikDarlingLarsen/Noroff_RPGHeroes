public class HeroMage extends Hero {

    public HeroMage(String _name){
        super(_name, new HeroAttributes(1,1,8), HeroClass.MAGE);

        addValidWeaponType(WeaponType.STAFF);
        addValidWeaponType(WeaponType.WAND);

        addValidArmorType(ArmorType.CLOTH);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(1,1,5);
    }

}