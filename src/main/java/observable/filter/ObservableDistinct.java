package observable.filter;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;

import java.util.List;

public class ObservableDistinct {
    public static void main(String[] args) {
        List<String> name = List.of("lee", "lee", "kem", "aaa");

        Observable.fromIterable(name)
                .distinct(data -> data.split("")[1])
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        System.out.println("--------------------");

        Observable.fromIterable(name)
                .distinct()
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
