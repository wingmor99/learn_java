import charactor.HeroType;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public class HelloWorld {

    public void method1(final int i) {
        System.out.println(i);
    }

    public void getSeason(int month) {
        if (month < 0) {
            System.out.println("负数月份？");
        }
        else if (month > 13) {
            System.out.println("你的月份太大了");
        }

        int monthMode = month / 4;
        switch (monthMode) {
            case 0 -> System.out.println("Spring");
            case 1 -> System.out.println("Summer");
            case 2 -> System.out.println("Autumn");
            case 3 -> System.out.println("Winter");
            default -> System.out.println("None");
        }
    }

    public int askMoney() {
        int earnedToday = 1;
        int total = 0;
        for (int j = 0; j < 10; j++) {
            total = total + earnedToday;
            earnedToday = earnedToday * 2;
        }
        return total;
    }

    public void ignore3and5() {
        for (int i = 1; i < 101; i++){
            if ((i % 3 == 0 ) | (i % 5 == 0)) {
                continue;
            }
            System.out.println(i);
        }
    }

    public void becomeMile() {
//        int yearInvest = 12000;
//        double returnRate = 0.20;
//
//        double totalMoney = 0;
//        for (int yearNum = 1;yearNum<1000; yearNum++) {
//            totalMoney = totalMoney * (1 + returnRate) + yearInvest;
//            if (totalMoney > 1000000) {
//                System.out.println("Become milienare at year " + yearNum );
//                break;
//            }
//        }
        double totalMoney = 0;
        int year = 0;

        outwhile:
        while (totalMoney < 10000000) {
            year++;
            totalMoney = totalMoney * (1 + 0.20) + 12000;
            System.out.println("year " + year +" has " + totalMoney);
            if (totalMoney > 1000000) {
                break outwhile;
            }
        }
    }

    public void endoutside() {
//        boolean breakout = false; //是否终止外部循环的标记

        outloop: // 标记outloop
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                System.out.println(i + ":" + j);
                if (0 == j % 2) {
//                    breakout = true; //终止外部循环的标记设置为true
                    break outloop;
                }
            }
//            if (breakout) {
//                break;
//            }
        }

    }

    public void getPower(int baseNumber) {
        int a = 1;
        while(baseNumber > 1) {
            a = a * baseNumber;
            baseNumber = baseNumber - 1;
        }
        System.out.println(a);
    }

    public void findGold() {
        float iGold = 0;
        float jGold = 0;
        double best = 0;
        for (float i = 1; i < 21; i++) {
            for (float j = 1; j < 21; j++){
                if ((i % 2 == 0) && (j % 2 ==0 )) {
                    continue;
                }
                else {
                    double result = i / j;
                    if (Math.abs(result - 0.618) < Math.abs(best - 0.618)) {
                        best = result;
                        iGold = i;
                        jGold = j;
                    }
                }
            }
        }
        System.out.println(best);
        System.out.println("Best i is " + iGold + " best j is " + jGold);
    }

    public void findWater() {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int z = 0; z < 10; z++) {
                    int number = 100 * i + 10 * j + z;
                    if (number == i * i * i + j * j * j + z * z * z) {
                        System.out.println(number);
                    }
                }
            }
        }
    }

    public void setList(int @NotNull [] a, int b) {
        System.out.println(a[b]);
    }

    public  void getRandomList(int a) {
        int[] nums =new int[a];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100);
        }
        System.out.println("数组中元素为：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        int[] reverse = new int[a];

        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = nums[a-1-i];
        }
        System.out.println("\n逆向数组为");
        for (int i = 0; i < reverse.length; i++) {
            System.out.print(reverse[i] + " ");
        }
    }

    public int getMax(int @NotNull [] a){
        int maxNum = 0;
        for (int value:a
             ) {
            if (value > maxNum) {
                maxNum = value;
            }
        }
        return maxNum;
    }

    public void copyList() {
        int a[] = {1,2,3,4,5,6};
        int b[] = new int[3];
        System.arraycopy(a, 2, b, 0, 3);
        for (int value: b
             ) {
            System.out.println(value);
        }
    }

    public void getListSum() {
        int a[] = new int[5];
        int b[] = new int[5];
        int listsun[] = new int[10];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(5) + 5;
            b[i] = rand.nextInt(5) + 5;
        }

        System.arraycopy(a, 0, listsun, 0, 5);
        System.arraycopy(b, 0, listsun, 5, 5);

        for (int value :listsun
             ) {
            System.out.println(value);
        };

    }

    public static void printRow(int[] a) {
        System.out.print("\n");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public void getMaxInMatrix() {
        int[][] a = new int[5][5];
        for (int i = 0 ; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int) (Math.random() * 100);
            }
        }

        for (int i = 0; i < a.length; i++) {
            printRow(a[i]);
        }

        int maxi = 0;
        int maxj = 0;
        int maxNum = 0;
        for (int i = 0 ; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > maxNum) {
                    maxi = i;
                    maxj = j;
                    maxNum = a[i][j];
                }
            }
        }

        System.out.println("\n最大数是" + a[maxi][maxj] +
                "，坐标是" + "[" + maxi + "][" + maxj + "]");


    }









    public static void main(String[] args)  {
        System.out.println("This is Println");
        System.out.println("This is print");
        System.out.println("Command");
        HelloWorld hw = new HelloWorld();
//        hw.method1(100);
//        hw.method1(10000);
//
//        Scanner s = new Scanner(System.in);
//        int weight = s.nextInt();
//        System.out.println("your weight " + weight);
//        float height = s.nextFloat();
//        System.out.println("enter your height (m) " + height);
//        float bmi = weight / (height * height);
//        System.out.println(bmi);
//
//        // 长路与 && 两边都算
//        // 短路与 &  左边false就不算右边
//        // 长路或 ｜｜ 两边都算
//        System.out.println("输入月份");
//        int month = s.nextInt();
//        hw.getSeason(month);
//
//        System.out.println("enter the base number");
//        int baseNumber = s.nextInt();
//        hw.getPower(baseNumber);
        System.out.println(hw.askMoney());
        hw.ignore3and5();
        hw.becomeMile();
        hw.endoutside();
        hw.findGold();
        hw.findWater();

        int[] a = {1,2,3,4,5};

//        hw.setList(a, 1);
//        hw.setList(a, 2);
//
//        hw.getRandomList(8);
//        System.out.println("\n" + hw.getMax(a));
//
//        hw.copyList();
        hw.getListSum();
        hw.getMaxInMatrix();

        // 枚举
        Season season = Season.SPRING;

//        switch (season) {
//            case SPRING -> System.out.println("spring");
//            case SUMMER -> System.out.println("Summer");
//            case AUTUMN -> System.out.println("Autumn");
//            case WINTER -> System.out.println("Winter");
//        }

        for (Season s:Season.values()
             ) {
            System.out.println(s);
        }

        for (HeroType ht: HeroType.values()
             ) {
            System.out.println(ht);
        }
    }
}

