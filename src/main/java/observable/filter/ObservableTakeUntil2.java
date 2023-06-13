package observable.filter;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;
import log.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * 파라미터로 받은 Flowable/Observable이 최초로 데이터를 발행할 때까지 계속 데이터를 발행
 * timer와 함께 사용하여 특정 시점이 되기 전까지 데이터를 발행하는데 활용
 */
public class ObservableTakeUntil2 {
    public static void main(String[] args) {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .takeUntil(Observable.timer(5000L, TimeUnit.MILLISECONDS))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(10000L);
    }
}