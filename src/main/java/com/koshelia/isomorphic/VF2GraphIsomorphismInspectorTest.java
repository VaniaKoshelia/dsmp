package com.koshelia.isomorphic;

import org.jgrapht.*;
import org.jgrapht.alg.isomorphism.VF2GraphIsomorphismInspector;
import org.jgrapht.graph.*;

/**
 * This test class is fairly small compared with the tests for the VF2SubgraphIsomorphismInspector
 * class due to the similarities in both algorithms (SubgraphIsomorphism and GraphIsomorphism)
 */
public class VF2GraphIsomorphismInspectorTest
{

    public static void main(String[] args) {
        testSubgraph2();
    }


    public static void testSubgraph2()
    {

        Graph<Integer, DefaultEdge> g1 =
            new DefaultListenableGraph<>(new SimpleGraph<>(DefaultEdge.class));

        g1.addVertex(0);
        g1.addVertex(1);
        g1.addVertex(2);
        g1.addVertex(3);
        g1.addVertex(4);

        g1.addEdge(0, 1);
        g1.addEdge(0, 4);
        g1.addEdge(1, 2);
        g1.addEdge(1, 4);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);

        Graph<Integer, DefaultEdge> g2 =
            new DefaultListenableGraph<>(new SimpleGraph<>(DefaultEdge.class));

        g2.addVertex(0);
        g2.addVertex(1);
        g2.addVertex(2);
        g2.addVertex(3);
        g2.addVertex(4);
        g2.addVertex(5);

        g2.addEdge(4, 2);
        g2.addEdge(2, 0);
        g2.addEdge(0, 1);
        g2.addEdge(1, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        g2.addEdge(1, 4);

        Graph<Integer, DefaultEdge> g3 =
            new DefaultListenableGraph<>(new SimpleGraph<>(DefaultEdge.class));

        g3.addVertex(0);
        g3.addVertex(1);
        g3.addVertex(2);
        g3.addVertex(3);
        g3.addVertex(4);
        g3.addVertex(5);

        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 3);
        g3.addEdge(3, 4);
        g3.addEdge(5, 2);
        g3.addEdge(5, 3);
        g3.addEdge(5, 4);

        Graph<Integer, DefaultEdge> g4 =
            new DefaultListenableGraph<>(new SimpleGraph<>(DefaultEdge.class));

        g4.addVertex(0);
        g4.addVertex(1);
        g4.addVertex(2);
        g4.addVertex(3);
        g4.addVertex(4);
        g4.addVertex(5);

        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 3);
        g4.addEdge(4, 5);
        g4.addEdge(4, 2);
        g4.addEdge(5, 2);
        g4.addEdge(5, 3);

        VF2GraphIsomorphismInspector<Integer, DefaultEdge> vf2 =
            new VF2GraphIsomorphismInspector<>(g2, g1),
            vf3 = new VF2GraphIsomorphismInspector<>(g1, g2),
            vf4 = new VF2GraphIsomorphismInspector<>(g3, g4);
//        System.out.println(vf2.isomorphismExists());
        System.out.println(vf3.isomorphismExists() ? "Graphs is isomorphic" : "Graphs is not isomorphic");
//        System.out.println(vf4.isomorphismExists());
//        assertEquals(false, vf2.isomorphismExists());
//        assertEquals(false, vf3.isomorphismExists());
//        assertEquals(false, vf4.isomorphismExists());
    }

}