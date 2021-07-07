package divinerpg.compat;

import divinerpg.*;
import divinerpg.registries.*;
import mezz.jei.api.*;
import mezz.jei.api.constants.*;
import mezz.jei.api.registration.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

@JeiPlugin
public final class JEICompat implements IModPlugin {
    public static final ResourceLocation UID = new ResourceLocation(DivineRPG.MODID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.coalstoneFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.demonFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.greenlightFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.moltenFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.moonlightFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.oceanfireFurnace), VanillaRecipeCategoryUid.FURNACE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.whitefireFurnace), VanillaRecipeCategoryUid.FURNACE);
    }
}
