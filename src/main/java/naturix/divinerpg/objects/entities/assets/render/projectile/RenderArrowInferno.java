package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.DivineRPG;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArrowInferno extends RenderArrow<EntityTippedArrow>
{
    public static final ResourceLocation RES_ARROW = new ResourceLocation(DivineRPG.modId, "textures/entity/projectiles/arrow_inferno.png");

    public RenderArrowInferno(RenderManager manager)
    {
        super(manager);
    }

    protected ResourceLocation getEntityTexture(EntityTippedArrow entity)
    {
        return RES_ARROW;
    }
}