package mk.finki.ukim.wp.lab.web.servlet.controller;

import mk.finki.ukim.wp.lab.model.Balloon;
import mk.finki.ukim.wp.lab.model.Manufacturer;
import mk.finki.ukim.wp.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.wp.lab.service.BalloonService;
import mk.finki.ukim.wp.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/balloons")

public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("balloonList", balloonService.listAll());
        return "listBalloons";
    }

    @PostMapping()
    public String saveBalloon(@RequestParam String name, @RequestParam String description, @RequestParam Long manufacturer, @RequestParam(required = false) Long id){
        balloonService.save(name,description,manufacturer, id);
        return "redirect:/balloons";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model){
        if(balloonService.findById(id).isPresent()){
            Balloon balloon = balloonService.findById(id).get();
            List<Manufacturer> manufacturers = manufacturerService.findAll();
            model.addAttribute("balloon", balloon);
            model.addAttribute("manufacturers", manufacturers);
            return "add-balloon";
        }
        return "redirect:/balloons?error=BalloonNotFound";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        List<Manufacturer> manufacturers = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "add-balloon";
    }

}
