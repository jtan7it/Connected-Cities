package com.jtan.cityconnections.controller;

import com.jtan.cityconnections.service.ConnectedCitiesServices;
import com.jtan.cityconnections.service.MapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
public class CityController {
    @Autowired
    ConnectedCitiesServices connectedCitiesServices;

    Map<String, Set<String>> map = new MapBuilder().getMap("city.txt");

    public CityController() throws IOException {
    }

    @RequestMapping("/connected")
    public String isConnected(@RequestParam(value = "origin") String city1, @RequestParam(value = "destination") String city2, Map<String, Set<String>> map) throws IOException {
        if(connectedCitiesServices.checkIfConnected(city1.toLowerCase(), city2.toLowerCase(), this.map)) return "yes";
        return "no";
    }
}
