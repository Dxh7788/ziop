package com.dio;

import org.junit.Test;

import java.io.*;

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
 * StringBufferInputStream @Deprecated
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

        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);
    }
}
