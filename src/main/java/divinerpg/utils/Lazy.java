package divinerpg.utils;

import net.minecraft.util.LazyLoadBase;

import java.util.Objects;
import java.util.function.Supplier;

public class Lazy<T> extends LazyLoadBase<T> {

    private Supplier<T> func;

    public Lazy(Supplier<T> func) {
        this.func = func;

        Objects.requireNonNull(func);
    }

    @Override
    protected T load() {
        return func.get();
    }
}
