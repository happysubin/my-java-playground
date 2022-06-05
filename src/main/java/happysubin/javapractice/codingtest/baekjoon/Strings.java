package happysubin.javapractice.codingtest.baekjoon;

import java.io.*;
import java.util.*;



/* 11720
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num  = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int sum = 0;
        for(int i=0 ; i < num; i++){
            sum += Integer.parseInt(arr[i]);
        }
        System.out.println(sum);
    }
}


 */


/*
//8958
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num  = Integer.parseInt(br.readLine());

        for(int i=0 ; i < num; i++){
            int sum = 0;
            int point = 0;
            String str = br.readLine() + "X";
            String[] arr = str.split("");
            for(int j = 0; j < arr.length; j ++){
               if(arr[j].equals("O")){
                   point++;
                   sum += point;
               }
               else{
                   point = 0;
               }
            }
            System.out.println(sum);
        }

    }
}

 */

/*
//1152
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String[] arr = s.split(" ");
        if(arr[0].equals("")){
            System.out.println(0);
        }
        else{
            System.out.println(arr.length);
        }


    }
}


 */


/*
//10809
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] arr = new int[26];

        for (int i = 0; i< arr.length ; i++) {
            arr[i] = -1;
        }

        for(int i = 0; i< chars.length; i++){
           if(arr[chars[i]-'a'] == -1){
               arr[chars[i]-'a'] = i;
           }
           else{
               continue;
           }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }


    }
}

 */


/*

//2675
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            String[] str = br.readLine().split(" ");
            int count = Integer.parseInt(str[0]);
            char[] chars = str[1].toCharArray();

            for(int j = 0; j < chars.length; j++ ){
                for(int z = 0; z < count; z++){
                    System.out.print(chars[j]);
                }
            }
            System.out.println();

        }
    }
}


 */

//1157
/*
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().toLowerCase().split("");
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        Set<String> strings = map.keySet();
        int max = 0;
        String answer = null;


        //제일 큰거를 찾는다.
        for (String str : strings) {
            if(map.get(str) > max){
                max = map.get(str);
                answer = str;
            }
        }

        int count = 0; //여러 개 있는지 검사
        for (String str : strings) {
            if(max == map.get(str)) count++;
        }

        if(count > 1) System.out.println("?");
        else System.out.println(answer.toUpperCase());
    }
}


 */

/*
//1316
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int answer = num; //아닌것을 빼자

        for(int i = 0; i < num; i++){
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = (br.readLine() + "0").toCharArray();

            for(int j = 0; j < chars.length - 1 ; j++){
                if(chars[j] != chars[j+1]){
                    map.put(chars[j],map.getOrDefault(chars[j],0)+1);
                }
            }

            Set<Character> characters = map.keySet();

            for (Character character : characters) {
                if (map.get(character) > 1){
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
*/




/*
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = {"c-","c=","dz=","d-","lj","nj","s=","z="};

        for(int i = 0; i < arr.length ; i++){
            if(str.contains(arr[i])){
                str = str.replace(arr[i],"0");
            }
        }

        System.out.println(str.length());
    }
}

 */


/* 크로아티아
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = {"c-","c=","dz=","d-","lj","nj","s=","z="};

        for(int i = 0; i < arr.length ; i++){
            if(str.contains(arr[i])){
                str = str.replace(arr[i],"0");
            }
        }

        System.out.println(str.length());
    }
}

 */

//1764
/*
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int d = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);


        List<String> answers = new ArrayList<>();


        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < d + b ; i++ ){
            String str = br.readLine();
            map.put(str,map.getOrDefault(str,0)+1);
        }

        Set<String> keys = map.keySet();

        for (String key : keys) {
            if(map.get(key) > 1){
                answers.add(key);
            }
        }

        Collections.sort(answers);

        System.out.println(answers.size());

        for (String answer : answers) {
            System.out.println(answer);
        }


    }
}


 */

/*
//1543
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int answer = 0;
        for(int i = 0; i< str.length(); i++){
            if(str.contains(target)){
                str = str.replaceFirst(target,"0");
                answer++;
            }
        }

        System.out.println(answer);
    }
}

 */

/*
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        int answer = 0;
        for(int i = 0; i< str.length(); i++){
            if(str.contains(target)){
                str = str.replaceFirst(target,"0");
                answer++;
            }
        }

        System.out.println(answer);
    }
}

 */

/*
//1427
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Arrays.sort(chars);

        for (int i = chars.length -1 ; i >=0 ; i--) {
            System.out.print(chars[i]);
        }
    }
}

 */

/*

//10610
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split("");

        int sum = 0;
        for (String s : arr) {
            sum += Integer.parseInt(s);
        }

        if(!str.contains("0") | sum % 3 != 0){
            System.out.println(-1);
        }

        else{
            Arrays.sort(arr,Comparator.reverseOrder());
            for (String s : arr) {
                System.out.print(s);
            }
        }

    }
}
*/

/*

//11656
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = new String[str.length()];

        for(int i = 0; i < str.length(); i++){
            arr[i] = str.substring(i,str.length());
        }
        Arrays.sort(arr);

        for (String s : arr) {
            System.out.println(s);
        }

    }
}

*/

//14425
/*
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int num1 = Integer.parseInt(str[0]);
        int num2 = Integer.parseInt(str[1]);
        int answer = 0;

        List<String> list = new ArrayList<>();

        for(int i = 0; i < num1; i++){
            list.add(br.readLine());
        }

        for(int i = 0; i < num2; i++){
            if(list.contains(br.readLine())){
                answer++;
            }
        }


        System.out.println(answer);

    }
}


 */

/*
//11478
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>(); //중복 방지
        String str = br.readLine();

        for(int i = 0; i <= str.length(); i++){
            for(int j = i; j <= str.length(); j++){
                String substring = str.substring(i, j);
                if(!substring.equals("")){ //이 경우가 아니면 모두 추가
                    set.add(substring);
                }
            }
        }
        System.out.println(set.size());
    }
}

 */


//5635

/*
class Birthday implements  Comparable<Birthday>{
    String name;
    int year;
    int month;
    int day;

    public Birthday(String name, int day, int month, int year) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(Birthday o) {
        if(this.year < o.year ) return 1;
        else if(this.year > o.year) return -1;
        else if(this.month < o.month) return 1;
        else if(this.month > o.month) return -1;
        else if(this.day < o.day) return 1;
        else  return -1;
    }
}

public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Birthday> arr = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            String[] str = br.readLine().split(" ");
            Birthday birthday =
                    new Birthday(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]),Integer.parseInt(str[3]));
            arr.add(birthday);
        }

        Collections.sort(arr);

        System.out.println(arr.get(0).name);
        System.out.println(arr.get(arr.size()-1).name);

    }
}


 */

public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String answer = "{";

        for(int i = 0; i < num; i++){
            String key = br.readLine();;
            map.put(key , map.getOrDefault(key , 0 ) + 1 );
        }

        Object[] objects = map.keySet().toArray();
        Arrays.sort(objects);

        int max = -1;
        for (Object s : objects) {
            if(max <  map.get(s)){
                max = map.get(s);
                answer = s.toString();
            }
        }
        System.out.println(answer);
    }
}