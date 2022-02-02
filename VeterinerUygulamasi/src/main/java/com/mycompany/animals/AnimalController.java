package com.mycompany.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService service;

    @GetMapping("/animals")
    public String showAnimalList(Model model) {
        List<Animal> listAnimals = service.listAll();
        model.addAttribute("listAnimals", listAnimals);
        return "animals";
    }

    @GetMapping("/animals/animal_form")
    public String showNewForm(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("pageTitle","Yeni Hayvan Ekle");
        return "animal_form";
    }

    @PostMapping("/animals/save")
    public String saveUser(Animal animal, RedirectAttributes ra) {
        service.save(animal);
        ra.addFlashAttribute("message", "Hayvan başarıyla kaydedildi...");
        return "redirect:/animals";
    }

    @GetMapping("/animals/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Animal animal = service.get(id);
            model.addAttribute("animal", animal);
            model.addAttribute("pageTitle","Hayvan Güncelle (ID="+id+") ");
            return "animal_form";
        } catch (AnimalNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/animals";

        }

    }
    @GetMapping("/animals/delete/{id}")
    public String deleteAnimal(@PathVariable("id") Integer id,  RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message","Hayvan başarıyla silindi...");
        } catch (AnimalNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/animals";
    }
    }
