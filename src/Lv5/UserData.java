package Lv5;

import java.io.*;
import java.util.Properties;

public class UserData {
    private static final String Userdir = "Userdata/" + File.separator;;

    public static int[] loadUserData(String userId){
        Properties users = new Properties();
        String fileName = Userdir + userId + ".properties";
        File file = new File(fileName);


        File dir = new File(Userdir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        //파일이 없다면? -> 신규 이용자로 등록
        if(!file.exists()){
            System.out.println(userId + "님 신규 등록되었습니다. (가입 포인트: 1,000 지급)");
            saveUserData(userId, 0, 1000);
            return new int[]{0, 1000};
        }

        try(FileInputStream fileinput = new FileInputStream(file)){
            users.load(fileinput);
            int cash = Integer.parseInt(users.getProperty("cash", "0"));
            int point = Integer.parseInt(users.getProperty("point", "0"));
            return new int[]{cash, point};
        } catch (IOException e){
            e.printStackTrace();
            return new int[]{0, 0};
        }
    }

    public static void saveUserData(String userId, int cash, int point){
        Properties user = new Properties();
        String fileName = Userdir + userId + ".properties";

        File dir = new File(Userdir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        user.setProperty("cash", String.valueOf(cash));
        user.setProperty("point", String.valueOf(point));

        try(FileOutputStream fos = new FileOutputStream(fileName)){
            user.store(fos, "user data (cash, point)");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}