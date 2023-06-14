package observable.transform;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;

import java.util.List;

public class map {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(1, 2, 3, 4);

        Observable.fromIterable(numberList)
                .map(number -> number * 3)
                .subscribe(number -> Logger.log(LogType.ON_NEXT, number));
    }
}
