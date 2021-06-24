package org.sambasoft;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sambasoft.impl.FinancaServiceImpl;
import org.sambasoft.model.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class FinanceServiceImplTest {

    @TestConfiguration
    static  class FinanceServiceImplTestConfiguaration{
        @Bean
        public  FinancaServiceImpl financaService(){
            return new FinancaServiceImpl();
        }
    }

    @Autowired
    FinancaServiceImpl financaServiceImpl;
    
    @Test
    public void calcularSaldo(){
        int count= financaServiceImpl.totalizingBalance();
        assertEquals(count,20);
    }

    @Test
    public void pesquisaFinancaPorId(){
        Finance finance= financaServiceImpl.findById(2);
        Boolean result;
        if(finance!=null){
            result=true;
            System.out.println("Existe");
        }else{
            result=false;
            System.out.println("Não encontrado");
        }
        assertTrue(result);
    }

    @Test
    public void verificarlistaVazia(){
        List<Finance> list= financaServiceImpl.findAll();
        assertEquals(0,list.size());
    }

    @Test
    public void verificarlistaPreenchida(){
        List<Finance> list= financaServiceImpl.findAll();
        if(list.size()==0){
            assertTrue(false);
        }else{
            assertTrue(true);
        }

    }

    @Before
    public void setup(){

    }
}
