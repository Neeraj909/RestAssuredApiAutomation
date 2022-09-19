import java.util.LinkedHashMap;
import java.util.Map;

public class ProgramCashree {
    public static void main(String[] args) {
       System.out.println( firstNonRepeating(""));

    }
    public static String firstNonRepeating(String str){

        LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
            else {
                map.put(str.charAt(i),1);
            }
        }
        String nonRepChar="";
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                nonRepChar= String.valueOf(entry.getKey());
                break;
            }
        }
        return nonRepChar;
    }
}
