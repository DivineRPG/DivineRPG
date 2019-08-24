package divinerpg.objects.entities.assets.model.vanilla;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSaguaroWormShot extends ModelBase {
    public ModelRenderer box = (new ModelRenderer(this, 0, 0)).setTextureSize(16, 16);

    public ModelSaguaroWormShot() {
        this.box.addBox(0.0F, 0F, 0F, 1, 1, 1, 0.0F);
        this.box.rotationPointX = 0;
        this.box.rotationPointY = 0;
        this.box.rotationPointZ = 0;
    }

    public void renderAll() {
        box.render(0.0625f);
    }
}