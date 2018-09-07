package metatom.autumnioc;

/**
 * @author igaozp
 */
public class HelloWorldService {
    private String text;

    public void helloWorld() {
        System.out.println("Hello World!");
    }

    public void setText(String text) {
        this.text = text;
    }
}
