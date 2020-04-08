package divinerpg.utils.tasks;

import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.function.Consumer;

public class ScheduledTask<T extends Event> {
    private final ITask<T> task;
    private IThreadListener listener;
    private Consumer<ITask<T>> onFinish;
    private boolean isExecuting;

    public ScheduledTask(IThreadListener listener, ITask<T> task, Consumer<ITask<T>> onFinish) {
        this.listener = listener;
        this.task = task;
        this.onFinish = onFinish;
    }

    public boolean schedule() {
        listener.addScheduledTask(() -> {
            isExecuting = true;
            task.execute();
            onFinish.accept(task);
        });

        return true;
    }

    public ITask<T> getTask() {
        return task;
    }

    /**
     * Can merge new events only if not already executing.
     * Avoid cascading execution
     *
     * @param event
     * @return
     */
    public boolean shouldMerge(T event) {
        return !isExecuting && getTask().shouldMerge(event);
    }
}
