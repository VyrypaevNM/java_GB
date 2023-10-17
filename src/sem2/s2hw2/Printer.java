package sem2.s2hw2;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {
        int temp;
        for (int j = 0; j< mas.length-1; j++){
            for (int i = 0; i< mas.length-1-j; i++){
                if (mas[i] > mas [i+1]){
                    temp = mas[i];
                    mas[i]=mas[i+1];
                    mas[i+1] = temp;
                }
                String tempStr = Arrays.toString(mas);
                //tempStr = tempStr.replaceAll("[],]","");
                //System.out.println(SimpleDateFormat);
                Date date = new Date();
                //Date date = new SimpleDateFormat("y-M-d H:m:s.S").parse();
                //java.time.LocalDateTime currentDateTime = java.time.LocalDateTime.now();
                System.out.print(date);
                System.out.print(" ");
                System.out.println (tempStr);
                //File file

            }
        }
        //System.out.println(mas);

    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 4, 8, 3, 1};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("src/sem2/s2hw2/log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}