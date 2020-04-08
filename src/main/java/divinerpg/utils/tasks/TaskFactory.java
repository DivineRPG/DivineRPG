package divinerpg.utils.tasks;

import net.minecraft.util.IThreadListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public abstract class TaskFactory<T extends Event> {
    private final Map<UUID, ScheduledTask<T>> playerTasks = new ConcurrentHashMap<>();
    private Function<T, UUID> findActorFunc;

    protected TaskFactory(Function<T, UUID> findActorFunc) {
        this.findActorFunc = findActorFunc;
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Creating new task from player ID and event
     *
     * @param id
     * @param event
     * @return
     */
    protected abstract ITask<T> createTask(UUID id, T event);

    /**
     * Should we proceed current event?
     * Brand new for each player
     *
     * @param event - event
     * @return
     */
    protected abstract boolean shouldProceed(T event);

    /**
     * Gets thread listener from event
     *
     * @param event
     * @return
     */
    protected abstract IThreadListener getListener(T event);

    /**
     * Should called on every implementation.
     * Create a method with @SubscribeEvent
     *
     * @param event
     */
    public void listen(T event) {
        if (event == null)
            return;

        // getting actor from event
        UUID id = findActorFunc.apply(event);
        if (id == null)
            return;

        // find task on current player
        ScheduledTask<T> task = playerTasks.get(id);

        if (task != null) {

            // check should we merge work with current event
            if (task.shouldMerge(event)) {
                // merging work and set delay
                task.getTask().merge(event);
            }
        } else {
            if (shouldProceed(event)) {
                ITask<T> newTask = createTask(id, event);

                if (newTask != null) {
                    newTask.merge(event);
                    ScheduledTask<T> scheduledTask = new ScheduledTask<>(getListener(event), newTask, x -> playerTasks.remove(x.getActor()));
                    playerTasks.put(id, scheduledTask);

                    scheduledTask.schedule();
                }
            }
        }
    }
}
