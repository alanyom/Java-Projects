public class Main {

    public static void main(String[] args) {
       var textBox1 = new TextBox();
       var textBox2 = textBox1;
       textBox2.setText("Hello World");
        System.out.println(textBox1.text);
    }
}

//textBox2 is an unused object and so java will automatically remove that object
