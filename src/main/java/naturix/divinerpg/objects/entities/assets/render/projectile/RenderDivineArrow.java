package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDivineArrow extends RenderArrow<EntityDivineArrow> {
    public static final ResourceLocation ARROW = new ResourceLocation("minecraft:textures/projectiles/arrow.png");

    public RenderDivineArrow(RenderManager manager) {
        super(manager);
    }

    protected ResourceLocation getEntityTexture(EntityDivineArrow entity) {
        return ARROW;
    }
}