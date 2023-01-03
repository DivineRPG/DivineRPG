package divinerpg.loot_modifiers;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.DivineRPG;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.*;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AbandonedMineshaftChestModifier extends LootModifier {
    public static final Supplier<Codec<AbandonedMineshaftChestModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, AbandonedMineshaftChestModifier::new)));

    protected AbandonedMineshaftChestModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    @NotNull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() <= 0.5){
            ItemStack toAdd = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "realmite_pickaxe")), 1);
            generatedLoot.add(toAdd);
        }
        if (context.getRandom().nextFloat() <= 0.3){
            ItemStack toAdd = new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleton_torch")), 4 + context.getRandom().nextInt(4));
            generatedLoot.add(toAdd);
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
