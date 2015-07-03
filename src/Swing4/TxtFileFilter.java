/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing4;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author QuangAnh
 */
public class TxtFileFilter extends FileFilter{

    @Override
    public boolean accept(File f) {
        if(f.isDirectory()){
        return true;
        }
        
        String name=f.getName();
        return name.endsWith(".txt");
    }

    @Override
    public String getDescription() {
       return "File text";
    }
    
}
