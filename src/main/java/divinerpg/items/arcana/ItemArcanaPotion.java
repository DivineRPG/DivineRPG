package divinerpg.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.DivineRPG;
import divinerpg.capability.ArcanaProvider;
import divinerpg.capability.IArcana;
import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

public class ItemArcanaPotion extends ItemMod {

    protected int amountToAdd;

    public ItemArcanaPotion(String name, int amountToAdd) {
    	super(name, new Item.Properties().tab(DivineRPG.tabs.utilities));
        this.amountToAdd = amountToAdd;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaRegen(amountToAdd));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity player = (PlayerEntity) entityLiving;
        if (player != null) {
            if (!player.isCreative()) {
                stack.shrink(1);
            }
            IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP).orElse(null);
            arcana.fill(player, amountToAdd);
        }

        return stack;
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack par1ItemStack) {
        return 10;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {

        player.setItemInHand(hand, null);

        IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP).orElse(null);

        ActionResultType result = arcana.getArcana() < arcana.getMaxArcana() ? ActionResultType.SUCCESS :
                ActionResultType.FAIL;

        return new ActionResult<>(result, player.getItemInHand(hand));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}