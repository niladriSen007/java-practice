package designpattertnsupgrade.structuraldp.decorator.example2;

public abstract class CharacterDecorator implements ICharacter {
    protected ICharacter character;

    public CharacterDecorator(ICharacter character) {
        this.character = character;
    }

}
