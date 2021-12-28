package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.EntityGrenade;
import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemGrenade extends ItemMod {

    private int counter = 0;

    public ItemGrenade() {
        super("grenade", RarityList.COMMON, DivineRPG.tabs.ranged);

    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (counter == 0) {
            if (!world.isClientSide) {
                EntityGrenade projectile = new EntityGrenade(world, player);
                projectile.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);

                world.addFreshEntity(projectile);
                world.playSound(player, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundCategory.PLAYERS, 1, 1);
            }
            if (!player.isCreative()) stack.shrink(1);
        }
        if (counter < 3) counter++;
        if (counter == 3) counter = 0;
        return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.explosiveShots());
    }
}
