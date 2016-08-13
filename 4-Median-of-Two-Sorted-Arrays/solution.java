public class Solution {
    
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int m = A.length, n = B.length;
        if(m > n) {
            return findMedianSortedArrays(B, A);
        }
        int imin = 0, imax = m, half_len = (m + n + 1) / 2;
        while(imin <= imax) {
            int i = (imin + imax) / 2;
            int j = half_len - i;
            if(j > 0 && i < m && B[j - 1] > A[i]) {
                imin = i + 1;
            } else if(i > 0 && j < n && A[i - 1] > B[j]) {
                imax = i - 1;
            } else {
                int max_of_left = 0, min_of_right = 0;
                if(i == 0)
                    max_of_left = B[j - 1];
                else if (j == 0)
                    max_of_left = A[i - 1];
                else 
                    max_of_left = Math.max(A[i - 1], B[j - 1]);
                
                if((m + n) % 2 == 1) {
                    return max_of_left;
                } 
                
                if(i == m)
                    min_of_right = B[j];
                else if(j == n)
                    min_of_right = A[i];
                else {
                    min_of_right = Math.min(A[i], B[j]);
                }
                return (max_of_left + min_of_right) / 2.0;
            }
        }
        return 0;
    }
    
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        
        if(len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }
    
    private int findKth(int[] A, int i, int[] B, int j, int k) {
        if(i >= A.length)
            return B[j + k - 1];
        if(j >= B.length)
            return A[i + k - 1];
        
        if(k == 1)
            return Math.min(A[i], B[j]);
        
        
        if(i + k/2 - 1 >= A.length)
            return findKth(A, i, B, j + k / 2, k - k/2);
        if(j + k/2 - 1 >= B.length)
            return findKth(A, i + k / 2, B, j, k - k/2);
        
        if(A[i + k/2 - 1] < B[j + k/2 - 1]) {
            return findKth(A, i + k/2, B, j, k - k/2);
        } else {
            return findKth(A, i, B, j + k/2, k - k/2);
        }
        
    }
}