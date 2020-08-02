class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordlen = beginWord.length();
        HashSet<String> used = new HashSet<>();
        HashSet<String> wordBank = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        used.add(beginWord);
        int step = 1;
        
        while(!q.isEmpty()){
            int curSize = q.size();
            for (int i=0; i<curSize ;i++) {
                String cur = q.poll();
                char[] wordArray = cur.toCharArray();
                for (int j = 0; j < wordlen; j++) {

                    char originChar = wordArray[j];

                    for(char k = 'a'; k <='z'; k++) {
                        if (k == wordArray[j]) continue;
                        wordArray[j] = k;
                        String nextWord = String.valueOf(wordArray);



                        if (wordBank.contains(nextWord)) {
                            if (nextWord.equals(endWord)) return step+1;
                            if (!used.contains(nextWord)) {
                                q.add(nextWord);
                                used.add(nextWord);
                            }
                        }
                        
                    }
                    wordArray[j] = originChar;
                }
                
            }
            step++;
        }
        return 0;
    
    }
}