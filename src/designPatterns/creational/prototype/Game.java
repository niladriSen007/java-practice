package designPatterns.creational.prototype;

public class Game {
    public static void main(String[] args) {
        EnemyRegistry enemyRegistry = new EnemyRegistry();

        enemyRegistry.registerEnemyToRegistry("flying", new Enemy("FlyingEnemy", 100, 12.0, false, "Laser"));
        enemyRegistry.registerEnemyToRegistry("armored", new Enemy("ArmoredEnemy", 300, 6.0, true, "Cannon"));

        Enemy e1 = enemyRegistry.getEnemy("flying");
        Enemy e2 = enemyRegistry.getEnemy("armored");
        Enemy e3 = enemyRegistry.getEnemy("flying");
        e3.setHealth(90);

        e1.printStatus();
        e2.printStatus();
        e3.printStatus();

    }
}
