package designpattertnsupgrade.structuraldp.decorator.example2;

public class GunPowerUp extends CharacterDecorator {
    public GunPowerUp(ICharacter character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " GunPowerUp";
    }

}
