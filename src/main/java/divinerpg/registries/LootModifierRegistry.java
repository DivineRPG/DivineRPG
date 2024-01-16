package divinerpg.registries;

import com.mojang.serialization.Codec;
import divinerpg.DivineRPG;
import divinerpg.loot_modifiers.*;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.*;

public class LootModifierRegistry {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DivineRPG.MODID);

    public static final  DeferredHolder<Codec<? extends IGlobalLootModifier>, Codec<SpawnBonusChestModifier>> SPAWN_BONUS_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("spawn_bonus_modifier", SpawnBonusChestModifier.CODEC);
    public static final DeferredHolder<Codec<? extends IGlobalLootModifier>, Codec<AbandonedMineshaftChestModifier>> ABANDONED_MINESHAFT_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("abandoned_mineshaft_modifier", AbandonedMineshaftChestModifier.CODEC);
    public static final DeferredHolder<Codec<? extends IGlobalLootModifier>, Codec<JungleTempleChestModifier>> JUNGLE_TEMPLE_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("jungle_temple_modifier", JungleTempleChestModifier.CODEC);
    public static final DeferredHolder<Codec<? extends IGlobalLootModifier>, Codec<UnderwaterRuinBigModifier>> UNDERWATER_RUIN_BIG_MODIFIER = GLOBAL_LOOT_MODIFIERS.register("underwater_ruin_big_modifier", UnderwaterRuinBigModifier.CODEC);
}