import javax.swing.*;
import java.awt.*;
public class draw extends JFrame {
    public draw() {
        setTitle("하트 버튼 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null); // 컨텐트팬의 배치관리자 제거
        setSize(500, 400);     
        int i, j, n=5;
        for(i=0;i<n;i++) {        
            for(j=0;j<n;j++) {
                JButton b=new JButton("\u2764");
                b.setSize(50,20);
                if( i==0 && (j>=n/5 && j<=n/2-n/5) || i==0 &&   (j>=n/2+n/5 && j<=(n-1)-n/5) )  {
                    b.setLocation(j*50,i*50);
                    contentPane.add(b);
                }               
                else if ( i>0 && i<=n/5 && (j==n/5-i||j==n/2+n/5-i ||j==n/2-n/5+i||j==(n-1)-n/5+i)){
                    b.setLocation(j*50,i*50);
                    contentPane.add(b);
                }                    
                else if(( i>n/5 && i<=n/2) && (j==0 || j==n-1) ){             
                    b.setLocation(j*50,i*50);
                    contentPane.add(b);
                }
                else if ( i>n/2 && (j==i-n/2 || j==(n-1)-(i-n/2) )){  
                    b.setLocation(j*50,i*50);
                    contentPane.add(b);
                }
                }
                }
        setVisible(true);
        }
    public static void main(String[] args) {
        new draw();       
        int i, j, n=5;

        for(i=0;i<n;i++) {
            for(j=0;j<n;j++) {
                if( i==0 && (j>=n/5 && j<=n/2-n/5) || i==0 &&   (j>=n/2+n/5 && j<=(n-1)-n/5) )     
                    System.out.print("* "); // i=0 j=1,3     
                else if ( i>0 && i<=n/5 && (j==n/5-i||j==n/2+n/5-i ||j==n/2-n/5+i||j==(n-1)-n/5+i))
                    System.out.print("* "); // i=1 j=0,2,4
                else if(( i>n/5 && i<=n/2) && (j==0 || j==n-1) )
                    System.out.print("* "); // i=2 j=0,4
                else if ( i>n/2 && (j==i-n/2 || j==(n-1)-(i-n/2) ))
                    System.out.print("* "); // i=3 j=1,3 i=4 j=2
                else
                    System.out.print(" ");
                }
                    System.out.print("\n");
                }
    }
}
