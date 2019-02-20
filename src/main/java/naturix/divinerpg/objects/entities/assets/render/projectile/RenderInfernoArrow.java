package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityInfernoArrow;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderInfernoArrow extends RenderArrow<EntityInfernoArrow> {
    public static final ResourceLocation ARROW = new ResourceLocation(DivineRPG.modId,
            "textures/entity/projectiles/arrow_inferno.png");

    public RenderInfernoArrow(RenderManager manager) {
        super(manager);
        this.bindTexture(ARROW);
    }

    protected ResourceLocation getEntityTexture(EntityInfernoArrow entity) {
        return ARROW;
    }
}