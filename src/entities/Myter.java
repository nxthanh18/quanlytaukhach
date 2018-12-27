/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.File;
import javax.swing.filechooser.FileFilter;


public class Myter extends FileFilter{
    
    private String name;
    private String exec;

    public Myter() {
    }

    public Myter(String name, String exec) {
        this.name = name;
        this.exec = exec;
    }
    
    

    @Override
    public boolean accept(File f) {
       if(f.isDirectory()){
           return true;
       }
       return f.getName().endsWith(this.exec);
    }

    @Override
    public String getDescription() {
        return this.name + " (. " + this.exec + " ) ";
    }
    
}
