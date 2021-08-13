package divinerpg.items.base;

import divinerpg.*;
import divinerpg.entities.base.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class ItemSpawnEgg extends ItemMod {
    private final EntityType<?> typeIn;
    private final String langId;
    public ItemSpawnEgg(String name, EntityType<?> typeIn) {
        super(name, new Item.Properties().stacksTo(1).tab(DivineRPG.tabs.spawners));
        this.typeIn = typeIn;
        langId = "tooltip." + name;
    }

    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();
        int x = pos.getX(), y = pos.getY(), z = pos.getZ();
        if (!world.isClientSide) {
            EntityType<?> entitytype = typeIn;
            Entity e = entitytype.create(world);
            e.moveTo(x, y + 1, z, 0.0F, 0.0F);
            if(e instanceof EntityDivineTameable) {
                EntityDivineTameable ent = ((EntityDivineTameable)e);
                ent.tame(context.getPlayer());
            }
            world.addFreshEntity(e);
            if(!context.getPlayer().isCreative()) {
                stack.shrink(1);
            }

        }
        return ActionResultType.FAIL;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n(langId));
    }
}
