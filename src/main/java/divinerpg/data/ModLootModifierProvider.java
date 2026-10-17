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

public class ModLootModifierProvider extends GlobalLootModifierProvider {
    public ModLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> reloadable, String modid) {
        super(output, reloadable, modid);
    }

    @Override
    protected void start() {
        add("abandoned_mineshaft_chest", new AbandonedMineshaftChestModifier(createCondition(vanillaLootTable("chests/abandoned_mineshaft")), 1));
        add("jungle_temple_chest", new AbandonedMineshaftChestModifier(createCondition(vanillaLootTable("chests/jungle_temple")), 1));
        add("spawn_bonus_chest", new SpawnBonusChestModifier(createCondition(vanillaLootTable("chests/spawn_bonus")), 1));
        add("underwater_ruin_big", new UnderwaterRuinBigModifier(createCondition(vanillaLootTable("chests/underwater_ruin_big")), 1));
    }

    private static Optional<Holder<LootItemCondition>> createCondition(Identifier lootTableId) {
        return Optional.of(Holder.direct(LootTableIdCondition.builder(lootTableId).build()));
    }

    private static Identifier vanillaLootTable(String path) {
        return Identifier.fromNamespaceAndPath("minecraft", path);
    }
}