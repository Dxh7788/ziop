package com.dio;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author xh.d
 * @date 2018/1/5 18:04
 *
 * AudioInputStream  audio inputStream,temporarily ignore because of the audio is a specified file.
 * ByteArrayInputStream
 * FileInputStream
 * FilterInputStream
 * InputStream
 * ObjectInputStream
 * PipedInputStream
 * SequenceInputStream
 * StringBufferInputStream

 */
public class ParentIOTest {
    private InputStream is = null;

    /**
     * ByteArrayInputStream use a buffer to store the read bytes from the io.Its a memory I/O.
     * */
    @Test
    public void byteArrayInputStreamTest() throws IOException {
        byte [] buffer = new byte[]{
                0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D,
                0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
        };
        is = new ByteArrayInputStream(buffer);
        byte[] bf = new byte[5];
        while (is.read(bf)!=-1){
            System.out.println("remain "+is.available()+" unread");
            System.out.println(new String(bf));
        }
        is.close();
    }

    /**
     * FileInputStream file inputStream
     * */
    @Test
    public void fileInputStreamTest() throws IOException{
        InputStream is = new FileInputStream(new File("E:"+File.separator+"data"+File.separator+"d"+File.separator+"td.txt"));
        /*Convert to ByteArrayOutputStream*/
        byte[] buffer = new byte[10];
        while (is.read(buffer)!=-1){
            String ou = new String(buffer);
            System.out.println(ou);
        }
        is.close();
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
}
