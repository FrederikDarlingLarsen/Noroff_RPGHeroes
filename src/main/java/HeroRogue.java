public class HeroRogue extends Hero {
    public HeroRogue(String _name){
        super(_name, new HeroAttributes(2,6,1), HeroClass.ROGUE);

        addValidWeaponType(WeaponType.DAGGER);
        addValidWeaponType(WeaponType.SWORD);

        addValidArmorType(ArmorType.LEATHER);
        addValidArmorType(ArmorType.MAIL);
    }
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(1,4,1);
    }


}