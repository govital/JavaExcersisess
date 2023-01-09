class Twitter {
    private Map<Integer, Set<Integer>> follows = new HashMap();
    private Map<Integer, Queue<Tweet>> tweets = new HashMap();
    int ts=0;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)){
            tweets.put(userId, new PriorityQueue(10, Collections.reverseOrder()));
        }
        while(tweets.get(userId).size()>9)tweets.get(userId).poll();
        tweets.get(userId).add(new Tweet(userId, tweetId, ts++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Queue<Tweet> q = new PriorityQueue();
        List<Integer> retval = new ArrayList();
        //  in user follows follow no one - add himself to q for next logic.
        if(!follows.containsKey(userId)){
            follows.put(userId, new HashSet<>());
        }
        follows.get(userId).add(userId);
        //for each followee (including user himself - add to queue)
        for(Integer uid: follows.get(userId)){
            if(!tweets.containsKey(uid))continue;
            q.addAll(tweets.get(uid));
            Queue<Tweet> tq = new PriorityQueue();
            if (q.size()>10){
                while(tq.size()<10){
                    tq.add(q.poll());tq.add(q.poll());
                }
            }
            if(!tq.isEmpty()){
                q.clear();
                q.addAll(tq);
            }
        }
        while(q.size()>0)retval.add(q.poll().tid);
        //remove user himself from his q uf followees
        follows.get(userId).remove(userId);
        return retval;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followeeId==followerId)return;
        if(!follows.containsKey(followerId)){
            follows.put(followerId, new HashSet<>());
        }
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId))return;
        follows.get(followerId).remove(followeeId);
    }
}

public class Tweet implements Comparable<Tweet>{
    public final int uid;
    public final int tid;
    public final int ts;

    public Tweet(int uid, int tid, int ts) {
        this.uid = uid;
        this.tid = tid;
        this.ts = ts;
    }

    @Override
    public int compareTo(Tweet o) {
        return o.ts-this.ts;
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
