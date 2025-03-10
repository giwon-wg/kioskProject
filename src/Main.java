import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lv;
        while(true) {
            System.out.println("===========================");
            System.out.println("실행할 Lv을 입력하세요.");
            System.out.println("Lv1  = 1번");
            System.out.println("Lv2  = 2번");
            System.out.println("Lv3  = 3번");
            System.out.println("Lv4  = 4번");
            System.out.println("Lv5  = 5번");
            System.out.print("종료  = 0번\n: ");
            lv = sc.next();
            System.out.println("===========================\n");
            switch (lv) {
                case "1":
                    System.out.println("Lv.1을 실행합니다.\n");
                    new Lv1.Main().main();
                    break;
                case "2":
                    System.out.println("Lv.2을 실행합니다.\n");
                    new Lv2.Main().main();
                    break;
                case "3":
                    System.out.println("Lv.3을 실행합니다.\n");
                    new Lv3.Main().main();
                    break;
                case "4":
                    System.out.println("Lv.4을 실행합니다.\n");
                    new Lv4.Main().main();
                    break;
                case "5":
                    System.out.println("Lv.5을 실행합니다.\n");
                    new Lv5.Main().main();
                    break;
                case "0":
                    System.out.println("**프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("올바르지 않는 입력값입니다.\n");
            }
        }
    }
}