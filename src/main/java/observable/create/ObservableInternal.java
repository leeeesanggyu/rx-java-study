package observable.create;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;
import log.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * Polling 용도로 주로 사용
 */
public class ObservableInternal {
    public static void main(String[] args) {
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
                .map(num -> num + " count")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3000);
    }
}
