package com.jtan.cityconnections.service;

import com.jtan.cityconnections.service.Impl.ConnectedCitiesImpl;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.*;


public class ConnectedCitiesServicesTest {
    @Test
    /**if it is an undirecte graph and the two cities are connected together, assertTrue*/
    public void testUnDirectedGraphConnected(){
        ConnectedCitiesImpl connectedCitiesImpl = new ConnectedCitiesImpl();
        HashMap<String, Set<String>> map = new HashMap<>();
        map.put("Boston", new HashSet<>());
        map.get("Boston").add("Newark");
        map.put("Newark", new HashSet<>());
        map.get("Newark").add("Boston");
        assertTrue(connectedCitiesImpl.checkIfConnected("Boston", "Newark", map));
    }

    @Test
    /**if it is a directed graph, return false*/
    public void testDirectedGraph(){
        ConnectedCitiesImpl connectedCitiesImpl = new ConnectedCitiesImpl();
        HashMap<String, Set<String>> map = new HashMap<>();
        map.put("Boston", new HashSet<>());
        map.get("Boston").add("Newark");
//        map.put("Newark", new HashSet<>());
//        map.get("Newark").add("Boston");
        assertTrue(!connectedCitiesImpl.checkIfConnected("Boston", "Newark", map));
    }

    @Test
    /**if it is a undirected graph but two cities not connected together, return false*/
    public void testDirectedGraphNotConnected(){
        ConnectedCitiesImpl connectedCitiesImpl = new ConnectedCitiesImpl();
        HashMap<String, Set<String>> map = new HashMap<>();
        map.put("Boston", new HashSet<>());
        map.get("Boston").add("Newark");
        map.put("Newark", new HashSet<>());
        map.get("Newark").add("Boston");
        map.put("Trendon", new HashSet<>());
        map.get("Trendon").add("Albany");
        map.put("Albany", new HashSet<>());
        map.get("Albany").add("Trendon");
        assertTrue(!connectedCitiesImpl.checkIfConnected("Boston", "Trendon", map));
    }
}
