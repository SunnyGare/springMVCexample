package com.sunny.controllers;

import com.sunny.classes.CitiesService;
import com.sunny.classes.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Написать контроллер, который принимает параметр "city" и возвращает все города,
 * которые начинаются с последней буквы этого параметра.
 * Перенесите CitiesService из прошлых ДЗ. Для хранения городов можно использовать HashMap вместо базы данных.
 * CitiesService должен быть передан в контроллер с помощью Spring
 */

@Controller
@RequestMapping("/addCity")
public class AddCityController {

    @RequestMapping(method = RequestMethod.GET)
    public String addCity(
            @RequestParam("newCity") String title,
            Model model
    ) {
        City city = new City(title);
        CitiesService service = new CitiesService();
        service.addCity(city);
        System.out.println(title);

        model.addAttribute("cityAdded", title);
        return "addCity-view";
    }
}
