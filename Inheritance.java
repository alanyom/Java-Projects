
public class Main {

    public static void main(String[] args) {
        var control = new UIControl(true);
        var textBox = new TextBox();
        show(textBox);
    }

    public static void show(UIControl control) {
        if (control instanceof TextBox) {            //prints if control is a textbox
            var textBox = (TextBox) control;
            textBox.setText("Hello");
        }
        System.out.println(control);
    }
}



public class UIControl {
    private boolean isEnabled = true;

    public UIControl(boolean isEnabled) {
      this.isEnabled = isEnabled;
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

    public TextBox() {
        super(true);
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
