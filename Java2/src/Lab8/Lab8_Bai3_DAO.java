package Lab8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Lab8_Bai3_DAO<Entity> {
    protected List<Entity> list = new ArrayList<>(); // database
    
    public void add(Entity entity){
        list.add(entity);
    }
    
    public void remove(Entity entity){
        list.remove(entity);
    }
    
    abstract public void update(Entity entity);
    abstract public Entity find(Serializable id);
    
    public List<Entity> getList(){
        return list;
    }
    
    public void read(String path)throws FileNotFoundException, IOException, ClassNotFoundException{
        try(ObjectInputStream objectInputStream = new ObjectInputStream( new FileInputStream(path))){
        list = (List<Entity>) objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void write(String path) throws FileNotFoundException, IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
        oos.writeObject(list);
        }   catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
