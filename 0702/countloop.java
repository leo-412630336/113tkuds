
public class countloop {
  public static void main(String[] args) {
    int n=5;
    int sum=0;
    int count=0;
    for (int i = 1; i <=n; i++) {
        System.out.println("第"+i+"迴圈，sum＝"+sum+"+"+i);
        sum+=1;
        count++;
        
    }
    System.out.println("和"+sum);
    System.out.println("次"+count);
  }  
}
