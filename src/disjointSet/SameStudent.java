package disjointSet;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Jason Tan on 2022-09-14 21:07
 */
public class SameStudent {

    public static class Student{
        public String a;
        public String b;
        public String c;

        public Student(String a, String b, String c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }

    public static int mergeStudents(List<Student> students){
        DisjointSet.UnionSet<Student> unionFind = new DisjointSet.UnionSet<>(students);
        HashMap<String, Student> map1 = new HashMap<>();
        HashMap<String, Student> map2 = new HashMap<>();
        HashMap<String, Student> map3 = new HashMap<>();

        for (Student st : students){
            if (!map1.containsKey(st.a)){
                map1.put(st.a, st);
            }else{
                unionFind.union(st, map1.get(st.a));
            }
            if (!map2.containsKey(st.b)){
                map2.put(st.b, st);
            }else{
                unionFind.union(st, map2.get(st.b));
            }
            if (!map3.containsKey(st.c)){
                map3.put(st.c, st);
            }else{
                unionFind.union(st, map3.get(st.c));
            }
        }
        return unionFind.sizeMap.size();
    }
}
