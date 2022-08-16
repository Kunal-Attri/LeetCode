package leetcode;

public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
	public int numSteps(String s) {
        int res = 0;
        boolean carry = false;
        
        for (int i = s.length()-1; i > 0; i--) {
            if (s.charAt(i) == '1') {
                res += carry ? 1 : 2;
                carry = true;
            } else {
                res += carry ? 2 : 1;
            }
        }
        
        if (carry) {
            res++;
        }
        
        return res;
    }
}
