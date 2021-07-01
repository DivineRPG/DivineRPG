package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemStaff extends ItemModRanged {

    protected int damage;

    public ItemStaff(int dam,
                     int arcana,
                     String name) {
        super(name, null, null, SoundRegistry.STAFF,
                SoundCategory.PLAYERS,
                -1,
                0,
                null,
                arcana, DivineRPG.tabs.vethea);
        this.damage = dam;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaDam(damage));
        tooltip.add(LocalizeUtils.i18n("tooltip.staff.bounce"));
		/*if(stack.getItem() == ItemRegistry.evernight)
			list.add(LocalizeUtils.i18n("tooltip.staff.evernight.damage"));*/
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        //list.add(TooltipLocalizer.vethean());
    }

    @Override
    protected void spawnEntity(World world, PlayerEntity player, ItemStack stack, BulletType bulletType, EntityType entityType) {
        DivineThrowable projectile = new EntityBouncingProjectile(EntityRegistry.BOUNCING_PROJECTILE, player, world, this.damage);
        projectile.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 0.4F);
        world.addFreshEntity(projectile);
    }
}
