import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        InputOutput io = new InputOutput();
        io.inputData();
        Integrator integrator = new Integrator();
        integrator.integrate(io.getData());

    }

}
