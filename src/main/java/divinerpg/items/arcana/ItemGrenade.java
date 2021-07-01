package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemGrenade extends ItemMod {

    private int counter = 0;

    public ItemGrenade() {
        super("grenade", DivineRPG.tabs.ranged);

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
