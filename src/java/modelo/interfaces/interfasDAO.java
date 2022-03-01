package modelo.interfaces;

import java.util.List;

public interface interfasDAO <Objecto>{
    public boolean create(Objecto temp);
    public List<Objecto> readAll();
    public Objecto read(Objecto filt);
    public boolean update(Objecto temp);
    public boolean delete(Objecto temp);
}