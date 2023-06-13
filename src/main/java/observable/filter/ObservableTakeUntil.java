package observable.filter;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;

import java.util.List;

public class ObservableTakeUntil {
    public static void main(String[] args) {
        List<String> name = List.of("lee", "kim", "park", "choi");

        Observable.fromIterable(name)
                .takeUntil((String data) -> data.equals("kim"))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}