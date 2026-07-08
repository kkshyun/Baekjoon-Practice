class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        new_id = new_id.toLowerCase();
        for(char c : new_id.toCharArray()) {
            if(Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.')
                sb.append(c);
        }
        
        new_id = sb.toString();
        sb = new StringBuilder();
        
        // 3단계
        for(int i = 0 ; i < new_id.length(); i++) {
            if(new_id.charAt(i) == '.') {
                if(sb.length() == 0 || sb.charAt(sb.length() - 1) != '.') {
                    sb.append('.');
                }
            } else {
                sb.append(new_id.charAt(i));
            }
        }
        new_id = sb.toString();
        sb = new StringBuilder();
        if(new_id.length() > 0 && new_id.charAt(0) == '.')
            new_id = new_id.substring(1,new_id.length());
        if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.')
            new_id = new_id.substring(0,new_id.length()-1);
        
        if(new_id.equals(""))
            new_id = "a";
        
        if(new_id.length() >= 16)
            new_id = new_id.substring(0,15);
        if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.')
            new_id = new_id.substring(0,new_id.length()-1);
        
        sb = new StringBuilder(new_id);
        if(new_id.length() <= 2) {
            char end = new_id.charAt(new_id.length()-1);
            while(sb.length()<3) {
                sb.append(end);
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}