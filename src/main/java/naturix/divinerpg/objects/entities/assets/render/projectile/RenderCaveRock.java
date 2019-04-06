package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityCaveRock;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCaveRock extends RenderProjectile<EntityCaveRock> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/projectiles/cave_rock.png");

    public RenderCaveRock(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCaveRock entity) {
        return TEXTURE;
    }
}
