package designPatterns.creational.abstractFactory;

interface Button {
    void render();
}

interface Checkbox {
    void paint();
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting Windows Checkbox");
    }
}

class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering MacOS Button");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting MacOS Checkbox");
    }
}

class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

public class AbstractFactory {
    private Button button;
    private Checkbox checkbox;

    public AbstractFactory(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.paint();
    }

    static void main() {
        GUIFactory factory = new WindowsFactory();
        AbstractFactory app = new AbstractFactory(factory);
        app.renderUI();

        factory = new MacOSFactory();
        app = new AbstractFactory(factory);
        app.renderUI();
    }
}
