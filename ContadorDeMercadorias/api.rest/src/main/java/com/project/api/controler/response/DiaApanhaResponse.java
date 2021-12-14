package com.project.api.controler.response;
import com.project.core.domain.DiaApanha;
import lombok.Getter;

@Getter
public class DiaApanhaResponse {
    private String data;
    private double qtdBom;
    private double precoBom;
    private double qtdPoupa;
    private double precoPoupa;
    
    public DiaApanhaResponse fromDiaApanha(DiaApanha dia)
    {
        this.data = dia.getData();
        this.qtdBom = dia.getQtdBom();
        this.qtdPoupa = dia.getQtdPoupa();
        this.precoBom = dia.getPrecoBom();
        this.precoPoupa = dia.getPrecoPoupa();
        return this;
    }
}
