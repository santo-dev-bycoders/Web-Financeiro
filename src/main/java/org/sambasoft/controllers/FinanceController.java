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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    public FinanceController() {
    }


    @GetMapping("/visualizar-financas")
    public String getAllFinances(Model model){

        List<Finance> finances = financeService.findAll();
        model.addAttribute("finances", finances);
        return "financas";
    }

    public int totalizingBalance(){
        Integer countValue=financeService.totalizingBalance();
        if(countValue.equals(null)) {
            return 0;
        }else{
            return countValue;
        }
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        String baseDir= System.getProperty("user.dir") + "/images/";
        try {
            file.transferTo(new File(baseDir+ file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/visualizar-financas";
    }



    public void upload(String diretorio, MultipartFile multipartFile){
        try {
            multipartFile.transferTo(new File(diretorio+ multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Date converterDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        String day=date.substring(6,8);
        String month=date.substring(4,6);
        String year=date.substring(0,4);
        Date newDate=simpleDateFormat.parse(day+"/"+month+"/"+year);
        return newDate;
    }

    public String converterHour(String hours) throws ParseException {
        String hour=hours.substring(0,2);
        String minute=hours.substring(2,4);
        String second=hours.substring(4,6);
        String newHour=hour+":"+minute+":"+second;
        return newHour;
    }

    @RequestMapping(value = "/salvar-financa", method = RequestMethod.POST)
    public String saveRoute(@RequestParam("file")MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws ParseException {

        String diretorio= System.getProperty("user.dir") + "/images/";
        List<Finance> listFinance=new ArrayList<Finance>();
        Transacts transacts=new Transacts();

        upload(diretorio, multipartFile);

        String linha=new String();
        File file=new File(diretorio+ multipartFile.getOriginalFilename());
        FileReader leitorArquivo= null;
        try {
            leitorArquivo = new FileReader(diretorio+ multipartFile.getOriginalFilename());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader=new BufferedReader(leitorArquivo);

        if(file.exists()){
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
                finance.setIdType(linha.substring(0, 1));
               finance.setDateFinance(converterDate(linha.substring(1, 9)));
               finance.setValue(Integer.parseInt(linha.substring(9, 19)));
                finance.setCpf(linha.substring(19, 30));
                finance.setCard(linha.substring(30, 42));
                finance.setHour(converterHour(linha.substring(42, 48)));
                finance.setOwnerStore(linha.substring(48, 62));
                finance.setNameStore(linha.substring(62, 80));
                listFinance.add(finance);
            }
        }


        financeService.create(listFinance);
        redirectAttributes.addFlashAttribute("message","Totalizador de Saldo na Conta: "+totalizingBalance());
        return "redirect:/visualizar-financas";
    }









}
