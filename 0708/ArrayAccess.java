public class ArrayAccess {
public static void main(String[] args) {
    int[]score={85,92,77,60,88};
    int first=score[0];//取第一位
    int second=score[3];
    int third=score[2];
    System.out.println(first);
    System.out.println(second);
    System.out.println(third);
    
    score[0]=90;//改第一個成績
    score[score.length-1]=95;//改最後一個

    int Arraylenth=score.length;//陣列長度
    System.out.println("改後");
    for (int i = 0; i < Arraylenth; i++) {
        System.out.printf("索引 %d:%d",i,score[i]);
        
    }


}    
}
