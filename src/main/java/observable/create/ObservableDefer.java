package observable.create;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;

import java.time.LocalDateTime;

/**
 * 실제 구독이 발생할 떄 새로운 Observable을 생성한다.
 * defer()를 활용하면 데이터 흐름 생성을 지연하는 효과를 보여준다.
 */
public class ObservableDefer {
    public static void main(String[] args) throws InterruptedException {
        Observable<LocalDateTime> defer = Observable.defer(() -> Observable.just(LocalDateTime.now()));
        Observable<LocalDateTime> just = Observable.just(LocalDateTime.now());

        defer.subscribe(data -> Logger.log(LogType.ON_NEXT, "defer1 시간 : " + data));
        just.subscribe(data -> Logger.log(LogType.ON_NEXT, "just1 시간 : " + data));

        Thread.sleep(5000);

        defer.subscribe(data -> Logger.log(LogType.ON_NEXT, "defer2 시간 : " + data));
        just.subscribe(data -> Logger.log(LogType.ON_NEXT, "just2 시간 : " + data));
    }
}
