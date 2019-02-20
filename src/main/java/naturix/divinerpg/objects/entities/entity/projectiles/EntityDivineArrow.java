package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderDivineArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDivineArrow extends EntityArrow {
    public EntityDivineArrow(World worldIn) {
        super(worldIn);
    }

    public EntityDivineArrow(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityDivineArrow(World worldIn, EntityLivingBase shooter) {
        super(worldIn, shooter);
    }

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDivineArrow.class,
                manager -> new RenderDivineArrow(manager));
    }

    protected ItemStack getArrowStack() {
        return new ItemStack(Items.ARROW);
    }
}