package day01;

@Anno(value = "sss",count = 1)
public class MyClass {
    @Anno(value = "field value", count = 10)
    private int myField;

    @Anno
    public void myMethod() {
        // method implementation
    }

}
