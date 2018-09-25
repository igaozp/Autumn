package metatom.autumnioc;

/**
 * HelloWorldService
 *
 * @author igaozp
 */
public class HelloWorldService {
    private String text;
    private OutputService outputService;

    public void helloWorld() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
