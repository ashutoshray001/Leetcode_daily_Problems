class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> outDegree = new HashMap<>();

        for (List<String> path : paths) {
            String src = path.get(0);
            String dest = path.get(1);

            outDegree.put(src, outDegree.getOrDefault(src, 0) + 1);
            outDegree.putIfAbsent(dest, 0);
        }

        for (String city : outDegree.keySet()) {
            if (outDegree.get(city) == 0) {
                return city;
            }
        }

        return "";
    }
}