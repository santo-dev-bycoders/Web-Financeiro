package org.sambasoft.controllers;


import org.sambasoft.model.Finance;
import org.sambasoft.model.Transacts;
import org.sambasoft.services.FinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FinanceController {

    private FinanceService financeService;

    private static final Logger logger = LoggerFactory.getLogger(FinanceController.class);


    @Autowired
    public void setRouteService(FinanceService financeService) {
        this.financeService = financeService;
    }


    @GetMapping("/visualizar-financas")
    public String getAllRoutes(Model model){
        List<Finance> finances = financeService.findAll();
        model.addAttribute("finances", finances);
        return "financas";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        String baseDir= System.getProperty("user.dir") + "/upload/";
        try {
            file.transferTo(new File(baseDir+ file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/visualizar-financas";
    }



    @RequestMapping(value = "/salvar-financa", method = RequestMethod.POST)
    public String saveRoute(@RequestParam("file")MultipartFile file) throws ParseException {

        String baseDir= System.getProperty("user.dir") + "/upload/";
        try {
            file.transferTo(new File(baseDir+ file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }



        String linha=new String();
        File file2=new File(baseDir+ file.getOriginalFilename());
        FileReader leitorArquivo= null;
        try {
            leitorArquivo = new FileReader("C:\\CNAB.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader=new BufferedReader(leitorArquivo);
        List<Finance> listFinance=new ArrayList<Finance>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Transacts transacts=new Transacts();

        if(file2.exists()){
            while (true) {
                Finance finance=new Finance();
                try {
                    linha=bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(linha==null){
                    break;
                }
                //finance.setType(transacts);
               finance.setDateFinance(converterDate(linha.substring(1, 9)));
               finance.setValue(Integer.parseInt(linha.substring(9, 19)));
                finance.setCpf(linha.substring(19, 30));
                finance.setCard(linha.substring(30, 42));
                finance.setHour(linha.substring(42, 48));
                finance.setOwnerStore(linha.substring(48, 62));
                finance.setNameStore(linha.substring(62, 80));
                listFinance.add(finance);
            }
        }

        financeService.create(listFinance);
        return "redirect:/visualizar-financas";
    }


    public Date converterDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String day=date.substring(6,8);
        String month=date.substring(4,6);
        String year=date.substring(0,4);
        Date newDate=simpleDateFormat.parse(day+"/"+month+"/"+year);
        return newDate;
    }




}
