import java.util.Scanner;

public class TypingCUI_Earnestly {
    public static void main(String[] args) {
        System.out.println("練習したい文字を入力してください");
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        int cnt = 0; // 回数
        int num = 0; // 連続正解(コンボ数。10コンボ毎)
        int Max = 0;
        long start = System.currentTimeMillis();
        while (true) {
            cnt++;
            System.out.println(cnt + "回目 : " + ans + " と入力してください");
            String inp = scanner.nextLine();
            if (ans.equals(inp)) {
                num++;
                System.out.println("〇");
                if (num % 10 == 0) {
                    System.out.println(num + "コンボ～♪");
                    if (num >= Max) {
                        Max += 10;
                    }
                }
            } else if (inp.equals("-break") || inp.equals("-b")) {
                long end = System.currentTimeMillis();
                long Time_taken_sec = (end - start) / 1000; // 経過時間(s)
                int Time_taken_min_cnt = 0;
                int Time_taken_hour_cnt = 0;
                while (true) {
                    if (3600 <= Time_taken_sec) {
                        Time_taken_hour_cnt++;
                        Time_taken_sec -= 3600;
                    } else if (60 <= Time_taken_sec) {
                        Time_taken_min_cnt++;
                        Time_taken_sec -= 60;
                    } else {
                        System.out.println("タイピング時間は " + Time_taken_hour_cnt + "時間 " + Time_taken_min_cnt + "分 "
                                + Time_taken_sec + "秒！\n最大コンボ数は " + Max + "コンボ！");
                        System.out.println("終了します。お疲れさまでした！！");
                        scanner.close();
                        System.exit(0); // breakではなく、Systemクラスのexitメソッドを使用
                    }
                }
            } else {
                num = 0;
                System.out.println("✕\n" + inp);
            }
        }
    }
}
