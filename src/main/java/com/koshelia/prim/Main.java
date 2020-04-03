package com.koshelia.prim;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrimAlgorithm primAlgorithmForMinimum = new PrimAlgorithm(generateGraph());
        System.out.println(primAlgorithmForMinimum.outputGraph());

        primAlgorithmForMinimum.findOstovTree(true);
        primAlgorithmForMinimum.resetPrintHistory();
        System.out.println(primAlgorithmForMinimum.outputOstovTree());

        PrimAlgorithm primAlgorithmForMaximum = new PrimAlgorithm(generateGraph());
        primAlgorithmForMaximum.findOstovTree(false);
        System.out.println(primAlgorithmForMaximum.outputOstovTree());
    }

    public static List<Top> generateGraph() {
        List<Top> graph = new ArrayList<>();
        Top a = new Top("A");
        Top b = new Top("B");
        Top c = new Top("C");
        Top d = new Top("D");
        Top e = new Top("E");

        Rib ab = new Rib(2);
        a.addEdge(b, ab);
        b.addEdge(a, ab);

        Rib bс = new Rib(2);
        b.addEdge(c, bс);
        c.addEdge(b, bс);

        Rib be = new Rib(5);
        b.addEdge(e, be);
        e.addEdge(b, be);

        Rib cd = new Rib(1);
        c.addEdge(d, cd);
        d.addEdge(c, cd);

        Rib ce = new Rib(1);
        c.addEdge(e, ce);
        e.addEdge(c, ce);

        Rib ac = new Rib(3);
        a.addEdge(c, ac);
        c.addEdge(a, ac);



        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        return graph;
    }
}
