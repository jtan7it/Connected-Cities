package com.jtan.cityconnections.service.Impl;
import java.io.IOException;
import java.util.*;
import com.jtan.cityconnections.service.ConnectedCitiesServices;
import com.jtan.cityconnections.service.MapBuilder;
import org.springframework.stereotype.Service;

@Service
public class ConnectedCitiesImpl implements ConnectedCitiesServices {

    @Override
    public boolean checkIfConnected(String origin, String destination, Map<String, Set<String>> map){
        boolean isFound = origin.equals(destination);
        if (map.containsKey(origin) && map.containsKey(destination)) {
            // By using a Queue, we are implementing Breadth First Search
            // This will find the shortest path between two cities
            Queue<String> notVisited = new LinkedList<>();

            // We keep a set of the cities we have already visited. This prevents BFS from looping in
            // cycles and allows the BFS to terminate if no path can be found after exploring all reachable nodes
            Set<String> visited = new HashSet<>();

            notVisited.add(origin);

            while (!notVisited.isEmpty() && !isFound) {
                String city = notVisited.poll();
                isFound = city.equals(destination);

                Set<String> possibleConnections = map.get(city);
                for (String possibleCity : possibleConnections) {
                    if (!visited.contains(possibleCity)) {
                        notVisited.add(possibleCity);
                        visited.add(possibleCity);
                    }
                }
            }
        }
        return isFound;
    }
}
