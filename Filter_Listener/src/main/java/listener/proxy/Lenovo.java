package listener.proxy;

public class Lenovo implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"元买一台联想电脑");
        return "lenovo";
    }

    @Override
    public void show() {
        System.out.println("这是一台联想电脑");
    }
}
