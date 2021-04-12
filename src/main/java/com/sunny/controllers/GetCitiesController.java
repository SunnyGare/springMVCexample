package com.sunny.controllers;

import com.sunny.classes.CitiesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Написать контроллер, который принимает параметр "city" и возвращает все города,
 * которые начинаются с последней буквы этого параметра.
 * Перенесите CitiesService из прошлых ДЗ. Для хранения городов можно использовать HashMap вместо базы данных.
 * CitiesService должен быть передан в контроллер с помощью Spring
 */

@Controller
@RequestMapping("/getCities")
public class GetCitiesController {

    @RequestMapping(method = RequestMethod.GET)
    public String addCity(
            @RequestParam("city") String title,
            Model model
    ) {
        String lastChar = title.substring(title.length() - 1);
        CitiesService service = new CitiesService();
        System.out.println(title);

        List citiesServer = service.getCities(lastChar);
        model.addAttribute("cities", citiesServer);
        return "getCities-view";
    }
}
