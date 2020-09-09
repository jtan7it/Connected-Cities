package com.jtan.cityconnections.service;

import com.jtan.cityconnections.service.Impl.ConnectedCitiesImpl;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.*;

public class MapBuilderTest {
    @Test
    /** check if MapBuilder can correctly build a undirected graph**/
    public void buildMap() throws IOException {
        Map<String, Set<String>> map = new MapBuilder().getMap("city.txt");
        assertNotNull(map);
    }
}
