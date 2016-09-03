/*
Description: prints out look and say sequence introduced by John Conway
Compile: javac LookSaySequence.c
Run: java LookSaySequence
*/

public final class LookSaySequence {
    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        String n = "1";
        System.out.println(n);
        nextNumber(n, 0);
    }

    public static void nextNumber(String n, int num) {
        String newString = "";
        String first = "";
        if (n.length() == 1) {
            String nextString = "11";
            System.out.println(nextString);
            nextNumber(nextString, 1);
        } else {
            first = n.substring(0, 1);
            int counter = 0;
            for (int i = 0; i < n.length(); i++) {
                String next = n.substring(i, i + 1);
                if (first.equals(next)) {
                    counter++;
                } else {
                    String sayDigit = Integer.toString(counter).concat(first);
                    newString = newString.concat(sayDigit);
                    first = n.substring(i, i + 1);
                    counter = 1;
                }

            }
            String sayDigit = Integer.toString(counter).concat(first);
            newString = newString.concat(sayDigit);
            System.out.println(newString);
            if (num < 30) { //number of elements
                nextNumber(newString, num + 1);
            }
        }

    }
}
