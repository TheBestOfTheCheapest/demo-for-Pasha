package test1;

import java.util.Random;

public class MatrixSumm {
    private int[][] a = new int[5][5];

    public MatrixSumm(){
        for (int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = new Random().nextInt(9);
            }
        }
    }

    private int calculateMatrix(int[][] array){
        int summ=0;
          // REPLACE

        return summ;
    }

    public String test()
    {
        int summ = 0;
        String s ="fail";
        for (int i=0;i<5;i++){
            for (int j=0;i<5;i++){
                if((i==j) || (i==(5-j-1)))
                    summ += a[i][j];
            }
        }

        if(summ == calculateMatrix(a)){
            s="success";
        }
        return s;
    }
}




