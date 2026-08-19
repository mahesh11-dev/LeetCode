class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }
        int result = (n - map.size())*2;

        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {

            HashSet<Integer> seats = entry.getValue();

            boolean grpA =
                    !seats.contains(2) &&
                    !seats.contains(3) &&
                    !seats.contains(4) &&
                    !seats.contains(5);

            boolean grpB =
                    !seats.contains(4) &&
                    !seats.contains(5) &&
                    !seats.contains(6) &&
                    !seats.contains(7);

            boolean grpC =
                    !seats.contains(6) &&
                    !seats.contains(7) &&
                    !seats.contains(8) &&
                    !seats.contains(9);

            if (grpA && grpC) {
                result += 2;
            } 
            else if (grpA || grpB || grpC) {
                result += 1;
            }
        }

        return result;
    }
}