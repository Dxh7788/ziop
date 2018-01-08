package com.dio;

import org.junit.Test;

import java.util.*;

/**
 * @author xh.d
 * @date 2018/1/8 14:42
 */
public class CollectionsTest {
    /**
     * Collections的32个操作
     * */
    @Test
    public void collectionsTest(){
        List<String> ls = new ArrayList<String>();
        List<String> lsBak = new ArrayList<String>();
        /*
        * 等同于ls.add("aaa"),ls.add("bbb"),ls.add("ccc")
        * */
        Collections.addAll(ls,"aaa","ddd","bbb","ccc");
        System.out.println(Collections.frequency(ls,"aaa"));
        System.out.println(ls);

        /*
        * Collections' 32 Common Collection Interfaces
        * */
        /* 1. size 2*/
        Collections.sort(ls, new Comparator<String>() {
            public int compare(String o1, String o2) {;
                return 0;
            }
        });
        /*2. size 2*/
        int index01 = Collections.binarySearch(ls,"bbb");
        int index02 = Collections.binarySearch(ls,"bbb",new Comparator<String>(){
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        /*3. size 6*/
        Collection<String> cs01 = Collections.checkedCollection(ls,String.class);
        Collection<String> cs02 = Collections.checkedSet(new HashSet<String>(),String.class);
        Collection<String> cs03 = Collections.checkedSortedSet(new TreeSet<String>(),String.class);
        Collection<String> cs04 = Collections.checkedList(ls,String.class);
        Map<String,String> cs05 = Collections.checkedMap(new HashMap<String,String>(),String.class,String.class);
        Map<String,String> cs06 = Collections.checkedSortedMap(new TreeMap<String,String>(),String.class,String.class);
        /*4. size 1+size 1*/
        Collections.copy(ls,lsBak);
        Collections.disjoint(ls,lsBak);
        /*5. size 1*/
//        Collections.enumeration()
        /*6. size 2*/
        Collections.fill(ls,"eee");
        Collections.frequency(ls,"aaa");
        /*7. size 4*/
        Collections.max(ls);
        List<String> lsRan = new ArrayList<String>(0);
        /*7. size 2*/
        Collections.shuffle(lsRan);
        /*8. size 2*/
        Collections.swap(ls,1,2);
        /*unmodified List,Set,Map,SortedSet,Collection,SortedMap.Synchronized List,Set,Map,SortedMap,SortedSet,Collection*/
        Collections.unmodifiableList(ls);
        Collections.synchronizedList(ls);
    }
    @Test
    public void valueOfTest(){
        Integer i0 = Integer.valueOf(7);
        Integer i1 = Integer.valueOf(7);
        Integer i2 = new Integer(7);
        System.out.println(i0==i1);
        System.out.println(i0==i2);

        String s0 = String.valueOf("aaa");
        String s1 = String.valueOf("aaa");
        String s2 = new String("aaa");
        String s3 = s1.intern();
        System.out.println(s0==s1);
        System.out.println(s0==s2);
        System.out.println(s0==s3);
    }
}
