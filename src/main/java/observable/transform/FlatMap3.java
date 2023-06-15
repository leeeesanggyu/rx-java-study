package observable.transform;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;

/**
 * FlatMap을 활용한 구구단 2단 출력
 */
public class FlatMap3 {
    public static void main(String[] args) {
        Observable.range(2, 1)
                .flatMap(
                        dan -> Observable.range(1, 9),
                        (sourceData, transformData) -> sourceData + " * " + transformData + " = " + sourceData * transformData
                )
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
