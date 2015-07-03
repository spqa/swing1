/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author QuangAnh
 */
public class Draft {
    public void WriterDemo() throws IOException{
        try (BufferedWriter b = new BufferedWriter(new FileWriter("test.txt"))) {
            String la="dfsdffsdfd";
            b.write(la);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Draft draft = new Draft();
        draft.WriterDemo();
    }
}
