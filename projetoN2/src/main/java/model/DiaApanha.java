package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiaApanha 
{
    private String data;
    private double qtdBom;
    private double precoBom;
    private double qtdPoupa;
    private double precoPoupa;
    private boolean pago;
}
