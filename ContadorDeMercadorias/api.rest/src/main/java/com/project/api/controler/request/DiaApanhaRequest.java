package com.project.api.controler.request;
import com.project.core.domain.DiaApanha;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiaApanhaRequest 
{
    private String supplier;
    private String data;
    private double qtdBom;
    private double precoBom;
    private double qtdPoupa;
    private double precoPoupa;
    
    public DiaApanha toDiaApanha()
    {
        var dia = new DiaApanha();
        
        dia.setData(data);
        dia.setPrecoBom(precoBom);
        dia.setPrecoPoupa(precoPoupa);
        dia.setQtdBom(qtdBom);
        dia.setQtdPoupa(qtdPoupa);
        
        return dia;
    }
}
