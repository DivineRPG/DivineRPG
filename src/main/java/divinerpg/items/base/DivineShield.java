package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.client.renders.item.DivineShieldRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.api.distmarker.*;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class DivineShield extends ShieldItem {
    public ResourceLocation resource;
    public Optional<Integer> nameColor;
    private final Ingredient repairMaterial;
    public DivineShield(int nameColor, Item repairMaterial, int damage, String name) {
        super(new Properties().durability(damage));
        this.repairMaterial = Ingredient.of(repairMaterial);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
        resource = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/shield/" + name + ".png");
        this.nameColor = Optional.of(nameColor);
    }
    public DivineShield(Item repairMaterial, int damage, String name) {
        super(new Properties().durability(damage));
        this.repairMaterial = Ingredient.of(repairMaterial);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
        resource = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/shield/" + name + ".png");
    }
    @Override public boolean isValidRepairItem(ItemStack shield, ItemStack repairItem) {
        if(repairMaterial != null) return repairMaterial.test(repairItem);
        else return super.isValidRepairItem(shield, repairItem);
    }
    @Override public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(RenderProps.INSTANCE);
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        if(!stack.isDamageableItem()) stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
    static class RenderProps implements IClientItemExtensions {
        public static RenderProps INSTANCE = new RenderProps();
        @Override public BlockEntityWithoutLevelRenderer getCustomRenderer() {return new DivineShieldRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());}
    }
    @Override
    public Component getName(ItemStack pStack) {
    	return nameColor != null && nameColor.isPresent() ? ((MutableComponent) super.getName(pStack)).withColor(nameColor.get()) : super.getName(pStack);
    }
}