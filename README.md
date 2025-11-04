# Java Practice Project - Upgraded to Java 21 LTS

This project has been successfully upgraded from Java 17 to Java 21 LTS (Long Term Support).

## Upgrade Summary

### What was upgraded:
- **Java Runtime**: From Java 17 to Java 21 LTS
- **Build Configuration**: Maven POM configured for Java 21
- **Development Environment**: VS Code settings updated for Java 21

### Versions:
- **Previous**: Java 17.0.13
- **Current**: Java 21.0.8 (Microsoft Build of OpenJDK)
- **Maven**: 3.9.9 (unchanged)

## Installation Details

### Java 21 Installation:
- **Location**: `C:\Program Files\Microsoft\jdk-21.0.8.9-hotspot`
- **Installed via**: Windows Package Manager (winget)
- **Command used**: `winget install Microsoft.OpenJDK.21`

### Environment Variables:
- **JAVA_HOME**: `C:\Program Files\Microsoft\jdk-21.0.8.9-hotspot`
- **PATH**: Updated to include Java 21 bin directory

## Project Configuration

### Maven Configuration (pom.xml):
```xml
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <maven.compiler.release>21</maven.compiler.release>
</properties>
```

### VS Code Configuration (.vscode/settings.json):
- Java Language Server configured to use Java 21
- Runtime configuration set with Java 21 as default
- Java 17 kept as alternative runtime

## Verification

### Build Status:
✅ **Build**: `mvn clean compile` - SUCCESS  
✅ **Runtime**: Java 21 features working correctly

### Test Run:
The `stream.Java21FeaturesDemo.java` demonstrates:
- Switch expressions (Java 14+ feature)
- Records (Java 14+ feature) 
- Text blocks (Java 15+ feature)
- Modern Stream operations with `toList()` (Java 16+)

## Usage

### Building the project:
```bash
mvn clean compile
```

### Running a specific class:
```bash
java -cp target\classes <ClassName>
```

### Example - Running the Java 21 features demo:
```bash
java -cp target\classes stream.Java21FeaturesDemo
```

## Benefits of Java 21 LTS

Java 21 is a Long Term Support (LTS) release that provides:

1. **Performance Improvements**: Better garbage collection and runtime optimizations
2. **New Language Features**: Pattern matching, sealed classes, records, and more
3. **Long-term Support**: 8+ years of support from Oracle and other vendors
4. **Enhanced Security**: Latest security updates and improvements
5. **Modern API Enhancements**: Improved Collections, String operations, and more

## Project Structure

```
java-practice/
├── src/
│   ├── stream.Main.java                    # Original main class
│   ├── stream.Calc.java                    # Calculator interface
│   ├── stream.Java21FeaturesDemo.java     # Java 21 features demonstration
│   ├── stream.StreamBasic.java             # Stream operations examples
│   ├── stream.StreamDemo.java              # Stream demonstrations
│   ├── stream.StreamEasy.java              # Easy stream examples
│   └── array/
│       └── array.RotateArray.java      # Array-related problems
├── pom.xml                          # Maven configuration (Java 21)
├── .vscode/
│   └── settings.json                # VS Code Java 21 configuration
└── set-java21.ps1                   # PowerShell script to set Java 21 permanently
```

## Next Steps

1. **Permanent Environment Setup**: Run `set-java21.ps1` as Administrator to set system-wide environment variables
2. **IDE Restart**: Restart VS Code to pick up the new Java 21 settings
3. **Explore Java 21 Features**: Experiment with new language features and APIs
4. **Update Dependencies**: Consider updating any Java dependencies to versions that support Java 21

## Compatibility Notes

- All existing Java code remains compatible (backward compatibility maintained)
- Maven configuration updated to use Java 21 source and target
- VS Code Java extension configured for Java 21 development
- Both Java 17 and Java 21 are available on the system for compatibility

---

**Upgrade completed successfully on**: October 22, 2025  
**Java Version**: 21.0.8 LTS (Microsoft Build of OpenJDK)