public class ValidWordAbbr {
    HashMap<String, Integer> map = new HashMap<>();
    Set<String> dic = new HashSet<>();
    public String convert(String s) {
        if(s == null || s.length() < 2)
            return s;
        return "" + s.charAt(0) + (s.length() -2) + s.charAt(s.length() - 1);
    }
    
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary) {
            if(dic.contains(s))
                continue;
            dic.add(s);
            String abbr = convert(s);
            if(map.containsKey(abbr)) {
                map.put(abbr, map.get(abbr) + 1);    
            } else {
                map.put(abbr, 1);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = convert(word);
        int count = map.containsKey(abbr) ? map.get(abbr) : 0; 
        if(dic.contains(word)) {
            return count == 1;
        } else {
            return count == 0;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");