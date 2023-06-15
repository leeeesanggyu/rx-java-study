package observable.transform;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;

/**
 * FlatMap을 활용한 1:다 mapping 예제
 */
public class FlatMap {
    public static void main(String[] args) {
        Observable.just("Hello")
                .flatMap(
                        hello -> Observable.just("lee", "kim", "park")
                                .map(name -> hello + ", " + name)
                )
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
