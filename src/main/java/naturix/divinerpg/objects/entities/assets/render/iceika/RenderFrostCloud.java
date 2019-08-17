package naturix.divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.EntityFrostCloud;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on Feb /08/2019
 */
@SideOnly(Side.CLIENT)
public class RenderFrostCloud extends Render<EntityFrostCloud> {
    public RenderFrostCloud(RenderManager manager) {
        super(manager);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityFrostCloud entity) {
        return null;
    }
}