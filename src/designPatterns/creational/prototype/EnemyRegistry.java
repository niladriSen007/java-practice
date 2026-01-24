package designPatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {
    private final Map<String, Enemy> enemyRegistry = new HashMap<>();

    public void registerEnemyToRegistry(String enemyCategory, Enemy prototype) {
        enemyRegistry.put(enemyCategory, prototype);
    }

    public Enemy getEnemy(String enemyCategory) {
        Enemy prototype = enemyRegistry.get(enemyCategory);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new IllegalArgumentException("Enemy with " + enemyCategory + " does not exist");
    }

}
