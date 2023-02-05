package com.ai.alg;

import java.util.Arrays;

/**
 * Perceptron Class.
 * <p>
 * This class implements a single layer Perceptron with the ability to predict
 * outputs given an input vector, update its weights and bias based on prediction
 * error, and return the weights and bias.
 * <p>
 * The Perceptron class uses a simple activation function that predicts outputs
 * of either 1 or -1 based on a linear combination of input and weights, with
 * an added bias.
 * <p>
 * If the prediction is not equal to the expected output, the weights and bias
 * are updated in the direction that would reduce the prediction error.
 * <p>
 * The learning rate determines the step size of the weight and bias updates.
 */
public class Perceptron {

    /**
     * The weights of the Perceptron.
     */
    private double[] weights;

    /**
     * The bias of the Perceptron.
     */
    private double bias;

    /**
     * The learning rate of the Perceptron.
     */
    private double learningRate;

    /**
     * The constructor of the Perceptron class.
     *
     * @param numWeights   the number of weights of the Perceptron.
     * @param learningRate the learning rate of the Perceptron.
     */
    public Perceptron(int numWeights, double learningRate) {
        this.weights = new double[numWeights];
        this.bias = 0;
        this.learningRate = learningRate;
        Arrays.fill(weights, 0);
    }

    /**
     * The predict method of the Perceptron class.
     * <p>
     * Given an input vector and expected output, the predict method returns
     * the prediction of the Perceptron, updates the weights and bias if the
     * prediction is not equal to the expected output, and returns the prediction.
     *
     * @param inputs   the input vector.
     * @param expected the expected output.
     * @return the prediction of the Perceptron.
     */
    public int predict(double[] inputs, int expected) {
        double result = 0;
        for (int i = 0; i < inputs.length; i++) {
            result += inputs[i] * weights[i];
        }
        result += bias;
        int prediction = result >= 0 ? 1 : -1;
        if (prediction != expected) {
            updateWeightsAndBias(inputs, expected, prediction);
        }
        return prediction;
    }

    /**
     * The updateWeightsAndBias method of the Perceptron class.
     * <p>
     * Given an input vector, expected output, and prediction, the
     * updateWeightsAndBias method updates the weights and bias of the Perceptron
     * in the direction that would reduce the prediction error.
     *
     * @param inputs     the input vector.
     * @param expected   the expected output.
     * @param prediction the prediction of the Perceptron.
     */
    private void updateWeightsAndBias(double[] inputs, int expected, int prediction) {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = weights[i] + learningRate * (expected - prediction) * inputs[i];
        }
        bias = bias + learningRate * (expected - prediction);
    }

    /**
     * Getter method to retrieve the bias of the perceptron.
     *
     * @return The current bias of the perceptron.
     */
    public double getBias() {
        return bias;
    }

    /**
     * Getter method to retrieve the learning rate of the perceptron.
     *
     * @return The current learning rate of the perceptron.
     */
    public double getLearningRate() {
        return learningRate;
    }

    /**
     * Getter method to retrieve the weights of the perceptron.
     *
     * @return The current weights of the perceptron.
     */
    public double[] getWeights() {
        return weights;
    }
}

