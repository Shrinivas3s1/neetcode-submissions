class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resIndex = 0;

        // Deque stores the indices of elements in the current window.
        // The values corresponding to these indices are kept in strictly decreasing order.
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window (i - k + 1 is the start of the window)
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove elements from the back of the deque that are smaller than the current element
            // Because they can never be the maximum while the current element is in the window.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add the current element's index to the back
            deque.offerLast(i);

            // 4. Record the maximum for the current window (front of the deque holds the max index)
            if (i >= k - 1) {
                result[resIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
