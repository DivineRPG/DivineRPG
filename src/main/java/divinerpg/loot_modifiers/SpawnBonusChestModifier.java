package divinerpg.loot_modifiers;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.DivineRPG;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class SpawnBonusChestModifier extends LootModifier {
    public static final Supplier<Codec<SpawnBonusChestModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, SpawnBonusChestModifier::new)));

    protected SpawnBonusChestModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    @NotNull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() <= 0.2){
            ItemStack toAdd = new ItemStack(BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "divine_log")), 1 + context.getRandom().nextInt(3));
            generatedLoot.add(toAdd);
        }
        if (context.getRandom().nextFloat() <= 0.1){
            ItemStack toAdd = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "tomato")), 1 + context.getRandom().nextInt(3));
            generatedLoot.add(toAdd);
        }
        if (context.getRandom().nextFloat() <= 0.4){
            ItemStack toAdd = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(DivineRPG.MODID, "chicken_dinner")), 1);
            generatedLoot.add(toAdd);
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
