package designpattertnsupgrade.structuraldp.decorator.example2;

public class Client {
    public static void main(String[] args) {
        ICharacter mario = new Mario();
        System.out.println("Basic character: " + mario.getAbilities());

        mario = new HeightUp(mario);
        System.out.println("HeightUp character: " + mario.getAbilities());

        mario = new GunPowerUp(mario);
        System.out.println("GunPowerUp character: " + mario.getAbilities());

    }
}
