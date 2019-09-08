package divinerpg.api;

/**
 * Executes action at one time only once
 */
public class ActionArbiter {
    private boolean isExecuting;

    /**
     * Executes only action at one time
     *
     * @param runnable
     */
    public void Do(Runnable runnable) {
        if (isExecuting) {
            return;
        }

        try {
            isExecuting = true;
            runnable.run();
        } finally {
            isExecuting = false;
        }
    }
}
