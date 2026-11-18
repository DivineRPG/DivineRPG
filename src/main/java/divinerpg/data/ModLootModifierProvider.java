package divinerpg.data;

import divinerpg.loot_modifiers.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.LootModifierRegistry.*;

public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> reloadable) {
        super(output, reloadable, MODID);
    }
    @Override protected void start() {
        add(ABANDONED_MINESHAFT_MODIFIER.getId().getPath(), new AbandonedMineshaftChestModifier(condition("chests/abandoned_mineshaft"), 1));
        add(JUNGLE_TEMPLE_MODIFIER.getId().getPath(), new JungleTempleChestModifier(condition("chests/jungle_temple"), 1));
        add(SPAWN_BONUS_MODIFIER.getId().getPath(), new SpawnBonusChestModifier(condition("chests/spawn_bonus"), 1));
        add(UNDERWATER_RUIN_BIG_MODIFIER.getId().getPath(), new UnderwaterRuinBigModifier(condition("chests/underwater_ruin_big"), 1));
    }
    private static Optional<Holder<LootItemCondition>> condition(String path) {
        return Optional.of(Holder.direct(LootTableIdCondition.builder(Identifier.withDefaultNamespace(path)).build()));
    }
}