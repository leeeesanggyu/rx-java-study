package observable;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;

/**
 * 반복문으로 사용 가능
 */
public class ObservableRange {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(0, 5);
        source.map(number -> number + " count")
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
