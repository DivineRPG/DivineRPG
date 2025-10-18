package divinerpg.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.registries.*;

import static divinerpg.DivineRPG.MODID;

public class DamageRegistry {
    public static final DeferredRegister<DamageType> DAMAGE_TYPE = DeferredRegister.create(Registries.DAMAGE_TYPE, MODID);
    public static final DeferredHolder<DamageType, DamageType>
        ACID = register("acid", .1F),
        ARCANA = register("arcana", 0),
        HAIL = register("hail", .1F),
        SPIKE = register("spike", .1F),
        TAR = register("tar", .1F),
        TURTLE = register("turtle", .1F);
    //TODO? Why is there no DamageType(name) constructor, the rest of the info is presented in data anyways
    private static DeferredHolder<DamageType, DamageType> register(String name, float exhaustion) {
        return DAMAGE_TYPE.register(name, () -> new DamageType(name, exhaustion));
    }
}