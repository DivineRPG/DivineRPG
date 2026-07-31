package divinerpg.loot_modifiers;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class SpawnBonusChestModifier extends LootModifier {
    public static final MapCodec<SpawnBonusChestModifier> CODEC = RecordCodecBuilder.mapCodec(
            instance -> codecStart(instance).apply(instance, SpawnBonusChestModifier::new)
    );

    public SpawnBonusChestModifier(LootItemCondition[] conditionsIn, int priority) {
        super(conditionsIn, priority);
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() <= 0.2F) {
            generatedLoot.add(new ItemStack(BlockRegistry.divineLog.get().asItem(), 1 + context.getRandom().nextInt(3)));
        }
        if(context.getRandom().nextFloat() <= 0.1F) {
            generatedLoot.add(new ItemStack(ItemRegistry.tomato.get(), 1 + context.getRandom().nextInt(3)));
        }
        if(context.getRandom().nextFloat() <= 0.4F) {
            generatedLoot.add(new ItemStack(ItemRegistry.chicken_dinner.get(), 1));
        }
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}