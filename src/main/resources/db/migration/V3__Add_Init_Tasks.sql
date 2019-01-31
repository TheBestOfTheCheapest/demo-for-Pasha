insert into task ( section_id, created_date, task_title, task_text,  source_sample, source_template)
values (1,
timestamp '2018-07-10 18:00:00',
        'MatrixSumm',
        'Есть матрица 5х5 случайных натуральных чисел в интервале [0; 9]. Напишите код, подсчитывающий сумму диагоналей этой матрицы. Matrix',
        'private int calculateMatrix(int[][] array) {
    int summ = 0;
    // enter your code here
    return summ;
}',
'import java.io.IOException;
import java.util.Random;
import ru.digitalleague.demo.service.core.TaskLogger;

public class MatrixSumm {
    private int[][] a = new int[5][5];
    private String matrix = "";
    public MatrixSumm() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = new Random().nextInt(9);
                matrix+=a[i][j]+" ";
            }
            matrix+="\n";
        }
    }

    public static void main(String[] args) throws IOException {
        MatrixSumm matrixSumm = new MatrixSumm();
        matrixSumm.test();
    }

//REPLACE

   public String test() throws IOException {
        int summTest = 0;
        int summMethod = 0;
        String s = "fail";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i == j) || (i == (5 - j - 1)))
                    summTest += a[i][j];
            }
        }

        summMethod = calculateMatrix(a);

        if (summTest == summMethod) {
            s = "success";
        } else {
            s += ", your answer - " + summMethod + " , but expected - " + summTest + "\n" + matrix;
        }

        TaskLogger.writeLog("Test 1 - " + s);
        return s;
    }
}'),
(1,
timestamp '2018-07-10 18:00:00',
        'ArraySort',
        'Вам данн массив в 1000 символов, заполненный случайными цифрами. Ваша задача отсортировать его по возрастанию. Напишите реализацию метода, не изменяя сигнатуру метода и уже заданных в шаблоне переменных.x',
        'public int[] sort() {   int[] ar = new int[a.length];   //write your code here    return ar; }',
        'import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import ru.digitalleague.demo.service.core.TaskLogger;
public class ArraySort {
    private int[] a = new int[1000];

    public ArraySort() {
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(1000);
        }
    }

    public static void main(String[] args)  throws IOException{
        ArraySort arraySort = new ArraySort();
        arraySort.test();
    }
//REPLACE
    public void test() throws IOException {
        String s = "fail";
        int[] ar = new int[a.length];
        int[] arResult;
        for (int i = 0; i < a.length; i++)
            ar[i] = a[i];
        Arrays.sort(ar);
        arResult = sort();
        boolean status = true;
        for (int i = 0; i < a.length; i++) {
            if(ar[i]!=arResult[i])
                status=false;
        }
            if (status) {
                s = "success";
            } else {
                s += " , your answer - \n";
                for (int i = 0; i < a.length; i++)
                    s += arResult[i];
                s += "\n but expected - \n";
                for (int i = 0; i < a.length; i++)
                    s += ar[i];
            }

        TaskLogger.writeLog("Test 1 - " + s);
    }
}
'),
(1,
timestamp '2018-07-10 18:00:00',
'TextRefactor',
'Вам дан текст, в которой в случайном порядке вставлен символ ''s'', вам необходимо восстановить исходный текст и определить номер последней буквы "Ф". Напишите реализацию метода, не изменяя сигнатуру метода и уже заданных в шаблоне переменных.',
'public int result(String text) {  //write your code here    return text; }',
'import ru.digitalleague.demo.service.core.TaskLogger;

import java.io.IOException;

public class TextRefactor {
    private static String text = "— Чssssтssssо?! \"Бssезвssssреsssдsssнssа\"? Этоsss вssсе, чsssтsоss сsssкssssазаsssно о Зеsssмлssssе?! Оssднsо слsssовsssо!\n" +
            "Фsssоssрsssд поsжssаsл пssлsssечsssssаssмssssиss:\n" +
            "— Вss ssГssssалsакsтикsе sсsтsо мsилsлssиssаsрssдsов sзвsезsд, а еsмssкоsсть микропроцsssssssессоров кнsssижsssкssи оsssгрsssаsниsssченssа. К томsу же о Зsssемле в оsssбщеsssм-ssтssо ниsssкто sssи нsssе слsssышsssал.\n" +
            "— Нssssо тепsеsрsь, надsеюсь, sssтssыsss ssssssоssss ssнsеsssйs рssасssсsкsssаssssжsешь?\n" +
            "— ssssЯ нsssаsпsssиsssсаsssл и sпереsssдал иsssзsssдssателюs sнsоssвsуsю sсsтsаsтsью. ssЕsssеs, кsssонssечно,s ssподsssреsssдактsируют, sнssоs сssуssтsьss ssсохранssится.\n" +
            "ssss— ssЧsssтsssоss жssssе тsssаssм бsуssдssssssеssтss сsкsssаssзано?\n" +
            "— \"ssВss оssssснsоsвномs sssбsssезsврsеsssдsssнsаss\", — пsрsоssизsнеsssсs sФоsрsд и смsssущsssеsнно sкsаsшлssяsнsssул.";

//    private final static String resultText = "— Что?! \"Безвредна\"? Это все, что сказано о Земле?! Одно слово!\n" +
//            "Форд пожал плечами:\n" +
//            "— В Галактике сто миллиардов звезд, а емкость микропроцессоров книжки ограничена. К тому же о Земле в общем-то никто и не слышал.\n" +
//            "— Но теперь, надеюсь, ты о ней расскажешь?\n" +
//            "— Я написал и передал издателю новую статью. Ее, конечно, подредактируют, но суть сохранится.\n" +
//            "— Что же там будет сказано?\n" +
//            "— \"В основном безвредна\", — произнес Форд и смущенно кашлянул.";


    public static void main(String[] args) throws IOException {
             TextRefactor textRefactor = new TextRefactor();
             textRefactor.test(textRefactor.result(text));
    }

//REPLACE

//    public int result(String text) {
//        return text.replaceAll("s", "").lastIndexOf("Ф");
//    }

    public void test(int index) throws IOException {
      String log = "fail";
      int answer =result(text);
      if (416==answer){
          log = "success";
      }
      else {
          log += ", your answer - " + answer+ " , but expected another answer, may be your text refactor code is not correct";
      }
      TaskLogger.writeLog(log);
    }

}');