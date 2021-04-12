package com.sunny.classes;

public class Main {
    public static void main(String[] args) {
//        City city = new City("Vinnytsia");
//        System.out.println(city);
        CitiesService service = new CitiesService();
//        service.addCity(city);
        System.out.println(service.getCities("K"));

    }
}
