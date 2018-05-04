package j2se;

/**
 * <p>Title: jp1705</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2017</p>
 *
 * <p>Company: </p>
 *
 * @author Nguyen Trong Hue
 * @version 1.0
 */
public class Examples {
    public Examples() {
    }

    /**
     * Phuong thuc lay UCLN tu 2 so
     * <br/>
     * updated : 21/10/2017
     * @param a int
     * @param b int
     * @return int
     */
    public static int getUCLN(int a, int b){
        int ucln = -1;

        if(a*b!=0){
            while(a!=b){
                if(a>b){
                    a-=b;
                }
                else{
                    b-=a;
                }
            }
            ucln = a;
        }

        return ucln;
    }

    /**
     * Phuong thuc lay UCLN tu 3 so
     * @param a int
     * @param b int
     * @param c int
     * @return int
     */
    public static int getUCLN (int a, int b, int c){
        return Examples.getUCLN(Examples.getUCLN(a,b),c);
    }


    /**
     *
     * Phuong thuc nay sinh ra so ngau nhien tu 0 - n
     * <br/>
     * updated: 27/10/2017
     * @param n int
     * @return int
     */
    public static int getRandomValue(int n){
        return ((int)Math.random()*100);
    }

    /**
     * Lay gia tri lon nhat tu 3 gia tri truyen vao
     * <br/>
     * updated: 27/10/2017
     * @param n int
     * @param m float
     * @param ch char
     * @return int
     */
    public static int getMax(int n, float m, char ch){
        int max = n;
        if(max<(int)m){
            max = (int)m;
        }
        if(max<ch){
            max = ch;
        }
        return max;
    }

    /**
     * Phuong thuc kiem tra gia tri rang co phai so nguyen to hay khong
     * <br/>
     * updated: 27/10/2017
     * @param n int
     * @return boolean
     */
    public static boolean checkValue(int n){

        // Khai bao bien trung gian xac nhan nguyen to
        boolean flag = true;
        // Kiem tra
        if (n < 2) {
            flag = false;
        } else {
            for (int v = 2; v <= (int) (Math.sqrt(n)); v++) {
                if (n % v == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;

    }

    public static void main(String[] args) {

        // Sinh ngau nhien 1 gia tri
        int n = (int) (Math.random() * 100);
        int m = (int) (Math.random() * 100);

        // In ra
        System.out.print("Uoc chung lon nhat cua n = " + n + " va m =  " + m + " la : " + Examples.getUCLN(m,n) );


        // Ket qua
        if (Examples.checkValue(n)) {
            System.out.print("\nLa nguyen to");
        } else {
            System.out.print("\nKhong phai nguyen to");
        }

    }

}
