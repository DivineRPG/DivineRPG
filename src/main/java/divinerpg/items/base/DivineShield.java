package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.client.renders.item.DivineShieldRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class DivineShield extends ShieldItem {
    public ResourceLocation resource;
    private final Ingredient repairMaterial;
    public DivineShield(Rarity rarity, Item repairMaterial, int damage, String name) {
        super(new Properties().durability(damage).rarity(rarity));
        this.repairMaterial = Ingredient.of(repairMaterial);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
        resource = new ResourceLocation(DivineRPG.MODID, "textures/shield/" + name + ".png");
    }
    public DivineShield(Item repairMaterial, int damage, String name) {
        super(new Properties().durability(damage));
        this.repairMaterial = Ingredient.of(repairMaterial);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
        resource = new ResourceLocation(DivineRPG.MODID, "textures/shield/" + name + ".png");
    }
    @Override public boolean isValidRepairItem(ItemStack shield, ItemStack repairItem) {
        if(repairMaterial != null) return repairMaterial.test(repairItem);
        else return super.isValidRepairItem(shield, repairItem);
    }
    @Override public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        super.initializeClient(consumer);
        consumer.accept(RenderProps.INSTANCE);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
    }
    static class RenderProps implements IClientItemExtensions {
        public static RenderProps INSTANCE = new RenderProps();
        @Override public BlockEntityWithoutLevelRenderer getCustomRenderer() {return new DivineShieldRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());}
    }
}