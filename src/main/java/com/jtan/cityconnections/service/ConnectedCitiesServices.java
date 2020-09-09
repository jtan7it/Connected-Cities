package com.jtan.cityconnections.service;

import java.io.IOException;
import java.util.*;
/**
 * an interface contains method that determines if two cities are connected together
 */
public interface ConnectedCitiesServices {
    boolean checkIfConnected(String origin, String destination, Map<String, Set<String>> map);
}
