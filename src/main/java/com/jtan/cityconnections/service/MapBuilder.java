package com.jtan.cityconnections.service;


import java.util.*;
import java.io.*;

/**
 *  build a undirected graph the represents the connections of cities.
 */
public class MapBuilder {
    public MapBuilder(){};
    public Map<String, Set<String>> getMap(String filename) throws IOException {
        Map<String, Set<String>> map = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            Reader fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null && !line.isEmpty()) {
                String[] cities = line.split(",");
                String origin = cities[0].trim().toLowerCase();
                String destination = cities[1].trim().toLowerCase();
                map.putIfAbsent(origin,new HashSet<>());
                map.putIfAbsent(destination, new HashSet<>());
                Set<String> firstCityConnections = map.get(origin);
                Set<String> secondCityConnections = map.get(destination);
                firstCityConnections.add(destination);
                secondCityConnections.add(origin);
                line = bufferedReader.readLine();
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

        return map;
    }
}
