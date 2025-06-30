package divinerpg.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.registries.*;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.world.damagesource.DamageEffects.BURNING;

public class DamageRegistry {
    public static final DeferredRegister<DamageType> DAMAGE_TYPE = DeferredRegister.create(Registries.DAMAGE_TYPE, MODID);
    public static final DeferredHolder<DamageType, DamageType>
        ACID = register("acid", .1F),
        ARCANA = register("arcana", 0),
        SPIKE = register("spike", .1F),
        TAR = DAMAGE_TYPE.register("tar", () -> new DamageType("tar", .1F, BURNING)),
        TURTLE = register("turtle", .1F);
    private static DeferredHolder<DamageType, DamageType> register(String name, float exhaustion) {
        return DAMAGE_TYPE.register(name, () -> new DamageType(name, exhaustion));
    }
}