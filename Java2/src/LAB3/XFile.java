
package Lab3;


import java.io.*;
public class XFile {
    
    //String path = System.getProperty("file.separator");
    
    public static Object readObject(String path){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Object object = ois.readObject();
            ois.close();
            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        
    }
    public static void writeObject (String path, Object object){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
            oos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
    }
}

