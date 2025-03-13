import java.util.*;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class Solution {
    public char[] geneChoices = { 'A', 'C', 'G', 'T' };

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> validGenes = new HashSet<>(Arrays.asList(bank));

        if (!validGenes.contains(endGene))
            return -1;

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(startGene, 0));

        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();

            String gene = current.getKey();
            int mutations = current.getValue();

            if (gene.equals(endGene))
                return mutations;

            for (int i = 0; i < 8; i++) {
                for (char choice : geneChoices) {
                    StringBuffer newGeneBuffer = new StringBuffer(gene);
                    newGeneBuffer.setCharAt(i, choice);
                    String newGene = newGeneBuffer.toString();
                    if (validGenes.contains(newGene)) {
                        queue.offer(new Pair<>(newGene, mutations + 1));
                        validGenes.remove(newGene);
                    }
                }
            }
        }

        return -1;
    }
}