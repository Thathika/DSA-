class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord,
                                          List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int dist = distance.get(word);

            for (String next : getNextWords(word, words)) {
                if (!distance.containsKey(next)) {
                    distance.put(next, dist + 1);
                    queue.add(next);
                    graph.putIfAbsent(next, new ArrayList<>());
                    graph.get(next).add(word);
                } else if (distance.get(next) == dist + 1) {
                    graph.get(next).add(word);
                }
            }
        }

        if (!distance.containsKey(endWord)) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, graph, path, result);

        return result;
    }

    private List<String> getNextWords(String word, Set<String> words) {
        List<String> result = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) {
                    continue;
                }

                chars[i] = c;
                String next = new String(chars);

                if (words.contains(next)) {
                    result.add(next);
                }
            }

            chars[i] = original;
        }

        return result;
    }

    private void dfs(String word, String beginWord,
                     Map<String, List<String>> graph,
                     List<String> path,
                     List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!graph.containsKey(word)) {
            return;
        }

        for (String prev : graph.get(word)) {
            path.add(prev);
            dfs(prev, beginWord, graph, path, result);
            path.remove(path.size() - 1);
        }
    }
}