
public class Main {

    public static void main(String[] args) {
        UIControl[] controls = { new TextBox(), new CheckBox() };
        for (var control : controls)
            control.render();
    }
}



public final class CheckBox extends UIControl {
    @Override
    public void render() {
        System.out.println("Render CheckBox");
    }
}



public class UIControl {
    private boolean isEnabled = true;

//    public UIControl(boolean isEnabled) {
//      this.isEnabled = isEnabled;
//    }

    public void render() {

    }

    public final void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}



public class TextBox extends UIControl {
    private String text = "";

//    public TextBox() {
//        super(true);
//    }

    @Override
    public void render() {
        System.out.println("Render TextBox");
    }

    @Override
    public String toString() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        text = "";
    }
}
```
