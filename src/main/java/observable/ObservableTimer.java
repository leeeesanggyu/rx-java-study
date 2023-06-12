package observable;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;
import log.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * 설정한 시간이 지난 후에 동작을 수행할때 활용
 */
public class ObservableTimer {
    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# start");

        Observable<String> timer = Observable.timer(2000, TimeUnit.MILLISECONDS)
                .map(count -> "do work");

        timer.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
        TimeUtil.sleep(5000);
    }
}
