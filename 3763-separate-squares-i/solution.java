class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double minY = 2e9;
        double maxY = 0;

          for (int[] s : squares) {
            long l = s[2];
            totalArea += (double) l * l;
            minY = Math.min(minY, s[1]);
            maxY = Math.max(maxY, (double) s[1] + l);
        }

        double target = totalArea / 2.0;
        double low = minY;
        double high = maxY;

        for (int i = 0; i < 100; i++) {
            double mid = low + (high - low) / 2.0;
            if (calculateAreaBelow(squares, mid) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private double calculateAreaBelow(int[][] squares, double mid) {
        double area = 0;
        for (int[] s : squares) {
            double y = s[1];
            double l = s[2];
            
            if (mid <= y) {
                
                continue; 
            } else if (mid >= y + l) {
                
                area += l * l;
            } else {
              
                area += (mid - y) * l;
            }
        }
        return area;
    }
    
}
