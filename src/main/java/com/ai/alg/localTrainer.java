package com.ai.alg;

public class localTrainer {

    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron(2, 0.1);
        double[] apple = {1, 0};
        double[] banana = {0, 1};
        int prediction = 0;
        String firmeza = "";
        for (int i = 0; i < 100; i++) {
            prediction = perceptron.predict(apple, 1);
            firmeza = prediction == 1 ? "dura" : "macia";
            System.out.println("Iteração: " + i + ". A maçã é classificada como: " + firmeza + ". Vies: " + perceptron.getBias());
            prediction = perceptron.predict(banana, -1);
            firmeza = prediction == 1 ? "dura" : "macia";
            System.out.println("Iteração: " + i + ". A banana é classificada como: " + firmeza + ". Vies: " + perceptron.getBias());
        }
    }
}
