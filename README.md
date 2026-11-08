# SE350 – Behavioral Design Patterns

Java examples of behavioral design patterns from DePaul SE350 (Object-Oriented Software Development). Most patterns are shown as a "Bad" version without the pattern next to a "Good" version that uses it.

## Patterns

All code is in `Behavioral/src/main/java/org/example/`:

- **ChainOfResponsibility**: request handling with a chain, a builder, and a template-method variant
- **Command**: light switch (with undo and an undo manager) and a UI example
- **Memento**: saving and restoring object state
- **Observer**: push and pull notification models
- **State**: behavior that changes with internal state
- **Strategy**: interchangeable compression algorithms
- **Template**: template method compared with inheritance-based and strategy-based attempts

## Running

Requires Java 21 and Maven.

```bash
cd Behavioral
mvn compile
```

Each example is in its own package and has a `Client.java` entry point. Run it from your IDE.
