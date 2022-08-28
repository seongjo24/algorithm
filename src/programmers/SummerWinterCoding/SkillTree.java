package programmers.SummerWinterCoding;

class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i = 0; i < skill_trees.length; i++){
            String skill_tree = skill_trees[i];
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < skill_tree.length(); j++){
                if(skill.contains(String.valueOf(skill_tree.charAt(j)))){
                    sb.append(skill_tree.charAt(j));
                }
            }

            for(int j = skill.length(); j > -1; j--){
                String s = skill.substring(0, j);
                if(s.equals(sb.toString())){
                    answer++;
                    break;
                }
            }

        }
        return answer;
    }
}