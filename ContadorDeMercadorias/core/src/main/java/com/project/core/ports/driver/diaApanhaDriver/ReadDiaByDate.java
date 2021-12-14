package com.project.core.ports.driver.diaApanhaDriver;

import com.project.core.domain.DiaApanha;
import java.util.List;

public interface ReadDiaByDate
{
     List<DiaApanha> apply(String supplier);
}
