import java.util.HashMap;

//we have to construct the give string using wordbank by only using CONCATINATION
// (ie we cannot remove from the middle) (remember in DP we usally start from end ie we take a string and remove matching prefix from wordbank till we get a prefectly empty string)

public class CanConstructString {



    static boolean canConstruct(String str, String[] wordbank, HashMap<String, Boolean> memo){

        if(str=="") return true;

        if(memo.containsKey(str)){
            return memo.get(str);
        }

        for (String word : wordbank) {
            if (str.startsWith(word)) {
                if(canConstruct(str.substring(word.length()), wordbank, memo)){
                    return true;
                }
            }
        }


        memo.put(str, false);
        return false;



    }   


    public static void main(String[] args) {

        System.out.println(canConstruct("abcdef", new String[]{"ab","abc","cd","def","abcd"}, new HashMap<String, Boolean>()));
        System.out.println(canConstruct("skateboard", new String[]{"bo","rd","ate","t","ska","sk","boar"}, new HashMap<String, Boolean>()));
        System.out.println(canConstruct("gandu", new String[]{"ga","n","nud","du","eeeeeeee","eeeeeeeeeeee","eeeee"}, new HashMap<String, Boolean>()));
        System.out.println(canConstruct("gandu", new String[]{"ga","n","nud","d","eeeeeeee","eeeeeeeeeeee","eeeee"}, new HashMap<String, Boolean>()));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee","eee","eeee","eeeeeeee","eeeeeeeeeeee","eeeee"}, new HashMap<String, Boolean>()));


    }

}
