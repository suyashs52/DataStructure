package string;

import java.util.*;
import java.util.stream.Collectors;

public class SentenceSimilarity {

    public static void main(String[] args) {
        String[] sentence1 = {"a", "very", "delicious", "meal"};
        String[] sentence2 = {"one", "really", "good", "dinner"};
        String[][] similarPairs
                = {{"great", "good"}, {"extraordinary", "good"}, {"well", "good"}, {"wonderful", "good"}, {"excellent", "good"}, {"fine", "good"}, {"nice", "good"}, {"any", "one"}, {"some", "one"}, {"unique", "one"}, {"the", "one"}, {"an", "one"}, {"single", "one"}, {"a", "one"}, {"truck", "car"}, {"wagon", "car"}, {"automobile", "car"}, {"auto", "car"}, {"vehicle", "car"}, {"entertain", "have"}
                , {"drink", "have"}, {"eat", "have"}, {"take", "have"}, {"fruits", "meal"}, {"brunch", "meal"}, {"breakfast", "meal"}, {"food", "meal"}, {"dinner", "meal"}, {"super", "meal"}, {"lunch", "meal"}, {"possess", "own"}, {"keep", "own"}, {"have", "own"}, {"extremely", "very"}, {"actually", "very"}, {"really", "very"}, {"super", "very"}};
        List<String[]> collect = Arrays.stream(similarPairs).collect(Collectors.toList());
        List<List<String>> mapped = new ArrayList<>();
        for (String[] s : collect) {
            mapped.add(List.of(s));
        }
        System.out.println(areSentencesSimilar(sentence1, sentence2, mapped));

    }

    public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        if (sentence1.length != sentence2.length) return false;

        Map<String, List<String>> hashmap = new HashMap<>();

        for (List<String> list : similarPairs) {
            if (hashmap.containsKey(list.get(0))) {
                List<String> l = hashmap.get(list.get(0));
                l.add(list.get(1));
            } else {
                List<String> l = new ArrayList();
                l.add(list.get(1));
                hashmap.put(list.get(0), l);
            }
            if (hashmap.containsKey(list.get(1))) {
                List<String> l = hashmap.get(list.get(1));
                l.add(list.get(0));
            } else {
                List<String> l = new ArrayList();
                l.add(list.get(0));
                hashmap.put(list.get(1), l);
            }

        }
        System.out.println(hashmap);
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i]) || sentence2[i].equals(hashmap.get(sentence1[i]))) {
                // return false;
            } else {
                List<String> list = hashmap.get(sentence1[i]);
                if(list==null) {
                    System.out.println(sentence1[i]+":::::"+sentence2[i]);
                }
                if (list.size() == 0) {
                    return false;
                }
                if (list.contains(sentence2[i]) == false) {
                    return false;
                }

            }
        }

        return true;


    }
}
