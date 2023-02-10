package dp.hash;

import java.util.HashSet;

public class NameCompany {
//https://leetcode.com/problems/naming-a-company/description/
    public static void main(String[] args) {

        System.out.println(distinctNames(new String[]{"phhrrjjcm","zjfkpps","pm","fnpduelfe","mxtvjnq"}));
    }

    public static long distinctNames(String[] ideas) {

        //offee and offee is same so c and t if interchange ll be same
        //if prefix is same again tasime, talsome replacing wont make sense we need to find pair
        //so suffix must be unique , prefix also be

        //if string is unique its hashkey also unique
        HashSet<Integer> [] count=new HashSet[26];
        for (int i = 0; i < 26; i++) {
            count[i]=new HashSet<>();
        }
        for(String id:ideas){
            int index=id.charAt(0)-'a';
            count[index].add(id.substring(1).hashCode()); //string len is max 10
        }
        long answer=0;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){ //2 group
                HashSet<Integer> one=count[i];
                HashSet<Integer> two=count[j];
                int c1=0;
                int c2=0;

                //no of common element
                long common=0;
                for(Integer o:one){
                    if(two.contains(o)){
                        common++;
                    }
                }
                answer+= (count[i].size()-common)*(count[j].size()-common);

            }
        }

        return answer*2;


    }
}
