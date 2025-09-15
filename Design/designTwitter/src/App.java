package Design.designTwitter.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Twitter {
    private static int time;
    HashMap<Integer, List<int[]>> tweet;
    HashMap<Integer, HashSet<Integer>> follow;

    public Twitter() {
        time = 0;
        tweet = new HashMap<>();
        follow = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        List<int[]> list = tweet.getOrDefault(userId, new ArrayList<>());
        list.add(new int[] { time++, tweetId });
        tweet.put(userId, list);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        HashSet<Integer> set = follow.getOrDefault(userId, new HashSet<>());

        set.add(userId);
        for (int i : set) {
            List<int[]> temp = tweet.getOrDefault(i, new ArrayList<>());
            for (int[] j : temp)
                maxHeap.add(j);
        }

        List<Integer> answer = new ArrayList<>();
        while (!maxHeap.isEmpty() && answer.size() < 10)
            answer.add(maxHeap.poll()[1]);

        return answer;
    }

    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = follow.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        follow.put(followerId, set);
    }

    public void unfollow(int followerId, int followeeId) {
        follow.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */