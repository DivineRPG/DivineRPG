package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemThrowingStar extends ItemMod {

    public ItemThrowingStar(String name) {
        super(name, DivineRPG.tabs.ranged);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(this == ItemRegistry.vileStorm){
            tooltip.add(LocalizeUtils.rangedDam(7));
            tooltip.add(LocalizeUtils.i18n("tooltip.vilestorm"));
        }
        if(this == ItemRegistry.shuriken){
            tooltip.add(LocalizeUtils.rangedDam(4));
        }
        if(this == ItemRegistry.snowflakeShuriken){
            tooltip.add(LocalizeUtils.rangedDam(7));
        }
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }

        world.playSound(null, player.blockPosition(), SoundEvents.ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
        DivineThrowable bullet;
        if (!world.isClientSide) {
            if(this == ItemRegistry.vileStorm) {
                bullet = new EntityVileStorm(EntityRegistry.VILE_STORM, player, world);
            }
            else if(this == ItemRegistry.snowflakeShuriken){
                bullet = new EntitySnowflakeShuriken(EntityRegistry.SNOWFLAKE_SHURIKEN, player, world);
            }
            else{
                bullet = new EntityShuriken(EntityRegistry.SHURIKEN, player, world);
            }
            bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(bullet);
        }

        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, itemstack);
    }
}