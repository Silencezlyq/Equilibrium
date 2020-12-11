import java.util.Scanner;

public class equilibrium {
    private static void getPayoff(payoff[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input 8 elements of the payoff matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = new payoff();
                int num1 = scanner.nextInt();
                matrix[i][j].setPayoffForOne(num1);
                int num2 = scanner.nextInt();
                matrix[i][j].setPayoffForTwo(num2);
            }
        }
    }

    public static void main(String[] args) {
        payoff[][] matrix = new payoff[2][2];
        getPayoff(matrix);
        //findNashEquilibrium(matrix);
        findCorrelatedEquilibrium(matrix);
        System.out.println("END");
    }

    private static void findCorrelatedEquilibrium(payoff[][] matrix) {
        int max = -1000000;
        int num=0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (matrix[i][j].getSum() > max) {
                    max = matrix[i][j].getSum();
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (matrix[i][j].getSum() == max) {
                    num++;
                    System.out.print("a"+num+":");
                    matrix[i][j].print();
                }
            }
        }

        for(int i=0;i<num;i++){
            System.out.print("a"+i);
            if(i+1<num) System.out.print("+");
        }
        System.out.println("=1");
    }

    private static void findNashEquilibrium(payoff[][] matrix) {
        int[][] T = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                T[i][j] = 1;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (matrix[0][i].getPayoffForOne() > matrix[1][i].getPayoffForOne()) {
                T[1][i] = 0;
            } else if (matrix[0][i].getPayoffForOne() < matrix[1][i].getPayoffForOne()) {
                T[0][i] = 0;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (matrix[i][0].getPayoffForTwo() > matrix[i][1].getPayoffForTwo()) {
                T[i][1] = 0;
            } else if (matrix[i][0].getPayoffForTwo() < matrix[i][1].getPayoffForTwo()) {
                T[i][0] = 0;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (T[i][j] == 1) {
                    matrix[i][j].print();
                }
            }
        }
    }
}
