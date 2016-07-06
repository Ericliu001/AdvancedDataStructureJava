package com.ericliu.developer.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by ericliu on 25/06/2016.
 */
public class Amazon {
    double threshold = 0.15;
    int numAffinity = 4;

    Set<TreeSet<String>> collections = new HashSet<>();

    List<RelationshipTriple> relations = new ArrayList<>();

    @Test
    public void generateList() {
        String input = "Item1 Item2 0.2";
        RelationshipTriple triple = parseRelationshipString(input);
        relations.add(triple);

        input = "Item2 Item3 0.1";
        triple = parseRelationshipString(input);
        relations.add(triple);

        input = "Item0 Item1 0.2";
        triple = parseRelationshipString(input);
        relations.add(triple);

        input = "Item4 Item5 0.3";
        triple = parseRelationshipString(input);
        relations.add(triple);


        input = "Item5 Item6 0.4";
        triple = parseRelationshipString(input);
        relations.add(triple);

        input = "Item6 Item0 0.4";
        triple = parseRelationshipString(input);
        relations.add(triple);

        for (RelationshipTriple relation : relations) {
            addItemsToCluster(relation);
        }


        int largestSize = 0;
        TreeSet<TreeSet> largestCluster = new TreeSet<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                TreeSet<String> cluster1 = (TreeSet<String>) o1;
                TreeSet<String> cluster2 = (TreeSet<String>) o2;
                return cluster1.first().compareTo(cluster2.first());
            }
        });


        for (TreeSet<String> cluster : collections) {
            if (cluster.size() > largestSize) {
                largestSize = cluster.size();
            }
        }

        for (TreeSet<String> cluster : collections) {
            if (cluster.size() == largestSize) {
                largestCluster.add(cluster);
            }
        }


        if (largestCluster.size() > 0 && largestCluster.first().size() > 0) {
            System.out.println(largestCluster.first().first());
        }

    }


    private void addItemsToCluster(RelationshipTriple triple) {
        if (triple.probability <= threshold) {
            return;
        }

        TreeSet<String> firstCluster = getCluster(triple.first);
        TreeSet<String> secondCluster = getCluster(triple.second);

        if (firstCluster == null && secondCluster == null) {
            TreeSet<String> newCluster = new TreeSet<>();
            newCluster.add(triple.first);
            newCluster.add(triple.second);
            collections.add(newCluster);
            return;

        } else if (firstCluster == null && secondCluster != null) {
            secondCluster.add(triple.first);
            return;

        } else if (firstCluster != null && secondCluster == null) {
            firstCluster.add(triple.second);
            return;
        }


        if (!firstCluster.equals(secondCluster)) {
            firstCluster.addAll(secondCluster);
            collections.remove(secondCluster);
        }

    }


    private TreeSet<String> getCluster(String item) {
        if (item == null) {
            return null;
        }

        for (TreeSet<String> cluster : collections) {
            if (cluster.contains(item)) {
                return cluster;
            }
        }

        return null;
    }


    public static class RelationshipTriple {
        public final String first;
        public final String second;
        public final double probability;

        public RelationshipTriple(String first, String second, double probability) {

            this.first = first;
            this.second = second;
            this.probability = probability;
        }


    }

    private RelationshipTriple parseRelationshipString(String input) {
        StringTokenizer st = new StringTokenizer(input);
        if (st.countTokens() != 3) {
            throw new IllegalArgumentException("the input is not a relationship triple!");

        }
        String first = st.nextToken();
        String second = st.nextToken();
        double probability = Double.valueOf(st.nextToken());

        return new RelationshipTriple(first, second, probability);
    }


    @Test
    public void testParsingRelationship() {
        String input = "Item1 Item2 0.2";
        RelationshipTriple triple = parseRelationshipString(input);

        assertEquals(triple.first, "Item1");
    }


    @Test
    public void testTreeMap() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Hello");
        treeSet.add("Berican");
        treeSet.add("Coffee");
        treeSet.add("China");
        treeSet.add("American");


        assertEquals(treeSet.first(), "American");

    }


}
