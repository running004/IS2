package negocio.Test;

import java.util.List;

import negocio.Sucursal.TSucursal;

public interface SATest {
    public int create(TTest t);
    public TTest read(int id);
    public List<TTest> readAll();
    public int update(TTest t);
    public int delete (String id);

}