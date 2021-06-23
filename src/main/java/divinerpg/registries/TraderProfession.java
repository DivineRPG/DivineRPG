package divinerpg.registries;

import com.google.common.collect.*;
import divinerpg.*;
import net.minecraft.entity.merchant.villager.*;
import net.minecraft.village.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class TraderProfession {
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, DivineRPG.MODID);

    public static final RegistryObject<VillagerProfession> TRADER = PROFESSIONS.register("trader", () -> new VillagerProfession("trader", PointOfInterestType.UNEMPLOYED, ImmutableSet.of(), ImmutableSet.of(), null));
}