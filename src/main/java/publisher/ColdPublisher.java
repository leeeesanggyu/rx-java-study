package publisher;

import io.reactivex.Flowable;

public class ColdPublisher {
    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("a", "b", "c", "d");
        flowable.subscribe(data -> System.out.println("구독자1 : " + data));
        flowable.subscribe(data -> System.out.println("구독자2 : " + data));
    }
}
