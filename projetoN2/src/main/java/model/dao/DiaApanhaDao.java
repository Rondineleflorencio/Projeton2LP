package model.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.DiaApanha;
import model.Supplier;
import model.bean.diaApanha.CreateDiaApanhaTablw;
import model.bean.diaApanha.InsertDiaApanha;
import model.bean.diaApanha.DeleteDiaApanha;
import model.bean.diaApanha.ReadByDate;
import model.bean.diaApanha.ReadDao;
import model.bean.diaApanha.UpdateDiaApanha;
import model.bean.diaApanha.ReadByTableNameDao;
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
    public List<DiaApanha> readByMonth(int data, String table){
        List<DiaApanha> apanhas = new ArrayList<>();
        String sql = "MONTH(Data)";
        return apanhas = ReadByDate.readForDate(data, sql, table);
    }
    public List<DiaApanha> readByDay(int data, String table){
        List<DiaApanha> apanhas = new ArrayList<>();
        String sql = "DAY(Data)";
        return apanhas = ReadByDate.readForDate(data, sql, table);
    }
    public List<DiaApanha> readByYear(int data, String table){
        List<DiaApanha> apanhas = new ArrayList<>();
        String sql = "YEAR(Data)";
        return apanhas = ReadByDate.readForDate(data, sql, table);
    }
    public List<DiaApanha> readForTable(String name, String month)
    {
        List<DiaApanha> apanhas = new ArrayList<>();
        if(month.equals("Todos"))
        {
            apanhas = ReadByTableNameDao.readForName(name);
        }else{
            if(month.equals("janeiro")){ apanhas = readByMonth(1, name);}
            if(month.equals("fevereiro")){ apanhas = readByMonth(2, name);}
            if(month.equals("marco")){ apanhas = readByMonth(3, name);}
            if(month.equals("abril")){ apanhas = readByMonth(4, name);}
            if(month.equals("maio")){ apanhas = readByMonth(5, name);}
            if(month.equals("junho")){ apanhas = readByMonth(6, name);}
            if(month.equals("julho")){ apanhas = readByMonth(7, name);}
            if(month.equals("agosto")){ apanhas = readByMonth(8, name);}
            if(month.equals("setembro")){ apanhas = readByMonth(9, name);}
            if(month.equals("outubro")){ apanhas = readByMonth(10, name);}
            if(month.equals("novembro")){ apanhas = readByMonth(11, name);}
            if(month.equals("dezembro")){ apanhas = readByMonth(12, name);} 
        }
        return apanhas;
    }
}
