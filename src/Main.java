public class Main {
    public static void main(String[] args) {
        String draws;
        if (args.length == 0) {
            draws = "";
        } else {
            draws = args[0];
        }
        System.out.println("Observation sequence Q: " + draws);
        System.out.println("Length of Q: " + draws.length());

        double[][] probabilities = new double[][]{{.10, 1.0}, {.20, .75}, {.40, .50}, {.20, .25}, {.10, 0}};
        int numC = draws.length() - draws.replace("C", "").length();
        double denominator = 0;
        for (int i = 0; i < probabilities.length; i++) {
            denominator += probabilities[i][0]*Math.pow(probabilities[i][1], numC)*Math.pow(1-probabilities[i][1], draws.length() - numC);
        }
        double p_C = 0;
        for (int i = 0; i < probabilities.length; i++) {
            double p = (probabilities[i][0]*Math.pow(probabilities[i][1], numC)*Math.pow(1-probabilities[i][1], draws.length() - numC))/denominator;
            p_C += p*probabilities[i][1];
            System.out.println("P(h" + i + " | Q) = " + String.format("%.5f", p));
        }
        System.out.println("Probability that the next candy we pick will be C, given Q: " + p_C);
        System.out.println("Probability that the next candy we pick will be L, given Q: " + (1-p_C));
    }
}
