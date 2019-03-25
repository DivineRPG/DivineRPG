package naturix.divinerpg.registry;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import naturix.divinerpg.events.advancementtriggers.AdvancementSpawnPet;
import naturix.divinerpg.events.advancementtriggers.AdvancementTenHeads;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ModTriggers

{
	public static final AdvancementSpawnPet SPAWN_PET = new AdvancementSpawnPet("spawn_pet");
	public static final AdvancementTenHeads TEN_HEADS = new AdvancementTenHeads("ten_heads");
	public static final AdvancementTenHeads SIX_ONE = new AdvancementTenHeads("six_one");

	public static final AdvancementSpawnPet[] TRIGGER_ARRAY = new AdvancementSpawnPet[] { SPAWN_PET };
	public static final AdvancementTenHeads[] TRIGGER_ARRAY1 = new AdvancementTenHeads[] { TEN_HEADS };
	public static final AdvancementTenHeads[] TRIGGER_ARRAY2 = new AdvancementTenHeads[] { SIX_ONE };

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
		for (int i = 0; i < TRIGGER_ARRAY1.length; i++) {
			try {
				method.invoke(null, TRIGGER_ARRAY1[i]);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < TRIGGER_ARRAY2.length; i++) {
			try {
				method.invoke(null, TRIGGER_ARRAY2[i]);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}