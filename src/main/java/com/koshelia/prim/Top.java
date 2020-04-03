package com.koshelia.prim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

public class Top {

    private String label = null;
    private Map<Top, Rib> edges = new HashMap<>();
    private boolean isVisited = false;

    public Top(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<Top, Rib> getEdges() {
        return edges;
    }

    public void addEdge(Top top, Rib rib){
        if (this.edges.containsKey(top)){
            if (rib.getWeight() < this.edges.get(top).getWeight()){
                this.edges.replace(top, rib);
            }
        } else {
            this.edges.put(top, rib);
        }
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Pair<Top, Rib> nextPair(boolean minimal){
        Rib nextRib = new Rib(minimal ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        Top nextTop = this;
        Iterator<Map.Entry<Top, Rib>> it = edges.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Top, Rib> pair = it.next();
            if (!pair.getKey().isVisited()){
                if (!pair.getValue().isIncluded()) {
                    if (minimal ? pair.getValue().getWeight() < nextRib.getWeight() :  pair.getValue().getWeight() > nextRib.getWeight()) {
                        nextRib = pair.getValue();
                        nextTop = pair.getKey();
                    }
                }
            }
        }
        return new Pair<>(nextTop, nextRib);
    }

    public String includedToString(){
        StringBuilder sb = new StringBuilder();
        if (isVisited()) {
            Iterator<Map.Entry<Top, Rib>> it = edges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Top, Rib> pair = it.next();
                if (pair.getValue().isIncluded()) {
                    if (!pair.getValue().isPrinted()) {
                        sb.append(getLabel());
                        sb.append(" <--- ");
                        sb.append(pair.getValue().getWeight());
                        sb.append(" ---> ");
                        sb.append(pair.getKey().getLabel());
                        sb.append("\n");
                        pair.getValue().setPrinted(true);
                    }
                }
            }
        }
        return sb.toString();
    }

    public String originalToString(){
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Top, Rib>> it = edges.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Top, Rib> pair = it.next();
            if (!pair.getValue().isPrinted()) {
                sb.append(getLabel());
                sb.append(" --- ");
                sb.append(pair.getValue().getWeight());
                sb.append(" --- ");
                sb.append(pair.getKey().getLabel());
                sb.append("\n");
                pair.getValue().setPrinted(true);
            }
        }
        return sb.toString();
    }
}