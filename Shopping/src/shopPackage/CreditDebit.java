package shopPackage;

import Prog1Tools.IOTools;

public class CreditDebit implements Zahlung {

    double d;
    public CreditDebit() {
        System.out.println ("Card payment ist gewählt ");

    }
    CustomerAction customerAction = new CustomerAction ();
    static double r;

    @Override
    public double getBalance() {
        return r;

    }

    @Override
    public double abrechnen() {
        d = IOTools.readDouble ( "Bitte geben Sie einen Betrag : " );
        return d;
    }
    public double getD() {
        return d;
    }
}
