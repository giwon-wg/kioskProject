package Lv5;

import java.io.*;
import java.util.Properties;

public class UserData {
    private static final String UserName = "Userdata_";


    public static int[] loadUserData(String userId){
        Properties users = new Properties();
        String fileName = UserName + userId + ".properties";
        File file = new File(UserName);


        //파일이 없다면? -> 신규 이용자로 등록
        if(!file.exists()){
            saveUserData(userId, 0, 0);
            return new int[]{0, 1000};
        }

        try(FileInputStream fileinput = new FileInputStream(file)){
            users.load(fileinput);
            int cash = Integer.parseInt(users.getProperty("cash", "0"));
            int point = Integer.parseInt(users.getProperty("point", "0"));
            return new int[]{0, 0};
        } catch (IOException e){
            e.printStackTrace();
        }
        return new int[]{0, 0};
    }

    public static void saveUserData(String userID, int cash, int point){
        Properties user = new Properties();
        user.setProperty("cash", String.valueOf(cash));
        user.setProperty("point", String.valueOf(point));

        try(FileOutputStream fos = new FileOutputStream(UserName + userID + ".properties")){
            user.store(fos, "user data (cash, point");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
