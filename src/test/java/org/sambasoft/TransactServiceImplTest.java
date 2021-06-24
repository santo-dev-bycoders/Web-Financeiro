package org.sambasoft;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sambasoft.impl.FinancaServiceImpl;
import org.sambasoft.impl.TransactServiceImpl;
import org.sambasoft.model.Finance;
import org.sambasoft.model.Transacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class TransactServiceImplTest {

    @TestConfiguration
    static  class TransactServiceImplTestConfiguaration{
        @Bean
        public TransactServiceImpl transactService(){
            return new TransactServiceImpl();
        }
    }

    @Autowired
    TransactServiceImpl transactServiceImpl;

    @Test
    public void pesquisaFinancaPorId(){
        Transacts transacts= transactServiceImpl.findById(2);
        Boolean result;
        if(transacts!=null){
            result=true;
            System.out.println("Existe");
        }else{
            result=false;
            System.out.println("Não encontrado");
        }
        assertTrue(result);
    }

    @Test
    public void verificarlistaTransacaoVazia(){
        List<Transacts> list= transactServiceImpl.findAll();
        assertEquals(0,list.size());
    }

    @Test
    public void verificarlistaTransacaoPreenchida(){
        List<Transacts> list= transactServiceImpl.findAll();
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
