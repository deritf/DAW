public class Main {

    public static void main(String[] args) {
        Lista l1 = new Lista();
        for (int i = 0; i < 3; i++) {
            l1.insertarFinal(i);
        }
        System.out.println("l1: " + l1);
        Lista cosa2 = new Lista();
        for (int i = 0; i < 3; i++) {
            cosa2.insertarFinal(i);
        }
        System.out.println("l2: " + cosa2);
        System.out.println(cosa2.equals(l1));

    }

}