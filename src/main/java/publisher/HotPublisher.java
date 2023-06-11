package publisher;

import io.reactivex.processors.PublishProcessor;

public class HotPublisher {
    public static void main(String[] args) {
        PublishProcessor<String> processor = PublishProcessor.create();
        processor.onNext("a");

        processor.subscribe(data -> System.out.println("구독자1 : " + data));
        processor.onNext("b");
        processor.onNext("c");

        processor.subscribe(data -> System.out.println("구독자2 : " + data));
        processor.onNext("d");
    }
}
