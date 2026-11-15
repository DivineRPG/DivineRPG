package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.EnchantmentRegistry.*;
import static divinerpg.registries.TagRegistry.Enchantments.*;

public class ModEnchantmentTagsProvider extends EnchantmentTagsProvider {
    public ModEnchantmentTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }
    @SuppressWarnings("unchecked")
    @Override protected void addTags(HolderLookup.Provider registries) {
        tag(Tags.Enchantments.WEAPON_DAMAGE_ENHANCEMENTS).add(AFTERSHOCK);

        tag(EnchantmentTags.NON_TREASURE).add(RIVE, AFTERSHOCK);
        tag(EnchantmentTags.TREASURE).add(BRAIN_FREEZE, INSULATION);

        tag(EXCLUSIVE_SET_EFFECT).add(Enchantments.FIRE_ASPECT, BRAIN_FREEZE);
    }
}