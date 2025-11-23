# Drawing Application - Core OOP

A foundational Java Swing-based drawing application demonstrating core Object-Oriented Programming principles. This project serves as the base implementation focusing on fundamental OOP concepts including inheritance, polymorphism, encapsulation, and abstraction.

## Related Projects

This project serves as the foundation for a more advanced implementation:
- [Java 2D Paint with Design Patterns](link) - Extended version with undo/redo, 
  persistence, command logging, and 6 design pattern implementations

## Project Overview

A desktop drawing application that allows users to create, modify, and manage geometric shapes. Built with Java Swing for the GUI and focusing on clean OOP design, this project provides essential drawing functionality with an intuitive interface.

**Key Achievement:** Implemented complete OOP hierarchy with abstract classes, inheritance, and polymorphic behavior for geometric shape management.

## Technologies Used

- **Java SE** - Core application development
- **Java Swing** - GUI framework
- **Java AWT** - 2D graphics rendering
- **Object-Oriented Programming** - Core design principles

## Core Features

### Drawing Capabilities
- **Shape Types:** Point, Line, Rectangle, Circle, Donut (circle with hole)
- **Color Selection:** Separate edge and fill color for shapes
- **Interactive Drawing:** Click-based shape placement
- **Visual Feedback:** Real-time preview during drawing

### Shape Management
- **Selection:** Click shapes to select/deselect
- **Modification:** Edit properties of selected shapes
- **Deletion:** Remove selected shapes from canvas
- **Drawing Order:** Shapes maintain Z-order (layering)

### User Interface
- **Toolbar:** Shape selection buttons
- **Color Pickers:** Edge and fill color indicators
- **Canvas:** Drawing area with mouse interaction
- **Status Bar:** Current operation feedback

## OOP Design Principles

### 1. Inheritance Hierarchy

```
Shape (abstract)
├── Point
├── Line
├── SurfaceShape (abstract)
│   ├── Rectangle
│   ├── Circle
│   └── Donut
```

**Abstract Base Class:**
```java
public abstract class Shape {
    protected Color edgeColor;
    protected boolean selected;
    
    public abstract void draw(Graphics g);
    public abstract boolean contains(Point p);
    public abstract void moveBy(int dx, int dy);
}
```

**Concrete Implementation:**
```java
public class Circle extends SurfaceShape {
    private Point center;
    private int radius;
    
    @Override
    public void draw(Graphics g) {
        g.setColor(fillColor);
        g.fillOval(center.getX() - radius, 
                   center.getY() - radius, 
                   2 * radius, 2 * radius);
        g.setColor(edgeColor);
        g.drawOval(center.getX() - radius, 
                   center.getY() - radius, 
                   2 * radius, 2 * radius);
    }
    
    @Override
    public boolean contains(Point p) {
        return center.distance(p) <= radius;
    }
}
```

### 2. Polymorphism

**Single Interface, Multiple Implementations:**
```java
// Drawing different shapes through same interface
List<Shape> shapes = new ArrayList<>();
shapes.add(new Point(100, 100, Color.RED));
shapes.add(new Circle(new Point(200, 200), 50, Color.BLUE, Color.YELLOW));
shapes.add(new Rectangle(new Point(300, 300), 80, 60, Color.GREEN, Color.WHITE));

// Polymorphic rendering
for (Shape shape : shapes) {
    shape.draw(g); // Each shape draws itself differently
}
```

### 3. Encapsulation

**Private Fields with Public Methods:**
```java
public class Rectangle extends SurfaceShape {
    private Point upperLeft;
    private int width;
    private int height;
    
    // Getters and setters control access
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        }
    }
}
```

### 4. Abstraction

**Abstract Methods Define Contract:**
```java
public abstract class SurfaceShape extends Shape {
    protected Color fillColor;
    
    public abstract double area();
    public abstract double circumference();
    
    // Concrete method for all surface shapes
    public Color getFillColor() {
        return fillColor;
    }
}
```

## Getting Started

### Prerequisites
- Java JDK 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans)

### Running the Application

**Using Command Line:**

**Using IDE:**
1. Import project
2. Run `Main.java`

## Key Learning Points

- **OOP Hierarchy:** Designed abstract base classes and concrete implementations
- **Inheritance:** Extended base classes to create specialized shapes
- **Polymorphism:** Used common interface for different shape types
- **Encapsulation:** Protected data with getters/setters
- **Abstraction:** Defined contracts through abstract methods
- **Java Swing:** Built interactive GUI with event handling
- **Graphics2D:** Rendered complex shapes with transparency
- **Collections:** Managed dynamic shape lists
- **Mouse Events:** Handled user input for drawing

## Differences from Advanced Version

This core version focuses on **fundamental OOP concepts**, while the advanced version (Design Patterns project) adds:

**Core Version (This Project):**
- Basic CRUD operations
- Simple shape management
- Direct implementation
- No persistence
- No undo/redo

**Advanced Version (Design Patterns):**
- Command pattern for undo/redo
- Adapter pattern for external libraries
- Strategy pattern for persistence
- Observer pattern for UI updates
- Prototype pattern for cloning
- Complete command logging
- Serialization support

## Code Quality

- **English Naming:** All classes, methods, variables in English
- **Clean Code:** Readable and maintainable
- **Comments:** JavaDoc style documentation
- **Consistent Style:** Follows Java conventions
- **No Code Smells:** No duplicate code or long methods
