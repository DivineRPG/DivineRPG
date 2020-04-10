package divinerpg.utils.tasks;

import net.minecraft.util.IThreadListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

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

    /**
     * Subscribes on next server tick and execute task on very next tick
     */
    public void executeOnNextTick() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent e) {
        if (e.phase == TickEvent.Phase.END) {
            MinecraftForge.EVENT_BUS.unregister(this);

            // already schedule executing and can't stop this
            isExecuting = true;

            listener.addScheduledTask(() -> {
                try {
                    task.execute();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    onFinish.accept(task);
                }
            });
        }
    }
}
