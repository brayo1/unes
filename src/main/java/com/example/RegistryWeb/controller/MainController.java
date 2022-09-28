package com.example.RegistryWeb.controller;

import com.example.RegistryWeb.models.Person;
import com.example.RegistryWeb.service.PersonService;
import com.example.RegistryWeb.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PersonService personService;
    @Autowired
    private ReportService reportService;

//    @RequestMapping("/")
    @GetMapping("/all")
    @ResponseBody
    public List<Person> allPersons(){
        return personService.listAll();
    }

    @GetMapping("/")
    public String viewHome(Model model){
        List <Person> listPersons = personService.listAll();
        model.addAttribute("listPersons", listPersons);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewPersonForm(Model model){
        Person person = new Person();
        model.addAttribute("person", person);

        return "new_person";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person person){
        personService.save(person);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updatePersonForm(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("update_person");
        Person person = personService.getById(id);
        mav.addObject("person", person);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable(name="id") Long id){
        personService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = {"/","/search"})
    public String search(Person person, Model model, String keyword) {
        if(keyword!=null) {
            List<Person> listPersons = personService.getByKeyword(keyword);
            model.addAttribute("listPersons", listPersons);
        }else {
            List<Person> listPersons = personService.listAll();
            model.addAttribute("listPersons", listPersons);}
        return "index";
    }

    @GetMapping("/report")
    @ResponseBody
//    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
    public String generateReport() throws JRException, FileNotFoundException {
        return reportService.exportReport("pdf");
    }

}
