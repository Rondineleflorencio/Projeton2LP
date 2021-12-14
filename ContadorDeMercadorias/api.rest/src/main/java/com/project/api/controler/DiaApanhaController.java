package com.project.api.controler;
import com.project.api.controler.request.DiaApanhaRequest;
import com.project.api.controler.response.DiaApanhaResponse;
import com.project.core.ports.driver.diaApanhaDriver.InsertDate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("diaApanha")
public record DiaApanhaController(InsertDate insert) 
{
    @PostMapping
    public DiaApanhaResponse post(@RequestBody DiaApanhaRequest request){
        var apanha = request.toDiaApanha();
        apanha = insert.apply(apanha, request.getSupplier());
        return new DiaApanhaResponse().fromDiaApanha(apanha);
    }
}
