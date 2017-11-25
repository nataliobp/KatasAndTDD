package test.java.com.natalio.bankkata;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final String originalNumber;
    private List<String> data = new ArrayList<>();

    public Solution(String originalNumber) {
        this.originalNumber = originalNumber;
    }

    public void addSolution(String number){
        data.add(number);
    }

    @Override
    public String toString() {
        if(data.size() == 1){
            return data.get(0);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s AMB ['%s'", originalNumber, data.get(0)));
        data.remove(0);

        for(String aSolution : data){
            sb.append(String.format(", '%s'", aSolution));
        }

        return sb.append("]").toString();
    }
}
