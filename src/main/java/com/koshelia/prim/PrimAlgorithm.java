package com.koshelia.prim;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

public class PrimAlgorithm {

    private List<Top> graph;

    public PrimAlgorithm(List<Top> graph){
        this.graph = graph;
    }

    public void findOstovTree(boolean minimalOstovTree){
        if (graph.size() > 0){
            graph.get(0).setVisited(true);
        }
        while (isUncompleted()){
            Rib nextRib = new Rib(minimalOstovTree ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            Top nextTop = graph.get(0);
            for (Top top : graph){
                if (top.isVisited()){
                    Pair<Top, Rib> candidate = top.nextPair(minimalOstovTree);
                    if (minimalOstovTree ? candidate.getValue().getWeight() < nextRib.getWeight() : candidate.getValue().getWeight() > nextRib.getWeight()){
                        nextRib = candidate.getValue();
                        nextTop = candidate.getKey();
                    }
                }
            }
            nextRib.setIncluded(true);
            nextTop.setVisited(true);
        }
    }

    private boolean isUncompleted(){
        for (Top top : graph){
            if (!top.isVisited()){
                return true;
            }
        }
        return false;
    }

    public String outputGraph(){
        StringBuilder sb = new StringBuilder();
        for (Top top : graph){
            sb.append(top.originalToString());
        }
        return sb.toString();
    }

    public void resetPrintHistory(){
        for (Top top : graph){
            Iterator<Map.Entry<Top, Rib>> it = top.getEdges().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Top, Rib> pair = it.next();
                pair.getValue().setPrinted(false);
            }
        }
    }


    public String outputOstovTree(){
        StringBuilder sb = new StringBuilder();
        for (Top top : graph){
            sb.append(top.includedToString());
        }
        return sb.toString();
    }

}