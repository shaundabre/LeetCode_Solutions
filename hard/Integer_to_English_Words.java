// class Solution {

//     HashMap<Integer, String> belowTen = {{0, ""}, {1, "One"}, {2, "Two"}, {3, "Three"}, {4, "Four"}, 
//     {5, "Five"}, {6, "Six"}, {7, "Seven"}, {8, "Eight"}, {9, "Nine"}};

//     HashMap<Integer, String> belowTwenty = {{10, "Ten"}, {11, "Eleven"}, {12, "Twelve"}, {13, "Thirteen"}, 
//     {14, "Fourteen"}, {15, "Fifteen"}, {16, "Sixteen"}, {17, "Seventeen"}, {18, "Eighteen"}, {19, "Nineteen"}};

//     HashMap<Integer, String> belowHundred = {{20, "Twenty"}, {30, "Thirty"}, {40, "Fourty"}, {50, "Fifty"}, 
//     {60, "Sixty"}, {70, "Seventy"}, {80, "Eighty"}, {90, "Ninety"}};

//     public String solveNum(int num){
//         if(num < 10) return belowTen[num];

//         if(num < 20) return belowTwenty[num];

//         if(num < 100) return belowHundred[num/10]  + (num%10 != 0 ? " " + belowTen[num%10] : "");

//         if(num < 1000) return solveNum(num/100) + " Hundred" + (num%100 != 0 ? " " + solveNum(num%10) : "");

//         if(num < 1000000) return solveNum(num/1000) + " Thousand" + (num%1000 != 0 ? " " + solveNum(num%1000) : "");

//         if(num < 1000000000) return solveNum(num/1000000) + " Million" + (num%1000000 != 0 ? " " + solveNum(num%1000000) : "");

//         return solveNum(num/1000000000) +" Billion" + (num%1000000000 != 0 ? " " + solveNum(num%1000000000) : "");
//     }

//     public String numberToWords(int num) {
//         if(num == 0) return "Zero";

//         return solveNum(num);
//     }
// }


import java.util.HashMap;

class Solution {

    HashMap<Integer, String> belowTen = new HashMap<>();
    HashMap<Integer, String> belowTwenty = new HashMap<>();
    HashMap<Integer, String> belowHundred = new HashMap<>();

    public Solution() {
        belowTen.put(0, "");
        belowTen.put(1, "One");
        belowTen.put(2, "Two");
        belowTen.put(3, "Three");
        belowTen.put(4, "Four");
        belowTen.put(5, "Five");
        belowTen.put(6, "Six");
        belowTen.put(7, "Seven");
        belowTen.put(8, "Eight");
        belowTen.put(9, "Nine");

        belowTwenty.put(10, "Ten");
        belowTwenty.put(11, "Eleven");
        belowTwenty.put(12, "Twelve");
        belowTwenty.put(13, "Thirteen");
        belowTwenty.put(14, "Fourteen");
        belowTwenty.put(15, "Fifteen");
        belowTwenty.put(16, "Sixteen");
        belowTwenty.put(17, "Seventeen");
        belowTwenty.put(18, "Eighteen");
        belowTwenty.put(19, "Nineteen");

        belowHundred.put(20, "Twenty");
        belowHundred.put(30, "Thirty");
        belowHundred.put(40, "Forty");
        belowHundred.put(50, "Fifty");
        belowHundred.put(60, "Sixty");
        belowHundred.put(70, "Seventy");
        belowHundred.put(80, "Eighty");
        belowHundred.put(90, "Ninety");
    }

    public String solveNum(int num) {
        if(num < 10) return belowTen.get(num);

        if(num < 20) return belowTwenty.get(num);

        if(num < 100) return belowHundred.get((num/10) * 10) + (num % 10 != 0 ? " " + belowTen.get(num % 10) : "");

        if(num < 1000) return solveNum(num / 100) + " Hundred" + (num % 100 != 0 ? " " + solveNum(num % 100) : "");

        if(num < 1000000) return solveNum(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + solveNum(num % 1000) : "");

        if(num < 1000000000) return solveNum(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + solveNum(num % 1000000) : "");

        return solveNum(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + solveNum(num % 1000000000) : "");
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        return solveNum(num);
    }
}
