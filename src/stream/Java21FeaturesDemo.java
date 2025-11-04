package stream;

import java.util.List;

/**
 * Java 21 LTS Features Demo
 * This class demonstrates some of the new features available in Java 21 LTS
 */
public class Java21FeaturesDemo {

  public static void main(String[] args) {
    System.out.println("=== Java 21 LTS Features Demo ===\n");
    System.out.println("Java Runtime Version: " + Runtime.version());
    System.out.println("Java Version: " + System.getProperty("java.version"));
    System.out.println();

    // 1. Pattern Matching with Switch Expressions (Preview/Standard in Java 21)
    demonstratePatternMatching();

    // 2. Record Patterns (Preview in Java 21)
    demonstrateRecordPatterns();

    // 3. String Templates (Preview in Java 21)
    demonstrateStringFeatures();

    // 4. Sequenced Collections (Java 21)
    demonstrateSequencedCollections();
  }

  /**
   * Demonstrates switch expressions (Java 14+ feature)
   */
  private static void demonstratePatternMatching() {
    System.out.println("1. Switch Expressions (Java 14+ feature):");

    int[] numbers = { 1, 2, 3, 4, 5 };

    for (int num : numbers) {
      String result = switch (num) {
        case 1, 2, 3 -> "Small number: " + num;
        case 4, 5 -> "Medium number: " + num;
        default -> "Large number: " + num;
      };
      System.out.println("  " + result);
    }
    System.out.println();
  }

  /**
   * Record for demonstrating record patterns
   */
  record Point(int x, int y) {
  }

  record Circle(Point center, double radius) {
  }

  /**
   * Demonstrates record patterns (if available in your Java 21 build)
   */
  private static void demonstrateRecordPatterns() {
    System.out.println("2. Records (available in Java 14+):");

    Point origin = new Point(0, 0);
    Point point1 = new Point(3, 4);
    Circle circle = new Circle(point1, 5.0);

    System.out.println("  Origin: " + origin);
    System.out.println("  Point1: " + point1);
    System.out.println("  Circle: " + circle);

    // Calculate distance from origin
    double distance = Math.sqrt(point1.x() * point1.x() + point1.y() * point1.y());
    System.out.println("  Distance from origin to point1: " + distance);
    System.out.println();
  }

  /**
   * Demonstrates string-related features
   */
  private static void demonstrateStringFeatures() {
    System.out.println("3. String Features:");

    String name = "Java";
    int version = 21;

    // Text blocks (available since Java 15)
    String textBlock = """
        Welcome to %s %d LTS!
        This is a text block feature
        that preserves formatting.
        """.formatted(name, version);

    System.out.println("  Text block:");
    System.out.println(textBlock);
  }

  /**
   * Demonstrates modern Java features available in Java 21
   */
  private static void demonstrateSequencedCollections() {
    System.out.println("4. Modern Java Features in Java 21:");

    // Using List with modern features
    List<String> languages = List.of("Java", "Python", "JavaScript", "Go", "Rust");

    System.out.println("  Original list: " + languages);
    System.out.println("  First element: " + languages.get(0));
    System.out.println("  Last element: " + languages.get(languages.size() - 1));

    // Stream operations (available since Java 8)
    List<String> javaLanguages = languages.stream()
        .filter(lang -> lang.toLowerCase().contains("java"))
        .toList(); // toList() method added in Java 16
    System.out.println("  Languages containing 'java': " + javaLanguages);
    System.out.println();
  }
}