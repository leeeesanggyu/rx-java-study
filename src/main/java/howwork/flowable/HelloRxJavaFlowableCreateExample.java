package howwork.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import log.LogType;
import log.Logger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class HelloRxJavaFlowableCreateExample {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable =
                Flowable.create(new FlowableOnSubscribe<String>() {
                    @Override
                    public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                        String[] datas = {"Hello", "RxJava!"};
                        for(String data : datas) {
                            if (emitter.isCancelled())  // 구독이 해지되면 처리 중단
                                return;
                            emitter.onNext(data);   // 데이터 통지
                        }

                        emitter.onComplete();   // 데이터 통지 완료를 알린다
                    }
                }, BackpressureStrategy.BUFFER); // 구독자의 처리가 늦을 경우 데이터를 버퍼에 담아두는 설정.

        flowable.observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {
                    private Subscription subscription;  // 데이터 개수 요청 및 구독을 취소하기 위한 Subscription 객체

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        this.subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(String data) {
                        Logger.log(LogType.ON_NEXT, data);
                    }

                    @Override
                    public void onError(Throwable error) {
                        Logger.log(LogType.ON_ERROR, error);
                    }

                    @Override
                    public void onComplete() {
                        Logger.log(LogType.ON_COMPLETE);
                    }
                });

        Thread.sleep(500L);
    }
}
