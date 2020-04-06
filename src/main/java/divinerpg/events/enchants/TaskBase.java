package divinerpg.events.enchants;

import net.minecraft.util.IThreadListener;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class TaskBase {
    /**
     * Single list of performing tasks
     */
    public final static Queue<TaskBase> tasksQueue = new ConcurrentLinkedQueue<>();

    private final IThreadListener listener;

    protected TaskBase(IThreadListener listener) {
        this.listener = listener;

        Objects.requireNonNull(listener);
    }

    public final void perform() {
        // if already working, do not need to start
        if (tasksQueue.contains(this))
            return;

        onRegister();

        listener.addScheduledTask(() -> {
            try {
                start();
            } finally {
                tasksQueue.remove(this);
            }
        });
    }

    /**
     * Register itself in task collection
     */
    protected void onRegister() {
        tasksQueue.add(this);
    }

    /**
     * Do the main work.
     */
    protected abstract void start();
}
