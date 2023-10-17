package sem2.s2t5_logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class S2t5 {

    static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        String filePath = "src/sem2/s2t5_logger/test.txt";
        String s = "Test ";
        String logPath = "src/sem2/s2t5_logger/log.txt";
        int n=5;


        createLogger(logPath);
        String temp = repeat(s,n);
        writeToFile(filePath, temp);
        closeLogger();
        System.out.println(temp);
    }



    static String repeat(String s, int n){
        return s.repeat(n);
    }

    static void createLogger(String logPath){
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler handler = null;
        try {
            handler = new FileHandler(logPath, true);
            handler.setFormatter(formatter);
            logger.addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void closeLogger(){
        Handler[] handlers = logger.getHandlers();
        for (Handler handler:handlers){
            handler.close();
        }
    }

    static void writeToFile(String filePath, String s){
        //FileWriter writer = null;//создаем файл врайтер
        try (FileWriter writer = new FileWriter(filePath, true)){ //аргумент тру дает возможность дзаписи в файл
            //try (FileWriter writer = new FileWriter(filePath)){ // без "тру" файл перезаписывается
            writer.write(s); //копит в буфере
            writer.write("\n"); //перенос на новую строку
            writer.flush(); //выбрасывает в файл все что в буфере
            logger.info("record succesfull");
        } catch (Exception e){ //исключение
            e.printStackTrace();// выводит в консоль стек ошибки
            System.out.println("cant write");
            logger.warning("smth wrong");
        }

    }
}

