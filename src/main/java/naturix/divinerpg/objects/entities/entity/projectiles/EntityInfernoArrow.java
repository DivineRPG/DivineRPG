package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderInfernoArrow;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityInfernoArrow extends EntityArrow {
    public EntityInfernoArrow(World worldIn) {
        super(worldIn);
    }

    public EntityInfernoArrow(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public EntityInfernoArrow(World worldIn, EntityLivingBase shooter) {
        super(worldIn, shooter);
    }

    public static void registerFixesTippedArrow(DataFixer fixer) {
        EntityArrow.registerFixesArrow(fixer, "ArrrowInferno");
    }

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityInfernoArrow.class,
                manager -> new RenderInfernoArrow(manager));
    }

    protected ItemStack getArrowStack() {
        return new ItemStack(ModItems.arrowInferno);
    }
}