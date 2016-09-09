package net.bred.price.controller;

import net.bred.price.model.ProdCat;
import net.bred.price.service.ProdCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdCatController {

    private ProdCatService prodCatService;

    @Autowired(required = true)
    @Qualifier(value = "prodCatService")
    public void setProdService(ProdCatService prodCatService) {
        this.prodCatService = prodCatService;
    }

    @RequestMapping(value="newOne", method = RequestMethod.GET)
    public String listProdCat (Model model) {
        model.addAttribute("prodCat", new ProdCat());
        model.addAttribute("listProdCat", this.prodCatService.listProdCat());

        return "newOne";
    }


    @RequestMapping(value = "findProdCat", method = RequestMethod.GET)
    public String findProdCat(@RequestParam("catId") String cat, @RequestParam("name") String name,@RequestParam("minPrice") Float minPrice,@RequestParam("maxPrice") Float maxPrice, Model model){
        model.addAttribute("prodCat", new ProdCat());
        if (minPrice == null) minPrice=Float.MIN_VALUE;
        if (maxPrice == null) maxPrice=Float.MAX_VALUE;
        model.addAttribute("findProdCatResult", this.prodCatService.findProdCat(cat,name,minPrice,maxPrice));


        //return "redirect:/findProds";
        return "newOne";
    }
}
