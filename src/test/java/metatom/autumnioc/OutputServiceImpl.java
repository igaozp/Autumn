package metatom.autumnioc;

/**
 * OutputServiceImpl
 *
 * @author igaozp
 */
public class OutputServiceImpl implements OutputService {
    private HelloWorldService helloWorldService;

    @Override
    public void output(String text) {
        System.out.println(text);
    }

    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
