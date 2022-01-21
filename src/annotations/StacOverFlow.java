package annotations;

/**
 * @author - LeeN
 * PROJECT NAME: Final Project IZ0-819
 * CREATED ON: Wednesday 20 October 2021 - 10:44 PM
 */
public class StacOverFlow {

    static int kratos, zeus, hades;

    public static void main(String[] args)  {
        try {
            invokeAGod(kratos=1, lightningOfZeus(zeus =2 ), hades=3);
        } catch (StackOverflowError e) {
            System.out.println(kratos + " " + zeus + " " + hades);
        }
    }

    static int lightningOfZeus(int i) throws StackOverflowError{
        throw new StackOverflowError("Woww");
    }

    static int invokeAGod(int a, int b, int c){
        return a + b + c;
    }
}
