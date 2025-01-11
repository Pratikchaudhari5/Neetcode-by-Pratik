

class Solution {

    public String encode(List<String> strs) {
        String symbol = "*";

        for (int i = 0; i < strs.size(); i++) {
            strs.set(i, strs.get(i) + symbol); // Append symbol and set back to the list
        }

        return String.join("", strs); // Return the concatenated encoded string
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String[] parts = str.split("\\*"); // Split the string by the appended symbol '*'

        for (String s : parts) {
            result.add(s); // Add each decoded part to the list
        }

        return result;
    }
}
