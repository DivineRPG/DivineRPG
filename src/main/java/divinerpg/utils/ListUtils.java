package divinerpg.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class ListUtils {

    /**
     * Selects recursive the whole tree
     *
     * @param source     - source collection
     * @param selectFunc - recursve function
     * @param <T>
     * @return
     */
    public static <T> Collection<T> selectRecursive(Collection<T> source, Function<T, Collection<T>> selectFunc) {
        List<T> result = new ArrayList<>(source);

        for (T t : result) {
            Collection<T> children = selectFunc.apply(t);
            if (children != null && !children.isEmpty()) {
                result.addAll(selectRecursive(children, selectFunc));
            }
        }

        return result;
    }
}
