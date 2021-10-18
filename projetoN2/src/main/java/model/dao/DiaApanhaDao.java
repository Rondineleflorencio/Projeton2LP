package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.DiaApanha;
import model.Supplier;
import model.bean.diaApanha.CreateDiaApanhaTablw;
import model.bean.diaApanha.InsertDiaApanha;
import model.bean.diaApanha.DeleteDiaApanha;
import model.bean.diaApanha.ReadDao;
import model.bean.diaApanha.UpdateDiaApanha;
import model.bean.diaApanha.ReadByDateDao;
public class DiaApanhaDao 
{
    public void create(Supplier s)
    {
        CreateDiaApanhaTablw.createTable(s);
    }
    public void insert(DiaApanha dia, String f)
    {
        InsertDiaApanha.insert(dia, f);
    }
    public void update(DiaApanha dia, String f)
    {
        UpdateDiaApanha.update(dia, f);
    }
    public void delete(DiaApanha dia, String f)
    {
        DeleteDiaApanha.delete(dia, f);
    }
    public List<DiaApanha> read()
    {
        List<DiaApanha> apanhas = new ArrayList<>();
        apanhas = ReadDao.read();
        return apanhas;
    }
    public List<DiaApanha> readForName(String name)
    {
        List<DiaApanha> apanhas = new ArrayList<>();
        apanhas = ReadByDateDao.readForName(name);
        return apanhas;
    }
}
