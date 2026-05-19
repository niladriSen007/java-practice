# AGENTS.md — Java Practice Project

## Project Overview
A Java 21 LTS learning/practice repository covering streams, concurrency, design patterns, SOLID principles, data structures, and low-level design (LLD) problems. No external runtime dependencies — pure Java with Maven as the build tool.

## Build & Run

```powershell
# Compile
mvn clean compile

# Run a specific class (package path mirrors directory path)
java -cp target\classes stream.Java21FeaturesDemo
java -cp target\classes lld.swiggy.Main
java -cp target\classes designPatterns.creational.singleton.DoubleCheckSingleton
```

> **Important:** The Maven `<sourceDirectory>` is `src` (not the standard `src/main/java`). All packages live directly under `src/`.

There are no tests (no JUnit dependency in `pom.xml`). Demos run via `main()` methods.

**Java environment:** Microsoft OpenJDK 21 (`C:\Program Files\Microsoft\jdk-21.0.8.9-hotspot`). Run `set-java21.ps1` as Administrator if JAVA_HOME needs resetting.

## Directory → Package Mapping

| Directory | Package prefix | Purpose |
|---|---|---|
| `src/stream/` | `stream` | Stream API & Java 21 feature demos |
| `src/threads/` | `threads` | Concurrency: Callable, Future, ExecutorService, locks |
| `src/collections/` | `collections` | ArrayList, HashMap, HashSet demos |
| `src/dsa/` | `dsa` | DSA: binary search, sliding window, heap, recursion, bit manipulation |
| `src/coreImplementation/` | `coreImplementation` | Hand-rolled HashMap, LinkedList, Stack, Tree |
| `src/designPatterns/` | `designPatterns` | GoF patterns (creational/behavioural/structural + command/observer/memento/template) |
| `src/designpattertnsupgrade/` | `designpattertnsupgrade` | Refactored/upgraded versions of the same GoF patterns |
| `src/lld/` | `lld` | LLD problems: ParkingLot, notificationSystem, swiggy, googleDocs |
| `src/solid/` | `solid` | SOLID principles; each letter has `bad/` and `good/` sub-packages |
| `src/dtos/` | `dtos` | Shared data classes (`Employee`, `Person`) reused across stream/collection examples |
| `src/companyWise/` | `companyWise` | Company-specific interview problems (barclays, jpMorgan) |
| `src/basics/` | `basics` | Foundational demos: lambda, method references, arrays, strings |

## Key Conventions

### bad/ vs good/ pattern (SOLID)
Every SOLID principle module contrasts a violation with a fix:
- `src/solid/s/bad/Invoice.java` — single class doing generate + email + save (violation)
- `src/solid/s/good/` — responsibilities split across separate classes

Always add both `bad/` and `good/` sub-packages when adding a new SOLID example.

### LLD problem structure
Each LLD problem under `src/lld/<problem>/` follows:
- `entity/` — domain model (e.g., `Vehicle`, `ParkingSpot`)
- `enums/` — domain enumerations (e.g., `VehicleSize`)
- `exception/` — custom exceptions
- `strategy/` — pluggable behaviours
- `factory/` — factory/creator classes
- `Main.java` — runnable demo entry point

The `NotificationService` uses lazy Singleton + Observer + Decorator + Factory in combination — see `lld/notificationSystem/` as the canonical multi-pattern LLD reference.

### Design pattern implementations
`designPatterns/` holds first-pass implementations; `designpattertnsupgrade/` holds cleaner rewrites of the same patterns. Prefer `designpattertnsupgrade/` as the reference when both exist.

### Shared DTOs
`dtos/Employee` and `dtos/Person` are the standard data classes for stream, collection, and sorting examples. Do not duplicate new ad-hoc POJOs in demo files — reuse or extend these.

### Concurrency examples
`src/threads/` covers basic threading; `src/lock/` covers `StampedLock` and write-lock patterns; `src/executor/` and `src/threadpool/` cover executor framework usage. Each file is self-contained with its own `main()`.

## Java 21 Feature Usage
Modern syntax in use throughout the codebase:
- Switch expressions (`stream/Java21FeaturesDemo.java`)
- Records (inline in demo classes)
- Text blocks (`"""..."""`)
- `Stream.toList()` (Java 16+) — prefer over `Collectors.toList()`
- `List.of(...)` for immutable lists

## Adding New Code
1. Place files under `src/<topicPackage>/` matching an existing top-level directory, or create a new one that mirrors the package name.
2. Declare `package <topicPackage>;` (e.g., `package dsa.slidingwindow;`) consistent with the directory path.
3. Provide a `main()` method for runnable demos — there is no test harness.
4. Compile with `mvn clean compile` and run with `java -cp target\classes <package.ClassName>`.

