package observable.filter;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;
import log.TimeUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Quiz {
    public static void main(String[] args) {
        quiz1();
        quiz2();
        quiz3();
        quiz4();
    }

    /**
     * range, skipLast를 이용하여 1부터 15까지의 숫자 중에서 마지막에 발행된 숫자 3개를 제외한 나머지 숫자를 출력
     */
    private static void quiz4() {
        Observable.range(1, 15)
                .skipLast(3)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }

    /**
     * interval, skipUntil, timer를 이용하여 1초에 한번씩 발행된 데이터 중에서 3초 후에 발행된 데이터만 10까지 출력
     */
    private static void quiz3() {
        Observable.interval(1000L, TimeUnit.MILLISECONDS)
                .skipUntil(Observable.timer(3000L, TimeUnit.MILLISECONDS))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
        TimeUtil.sleep(10000L);
    }

    /**
     * interval, takeWhile을 이용하여 발행된 숫자가 10이 아닌동안 데이터를 1초에 한번씩 계속 출력
     */
    private static void quiz2() {
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
                .takeWhile(data -> data < 10)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
        TimeUtil.sleep(10000L);
    }

    /**
     * filter를 이용하여 데이터 필터링 후 출력
     */
    private static void quiz1() {
        List<String> name = List.of("lee", "kim", "law", "lol");
        Observable.fromIterable(name)
                .filter(data -> data.contains("l"))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
