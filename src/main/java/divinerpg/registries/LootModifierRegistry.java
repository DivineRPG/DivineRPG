package divinerpg.registries;

import com.mojang.serialization.Codec;
import divinerpg.DivineRPG;
import divinerpg.loot_modifiers.*;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.*;

public class LootModifierRegistry {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DivineRPG.MODID);

    public static final RegistryObject<Codec<SpawnBonusChestModifier>> SPAWN_BONUS_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("spawn_bonus_modifier", SpawnBonusChestModifier.CODEC);
    public static final RegistryObject<Codec<AbandonedMineshaftChestModifier>> ABANDONED_MINESHAFT_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("abandoned_mineshaft_modifier", AbandonedMineshaftChestModifier.CODEC);
    public static final RegistryObject<Codec<JungleTempleChestModifier>> JUNGLE_TEMPLE_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("jungle_temple_modifier", JungleTempleChestModifier.CODEC);
    public static final RegistryObject<Codec<UnderwaterRuinBigModifier>> UNDERWATER_RUIN_BIG_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("underwater_ruin_big_modifier", UnderwaterRuinBigModifier.CODEC);
}