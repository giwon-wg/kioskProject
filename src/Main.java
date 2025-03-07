import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lv;
        while(true) {
            System.out.println("===========================");
            System.out.print("실행할 Lv을 입력하세요(1 - 5)\n: ");
            lv = sc.next();
            System.out.println("===========================");
            System.out.println();
            switch (lv) {
                case "1":
                    System.out.println("Lv.1을 실행합니다.\n");
                    Lv1.Main.main(args);
                    sc.close();
                    return;
                case "2":
                    System.out.println("Lv.2을 실행합니다.\n");
                    Lv2.Main.main(args);
                    sc.close();
                    return;
                case "3":
                    System.out.println("Lv.3을 실행합니다.\n");
                    Lv3.Main.main(args);
                    sc.close();
                    return;
                case "4":
                    System.out.println("Lv.4을 실행합니다.\n");
                    Lv4.Main.main(args);
                    sc.close();
                    return;
                case "5":
                    System.out.println("Lv.5을 실행합니다.\n");
                    Lv5.Main.main(args);
                    sc.close();
                    return;
                default:
                    System.out.println("올바르지 않는 입력값입니다.\n");
            }
        }
    }
}