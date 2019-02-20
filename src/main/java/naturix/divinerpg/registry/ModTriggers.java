package naturix.divinerpg.registry;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import naturix.divinerpg.events.advancementtriggers.AdvancementSpawnPet;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ModTriggers

{
	public static final AdvancementSpawnPet SPAWN_PET = new AdvancementSpawnPet("spawn_pet");

	public static final AdvancementSpawnPet[] TRIGGER_ARRAY = new AdvancementSpawnPet[] { SPAWN_PET };

	public static void registerTriggers() {
		System.out.println("Registering custom triggers");

		Method method;

		method = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a",
		        ICriterionTrigger.class);

		method.setAccessible(true);

		for (int i = 0; i < TRIGGER_ARRAY.length; i++) {
			try {
				method.invoke(null, TRIGGER_ARRAY[i]);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}