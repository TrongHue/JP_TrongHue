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
public class MyStrings {

    public MyStrings() {
    }

    public static int countChar(String str, char ch, boolean isIgnorCase){
        int count = 0;
        //neu co bo qua kieu chu hoa thuong
        if(isIgnorCase){
            str = str.toLowerCase();
            ch = Character.toLowerCase(ch);
        }
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==ch){
                count ++;
            }
        }
        return count;
    }

    public static String formatString(String str){
        // danh sach cac ki tu dac biet
        char[] chs = {'`','~','!','@','#','$','%','^'
                     ,'&','*','(',')','_','-','+','='
                     ,'{','}','[',']','\\','|',':',';','\''
                     ,'"','<','>',',','.','?','/','*'
        };
        // loai bo ki tu khoi chuoi
        for(char ch:chs){
            str = str.replace(ch,' ');
            // loai bo khoang trong dau va chuoi
            str = str.trim();
        }
        // loai bo dau cach trong chuoi
        while(str.indexOf("  ")==1){
            str = str.replace("  "," ");
        }
      return str;
    }

    public static int countWords(String str){
        //chuan hoa chuoi
        str = MyStrings.formatString(str);
        return MyStrings.countChar(str,' ',false)+1;
    }

    public static String getWords(String str, byte nwords){
        // chuan hoa chuoi
        str = MyStrings.formatString(str);
        // xac dinh vi tri de cat
        int i;
        int count = 0; // dem dau cach
        for(i=0; i<str.length(); i++){
            if(str.charAt(i)==' '){
                count+=1;
            }
            if(count >= nwords){
                break;
            }
        }
        // tra ve gia tri chuoi
        if (i<str.length()-1){
            return str.substring(0,i) + "...";
        }
        else{
            return str;
        }
    }

    public static java.util.ArrayList FrequencyChars(String str, boolean isIgnoreCase){
        if(isIgnoreCase){
            str = str.toLowerCase();
        }
        // danh sach cac ki tu khac nhau
        String chs = "";
        String tmp = str.trim();
        char ch;
        for(int i =0; i<tmp.length(); i++){
            ch= tmp.charAt(i);
            if(ch!=' '){
                chs+=ch;
                tmp = tmp.replace(ch,' ');
            }
        }
        java.util.ArrayList fres = new java.util.ArrayList();
        int count;
        for(int i=0; i<chs.length();i++){
            ch = chs.charAt(i);
            count = MyStrings.countChar(str,ch,isIgnoreCase);
            fres.add("[" + ch +"," + count + "]");
        }
        return fres;
    }

    public static void main(String[] args) {
        String str = "Day la mot chuoi vi du";
        System.out.println(MyStrings.getWords(str,(byte)4));

    }
}

/*
b1: Viet ten rieng theo chuan
b2: So sanh muc do khop nhau cua 2 chuoi ki tu
*/
