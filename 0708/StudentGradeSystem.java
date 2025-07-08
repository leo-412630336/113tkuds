public class StudentGradeSystem {

  
    public static char getGrade(int score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else {
            return 'D';
        }
    }


    public static void displayReport(int[] scores) {
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;
        int sum = 0;

        char[] grades = new char[scores.length];


        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            char grade = getGrade(score);
            grades[i] = grade;

            switch (grade) {
                case 'A': aCount++; break;
                case 'B': bCount++; break;
                case 'C': cCount++; break;
                case 'D': dCount++; break;
            }

            if (score > max) {
                max = score;
                maxIndex = i;
            }
            if (score < min) {
                min = score;
                minIndex = i;
            }

            sum += score;
        }

        double average = (double) sum / scores.length;


        int aboveAverageCount = 0;
        for (int score : scores) {
            if (score > average) {
                aboveAverageCount++;
            }
        }
        double aboveAverageRatio = (double) aboveAverageCount / scores.length * 100;


        System.out.println("=========== 學生成績報告 ===========");
        System.out.printf("全班總分: %d%n", sum);
        System.out.printf("全班平均分: %.2f%n", average);
        System.out.printf("最高分: %d (學生編號: %d)%n", max, maxIndex);
        System.out.printf("最低分: %d (學生編號: %d)%n", min, minIndex);
        System.out.printf("高於平均分的學生比例: %.2f%%%n", aboveAverageRatio);
        System.out.println("------------------------------------");
        System.out.println("各等級人數統計:");
        System.out.println("A 等級: " + aCount);
        System.out.println("B 等級: " + bCount);
        System.out.println("C 等級: " + cCount);
        System.out.println("D 等級: " + dCount);
        System.out.println("------------------------------------");
        System.out.println("詳細成績列表:");
        System.out.printf("%-10s%-10s%-10s%n", "學生編號", "分數", "等級");
        System.out.println("------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d%-10d%-10c%n", i, scores[i], grades[i]);
        }
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        displayReport(scores);
    }
}